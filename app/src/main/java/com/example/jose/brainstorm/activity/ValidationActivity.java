package com.example.jose.brainstorm.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jose.brainstorm.R;

/**
 * Validation activity
 * Created by Jose on 3/9/2016.
 */

public class ValidationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);

        findViewById(R.id.bValidate).setOnClickListener(new LoginClickListener());
    }

    private void launchMainActivity() {
        Intent intent = new Intent(ValidationActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private class LoginClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            launchMainActivity();
        }

    }

}
