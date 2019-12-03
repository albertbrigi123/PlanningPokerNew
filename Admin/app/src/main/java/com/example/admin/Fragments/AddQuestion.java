package com.example.admin.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.Database.Fire_Question;
import com.example.admin.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class AddQuestion extends Fragment {
    private String groupId;
    private EditText question;
    private Switch status;
    private Button add, goToGroupBtn;
    FirebaseDatabase db;
    DatabaseReference databaseReference;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_question, container, false);
        groupId = getArguments().getString("groupCode");
        //Log.d("FFFF",groupId);
        question = v.findViewById(R.id.newQuestion);
        //status = v.findViewById(R.id.status_switch);
        add = v.findViewById(R.id.addButton);
        goToGroupBtn = v.findViewById(R.id.GoToGroup);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(question.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Question textbox is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                addQuestion();
                Toast.makeText(getActivity(), "Question is added!", Toast.LENGTH_SHORT).show();
                }
        });


        return v;
    }

    public void addQuestion()
    {
        databaseReference = FirebaseDatabase.getInstance().getReference("Questions");
        String id = databaseReference.push().getKey();
        question=getView().findViewById(R.id.newQuestion);
        String codeS=groupId;
        status=getView().findViewById(R.id.switch1);
        String questionS=question.getText().toString();
        boolean fstatus;
        if(status.isChecked()==true)
        {
            fstatus = true;
        }
        else
        {
            fstatus = false;
        }
        Fire_Question questionForm = new Fire_Question(questionS,codeS,fstatus);
        databaseReference.child(id).setValue(questionForm);

    }

}
