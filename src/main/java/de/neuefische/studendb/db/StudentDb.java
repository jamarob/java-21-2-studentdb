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

    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < students.length; i++) {
            result += students[i] + "\n";
        }
        return result;
    }

    public Student randomStudent() {
        int index = (int) Math.floor(Math.random() * students.length);
        return students[index];
    }

    public void add(Student student) {
        Student[] updatedStudents = new Student[students.length+1];

        for (int i = 0; i < students.length; i++) {
            updatedStudents[i] = students[i];
        }

        updatedStudents[updatedStudents.length-1] = student;

        students = updatedStudents;
    }

    public void remove(Student student) {
        int foundIndex = findIndex(student);
        if(foundIndex < 0){
            return;
        }
        Student[] updatedStudents = new Student[students.length-1];

        for (int i = 0; i < students.length; i++) {
            if(i < foundIndex){
                updatedStudents[i] = students[i];
            }
            if(i > foundIndex){
                updatedStudents[i-1] = students[i];
            }
        }

        students = updatedStudents;
    }

    private int findIndex(Student student) {
        for (int i = 0; i < students.length; i++) {
            if(students[i].equals(student)){
                return i;
            }
        }
        return -1;
    }


}
