package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;

public class StudentDb {

    private Student[] students;

    public StudentDb(Student[] students) {
        this.students = students;
    }

    public Student[] list() {
        return students;
    }
}
