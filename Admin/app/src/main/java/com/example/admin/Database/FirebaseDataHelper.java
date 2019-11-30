package com.example.admin.Database;

import com.example.admin.Models.Groups;
import com.example.admin.Models.QuestionItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FirebaseDataHelper {
    public static ArrayList<QuestionItem> questions = new ArrayList<>();

    public FirebaseDataHelper() {

    }

    public static class Instance {
        static FirebaseDatabase database = FirebaseDatabase.getInstance();
        static DatabaseReference adminReference =database.getReference("groups");
        static DatabaseReference questionsReference = database.getReference().child("Questions");
        static DatabaseReference answerReference = database.getReference().child("Answers");
        private static Groups group;


        public static String CreateNewGroup(String groupCode,String groupName) {
            adminReference.child(groupCode).setValue(groupName);
            return groupCode;
        }

        public static void CreateQuestions(String groupId, ArrayList<QuestionItem> questions) {
            for (QuestionItem question : questions) {
                InsertQuestion(question, groupId);
            }
        }

        public static void InsertQuestion(QuestionItem question, String groupId) {
            String questionKey = questionsReference.push().getKey();
            question.setGroupKey(groupId);
            questionsReference.child(questionKey).setValue(question);
        }

    }
}
