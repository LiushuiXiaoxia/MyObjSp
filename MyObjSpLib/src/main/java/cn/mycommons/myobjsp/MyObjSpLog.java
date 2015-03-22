package cn.mycommons.myobjsp;

import android.util.Log;

/**
 * MyObjSpLog <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public class MyObjSpLog {

    static final String TAG = "MyObjSpLog";

    static boolean LOG = false;

    public static void enable(boolean enable) {
        LOG = enable;
    }

    public static void i(String msg, Object... args) {
        if (LOG) {
            Log.i(TAG, String.format(msg, args));
        }
    }

    public static void w(String msg, Object... args) {
        if (LOG) {
            Log.w(TAG, String.format(msg, args));
        }
    }

    public static void e(String msg, Object... args) {
        if (LOG) {
            Log.e(TAG, String.format(msg, args));
        }
    }

    public static void e(String msg, Exception e) {
        if (LOG) {
            Log.e(TAG, msg, e);
        }
    }
}