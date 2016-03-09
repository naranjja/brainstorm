package com.example.jose.brainstorm.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;

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

    private void launchMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private class SplashClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // if the user has not logged in yet
            launchLoginActivity();

            // if the user has already logged in
            // launchMainActivity();
        }

    }
}