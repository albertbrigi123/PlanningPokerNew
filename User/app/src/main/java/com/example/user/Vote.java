package com.example.user;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Vote extends Fragment {
    private Button SendBtn;
    private TextView question;
    private CardView a,b,c,d,e,f,g,h,i;
    private String groupCodeS,uNameS;
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vote, container, false);
        groupCodeS=getArguments().getString("groupCode");
        uNameS=getArguments().getString("name");
        a=v.findViewById(R.id.one);
        b=v.findViewById(R.id.two);
        c=v.findViewById(R.id.tree);
        d=v.findViewById(R.id.four);
        e=v.findViewById(R.id.ten);
        f=v.findViewById(R.id.fifty);
        g=v.findViewById(R.id.oneh);
        h=v.findViewById(R.id.onet);
        i=v.findViewById(R.id.nulla);
        return v;
    }
}
