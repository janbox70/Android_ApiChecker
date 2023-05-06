import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import java.io.RandomAccessFile;
import android.util.Log;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import java.io.File;
public class Hook implements IXposedHookLoadPackage {

    private void hook_methods(String className, String methodName, XC_MethodHook xmh){
        try {
              Class<?> clazz = Class.forName(className);
              for (Method method : clazz.getDeclaredMethods())
                if (method.getName().equals(methodName)
                        && !Modifier.isAbstract(method.getModifiers())) {
                    XposedBridge.hookMethod(method, xmh);

                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void HookWriteLog(String strcontent) {

            String strFilePath = "/sdcard/hooks/xxxAPI.txt";

            String strContent = strcontent + "\r\n";
            try {
                File file = new File(strFilePath);
                if (!file.exists()) {
                    file.createNewFile();
                }
                RandomAccessFile raf = new RandomAccessFile(file, "rwd");
                raf.seek(file.length());
                raf.write(strContent.getBytes());
                raf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    @Override
    public void handleLoadPackage(LoadPackageParam lpp) throws Throwable {


       if (lpp.packageName.equals("xxxx")) {

           hook_methods("android.view.WindowManager", "aadView", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.view.WindowManager aadView");
               }
           });


           hook_methods("android.net.sip.SipManager", "close", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager close");
               }
           });


           hook_methods("android.content.res.Configuration", "setToDefaults", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.res.Configuration setToDefaults");
               }
           });


           hook_methods("android.widget.Toast", "cancel", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.Toast cancel");
               }
           });


           hook_methods("android.database.sqlite.SQLiteDatabase", "update", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.database.sqlite.SQLiteDatabase update");
               }
           });


           hook_methods("android.accounts.AccountManager", "getAccountsByType", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager getAccountsByType");
               }
           });


           hook_methods("android.provider.ContactsContract", "get", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.ContactsContract get");
               }
           });


           hook_methods("java.util.zip.Deflater", "Deflater", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.zip.Deflater Deflater");
               }
           });


           hook_methods("java.io.BufferedInputStream", "mark", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.BufferedInputStream mark");
               }
           });


           hook_methods("android.provider.ContactsContract", "set", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.ContactsContract set");
               }
           });


           hook_methods("android.location.LocationManager", "requestLocationUpdates", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager requestLocationUpdates");
               }
           });


           hook_methods("android.net.sip.SipManager", "isOpened", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager isOpened");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getDeviceId", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getDeviceId");
               }
           });


           hook_methods("java.util.Properties", "store", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.Properties store");
               }
           });


           hook_methods("android.location.LocationManager", "addNmeaListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager addNmeaListener");
               }
           });


           hook_methods("android.telephony.SmsMessage", "getDisplayOriginatingAddress", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsMessage getDisplayOriginatingAddress");
               }
           });


           hook_methods("java.security.InvalidKeyException", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.InvalidKeyException printStackTrace");
               }
           });


           hook_methods("java.text.SimpleDateFormat", "applyLocalizedPattern", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.text.SimpleDateFormat applyLocalizedPattern");
               }
           });


           hook_methods("java.io.FileNotFoundException", "toString", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.FileNotFoundException toString");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getCellLocation", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getCellLocation");
               }
           });


           hook_methods("java.util.SortedSet", "iterator", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.SortedSet iterator");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getSimSerialNumber", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getSimSerialNumber");
               }
           });


           hook_methods("android.content.Context", "startService", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.Context startService");
               }
           });


           hook_methods("javax.crypto.Cipher", "getInstance", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.Cipher getInstance");
               }
           });


           hook_methods("android.app.DownloadManager", "getUriForDownloadedFile", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.DownloadManager getUriForDownloadedFile");
               }
           });


           hook_methods("android.telephony.SubscriptionManager", "getActiveSubscriptionInfoForSimSlotIndex", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SubscriptionManager getActiveSubscriptionInfoForSimSlotIndex");
               }
           });


           hook_methods("javax.net.ssl.HttpsURLConnection", "setDefaultHostnameVerifier", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.net.ssl.HttpsURLConnection setDefaultHostnameVerifier");
               }
           });


           hook_methods("javax.crypto.IllegalBlockSizeException", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.IllegalBlockSizeException printStackTrace");
               }
           });


           hook_methods("android.net.Proxy", "getDefaultHost", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.Proxy getDefaultHost");
               }
           });


           hook_methods("java.nio.charset.CoderResult", "isError", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.nio.charset.CoderResult isError");
               }
           });


           hook_methods("android.speech.SpeechRecognizer", "cancel", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.speech.SpeechRecognizer cancel");
               }
           });


           hook_methods("android.provider.ContactsContract", "markAsContacted", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.ContactsContract markAsContacted");
               }
           });


           hook_methods("java.security.Security", "setProperty", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.Security setProperty");
               }
           });


           hook_methods("java.io.DataInputStream", "readLine", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.DataInputStream readLine");
               }
           });


