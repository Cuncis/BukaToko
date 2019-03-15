package com.boss.cuncis.bukatoko;

import android.app.Application;
import android.util.Log;

import com.boss.cuncis.bukatoko.data.PrefsManager;

public class App extends Application {
    public static PrefsManager prefsManager;

    @Override
    public void onCreate() {
        super.onCreate();
        prefsManager = new PrefsManager(this);
        Log.d("_logBase", "onCreate: Test");
    }
}
