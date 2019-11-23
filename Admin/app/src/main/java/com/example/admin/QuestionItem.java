package com.example.admin;

public class QuestionItem {
    public String question;
    public String difficulty;
    public String sessionKey;

    public QuestionItem(String question, String difficulty) {
        this.question = question;
        this.difficulty = difficulty;
    }

    public void SetSessionKey(String session) {
        this.sessionKey = session;
    }

    public void SetQuestion(String question) {
        this.question = question;
    }

    public void SetDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getSessionKey() {
        return sessionKey;
    }
}
