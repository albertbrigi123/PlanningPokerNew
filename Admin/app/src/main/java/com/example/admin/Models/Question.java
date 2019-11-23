package com.example.admin.Models;

public class Question {
    private String question;
    private String groupKey;

    public Question()
    {

    }

    public Question(String question, String groupKey) {
        this.question = question;
        this.groupKey = groupKey;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }
}
