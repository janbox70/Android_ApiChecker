#!/usr/bin/python
# coding:utf-8
"""
    comments here
"""
__author__ = 'apichecker'

import codecs
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

output_path = "../output"


def save_sorted_set(name, data):
    with open(os.path.join(output_path, name), "w", encoding="utf-8") as fp:
        for item in sorted(data):
            fp.write(item)
            fp.write("\n")


def prep_result_dict(resultfile_path):
    result_dict = {}
    with open(resultfile_path, encoding="utf-8") as f:
        for line in f.readlines()[1:]:
            line = line.split("\t")
            if len(line) != 20:
                print("Malformed line %s" % ("\t".join(line)))
                continue
            line = [l.strip() for l in line]
            label = line[0]
            time = line[2]
            taskid = line[10]
            packagename = line[17]
            appname = line[19]
            result_dict[taskid] = ["1" if label == "Black" else "0", time, taskid, packagename, appname]
    return result_dict


def prep_log_dict(log_dir, result_dict, addPermission, addReceiver):
    action_list = []
    # with open('action_list.txt', 'r') as action_file:
    #     action_list = action_file.readlines()

    for i in range(len(action_list)):
        action_list[i] = action_list[i].strip()

    print("actions: ", len(action_list), action_list)

    log_dict = {}
    action_set = set()

    op_set = set()
    for logfile in os.listdir(log_dir):
        if not logfile.endswith(".txt"):
            continue
        fullname = os.path.join(log_dir, logfile)
        print("processing %s" % fullname)
        with open(fullname, mode="rb") as f:
            malformed = 0
            for no, line in enumerate(f.readlines()):
                if no == 0:
                    continue
                try:
                    line = codecs.decode(line)
                except Exception as e:
                    malformed += 1
                    if malformed == 1:
                        print("    Malformed line(%d) ignored: %s" % (no, line))
                    continue

                line = line.split("\t")
                if len(line) != 9:
                    malformed += 1
                    # print("    Malformed line(%d) ignored: %s" % (no, line[0]))
                    continue
                parts = [l.strip() for l in line]
                fdata = parts[2]
                fop = parts[4]
                ftaskid = parts[8]
                if ftaskid not in result_dict:
                    continue

                words = []
                if addPermission and fop == "DefineUsesPermissions":  # permission
                    for permission in dangerous_permission:
                        if fdata.find(permission) != -1:
                            words.append(fop + ":" + permission)
                elif addReceiver and (fop == "DefineReceiver" or fop == "RegisterReceiver"):  # receiver
                    for kv in fdata.split("{|}"):
                        if kv.find("Actions{:}") != -1:
                            providers = kv.split("{:}")[1].split(";")
                            for pvd in providers:
                                pvd = pvd.strip()
                                action_set.add(pvd)
                                if pvd in action_list:
                                    words.append(fop + ":" + pvd)
                else:
                    words.append(fop)

                if words:
                    for fop in words:
                        op_set.add(fop)
                    if ftaskid not in log_dict:
                        log_dict[ftaskid] = words
                    else:
                        log_dict[ftaskid].extend(words)

            print("    total:{}, malformed:{}".format(no, malformed))

    save_sorted_set("actions_set.txt", action_set)
    save_sorted_set("op_set.txt", op_set)

    return log_dict, op_set


def preprocess(log_dir, resultfile_path):
    embeding_size = 128
    dangerous_permission.update(normal_permissions)
    dangerous_permission.update(extra_permissions)
    dangerous_permission.update(signature_permissions)

    print("permissions: ", len(dangerous_permission), dangerous_permission)

    result_dict = prep_result_dict(resultfile_path)

    print("loaded-tasks: ", len(result_dict))

    log_dict, op_set = prep_log_dict(log_dir, result_dict, addPermission=True, addReceiver=True)

    print("loaded-tasks with log: ", len(log_dict))

    print("Unique API Set Size %d" % (len(op_set)))

    docLabels = [ftaskid for ftaskid in log_dict]
    data = []
    for doc in docLabels:
        data.append(log_dict[doc])
    w2vmodel = gensim.models.Word2Vec(vector_size=embeding_size, window=2, min_count=1, workers=20, alpha=0.025)
    w2vmodel.build_vocab(data)
    print("Training word2vec")
    w2vmodel.train(data, total_examples=w2vmodel.corpus_count, epochs=w2vmodel.epochs)
    w2vmodel.save(os.path.join(output_path, "word2vec.model"))

    model = w2vmodel.wv
    print("preparing train data")
    outx = []
    outy = []
    for k, words in log_dict.items():
        feature_array = np.array([0.0 for i in range(embeding_size)], dtype='f4')
        if len(words) != 0:
            for word in words:
                if word not in model:
                    continue
                feature_array += model[word]
            feature_array = feature_array / len(words)

        outx.append(feature_array)
        outy.append(result_dict[k][0])

    pre_path = os.path.join(output_path, "pre_word2vec.pkl")
    print("Writing train data to file" + pre_path)
    with open(pre_path, "wb") as fp:
        pkl.dump([outx, outy], fp)
    pass


if __name__ == "__main__":
    preprocess(log_dir="../data/running_logs",
               resultfile_path="../data/apk_detect_result.txt")
    pass
