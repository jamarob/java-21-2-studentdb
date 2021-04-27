package de.neuefische.studendb.model;

import java.util.Objects;

public class CoffeStudent implements Student{

    private String name;
    private String id;
    private String grade;

    public CoffeStudent(String name, String id){
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String calculateGrades() {
        return "1";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGrade(String grade) {this.grade = grade; }

    public String getGrade() { return grade; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeStudent student = (CoffeStudent) o;
        return Objects.equals(name, student.name) && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
