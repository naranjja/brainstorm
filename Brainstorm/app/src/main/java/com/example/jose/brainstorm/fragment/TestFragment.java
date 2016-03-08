package com.example.jose.brainstorm.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jose.brainstorm.R;

/**
 * Created by Jose on 3/8/2016.
 */
public class TestFragment extends Fragment {

    private Context mContext;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();

        view = inflater.inflate(R.layout.fragment_test, null);

        Toast.makeText(mContext, "Test Fragment", Toast.LENGTH_SHORT).show();

        return view;

    }

}
