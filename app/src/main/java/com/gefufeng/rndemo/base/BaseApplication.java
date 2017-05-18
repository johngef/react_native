package com.gefufeng.rndemo.base;

import android.app.Application;
import android.content.pm.PackageManager;

/**
 * Created by gefufeng on 17/5/9.
 */

public class BaseApplication extends Application {

    private static BaseApplication applicationInstance;


    public static BaseApplication getInstance(){
        return applicationInstance;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationInstance = this;
    }

    /**
     * 在内存不足时会回调该方法;
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    /**
     * 只有在模拟器中终止程序时才会回调该方法, 在 Android 真机中是不会回调该方法的;
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}