//        hook_methods("dalvik.system.InMemoryDexClassLoader", "InMemoryDexClassLoader", new XC_MethodHook(){
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                HookWriteLog("hook dalvik.system.InMemoryDexClassLoader InMemoryDexClassLoader");
//            }
//        });


           hook_methods("android.os.HandlerThread", "isAlive", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.os.HandlerThread isAlive");
               }
           });


           hook_methods("java.security.cert.CertificateException", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.cert.CertificateException printStackTrace");
               }
           });


           hook_methods("android.widget.CheckBox", "getTextColors", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.CheckBox getTextColors");
               }
           });


           hook_methods("java.lang.Runtime", "getRuntime", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Runtime getRuntime");
               }
           });


           hook_methods("java.util.zip.GZIPOutputStream", "flush", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.zip.GZIPOutputStream flush");
               }
           });


           hook_methods("javax.crypto.CipherOutputStream", "close", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.CipherOutputStream close");
               }
           });


           hook_methods("java.net.URLConnection", "connect", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.URLConnection connect");
               }
           });


           hook_methods("android.provider.ContactsContract", "notifyDirectoryChange", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.ContactsContract notifyDirectoryChange");
               }
           });


           hook_methods("android.accounts.AccountManager", "editProperties", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager editProperties");
               }
           });


           hook_methods("dalvik.system.BaseDexClassLoader", "BaseDexClassLoader", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook dalvik.system.BaseDexClassLoader BaseDexClassLoader");
               }
           });


           hook_methods("java.net.URL", "getDefaultPort", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.URL getDefaultPort");
               }
           });


           hook_methods("android.os.Environment", "getExternalStorageDirectory", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.os.Environment getExternalStorageDirectory");
               }
           });


           hook_methods("android.widget.QuickContactBadge", "assignContactFromEmail", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.QuickContactBadge assignContactFromEmail");
               }
           });


           hook_methods("java.io.OutputStreamWriter", "close", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.OutputStreamWriter close");
               }
           });


           hook_methods("android.accounts.AccountManager", "addAccount", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager addAccount");
               }
           });


           hook_methods("android.database.sqlite.SQLiteDatabase", "query", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.database.sqlite.SQLiteDatabase query");
               }
           });


           hook_methods("java.security.interfaces.RSAPrivateKey", "getModulus", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.interfaces.RSAPrivateKey getModulus");
               }
           });


           hook_methods("android.content.pm.PackageManager", "getPackageArchiveInfo", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.pm.PackageManager getPackageArchiveInfo");
               }
           });


           hook_methods("java.util.concurrent.ThreadPoolExecutor", "getActiveCount", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.concurrent.ThreadPoolExecutor getActiveCount");
               }
           });


           hook_methods("java.util.SortedMap", "putAll", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.SortedMap putAll");
               }
           });


           hook_methods("android.widget.LinearLayout", "setMinimumWidth", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.LinearLayout setMinimumWidth");
               }
           });


           hook_methods("java.nio.charset.CoderResult", "isOverflow", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.nio.charset.CoderResult isOverflow");
               }
           });


           hook_methods("android.database.sqlite.SQLiteDatabase", "create", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.database.sqlite.SQLiteDatabase create");
               }
           });


           hook_methods("java.io.ByteArrayOutputStream", "reset", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.ByteArrayOutputStream reset");
               }
           });


           hook_methods("android.location.LocationManager", "getBestProvider", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager getBestProvider");
               }
           });


           hook_methods("android.app.Dialog", "dispatchKeyEvent", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Dialog dispatchKeyEvent");
               }
           });


           hook_methods("android.location.LocationManager", "setTestProviderEnabled", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager setTestProviderEnabled");
               }
           });


           hook_methods("java.lang.ProcessBuilder", "redirectErrorStream", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.ProcessBuilder redirectErrorStream");
               }
           });


           hook_methods("javax.crypto.spec.DESKeySpec", "DESKeySpec", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.spec.DESKeySpec DESKeySpec");
               }
           });


           hook_methods("android.accounts.AccountManager", "getAccounts", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager getAccounts");
               }
           });


           hook_methods("android.telephony.SignalStrength", "getCdmaDbm", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SignalStrength getCdmaDbm");
               }
           });


           hook_methods("dalvik.system.DexFile", "DexFile", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook dalvik.system.DexFile DexFile");
               }
           });


           hook_methods("java.lang.Integer", "byteValue", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Integer byteValue");
               }
           });


           hook_methods("android.app.Service", "onLowMemory", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Service onLowMemory");
               }
           });


           hook_methods("android.telephony.SmsManager", "sendMultipartTextMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsManager sendMultipartTextMessage");
               }
           });


           hook_methods("android.accounts.AccountManager", "getAuthToken", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager getAuthToken");
               }
           });


           hook_methods("android.app.ActivityManager", "getRunningTasks", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.ActivityManager getRunningTasks");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getLine1Number", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getLine1Number");
               }
           });


           hook_methods("org.xmlpull.v1.XmlSerializer", "text", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook org.xmlpull.v1.XmlSerializer text");
               }
           });


           hook_methods("java.util.concurrent.ScheduledExecutorService", "awaitTermination", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.concurrent.ScheduledExecutorService awaitTermination");
               }
           });


//        hook_methods("java.lang.Class<T>", "getDeclaredField", new XC_MethodHook(){
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                HookWriteLog("hook java.lang.Class<T> getDeclaredField");
//            }
//        });


           hook_methods("android.webkit.WebView", "removeAllViews", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.WebView removeAllViews");
               }
           });


           hook_methods("java.util.zip.GZIPOutputStream", "finish", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.zip.GZIPOutputStream finish");
               }
           });


           hook_methods("android.app.Service", "onStart", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Service onStart");
               }
           });


           hook_methods("java.lang.ClassLoader", "ClassLoader", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.ClassLoader ClassLoader");
               }
           });


           hook_methods("android.net.sip.SipManager", "close", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager close");
               }
           });


           hook_methods("android.net.sip.SipManager", "isRegistered", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager isRegistered");
               }
           });


           hook_methods("android.telephony.gsm.SmsManager", "sendDataMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.gsm.SmsManager sendDataMessage");
               }
           });


           hook_methods("java.security.DigestInputStream", "getMessageDigest", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.DigestInputStream getMessageDigest");
               }
           });


           hook_methods("java.lang.Process", "getInputStream", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Process getInputStream");
               }
           });


           hook_methods("android.app.Service", "onStartCommand", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Service onStartCommand");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getSubscriberId", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getSubscriberId");
               }
           });


           hook_methods("android.provider.ContactsContract", "newSetOperation", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.ContactsContract newSetOperation");
               }
           });


           hook_methods("android.telephony.gsm.SmsManager", "divideMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.gsm.SmsManager divideMessage");
               }
           });


           hook_methods("android.provider.Browser", "clearSearches", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Browser clearSearches");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getVoiceMailNumber", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getVoiceMailNumber");
               }
           });


           hook_methods("android.inputmethodservice.KeyboardView", "swipeDown", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.inputmethodservice.KeyboardView swipeDown");
               }
           });


           hook_methods("android.telephony.SmsMessage", "createFromPdu", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsMessage createFromPdu");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getDeviceSoftwareVersion", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getDeviceSoftwareVersion");
               }
           });


           hook_methods("android.content.ContextWrapper", "createPackageContext", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.ContextWrapper createPackageContext");
               }
           });


           hook_methods("android.database.sqlite.SQLiteDatabase", "insert", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.database.sqlite.SQLiteDatabase insert");
               }
           });


           hook_methods("java.lang.NumberFormatException", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.NumberFormatException printStackTrace");
               }
           });


           hook_methods("android.app.Instrumentation", "callActivityOnSaveInstanceState", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Instrumentation callActivityOnSaveInstanceState");
               }
           });


           hook_methods("android.provider.Contacts", "createPersonInMyContactsGroup", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Contacts createPersonInMyContactsGroup");
               }
           });


           hook_methods("java.lang.Runtime", "loadLibrary", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Runtime loadLibrary");
               }
           });

           hook_methods("android.os.Environment", "getDownloadCacheDirectory", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.os.Environment getDownloadCacheDirectory");
               }
           });


           hook_methods("android.os.storage.StorageManager", "getPrimaryStorageVolume", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.os.storage.StorageManager getPrimaryStorageVolume");
               }
           });


           hook_methods("dalvik.system.PathClassLoader", "PathClassLoader", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook dalvik.system.PathClassLoader PathClassLoader");
               }
           });


           hook_methods("java.io.File", "list", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.File list");
               }
           });


           hook_methods("java.io.BufferedWriter", "write", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.BufferedWriter write");
               }
           });


           hook_methods("org.apache.http.conn.ConnectTimeoutException", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook org.apache.http.conn.ConnectTimeoutException printStackTrace");
               }
           });


           hook_methods("android.database.sqlite.SQLiteOpenHelper", "SQLiteOpenHelper", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.database.sqlite.SQLiteOpenHelper SQLiteOpenHelper");
               }
           });


           hook_methods("android.location.LocationManager", "getProviders", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager getProviders");
               }
           });


           hook_methods("java.security.spec.RSAPrivateCrtKeySpec", "RSAPrivateCrtKeySpec", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.spec.RSAPrivateCrtKeySpec RSAPrivateCrtKeySpec");
               }
           });


           hook_methods("android.net.sip.SipManager", "getSessionFor", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager getSessionFor");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getDeviceId", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getDeviceId");
               }
           });


           hook_methods("android.accounts.AccountManager", "getAccountsByType", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager getAccountsByType");
               }
           });


           hook_methods("dalvik.system.DexClassLoader", "findLibrary", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook dalvik.system.DexClassLoader findLibrary");
               }
           });


           hook_methods("android.content.IntentFilter", "setPriority", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.IntentFilter setPriority");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getSubscriberId", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getSubscriberId");
               }
           });


           hook_methods("java.net.Socket", "connect", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.Socket connect");
               }
           });


           hook_methods("android.webkit.WebView", "setTag", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.WebView setTag");
               }
           });


           hook_methods("java.io.File", "renameTo", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.File renameTo");
               }
           });


           hook_methods("android.content.ContextWrapper", "sendOrderedBroadcast", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.ContextWrapper sendOrderedBroadcast");
               }
           });


           hook_methods("javax.crypto.Cipher", "doFinal", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.Cipher doFinal");
               }
           });


           hook_methods("android.net.sip.SipManager", "createSipSession", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager createSipSession");
               }
           });


           hook_methods("android.os.Bundle", "getClassLoader", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.os.Bundle getClassLoader");
               }
           });


           hook_methods("android.app.KeyguardManager", "exitKeyguardSecurely", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.KeyguardManager exitKeyguardSecurely");
               }
           });


           hook_methods("java.net.SocketException", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.SocketException printStackTrace");
               }
           });


           hook_methods("android.accounts.AccountManager", "updateCredentials", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager updateCredentials");
               }
           });


           hook_methods("android.net.sip.SipManager", "makeAudioCall", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager makeAudioCall");
               }
           });


           hook_methods("java.util.concurrent.ThreadPoolExecutor", "getTaskCount", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.concurrent.ThreadPoolExecutor getTaskCount");
               }
           });


           hook_methods("android.accounts.AccountManager", "removeAccount", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager removeAccount");
               }
           });


           hook_methods("android.webkit.WebView", "setDownloadListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.WebView setDownloadListener");
               }
           });


           hook_methods("android.database.sqlite.SQLiteDatabase", "insertWithOnConflict", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.database.sqlite.SQLiteDatabase insertWithOnConflict");
               }
           });


           hook_methods("android.provider.CalendarContract", "insert", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.CalendarContract insert");
               }
           });


           hook_methods("android.net.wifi.WifiManager", "disconnect", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.wifi.WifiManager disconnect");
               }
           });


           hook_methods("android.telephony.SubscriptionManager", "addOnSubscriptionsChangedListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SubscriptionManager addOnSubscriptionsChangedListener");
               }
           });


           hook_methods("android.location.LocationManager", "requestSingleUpdate", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager requestSingleUpdate");
               }
           });


           hook_methods("android.telephony.SmsManager", "sendTextMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsManager sendTextMessage");
               }
           });


           hook_methods("java.io.StringReader", "close", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.StringReader close");
               }
           });


           hook_methods("java.net.NetworkInterface", "getByName", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.NetworkInterface getByName");
               }
           });


           hook_methods("android.net.sip.SipManager", "makeAudioCall", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager makeAudioCall");
               }
           });


           hook_methods("android.provider.Browser", "clearHistory", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Browser clearHistory");
               }
           });


           hook_methods("android.webkit.WebView", "removeJavascriptInterface", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.WebView removeJavascriptInterface");
               }
           });


           hook_methods("android.net.NetworkInfo", "getExtraInfo", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.NetworkInfo getExtraInfo");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getNeighboringCellInfo", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getNeighboringCellInfo");
               }
           });


