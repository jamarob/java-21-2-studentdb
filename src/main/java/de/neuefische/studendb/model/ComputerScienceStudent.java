package de.neuefische.studendb.model;

import java.util.Objects;

public class ComputerScienceStudent implements Student{

    private String name;
    private String id;
    private String firstProgrammingLanguage;

    public ComputerScienceStudent(String name, String id, String firstProgrammingLanguage) {
        this.name = name;
        this.id = id;
        this.firstProgrammingLanguage = firstProgrammingLanguage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstProgrammingLanguage() {
        return firstProgrammingLanguage;
    }

    public void setFirstProgrammingLanguage(String firstProgrammingLanguage) {
        this.firstProgrammingLanguage = firstProgrammingLanguage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputerScienceStudent that = (ComputerScienceStudent) o;
        return Objects.equals(name, that.name) && Objects.equals(id, that.id) && Objects.equals(firstProgrammingLanguage, that.firstProgrammingLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, firstProgrammingLanguage);
    }

    @Override
    public String toString() {
        return "ComputerScienceStudent{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", firstProgrammingLanguage='" + firstProgrammingLanguage + '\'' +
                '}';
    }
}
