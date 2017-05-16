package com.gefufeng.rndemo.packages;

import android.widget.Toast;

import com.facebook.react.bridge.ObjectAlreadyConsumedException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by gefufeng on 17/5/15.
 */


/**
 Boolean -> Bool
 Integer -> Number
 Double -> Number
 Float -> Number
 String -> String
 Callback -> function
 ReadableMap -> Object
 ReadableArray -> Array
 */
public class NativeToast extends ReactContextBaseJavaModule {

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public NativeToast(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "NativeToast";
    }

    /**
     *
     * @param message
     * @param duration
     */
    @ReactMethod
    public void show(String message,int duration){
        Toast.makeText(getReactApplicationContext(),message,duration).show();
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        Map<String,Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }
}