//        hook_methods("java.lang.reflect.Method", "invoke", new XC_MethodHook(){
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                HookWriteLog("hook java.lang.reflect.Method invoke");
//            }
//        });


           hook_methods("android.content.Context", "stopService", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.Context stopService");
               }
           });


           hook_methods("android.provider.Browser", "updateVisitedHistory", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Browser updateVisitedHistory");
               }
           });


           hook_methods("java.io.FileOutputStream", "write", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.FileOutputStream write");
               }
           });


           hook_methods("android.telephony.SubscriptionManager", "getActiveSubscriptionInfo", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SubscriptionManager getActiveSubscriptionInfo");
               }
           });


           hook_methods("android.telephony.cdma.CdmaCellLocation", "getBaseStationLatitude", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.cdma.CdmaCellLocation getBaseStationLatitude");
               }
           });


           hook_methods("java.io.UnsupportedEncodingException", "initCause", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.UnsupportedEncodingException initCause");
               }
           });


           hook_methods("android.telephony.SignalStrength", "getGsmSignalStrength", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SignalStrength getGsmSignalStrength");
               }
           });


           hook_methods("android.net.sip.SipManager", "isOpened", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager isOpened");
               }
           });


           hook_methods("android.view.ViewManager", "removeView", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.view.ViewManager removeView");
               }
           });


           hook_methods("javax.crypto.spec.SecretKeySpec", "SecretKeySpec", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.spec.SecretKeySpec SecretKeySpec");
               }
           });


           hook_methods("android.widget.EditText", "setGravity", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.EditText setGravity");
               }
           });


           hook_methods("android.content.ContextWrapper", "sendOrderedBroadcastAsUser", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.ContextWrapper sendOrderedBroadcastAsUser");
               }
           });


           hook_methods("java.util.jar.Manifest", "read", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.jar.Manifest read");
               }
           });


           hook_methods("android.speech.SpeechRecognizer", "startListening", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.speech.SpeechRecognizer startListening");
               }
           });


           hook_methods("android.os.Environment", "getRootDirectory", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.os.Environment getRootDirectory");
               }
           });


           hook_methods("org.xmlpull.v1.XmlPullParser", "nextText", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook org.xmlpull.v1.XmlPullParser nextText");
               }
           });


           hook_methods("android.location.LocationManager", "addNmeaListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager addNmeaListener");
               }
           });


           hook_methods("javax.crypto.spec.DESedeKeySpec", "DESedeKeySpec", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.spec.DESedeKeySpec DESedeKeySpec");
               }
           });


           hook_methods("java.security.InvalidAlgorithmParameterException", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.InvalidAlgorithmParameterException printStackTrace");
               }
           });


           hook_methods("java.io.LineNumberReader", "close", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.LineNumberReader close");
               }
           });


           hook_methods("android.text.format.Time", "toMillis", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.text.format.Time toMillis");
               }
           });


           hook_methods("android.view.animation.AlphaAnimation", "start", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.view.animation.AlphaAnimation start");
               }
           });


           hook_methods("android.app.Application", "attachBaseContext", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Application attachBaseContext");
               }
           });


           hook_methods("android.telephony.PhoneStateListener", "onSignalStrengthsChanged", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.PhoneStateListener onSignalStrengthsChanged");
               }
           });


           hook_methods("java.net.SocketTimeoutException", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.SocketTimeoutException printStackTrace");
               }
           });


           hook_methods("android.telephony.gsm.SmsManager", "sendDataMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.gsm.SmsManager sendDataMessage");
               }
           });


           hook_methods("javax.crypto.CipherOutputStream", "write", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.CipherOutputStream write");
               }
           });


           hook_methods("android.net.wifi.WifiManager", "isWifiEnabled", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.wifi.WifiManager isWifiEnabled");
               }
           });


           hook_methods("android.webkit.WebView", "saveWebArchive", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.WebView saveWebArchive");
               }
           });


           hook_methods("java.text.DateFormat", "getInstance", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.text.DateFormat getInstance");
               }
           });


           hook_methods("java.util.jar.JarFile", "JarFile", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.jar.JarFile JarFile");
               }
           });


