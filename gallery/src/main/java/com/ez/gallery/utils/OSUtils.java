package com.ez.gallery.utils;

import android.os.Build;

import java.io.IOException;
import java.lang.reflect.Method;

public class OSUtils {
    private static final String KEY_EMUI_VERSION_CODE = "ro.build.version.emui";
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";

    private static boolean isPropertiesExist(String... keys) {
        try {
            BuildProperties prop = BuildProperties.newInstance();
            for (String key : keys) {
                if (prop.containsKey(key))
                    return true;
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean isEMUI() {
        return isPropertiesExist(KEY_EMUI_VERSION_CODE);
    }

    public static boolean isMIUI() {
        return isPropertiesExist(KEY_MIUI_VERSION_CODE, KEY_MIUI_VERSION_NAME, KEY_MIUI_INTERNAL_STORAGE);
    }

    public static boolean isFlyme() {
        try {
            final Method method = Build.class.getMethod("hasSmartBar");
            return method != null;
        } catch (final Exception e) {
            return false;
        }
    }
}