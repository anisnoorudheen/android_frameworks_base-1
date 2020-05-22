/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.internal.util.zenx;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.app.ActivityManager;
import android.content.res.Resources;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.input.InputManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.app.AlertDialog;
import android.app.IActivityManager;
import android.os.Looper;
import android.content.DialogInterface;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.SystemClock;
import android.view.InputDevice;
import android.view.IWindowManager;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.WindowManagerGlobal;
import android.util.DisplayMetrics;
import android.hardware.SensorManager;
import android.os.UserHandle;
import android.provider.Settings;
import android.os.AsyncTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.android.internal.R;
import com.android.internal.statusbar.IStatusBarService;

import java.util.Locale;

public class ZenxUtils {

    // Check for lockscreen accent color
    public static boolean useLockscreenClockAccentColor(Context context) {
        return Settings.System.getInt(context.getContentResolver(),
          Settings.System.LOCKSCREEN_ACCENT_COLOR, 0) == 1;
    }

     // Current performance mode
    public static String GetLastPerformanceProfileFromSettings(Context context) {
          int state = Settings.System.getInt(context.getContentResolver(),
                Settings.System.LAST_PERFORMANCE_PROFILE, 0);
         return Integer.toString(state);
    }

     // Set performance mode
    public static void SetLastPerformanceProfileToSettings(Context context, String mode) {
        Settings.System.putIntForUser(context.getContentResolver(),
                    Settings.System.LAST_PERFORMANCE_PROFILE, Integer.parseInt(mode), UserHandle.USER_CURRENT);
    }

    // Check for lockscreen indication accent color
    public static boolean IntelligentPerformanceProfileAvailable() {
        return Resources.getSystem().getBoolean(
                        R.bool.config_intelligent_performance_profile);
    }
}
