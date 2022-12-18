package com.Model;

public class User {
    private int id;
    private String FIO;
    private int ball;
    private String lesson;
    private String mark;

    public User(String FIO, int ball, String lesson) {
        this.id = id;
        this.FIO = FIO;
        this.ball = ball;
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "User: id = " + id + ",\nFIO = " + FIO + ",\nball = " + ball + ",\nlesson = " + lesson + ",\nmark = " + mark;
    }
}
