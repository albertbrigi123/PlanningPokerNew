package com.example.admin.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.R;


public class AddQuestion extends Fragment {
    private String groupId;
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_add_question,container,false);
        groupId = getArguments().getString("groupCode");
        Log.d("FFFF",groupId);
        return v;}

}