//        hook_methods("java.lang.Class<T>", "getDeclaredMethods", new XC_MethodHook(){
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                HookWriteLog("hook java.lang.Class<T> getDeclaredMethods");
//            }
//        });


           hook_methods("java.io.BufferedWriter", "close", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.BufferedWriter close");
               }
           });


           hook_methods("android.provider.CallLog", "getLastOutgoingCall", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.CallLog getLastOutgoingCall");
               }
           });


           hook_methods("android.telephony.cdma.CdmaCellLocation", "getSystemId", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.cdma.CdmaCellLocation getSystemId");
               }
           });


           hook_methods("android.telephony.gsm.SmsManager", "sendMultipartTextMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.gsm.SmsManager sendMultipartTextMessage");
               }
           });


           hook_methods("android.accounts.AccountManager", "confirmCredentials", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager confirmCredentials");
               }
           });


           hook_methods("android.telephony.SignalStrength", "getEvdoDbm", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SignalStrength getEvdoDbm");
               }
           });


           hook_methods("android.webkit.WebView", "getVisibility", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.WebView getVisibility");
               }
           });


           hook_methods("android.net.wifi.WifiManager", "disableNetwork", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.wifi.WifiManager disableNetwork");
               }
           });


           hook_methods("android.net.sip.SipManager", "register", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager register");
               }
           });


           hook_methods("android.telephony.SmsManager", "sendMultimediaMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsManager sendMultimediaMessage");
               }
           });


           hook_methods("java.net.NetworkInterface", "getInetAddresses", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.NetworkInterface getInetAddresses");
               }
           });


           hook_methods("java.lang.Runtime", "exec", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Runtime exec");
               }
           });


           hook_methods("android.widget.EditText", "getContext", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.EditText getContext");
               }
           });


           hook_methods("android.database.sqlite.SQLiteDatabase", "rawQuery", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.database.sqlite.SQLiteDatabase rawQuery");
               }
           });


           hook_methods("java.lang.ProcessBuilder", "ProcessBuilder", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.ProcessBuilder ProcessBuilder");
               }
           });


           hook_methods("android.app.Application", "getDir", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Application getDir");
               }
           });


           hook_methods("android.content.ContextWrapper", "sendStickyOrderedBroadcastAsUser", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.ContextWrapper sendStickyOrderedBroadcastAsUser");
               }
           });


           hook_methods("java.io.FileWriter", "write", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.FileWriter write");
               }
           });


           hook_methods("java.security.interfaces.RSAPublicKey", "getModulus", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.interfaces.RSAPublicKey getModulus");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getSimSerialNumber", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getSimSerialNumber");
               }
           });


           hook_methods("android.net.wifi.WifiManager", "saveConfiguration", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.wifi.WifiManager saveConfiguration");
               }
           });


           hook_methods("android.net.sip.SipManager", "unregister", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager unregister");
               }
           });


           hook_methods("java.util.jar.JarFile", "close", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.jar.JarFile close");
               }
           });


           hook_methods("android.content.Context", "startActivity", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.Context startActivity");
               }
           });


           hook_methods("android.widget.Button", "setLeft", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.Button setLeft");
               }
           });


           hook_methods("android.text.Editable", "toString", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.text.Editable toString");
               }
           });


           hook_methods("android.provider.ContactsContract", "getWithUri", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.ContactsContract getWithUri");
               }
           });


           hook_methods("android.provider.Contacts", "addToGroup", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Contacts addToGroup");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getLine1Number", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getLine1Number");
               }
           });


           hook_methods("java.lang.IllegalAccessError", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.IllegalAccessError printStackTrace");
               }
           });


           hook_methods("java.lang.reflect.AccessibleObject", "setAccessible", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.reflect.AccessibleObject setAccessible");
               }
           });


           hook_methods("android.app.DownloadManager", "addCompletedDownload", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.DownloadManager addCompletedDownload");
               }
           });


           hook_methods("java.io.OutputStreamWriter", "flush", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.OutputStreamWriter flush");
               }
           });


           hook_methods("android.telephony.SmsManager", "sendTextMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsManager sendTextMessage");
               }
           });


           hook_methods("javax.crypto.KeyGenerator", "getInstance", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.KeyGenerator getInstance");
               }
           });


           hook_methods("java.security.Key", "getEncoded", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.Key getEncoded");
               }
           });


           hook_methods("java.nio.channels.FileLock", "release", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.nio.channels.FileLock release");
               }
           });


           hook_methods("android.hardware.Sensor", "getVersion", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.hardware.Sensor getVersion");
               }
           });


           hook_methods("java.security.spec.RSAPublicKeySpec", "RSAPublicKeySpec", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.spec.RSAPublicKeySpec RSAPublicKeySpec");
               }
           });


           hook_methods("android.location.LocationManager", "addGpsStatusListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManage addGpsStatusListener");
               }
           });


           hook_methods("android.location.LocationManager", "getLastKnownLocation", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager getLastKnownLocation");
               }
           });


           hook_methods("android.text.format.Time", "set", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.text.format.Time set");
               }
           });


           hook_methods("java.io.File", "delete", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.File delete");
               }
           });


           hook_methods("android.accounts.AccountManager", "getAccounts", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManage getAccounts");
               }
           });


           hook_methods("android.telephony.SubscriptionManager", "getActiveSubscriptionInfoList", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SubscriptionManage getActiveSubscriptionInfoList");
               }
           });


           hook_methods("android.provider.Contacts", "setSetting", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Contacts setSetting");
               }
           });


           hook_methods("android.location.LocationManager", "sendExtraCommand", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager sendExtraCommand");
               }
           });


           hook_methods("android.content.pm.ServiceInfo", "ServiceInfo", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.pm.ServiceInfo ServiceInfo");
               }
           });


           hook_methods("android.provider.Browser", "addSearchUrl", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Browser addSearchUrl");
               }
           });


           hook_methods("android.telephony.cdma.CdmaCellLocation", "getBaseStationLongitude", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.cdma.CdmaCellLocation getBaseStationLongitude");
               }
           });


           hook_methods("android.util.Base64", "decode", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.util.Base64 decode");
               }
           });


           hook_methods("java.security.SecureRandom", "setSeed", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.SecureRandom setSeed");
               }
           });


           hook_methods("android.view.Window", "setLogo", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.view.Window setLogo");
               }
           });


           hook_methods("android.telephony.SmsManager", "sendDataMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsManager sendDataMessage");
               }
           });


           hook_methods("org.w3c.dom.Element", "getElementsByTagName", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook org.w3c.dom.Element getElementsByTagName");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getNeighboringCellInfo", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getNeighboringCellInfo");
               }
           });


           hook_methods("javax.crypto.SecretKeyFactory", "getInstance", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.SecretKeyFactory getInstance");
               }
           });


           hook_methods("android.net.sip.SipManager", "createSipSession", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager createSipSession");
               }
           });


           hook_methods("javax.crypto.CipherOutputStream", "flush", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.CipherOutputStream flush");
               }
           });


           hook_methods("android.telephony.SmsManager", "divideMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsManager divideMessage");
               }
           });


           hook_methods("android.text.format.Time", "Time", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.text.format.Time Time");
               }
           });


           hook_methods("java.lang.Process", "getOutputStream", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Process getOutputStream");
               }
           });


           hook_methods("android.net.sip.SipManager", "register", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager register");
               }
           });


           hook_methods("android.location.LocationManager", "getProvider", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager getProvider");
               }
           });


           hook_methods("android.net.Proxy", "getDefaultPort", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.Proxy getDefaultPort");
               }
           });


           hook_methods("android.provider.ContactsContract", "getContactLookupUri", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.ContactsContract getContactLookupUri");
               }
           });


           hook_methods("java.lang.StringBuffer", "substring", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.StringBuffer substring");
               }
           });


           hook_methods("java.util.concurrent.ThreadPoolExecutor", "getCompletedTaskCount", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.concurrent.ThreadPoolExecutor getCompletedTaskCount");
               }
           });


           hook_methods("android.webkit.WebSettings", "setTextSize", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.WebSettings setTextSize");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getAllCellInfo", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getAllCellInfo");
               }
           });


           hook_methods("android.content.Context", "bindService", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.Context bindService");
               }
           });


           hook_methods("java.lang.Process", "destroy", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Process destroy");
               }
           });


           hook_methods("android.media.MediaRecorder", "setAudioSource", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.media.MediaRecorder setAudioSource");
               }
           });


           hook_methods("android.view.Window", "getLayoutInflater", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.view.Window getLayoutInflater");
               }
           });


           hook_methods("android.net.SSLCertificateSocketFactory", "getHttpSocketFactory", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.SSLCertificateSocketFactory getHttpSocketFactory");
               }
           });


           hook_methods("android.provider.Browser", "deleteHistoryTimeFrame", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Browser deleteHistoryTimeFrame");
               }
           });

           hook_methods("android.view.Window", "setIcon", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.view.Window setIcon");
               }
           });


           hook_methods("java.lang.reflect.Proxy", "newProxyInstance", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.reflect.Proxy newProxyInstance");
               }
           });


           hook_methods("java.io.Reader", "markSupported", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.Reader markSupported");
               }
           });


           hook_methods("java.util.jar.Attributes", "putAll", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.jar.Attributes putAll");
               }
           });


           hook_methods("android.database.sqlite.SQLiteDatabase", "isOpen", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.database.sqlite.SQLiteDatabase isOpen");
               }
           });


           hook_methods("android.database.sqlite.SQLiteDatabase", "delete", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.database.sqlite.SQLiteDatabase delete");
               }
           });


           hook_methods("android.webkit.WebSettings", "setMinimumFontSize", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.WebSettings setMinimumFontSize");
               }
           });


           hook_methods("android.speech.SpeechRecognizer", "stopListening", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.speech.SpeechRecognizer stopListening");
               }
           });


           hook_methods("android.telephony.gsm.SmsManager", "sendTextMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.gsm.SmsManager sendTextMessage");
               }
           });


           hook_methods("java.io.File", "mkdir", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.File mkdir");
               }
           });


           hook_methods("android.telephony.PhoneNumberUtils", "isVoiceMailNumber", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.PhoneNumberUtils isVoiceMailNumber");
               }
           });


           hook_methods("android.webkit.WebView", "setVerticalScrollbarOverlay", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.WebView setVerticalScrollbarOverlay");
               }
           });


           hook_methods("javax.crypto.EncryptedPrivateKeyInfo", "getKeySpec", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.EncryptedPrivateKeyInfo getKeySpec");
               }
           });


           hook_methods("android.view.ViewGroup", "addView", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.view.ViewGroup addView");
               }
           });


           hook_methods("android.content.pm.ProviderInfo", "ProviderInfo", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.pm.ProviderInfo ProviderInfo");
               }
           });


           hook_methods("android.os.PowerManager", "newWakeLock", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.os.PowerManager newWakeLock");
               }
           });


           hook_methods("android.app.ActivityManager", "getRunningServices", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.ActivityManager getRunningServices");
               }
           });


           hook_methods("android.app.ActivityManager", "killBackgroundProcesses", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.ActivityManager killBackgroundProcesses");
               }
           });


           hook_methods("java.util.jar.JarEntry", "getName", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.jar.JarEntry getName");
               }
           });


           hook_methods("android.net.sip.SipManager", "open", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager open");
               }
           });


           hook_methods("java.security.spec.RSAPrivateKeySpec", "RSAPrivateKeySpec", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.spec.RSAPrivateKeySpec RSAPrivateKeySpec");
               }
           });


           hook_methods("android.provider.Contacts", "markAsContacted", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Contacts markAsContacted");
               }
           });


           hook_methods("android.database.sqlite.SQLiteDatabase", "updateWithOnConflict", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.database.sqlite.SQLiteDatabase updateWithOnConflict");
               }
           });


           hook_methods("android.provider.Browser", "deleteFromHistory", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Browser deleteFromHistory");
               }
           });


           hook_methods("java.io.FileReader", "read", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.FileReader read");
               }
           });


           hook_methods("android.webkit.WebChromeClient", "onRequestFocus", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.WebChromeClient onRequestFocus");
               }
           });


           hook_methods("android.telephony.gsm.SmsManager", "getDefault", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.gsm.SmsManager getDefault");
               }
           });


           hook_methods("android.accounts.AccountManager", "blockingGetAuthToken", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager blockingGetAuthToken");
               }
           });


           hook_methods("java.net.URLClassLoader", "loadClass", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.URLClassLoader loadClass");
               }
           });


           hook_methods("java.util.concurrent.FutureTask", "done", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.concurrent.FutureTask done");
               }
           });


           hook_methods("android.app.DownloadManager", "enqueue", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.DownloadManager enqueue");
               }
           });


           hook_methods("android.app.Instrumentation", "callActivityOnNewIntent", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Instrumentation callActivityOnNewIntent");
               }
           });


           hook_methods("android.net.ConnectivityManager", "startUsingNetworkFeature", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.ConnectivityManager startUsingNetworkFeature");
               }
           });


           hook_methods("java.io.FileWriter", "close", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.FileWriter close");
               }
           });


           hook_methods("android.content.Context", "sendBroadcast", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.Context sendBroadcast");
               }
           });


           hook_methods("java.util.jar.Attributes", "putValue", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.jar.Attributes putValue");
               }
           });


           hook_methods("android.hardware.Sensor", "getName", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.hardware.Sensor getName");
               }
           });


           hook_methods("java.net.URLConnection", "setDoInput", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.URLConnection setDoInput");
               }
           });


           hook_methods("android.location.LocationManager", "addProximityAlert", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager addProximityAlert");
               }
           });


           hook_methods("java.security.cert.Certificate", "getPublicKey", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.cert.Certificate getPublicKey");
               }
           });


           hook_methods("java.lang.StringBuffer", "ensureCapacity", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.StringBuffer ensureCapacity");
               }
           });


           hook_methods("android.accounts.AccountManager", "hasFeatures", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager hasFeatures");
               }
           });


           hook_methods("android.app.Instrumentation", "callActivityOnUserLeaving", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Instrumentation callActivityOnUserLeaving");
               }
           });


           hook_methods("java.math.BigInteger", "divideAndRemainder", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.math.BigInteger divideAndRemainder");
               }
           });


           hook_methods("android.database.sqlite.SQLiteDatabase", "execSQL", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.database.sqlite.SQLiteDatabase execSQL");
               }
           });


           hook_methods("android.telecom.TelecomManager", "isInCall", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telecom.TelecomManager isInCall");
               }
           });


           hook_methods("android.telephony.SmsManager", "sendDataMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsManager sendDataMessage");
               }
           });


           hook_methods("android.media.AudioRecord", "AudioRecord", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.media.AudioRecord AudioRecord");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getVoiceMailAlphaTag", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getVoiceMailAlphaTag");
               }
           });


           hook_methods("java.lang.ClassLoader", "getParent", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.ClassLoader getParent");
               }
           });

           hook_methods("android.app.Application", "onCreate", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Application onCreate");
               }
           });


           hook_methods("android.telephony.gsm.SmsManager", "sendTextMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.gsm.SmsManager sendTextMessage");
               }
           });


           hook_methods("android.provider.Browser", "truncateHistory", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Browser truncateHistory");
               }
           });


           hook_methods("android.net.sip.SipManager", "open", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager open");
               }
           });


           hook_methods("javax.crypto.NoSuchPaddingException", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.NoSuchPaddingException printStackTrace");
               }
           });


           hook_methods("android.widget.RadioButton", "isChecked", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.RadioButton isChecked");
               }
           });


           hook_methods("java.util.zip.Deflater", "finished", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.zip.Deflater finished");
               }
           });


           hook_methods("android.accounts.AccountManager", "getAuthTokenLabel", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager getAuthTokenLabel");
               }
           });


           hook_methods("android.location.LocationManager", "addGpsStatusListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager addGpsStatusListener");
               }
           });


           hook_methods("android.media.MediaRecorder", "setVideoSource", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.media.MediaRecorder setVideoSource");
               }
           });


           hook_methods("java.security.DigestInputStream", "read", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.DigestInputStream read");
               }
           });


           hook_methods("dalvik.system.DexClassLoader", "DexClassLoader", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook dalvik.system.DexClassLoader DexClassLoader");
               }
           });


