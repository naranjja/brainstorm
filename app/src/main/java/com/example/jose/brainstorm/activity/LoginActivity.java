package com.example.jose.brainstorm.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jose.brainstorm.R;

/**
 * Login activity
 * Created by Jose on 3/8/2016.
 */

public class LoginActivity extends Activity {

    private Context mContext = this;
    private String user = null;
    private String pass = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.bLogin).setOnClickListener(new LoginClickListener());
    }

    private void launchMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void launchValidationActivity() {
        Intent intent = new Intent(LoginActivity.this, ValidationActivity.class);
        startActivity(intent);
        finish();
    }

    private class LoginClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // if the user has not already been validated
            launchValidationActivity();

            // if the user has already been validated
            // launchMainActivity();
        }

    }

}
