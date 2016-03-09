package com.example.jose.brainstorm.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.jose.brainstorm.R;
import com.example.jose.brainstorm.fragment.GameModeFragment;

import java.util.HashMap;

/**
 * Main activity
 * Created by Jose on 3/8/2016.
 */

public class MainActivity extends FragmentActivity {

    private static final String GAME_MODE = "Game Mode";
    private Context mContext = this;
    private HashMap<String, Fragment> mFragmentTabs = new HashMap<>();
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeTab(GAME_MODE);
    }

    private void changeTab(String tabId) {

        Fragment newFragment = mFragmentTabs.get(tabId);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (mCurrentFragment == null) {

            if (newFragment == null) {
                newFragment = Fragment.instantiate(this, getFragmentClassName(tabId));
                mFragmentTabs.put(tabId, newFragment);
                ft.add(R.id.tabs_content_layout, newFragment, tabId);

            } else ft.attach(newFragment);

            mCurrentFragment = newFragment;

        } else {

            if (mCurrentFragment != newFragment) {
                ft.detach(mCurrentFragment);

                if (newFragment == null) {
                    newFragment = Fragment.instantiate(this, getFragmentClassName(tabId));
                    mFragmentTabs.put(tabId, newFragment);
                    ft.add(R.id.tabs_content_layout, newFragment, tabId);

                } else ft.attach(newFragment);

                mCurrentFragment = newFragment;
            }
        }

        ft.commit();
        getSupportFragmentManager().executePendingTransactions();

    }

    private String getFragmentClassName(String tabId) {

        switch (tabId) {
            case GAME_MODE:
                return GameModeFragment.class.getName();
        }

        // todo: change to null
        return "";
    }

}
