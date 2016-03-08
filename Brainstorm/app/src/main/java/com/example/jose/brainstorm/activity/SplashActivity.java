package com.example.jose.brainstorm.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.jose.brainstorm.R;

/**
 * Splash activity
 * Created by Jose on 3/8/2016.
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        PackageInfo pInfo;
        String versionNumber = null;

        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            versionNumber = pInfo.versionName;
            versionNumber = (versionNumber.split(" "))[1];

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        TextView version = (TextView) findViewById(R.id.version);
        version.setText(versionNumber);

        findViewById(R.id.splash).setOnClickListener(new SplashClickListener());

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                if (!isFinishing()) {
                    launchLoginActivity();
                }
            }
        }, 2000);
    }

    private void launchLoginActivity() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private class SplashClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            launchLoginActivity();
        }

    }
}