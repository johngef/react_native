package com.gefufeng.rndemo.packages;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 *
 * 有回调的JS调用native方法
 * Created by gefufeng on 17/5/15.
 */



public class CallBackNative extends ReactContextBaseJavaModule {


    public CallBackNative(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "CallBackNative";
    }
    @ReactMethod
    public void getData(Callback callback){
        String str = "gefufeng";
        callback.invoke(str);
    }
}
