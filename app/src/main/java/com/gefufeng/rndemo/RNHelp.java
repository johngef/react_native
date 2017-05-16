package com.gefufeng.rndemo;

import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.gefufeng.rndemo.packages.MyReactPackage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gefufeng on 17/5/15.
 */

public class RNHelp {

    public static List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new MainReactPackage(),
                new MyReactPackage()
        );
    }
}
