package com.example.jose.brainstorm.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

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
    }

}
