#!/usr/bin/python
# coding:utf-8
"""
    comments here
"""
__author__ = 'apichecker'
import os
import pickle as pkl
import gensim
import numpy as np



# google dev
dangerous_permission = {
    "READ_CALENDAR",
    "WRITE_CALENDAR",
    "CAMERA",
    "READ_CONTACTS",
    "WRITE_CONTACTS",
    "GET_ACCOUNTS",
    "ACCESS_FINE_LOCATION",
    "ACCESS_COARSE_LOCATION",
    "RECORD_AUDIO",
    "READ_PHONE_STATE",
    "CALL_PHONE",
    "READ_CALL_LOG",
    "WRITE_CALL_LOG",
    "ADD_VOICEMAIL",
    "USE_SIP",
    "PROCESS_OUTGOING_CALLS",
    "BODY_SENSORS",
    "SEND_SMS",
    "RECEIVE_SMS",
    "READ_SMS",
    "RECEIVE_WAP_PUSH",
    "RECEIVE_MMS",
    "READ_EXTERNAL_STORAGE",
    "WRITE_EXTERNAL_STORAGE",
    "ANSWER_PHONE_CALLS",
    "READ_PHONE_NUMBERS",
}

# google dev 
normal_permissions = {
    "ACCESS_LOCATION_EXTRA_COMMANDS",
    "ACCESS_NETWORK_STATE",
    "ACCESS_NOTIFICATION_POLICY",
    "ACCESS_WIFI_STATE",
    "BLUETOOTH",
    "BLUETOOTH_ADMIN",
    "BROADCAST_STICKY",
    "CHANGE_NETWORK_STATE",
    "CHANGE_WIFI_MULTICAST_STATE",
    "CHANGE_WIFI_STATE",
    "DISABLE_KEYGUARD",
    "EXPAND_STATUS_BAR",
    "GET_PACKAGE_SIZE",
    "INSTALL_SHORTCUT",
    "INTERNET",
    "KILL_BACKGROUND_PROCESSES",
    "MANAGE_OWN_CALLS",
    "MODIFY_AUDIO_SETTINGS",
    "NFC",
    "READ_SYNC_SETTINGS",
    "READ_SYNC_STATS",
    "RECEIVE_BOOT_COMPLETED",
    "REORDER_TASKS",
    "REQUEST_IGNORE_BATTERY_OPTIMIZATIONS",
    "REQUEST_INSTALL_PACKAGES",
    "REQUEST_COMPANION_RUN_IN_BACKGROUND",
    "REQUEST_COMPANION_USE_DATA_IN_BACKGROUND",
    "REQUEST_DELETE_PACKAGES"
    "SET_ALARM",
    "SET_TIME_ZONE",
    "SET_WALLPAPER",
    "SET_WALLPAPER_HINTS",
    "TRANSMIT_IR",
    "UNINSTALL_SHORTCUT",
    "USE_FINGERPRINT",
    "VIBRATE",
    "WAKE_LOCK",
    "WRITE_SYNC_SETTINGS"
}
signature_permissions = {
    "BIND_ACCESSIBILITY_SERVICE",
    "BIND_AUTOFILL_SERVICE",
    "BIND_CARRIER_SERVICES",
    "BIND_CHOOSER_TARGET_SERVICE",
    "BIND_CONDITION_PROVIDER_SERVICE",
    "BIND_DEVICE_ADMIN",
    "BIND_DREAM_SERVICE",
    "BIND_INCALL_SERVICE",
    "BIND_INPUT_METHOD",
    "BIND_MIDI_DEVICE_SERVICE",
    "BIND_NFC_SERVICE",
    "BIND_NOTIFICATION_LISTENER_SERVICE",
    "BIND_PRINT_SERVICE",
    "BIND_SCREENING_SERVICE",
    "BIND_TELECOM_CONNECTION_SERVICE",
    "BIND_TEXT_SERVICE",
    "BIND_TV_INPUT",
    "BIND_VISUAL_VOICEMAIL_SERVICE",
    "BIND_VOICE_INTERACTION",
    "BIND_VPN_SERVICE",
    "BIND_VR_LISTENER_SERVICE",
    "BIND_WALLPAPER",
    "CLEAR_APP_CACHE",
    "MANAGE_DOCUMENTS",
    "READ_VOICEMAIL",
    "REQUEST_INSTALL_PACKAGES",
    "SYSTEM_ALERT_WINDOW",
    "WRITE_SETTINGS",
    "WRITE_VOICEMAIL",

}
extra_permissions = {
    "GET_TASKS",
    "MOUNT_UNMOUNT_FILESYSTEMS",
    "CHANGE_CONFIGURATION",
    "SYSTEM_ALERT_WINDOW",
    "READ_LOGS",
    "RUN_INSTRUMENTATION",
    "READ_SETTINGS",
    "WRITE_APN_SETTINGS",
}

