package com.example.kfmily;

public class Question {
    private String text;
    private String[] choices;
    private int answer;

    public Question(String text, String[] choices, int answer) {
        this.text = text;
        this.choices = choices;
        this.answer = answer;

    }

    public String getText() {
        return text;
    }

    public String[] getChoices() {
        return choices;
    }

    public int getAnswer() {
        return answer;
    }
}
