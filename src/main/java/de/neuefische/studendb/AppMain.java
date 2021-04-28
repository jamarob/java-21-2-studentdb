package de.neuefische.studendb;

import de.neuefische.studendb.db.StudentDb;
import de.neuefische.studendb.model.MathStudent;
import de.neuefische.studendb.model.Student;

public class AppMain {

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new MathStudent("Jane", "42"),
                new MathStudent("Klaus", "13"),
                new MathStudent("Franky", "100")
        };
        StudentDb studentDb = new StudentDb(students);

        for(int i=0; i < 5; i++){
            System.out.println(studentDb.randomStudent());
        }

    }

}
