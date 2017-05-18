package com.gefufeng.rndemo.h5.pkg;

import android.content.Context;

import com.gefufeng.rndemo.base.BaseApplication;
import com.gefufeng.rndemo.base.BusinessCommonParameter;

import java.io.File;

/**
 * Created by gefufeng on 17/5/18.
 */

public class H5Package {

    public static final String webappWorkDirNamePrefix = "webapp";


    public static final String webappWorkDirName = webappWorkDirNamePrefix+"_"+ BusinessCommonParameter.VERSION;

    public static final File webAppWorkDir = BaseApplication.getInstance().getDir(webappWorkDirName, Context.MODE_PRIVATE);

}