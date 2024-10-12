package com.custom_home_page_kiosk_flutter_app;

import android.app.admin.DevicePolicyManager;
import android.os.Bundle;
import android.content.ComponentName;
import android.content.Intent;
import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends FlutterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Start Kiosk Mode on app launch
        if (isDeviceOwner()) {
            startLockTask(); // Enter kiosk mode
        }

        // Start background KioskService
        Intent intent = new Intent(this, KioskService.class);
        startService(intent);
    }

    private boolean isDeviceOwner() {
        DevicePolicyManager dpm = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        ComponentName adminComponent = new ComponentName(this, MyAdminReceiver.class);
        return dpm.isDeviceOwnerApp(getPackageName());
    }
}
