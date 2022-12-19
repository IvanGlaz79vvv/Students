package com.Model;

public class User {

    private int id;
    private String FIO;
    private int ball;
    private String lesson;
    private int lesson_id;
    private String mark;

    public User() {

    }

    public User(int id, String FIO, int ball, String lesson) {
        this.id = id;
        this.FIO = FIO;
        this.ball = ball;
        this.lesson = lesson;
    }

    public User(int id, String FIO, int ball, String lesson, int lesson_id, String mark) {
        this.id = id;
        this.FIO = FIO;
        this.ball = ball;
        this.lesson = lesson;
        this.lesson_id = lesson_id;
        this.mark = mark;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public int getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(int lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "User: " +
                " id: " + id +
                "\nFIO: " + FIO +
                "\nball: " + ball +
                "\nlesson: " + lesson;
    }
}
