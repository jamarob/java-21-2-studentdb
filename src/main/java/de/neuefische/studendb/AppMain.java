package de.neuefische.studendb;

import de.neuefische.studendb.db.StudentDb;
import de.neuefische.studendb.model.CoffeStudent;
import de.neuefische.studendb.model.MagicMathStudent;
import de.neuefische.studendb.model.Student;

public class AppMain {

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new MagicMathStudent("Jane", "42"),
                new CoffeStudent("Klaus", "13"),
                new MagicMathStudent("Franky", "100")
        };
        for (Student s:students) {
            System.out.println(s.calculateGrades());
        }

    }

}
