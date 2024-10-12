package com.custom_home_page_kiosk_flutter_app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class KioskService extends Service {

    private static final String TAG = "KioskService";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Kiosk Mode Service started");
        // Continue running until explicitly stopped
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Kiosk Mode Service stopped");
    }
}
