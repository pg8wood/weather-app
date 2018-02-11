package com.patrickgatewood.weather.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.widget.Toast;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;
import com.patrickgatewood.weather.BuildConfig;

public class WeatherActivity extends Activity implements DefaultHardwareBackBtnHandler {

    public static int OVERLAY_PERMISSION_REQ_CODE = 1234;

    private ReactRootView reactRootView;
    private ReactInstanceManager reactInstanceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestOverlayPermission();
        reactRootView = new ReactRootView(this);
        reactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        reactRootView.startReactApplication(reactInstanceManager,
                "WeatherApp", null);

        setContentView(reactRootView);

        ((WeatherApplication) getApplication()).getApplicationComponent().inject(this);
    }

    /**
     * Requests permission to show overlays. Required for development builds with React Native
     * so that React Native can display development errors above all other windows.
     */
    private void requestOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (reactInstanceManager != null) {
            reactInstanceManager.onHostPause(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (reactInstanceManager != null) {
            reactInstanceManager.onHostResume(this, this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (reactInstanceManager != null) {
            reactInstanceManager.onHostDestroy(this);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    Toast.makeText(this, "Overlay permission not granted :(",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if (reactInstanceManager != null) {
            reactInstanceManager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Override the hardware menu button to show the react native dev menu
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && reactInstanceManager != null) {
            reactInstanceManager.showDevOptionsDialog();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}