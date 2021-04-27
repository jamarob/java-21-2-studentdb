package de.neuefische.studendb.db;

import de.neuefische.studendb.model.CoffeeStudent;

public class StudentDb {

    private CoffeeStudent[] students;

    public StudentDb(CoffeeStudent[] students) {
        this.students = students;
    }

    public CoffeeStudent[] list() {
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

    public CoffeeStudent randomStudent() {
        int index = (int) Math.floor(Math.random() * students.length);
        return students[index];
    }

    public void add(CoffeeStudent student) {
        CoffeeStudent[] updatedStudents = new CoffeeStudent[students.length+1];

        for (int i = 0; i < students.length; i++) {
            updatedStudents[i] = students[i];
        }

        updatedStudents[updatedStudents.length-1] = student;

        students = updatedStudents;
    }

    public void remove(CoffeeStudent student) {
        int foundIndex = findIndex(student);
        if(foundIndex < 0){
            return;
        }
        CoffeeStudent[] updatedStudents = new CoffeeStudent[students.length-1];

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

    private int findIndex(CoffeeStudent student) {
        for (int i = 0; i < students.length; i++) {
            if(students[i].equals(student)){
                return i;
            }
        }
        return -1;
    }


}
