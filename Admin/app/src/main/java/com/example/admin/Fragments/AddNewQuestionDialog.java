package com.example.admin.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.admin.Interfaces.AddQuestionDialogListener;
import com.example.admin.Models.QuestionItem;
import com.example.admin.R;

public class AddNewQuestionDialog extends AppCompatDialogFragment {

    private EditText editTextQuestion;
    private Spinner difficultySpinner;
    private AddQuestionDialogListener listener;
    private QuestionItem questionItem;
    private int editPosition;

    public AddNewQuestionDialog() {

    }

    public AddNewQuestionDialog(QuestionItem editQuestion, int position) {
        this.questionItem = editQuestion;
        this.editPosition = position;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.question_dialog, null);

        editTextQuestion = view.findViewById(R.id.QuestionEditText);


        if (questionItem != null) {
            editTextQuestion.setText(questionItem.question);
            this.SetUpEditQuestion(builder, view);
        } else {
            this.SetUpAddNewQuestion(builder, view);
        }

        return builder.create();
    }


    private void SetUpEditQuestion(AlertDialog.Builder builder, View view) {
        builder.setView(view).setTitle("Edit question").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Edit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String question = editTextQuestion.getText().toString();
                if (question.isEmpty() || question == null) {
                    Toast addQuestion = Toast.makeText(getContext(), "QuestionItem cannot be blank", Toast.LENGTH_SHORT);
                    addQuestion.show();
                    return;
                }

                listener.applyQuestionModification(question,editPosition);
            }
        });
    }

    private void SetUpAddNewQuestion(AlertDialog.Builder builder, View view) {
        builder.setView(view).setTitle("Add new question").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String question = editTextQuestion.getText().toString();
                if (question.isEmpty() || question == null) {
                    Toast addQuestion = Toast.makeText(getContext(), "QuestionItem cannot be blank", Toast.LENGTH_SHORT);
                    addQuestion.show();
                }

                listener.applyQuestion(question);
            }
        });
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (AddQuestionDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement AddQuestionDialogListener");
        }
    }
}
