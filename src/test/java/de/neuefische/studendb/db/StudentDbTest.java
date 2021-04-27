package de.neuefische.studendb.db;

import de.neuefische.studendb.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StudentDbTest {

    @Test
    @DisplayName("list() returns all students in the db")
    public void testList() {
        // Given
        Student[] students = new Student[]{
                new Student("Jane", "42"),
                new Student("Klaus", "13"),
                new Student("Franky", "100")
        };
        StudentDb studentDb = new StudentDb(students);

        // When
        Student[] actual = studentDb.list();

        // Then
        Student[] expected = new Student[]{
                new Student("Jane", "42"),
                new Student("Klaus", "13"),
                new Student("Franky", "100")
        };
        assertArrayEquals(expected, actual);
    }

}