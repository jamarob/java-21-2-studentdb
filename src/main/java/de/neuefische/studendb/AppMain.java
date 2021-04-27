package de.neuefische.studendb;

import de.neuefische.studendb.model.CoffeeStudent;
import de.neuefische.studendb.model.MagicMathStudent;
import de.neuefische.studendb.model.Student;

public class AppMain {

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new CoffeeStudent("Jane", "42"),
                new MagicMathStudent("Klaus", "13"),
                new CoffeeStudent("Franky", "100")
        };
        for (Student s:students) {
            System.out.println(s.getSpecialSkill());
        }

    }

}
