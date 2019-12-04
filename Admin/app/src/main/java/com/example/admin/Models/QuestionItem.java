package com.example.admin.Models;

public class QuestionItem {
    public String question;
    private String groupKey;
    private boolean status;

    public QuestionItem()
    {

    }

    public QuestionItem(String question, String groupKey,boolean status) {
        this.question = question;
        this.groupKey = groupKey;
        this.status=status;
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