LabeledSentence = gensim.models.doc2vec.LabeledSentence

def preprocess(log_dir, resultfile_path):

    result_dict = {}
    log_dict = {}
    op_set = set()
    dangerous_permission.update(normal_permissions)
    dangerous_permission.update(extra_permissions)
    dangerous_permission.update(signature_permissions)

    action_file = open('action_list.txt', 'r')
    action_list = action_file.readlines()
    for i in range(len(action_list)):
        action_list[i] = action_list[i].strip()
    print(len(dangerous_permission), dangerous_permission)
    print(len(action_list), action_list)

    with open(resultfile_path) as f:
        for line in f.readlines()[1:]:
            line = line.split("\t")
            if len(line) != 20:           
                print("Malformed line %s" % ("\t".join(line)))
                continue
            line = [l.strip() for l in line]    
            label = line[0]  
            time = line[2]
            taskid = line[10]
            packagename=line[17]
            appname = line[19]
            result_dict[taskid] = ["1" if label=="Black" else "0", time, taskid, packagename, appname]
            log_dict[taskid] = []

    addPermission = True
    addReceiver = True
    dict_path = "dict.txt"
    pre_path = "pre_word2vec.pkl"

    for logfile in os.listdir(log_dir):
        if not logfile.endswith(".txt"):
            continue
        print("processing %s" % os.path.join(log_dir, logfile))
        with open(os.path.join(log_dir, logfile)) as f:
            for line in f.readlines()[1:]:
                line = line.split("\t")

                if len(line) != 9:
                    print("Malformed line %s" % ("\t".join(line)))
                    continue
                line = [l.strip() for l in line]
                fdata=line[2]
                fop = line[4]
                ftaskid=line[8]
                if addPermission and fop == "DefineUsesPermissions":  # permission
                    for permission in dangerous_permission:
                        if fdata.find(permission) != -1:
                            if ftaskid not in result_dict:
                                continue
                            else:
                                log_dict[ftaskid].append(fop + ":" + permission)
                                op_set.add(fop + ":" + permission)
                elif addReceiver and (fop == "DefineReceiver" or fop == "RegisterReceiver"):   # receiver
                    for kv in fdata.split("{|}"):
                        if kv.find("Actions{:}") != -1:
                            providers = kv.split("{:}")[1].split(";")
                            for pvd in providers:
                                if ftaskid in result_dict and pvd in action_list:
                                    log_dict[ftaskid].append(fop + ":" + pvd)
                                    op_set.add(fop + ":" + pvd)

                else:
                    if ftaskid not in result_dict:
                        continue
                    else:
                        log_dict[ftaskid].append(fop)
                        op_set.add(fop)
    prefix = ""
    feature_dict = {}
    print("Unique API Set Size %d" % (len(op_set)))
    print("Writing feature dict to " + dict_path)

    docLabels = [ftaskid for ftaskid in log_dict]
    data = []
    for doc in docLabels:
        data.append(log_dict[doc])
    model = gensim.models.Word2Vec(size=200, window=2, min_count=1, workers=20, alpha=0.025)
    model.build_vocab(data)
    print("Training")
    model.train(data, total_examples=model.corpus_count, epochs=model.iter)
    model.save("word2vec.model")
    print("preparing train data")
    outx = []
    outy=[]
    for k, v in result_dict.items():
        if k not in log_dict:
            print("Result taskid %s not in log, skipping..." % (k))
            continue

        feature_array = np.array([0.0 for i in range(200)])
        if len(log_dict[k]) != 0:
            for word in log_dict[k]:
                if word not in model:
                    continue
                feature_array += model[word]
            feature_array = feature_array/len(log_dict[k])

        outx.append(feature_array)
        outy.append(v[0])
    print("Writing train data to file" + pre_path)
    with open(pre_path, "wb") as fpre:
        pkl.dump([outx, outy], fpre, protocol=2)
    pass

if __name__ == "__main__":
    preprocess(log_dir="/run_log",
               resultfile_path="/apk_detect_result.txt")
    pass