//        hook_methods("java.lang.Class<T>", "forName", new XC_MethodHook(){
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                HookWriteLog("hook java.lang.Class<T> forName");
//            }
//        });


           hook_methods("android.telephony.SmsManager", "sendMultipartTextMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsManager sendMultipartTextMessage");
               }
           });


           hook_methods("android.net.wifi.WifiManager", "enableNetwork", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.wifi.WifiManager enableNetwork");
               }
           });


           hook_methods("android.app.Instrumentation", "callActivityOnPostCreate", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Instrumentation callActivityOnPostCreate");
               }
           });


           hook_methods("android.net.sip.SipManager", "takeAudioCall", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager takeAudioCall");
               }
           });


           hook_methods("android.widget.RadioButton", "setOnCheckedChangeListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.RadioButton setOnCheckedChangeListener");
               }
           });


           hook_methods("android.net.wifi.WifiManager", "updateNetwork", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.wifi.WifiManager updateNetwork");
               }
           });


           hook_methods("javax.crypto.Cipher", "init", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.Cipher init");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getVoiceMailNumber", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getVoiceMailNumber");
               }
           });


           hook_methods("android.hardware.Camera", "open", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.hardware.Camera open");
               }
           });


           hook_methods("android.provider.ContactsContract", "getLookupUri", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.ContactsContract getLookupUri");
               }
           });


           hook_methods("javax.crypto.BadPaddingException", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.BadPaddingException printStackTrace");
               }
           });


           hook_methods("android.bluetooth.BluetoothAdapter", "getAddress", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.bluetooth.BluetoothAdapter getAddress");
               }
           });


           hook_methods("android.telephony.cdma.CdmaCellLocation", "getNetworkId", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.cdma.CdmaCellLocation getNetworkId");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getVoiceMailAlphaTag", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getVoiceMailAlphaTag");
               }
           });


           hook_methods("android.content.BroadcastReceiver", "abortBroadcast", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.BroadcastReceiver abortBroadcast");
               }
           });


           hook_methods("android.database.sqlite.SQLiteDatabase", "deleteDatabase", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.database.sqlite.SQLiteDatabase deleteDatabase");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getDeviceSoftwareVersion", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getDeviceSoftwareVersion");
               }
           });


           hook_methods("java.io.File", "createNewFile", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.File createNewFile");
               }
           });


           hook_methods("android.app.ActivityManager", "getRunningAppProcesses", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.ActivityManager getRunningAppProcesses");
               }
           });


           hook_methods("java.util.WeakHashMap", "keySet", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.WeakHashMap keySet");
               }
           });


           hook_methods("java.util.jar.JarFile", "entries", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.jar.JarFile entries");
               }
           });


           hook_methods("java.lang.Float", "Float", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Float Float");
               }
           });


           hook_methods("java.lang.ProcessBuilder", "start", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.ProcessBuilder start");
               }
           });


           hook_methods("android.telephony.SmsMessage", "getMessageBody", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsMessage getMessageBody");
               }
           });


           hook_methods("java.util.zip.Adler32", "getValue", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.zip.Adler32 getValue");
               }
           });


           hook_methods("android.app.AlertDialog", "onCreate", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.AlertDialog onCreate");
               }
           });


           hook_methods("android.telephony.SubscriptionManager", "getActiveSubscriptionInfoCount", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SubscriptionManager getActiveSubscriptionInfoCount");
               }
           });


           hook_methods("android.widget.LinearLayout", "setBackgroundDrawable", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.LinearLayout setBackgroundDrawable");
               }
           });


           hook_methods("android.location.LocationManager", "isProviderEnabled", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.location.LocationManager isProviderEnabled");
               }
           });


           hook_methods("javax.crypto.SecretKeyFactory", "generateSecret", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.SecretKeyFactory generateSecret");
               }
           });


           hook_methods("android.inputmethodservice.KeyboardView", "swipeRight", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.inputmethodservice.KeyboardView swipeRight");
               }
           });


           hook_methods("android.widget.EditText", "setTextSize", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.EditText setTextSize");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "listen", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager listen");
               }
           });


           hook_methods("android.net.sip.SipManager", "setRegistrationListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager setRegistrationListener");
               }
           });


           hook_methods("java.security.DigestInputStream", "DigestInputStream", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.DigestInputStream DigestInputStream");
               }
           });


           hook_methods("java.io.BufferedReader", "ready", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.BufferedReader ready");
               }
           });


           hook_methods("android.content.Context", "fileList", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.Context fileList");
               }
           });

           hook_methods("android.graphics.NinePatch", "isNinePatchChunk", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.graphics.NinePatch isNinePatchChunk");
               }
           });


           hook_methods("android.content.ContextWrapper", "sendStickyOrderedBroadcast", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.ContextWrapper sendStickyOrderedBroadcast");
               }
           });


           hook_methods("android.provider.CalendarContract", "query", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.CalendarContract query");
               }
           });


           hook_methods("android.provider.Contacts", "getSetting", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Contacts getSetting");
               }
           });


           hook_methods("java.lang.Runtime", "load", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Runtime load");
               }
           });


           hook_methods("android.telephony.SmsManager", "getDefault", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsManager getDefault");
               }
           });


           hook_methods("android.view.inputmethod.InputMethodManager", "showInputMethodAndSubtypeEnabler", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.view.inputmethod.InputMethodManager showInputMethodAndSubtypeEnabler");
               }
           });


           hook_methods("java.net.Proxy", "Proxy", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.Proxy Proxy");
               }
           });


           hook_methods("android.telephony.gsm.GsmCellLocation", "getLac", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.gsm.GsmCellLocation getLac");
               }
           });


           hook_methods("android.hardware.Sensor", "getVendor", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.hardware.Sensor getVendor");
               }
           });


           hook_methods("android.accounts.AccountManager", "addOnAccountsUpdatedListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager addOnAccountsUpdatedListener");
               }
           });


           hook_methods("android.app.Instrumentation", "callActivityOnStart", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Instrumentation callActivityOnStart");
               }
           });


           hook_methods("android.net.sip.SipManager", "takeAudioCall", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager takeAudioCall");
               }
           });


           hook_methods("android.net.sip.SipManager", "unregister", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager unregister");
               }
           });


           hook_methods("android.net.NetworkInfo", "isAvailable", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.NetworkInfo isAvailable");
               }
           });


           hook_methods("org.apache.http.params.HttpConnectionParams", "setStaleCheckingEnabled", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook org.apache.http.params.HttpConnectionParams setStaleCheckingEnabled");
               }
           });


           hook_methods("java.util.Hashtable", "keys", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.Hashtable keys");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getGroupIdLevel1", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getGroupIdLevel1");
               }
           });


           hook_methods("android.net.sip.SipManager", "setRegistrationListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager setRegistrationListener");
               }
           });


           hook_methods("android.content.ContextWrapper", "stopService", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.ContextWrapper stopService");
               }
           });


           hook_methods("android.widget.EditText", "setFocusableInTouchMode", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.EditText setFocusableInTouchMode");
               }
           });


           hook_methods("android.telephony.cdma.CdmaCellLocation", "getBaseStationId", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.cdma.CdmaCellLocation getBaseStationId");
               }
           });


           hook_methods("java.lang.Exception", "fillInStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Exception fillInStackTrace");
               }
           });


           hook_methods("android.telephony.SignalStrength", "isGsm", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SignalStrength isGsm");
               }
           });


           hook_methods("java.util.SortedSet", "addAll", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.SortedSet addAll");
               }
           });


           hook_methods("android.speech.SpeechRecognizer", "setRecognitionListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.speech.SpeechRecognizer setRecognitionListener");
               }
           });


           hook_methods("android.widget.EditText", "setFocusable", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.EditText setFocusable");
               }
           });


           hook_methods("android.app.Instrumentation", "callActivityOnRestoreInstanceState", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Instrumentation callActivityOnRestoreInstanceState");
               }
           });


           hook_methods("java.util.Date", "toLocaleString", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.Date toLocaleString");
               }
           });


           hook_methods("java.lang.Process", "waitFor", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Process waitFor");
               }
           });


           hook_methods("android.provider.VoicemailContract", "buildSourceUri", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.VoicemailContract buildSourceUri");
               }
           });


           hook_methods("android.content.ContextWrapper", "sendStickyBroadcast", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.ContextWrapper sendStickyBroadcast");
               }
           });


           hook_methods("android.telephony.SmsManager", "downloadMultimediaMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsManager downloadMultimediaMessage");
               }
           });


           hook_methods("android.telecom.TelecomManager", "showInCallScreen", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telecom.TelecomManager showInCallScreen");
               }
           });


           hook_methods("java.nio.charset.CoderResult", "toString", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.nio.charset.CoderResult toString");
               }
           });


           hook_methods("android.app.Dialog", "setOnKeyListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Dialog setOnKeyListener");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getSimState", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getSimState");
               }
           });


           hook_methods("java.util.zip.Adler32", "reset", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.zip.Adler32 reset");
               }
           });


           hook_methods("android.provider.Contacts", "queryGroups", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Contacts queryGroups");
               }
           });


           hook_methods("android.widget.QuickContactBadge", "onClick", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.QuickContactBadge onClick");
               }
           });


           hook_methods("android.telephony.SmsManager", "divideMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsManager divideMessage");
               }
           });


           hook_methods("android.os.Environment", "getDataDirectory", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.os.Environment getDataDirectory");
               }
           });


           hook_methods("java.util.Properties", "put", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.Properties put");
               }
           });


           hook_methods("java.util.WeakHashMap", "size", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.WeakHashMap size");
               }
           });


           hook_methods("android.telephony.TelephonyManager", "getCellLocation", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.TelephonyManager getCellLocation");
               }
           });


           hook_methods("android.net.wifi.WifiManager", "setWifiEnabled", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.wifi.WifiManager setWifiEnabled");
               }
           });


           hook_methods("android.net.sip.SipManager", "isRegistered", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager isRegistered");
               }
           });


           hook_methods("java.text.SimpleDateFormat", "applyPattern", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.text.SimpleDateFormat applyPattern");
               }
           });


           hook_methods("android.provider.Contacts", "addToMyContactsGroup", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Contacts addToMyContactsGroup");
               }
           });


           hook_methods("java.lang.Character", "toTitleCase", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Character toTitleCase");
               }
           });


           hook_methods("android.accounts.AccountManager", "addOnAccountsUpdatedListener", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager addOnAccountsUpdatedListener");
               }
           });


           hook_methods("android.net.sip.SipManager", "getSessionFor", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.sip.SipManager getSessionFor");
               }
           });


           hook_methods("android.telephony.gsm.SmsManager", "sendMultipartTextMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.gsm.SmsManager sendMultipartTextMessage");
               }
           });


           hook_methods("java.net.URISyntaxException", "getCause", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.URISyntaxException getCause");
               }
           });


           hook_methods("java.net.URLClassLoader", "URLClassLoader", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.URLClassLoader URLClassLoader");
               }
           });


           hook_methods("java.util.jar.Attributes", "Attributes", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.jar.Attributes Attributes");
               }
           });


           hook_methods("android.telephony.gsm.SmsManager", "divideMessage", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.gsm.SmsManager divideMessage");
               }
           });


           hook_methods("java.lang.Class", "getDeclaredMethod", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Class getDeclaredMethod");
               }
           });


           hook_methods("android.accounts.AccountManager", "getAuthTokenByFeatures", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager getAuthTokenByFeatures");
               }
           });


           hook_methods("org.xmlpull.v1.XmlSerializer", "setFeature", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook org.xmlpull.v1.XmlSerializer setFeature");
               }
           });


           hook_methods("android.content.ContextWrapper", "sendBroadcast", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.ContextWrapper sendBroadcast");
               }
           });


           hook_methods("android.widget.TextView", "setText", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.TextView setText");
               }
           });


           hook_methods("java.security.cert.CertificateEncodingException", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.security.cert.CertificateEncodingException printStackTrace");
               }
           });


           hook_methods("android.os.storage.StorageManager", "getStorageVolumes", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.os.storage.StorageManager getStorageVolumes");
               }
           });


           hook_methods("android.app.Service", "onConfigurationChanged", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Service onConfigurationChanged");
               }
           });


           hook_methods("android.webkit.CookieManager", "removeAllCookie", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.CookieManager removeAllCookie");
               }
           });


           hook_methods("java.net.HttpURLConnection", "connect", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.HttpURLConnection connect");
               }
           });


           hook_methods("android.telephony.SignalStrength", "getCdmaEcio", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SignalStrength getCdmaEcio");
               }
           });


           hook_methods("android.content.ContextWrapper", "sendBroadcastAsUser", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.ContextWrapper sendBroadcastAsUser");
               }
           });


           hook_methods("android.app.AlertDialog", "AlertDialog", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.AlertDialog AlertDialog");
               }
           });


           hook_methods("android.telephony.gsm.GsmCellLocation", "getCid", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.gsm.GsmCellLocation getCid");
               }
           });


           hook_methods("android.webkit.WebSettings", "getMinimumFontSize", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.WebSettings getMinimumFontSize");
               }
           });


           hook_methods("android.view.ViewManager", "addView", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.view.ViewManager addView");
               }
           });


           hook_methods("java.io.BufferedInputStream", "reset", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.BufferedInputStream reset");
               }
           });


           hook_methods("android.telephony.SmsMessage", "getOriginatingAddress", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsMessage getOriginatingAddress");
               }
           });


           hook_methods("java.util.zip.Adler32", "Adler32", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.zip.Adler32 Adler32");
               }
           });


           hook_methods("java.lang.Character", "Character", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.Character Character");
               }
           });


           hook_methods("android.os.Environment", "getExternalStoragePublicDirectory", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.os.Environment getExternalStoragePublicDirectory");
               }
           });


           hook_methods("java.net.NetworkInterface", "getDisplayName", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.NetworkInterface getDisplayName");
               }
           });


           hook_methods("javax.crypto.Mac", "getAlgorithm", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.Mac getAlgorithm");
               }
           });


           hook_methods("android.widget.QuickContactBadge", "assignContactFromPhone", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.widget.QuickContactBadge assignContactFromPhone");
               }
           });


           hook_methods("android.content.Context", "registerReceiver", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.Context registerReceiver");
               }
           });


           hook_methods("java.util.zip.ZipEntry", "setCompressedSize", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.zip.ZipEntry setCompressedSize");
               }
           });


           hook_methods("android.webkit.WebSettings", "setDefaultZoom", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.webkit.WebSettings setDefaultZoom");
               }
           });


           hook_methods("android.telephony.SignalStrength", "getEvdoSnr", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SignalStrength getEvdoSnr");
               }
           });


           hook_methods("android.util.Base64", "encode", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.util.Base64 encode");
               }
           });


           hook_methods("java.nio.channels.FileChannel", "lock", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.nio.channels.FileChannel lock");
               }
           });


           hook_methods("android.content.ContentResolver", "delete", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.ContentResolver delete");
               }
           });


           hook_methods("android.accounts.AccountManager", "getAccountsByTypeAndFeatures", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.accounts.AccountManager getAccountsByTypeAndFeatures");
               }
           });


           hook_methods("android.telephony.SmsMessage", "getDisplayMessageBody", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.telephony.SmsMessage getDisplayMessageBody");
               }
           });


           hook_methods("org.apache.http.params.HttpParams", "setIntParameter", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook org.apache.http.params.HttpParams setIntParameter");
               }
           });


           hook_methods("android.content.ContextWrapper", "removeStickyBroadcast", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.ContextWrapper removeStickyBroadcast");
               }
           });


           hook_methods("javax.crypto.KeyGenerator", "init", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.KeyGenerator init");
               }
           });


           hook_methods("java.io.File", "listFiles", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.File listFiles");
               }
           });


           hook_methods("java.util.zip.Adler32", "update", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.util.zip.Adler32 update");
               }
           });


           hook_methods("java.lang.reflect.InvocationTargetException", "printStackTrace", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.lang.reflect.InvocationTargetException printStackTrace");
               }
           });


           hook_methods("javax.crypto.KeyGenerator", "generateKey", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.KeyGenerator generateKey");
               }
           });


           hook_methods("android.app.Instrumentation", "onException", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Instrumentation onException");
               }
           });


           hook_methods("android.app.Application", "Application", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.app.Application Application");
               }
           });


           hook_methods("java.io.LineNumberReader", "LineNumberReader", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.LineNumberReader LineNumberReader");
               }
           });


           hook_methods("android.provider.Contacts", "addPostalLocation", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.provider.Contacts addPostalLocation");
               }
           });


           hook_methods("java.nio.charset.IllegalCharsetNameException", "IllegalCharsetNameException", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.nio.charset.IllegalCharsetNameException IllegalCharsetNameException");
               }
           });


           hook_methods("android.content.ContextWrapper", "sendStickyBroadcastAsUser", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.content.ContextWrapper sendStickyBroadcastAsUser");
               }
           });


           hook_methods("java.net.URLConnection", "getHeaderField", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.net.URLConnection getHeaderField");
               }
           });


           hook_methods("java.io.LineNumberReader", "readLine", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook java.io.LineNumberReader readLine");
               }
           });


           hook_methods("android.net.wifi.WifiManager", "getConfiguredNetworks", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.net.wifi.WifiManager getConfiguredNetworks");
               }
           });


           hook_methods("javax.crypto.Cipher", "getBlockSize", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook javax.crypto.Cipher getBlockSize");
               }
           });


           hook_methods("android.graphics.drawable.NinePatchDrawable", "NinePatchDrawable", new XC_MethodHook(){
               @Override
               protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                   HookWriteLog("hook android.graphics.drawable.NinePatchDrawable NinePatchDrawable");
               }
           });


       }
    }
}