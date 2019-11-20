package com.example.admin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateGroup extends Fragment {
    private EditText name;
    private EditText gname;
    private Button createGroupBtn;
    private DatabaseReference dbform;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_create_group,container,false);
        name=v.findViewById(R.id.name);
        gname=v.findViewById(R.id.groupName);
        createGroupBtn=v.findViewById(R.id.createGroupButton);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Groups");
        createGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addForm();
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new AddQuestion());
                fr.commit();
            }
        });
        return v;
    }

    public void addForm()
    {
        name=getView().findViewById(R.id.name);
        String nameS=name.getText().toString();
        gname=getView().findViewById(R.id.groupName);
        String groupNameS=gname.getText().toString();
        Fire_CreateGroup fm=new Fire_CreateGroup(nameS,groupNameS);
        databaseReference.push().setValue(fm);
        Toast.makeText(getActivity(),"Insert to database",Toast.LENGTH_SHORT).show();

    }
}
