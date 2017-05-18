package com.gefufeng.rndemo.base;

/**
 * Created by gefufeng on 17/5/18.
 */

public class BusinessCommonParameter {

    // 版本
    public static String VERSION = "100.000";
    // 系统编号为32
    public static String SYSTEMCODE = "32";
    // 语言 01为中文
    public final static String LANGUAGE = "01";
    public final static int SID_JINLI = 8081;

    public final static String TELEPHONE_SELF = "4008209662";

    // 自有渠道
    public final static int SID_SELF = 8892;

    // 系统sourceId
    public static String SOURCEID = SID_SELF + "";

    public static int SOURCEID_INT = SID_SELF;

    //灰度发布版本号
    public static  int APP_GRAY_RELEASE_NUM = 1141;

    public static final String __defaultClientID = "00000000000000000000";

    private static boolean shakeDevice = false;

    public static synchronized boolean getShakeDevice() {
        return shakeDevice;
    }

    public static synchronized void setShakeDevice(boolean value) {
        shakeDevice = value;
    }
}
