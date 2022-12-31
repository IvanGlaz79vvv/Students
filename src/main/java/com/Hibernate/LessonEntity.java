package com.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@jakarta.persistence.Entity
@Entity
@Table(name = "lesson", schema = "mywork", catalog = "")
@jakarta.persistence.Table(name = "lesson", schema = "mywork", catalog = "")
public class LessonEntity {
    private int id;
    private String lesson;
    private String mark;

    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    @jakarta.persistence.Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @jakarta.persistence.Basic
    @Basic
    @Column(name = "Lesson", nullable = true, length = 255, insertable = true, updatable = true)
    @jakarta.persistence.Column(name = "Lesson", nullable = true, length = 255)
    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    @jakarta.persistence.Basic
    @Basic
    @Column(name = "mark", nullable = true, length = 255, insertable = true, updatable = true)
    @jakarta.persistence.Column(name = "mark", nullable = true, length = 255)
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LessonEntity that = (LessonEntity) o;
        return id == that.id && Objects.equals(lesson, that.lesson) && Objects.equals(mark, that.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lesson, mark);
    }
}
