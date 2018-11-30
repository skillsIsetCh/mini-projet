package io.javabrains.springbootstarter.lesson;

import io.javabrains.springbootstarter.course.Course;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Lesson {
    @Id
    private String id;
    private String name;
    private String description;
    private Course course;

    public Lesson(String id, String name, String description, String courseId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.course= new Course(courseId, "", "");
    }
    public Lesson() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
