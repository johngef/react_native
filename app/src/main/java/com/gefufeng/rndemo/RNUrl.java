package com.gefufeng.rndemo;

import android.text.TextUtils;
import android.util.Log;

import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by gefufeng on 17/5/18.
 */

public class RNUrl {
    public static final String DEFAULT_MODULE_NAME = "HelloWorld";
    public static final String MAIN_MODULE_NAME_FOR_DEV = "index.android";

    public static final String RN_MODULE_NAME_KEY = "rnmodulename";


    private String urlStr = "";
    private String moduleName = "";
    private String hostInfo;
    private Map<String,String> queryParams;
    private SourceType sourceType;
    private boolean canDebug;


    public enum SourceType{
        Online,
        Assets,
        File,
        Sdcard,
        Unknown
    }

    public RNUrl(String urlStr){
        this.urlStr = urlStr;
        this.sourceType = getRNSourceTypeFromUrl(urlStr);
        this.moduleName = getModuleNameFromUrl(urlStr);
        if (this.sourceType == SourceType.Online){
            this.hostInfo = fetchHostInfo(this.urlStr);
        }
        canDebug = (this.sourceType == SourceType.Online) && urlStr.toLowerCase().contains("index.android.bundle");
    }

    private static SourceType getRNSourceTypeFromUrl(String urlStr) {
        SourceType sourceType = SourceType.Unknown;
        boolean isOnlineURL = isOnlineHTTPURL(urlStr);
        if (isOnlineURL) {
            sourceType = SourceType.Online;
        } else if (urlStr.toLowerCase().contains("sdcard")) {
            sourceType = SourceType.Sdcard;
        } else if (urlStr.startsWith("/")) {
            sourceType = SourceType.File;
        } else {
            sourceType = SourceType.Assets;
        }

        return sourceType;
    }

    public static boolean isOnlineHTTPURL(String inUrl) {
        return emptyOrNull(inUrl)?false:inUrl.toLowerCase().startsWith("http");
    }
    public static boolean emptyOrNull(String str) {
        return str == null || str.length() == 0;
    }

    private static String getModuleNameFromUrl(String urlStr) {
        if (TextUtils.isEmpty(urlStr)) {
            return null;
        }
        String moduleName = null;
        Map<String, String> params = getQueryMap(urlStr);
        if (params != null) {
            Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
            Map.Entry<String, String> entry;

            while (it.hasNext()) {
                entry = it.next();
                String key = entry.getKey();
                if (key.equalsIgnoreCase(RN_MODULE_NAME_KEY)) {
                    moduleName = entry.getValue();
                    break;
                }
            }
        }

        return moduleName;
    }

    private String fetchHostInfo(String urlStr) {
        try {
            URI uri = URI.create(urlStr);
            return uri.getHost() + ":" + uri.getPort();
        } catch (Exception e) {
            return "";
        }
    }


    public static Map<String, String> getQueryMap(String url) {
        Map<String, String> queries = new HashMap<>();
        try {
            if (url != null && url.contains("?") && url.length() > 1) {
                url = url.substring(url.indexOf("?") + 1, url.length());
                for (String str : url.split("&")) {
                    if (TextUtils.isEmpty(str)) {
                        continue;
                    }
                    int eIndex = str.indexOf("=");
                    String query[] = new String[2];
                    if (eIndex > 0 && eIndex < str.length()) {
                        query[0] = str.substring(0, eIndex);
                    }
                    if (eIndex + 1 > 0 && eIndex + 1 < str.length()) {
                        query[1] = str.substring(eIndex + 1, str.length());
                    }
                    queries.put(query[0], (query[1] != null ? URLDecoder.decode(query[1]) : null));
                }
            }
        } catch (Exception e) {
            Log.e("RNUrl","error when parse querymap", e);
        }
        return queries;
    }


    public String getUrlStr() {
        return urlStr;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getHostInfo() {
        return hostInfo;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public SourceType getSourceType() {
        return sourceType;
    }

    public boolean isCanDebug() {
        return canDebug;
    }
}
