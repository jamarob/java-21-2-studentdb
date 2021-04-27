package de.neuefische.studendb.db;

import de.neuefische.studendb.model.ComputerScienceStudent;
import de.neuefische.studendb.model.HistoryStudent;
import de.neuefische.studendb.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class StudentDbTest {

    private static Arguments[] provideTestAddArguments() {
        return new Arguments[]{
                Arguments.of(
                        new Student[]{
                                new HistoryStudent("Student 1", "1"),
                                new HistoryStudent("Student 2", "2")
                        },
                        new Student[]{
                                new HistoryStudent("Student 1", "1"),
                                new ComputerScienceStudent("Student 2", "2", "C#"),
                                new HistoryStudent("Jane", "42")
                        }
                ),
                Arguments.of(
                        new Student[]{},
                        new Student[]{new HistoryStudent("Jane", "42")}
                )
        };
    }

    private static Arguments[] provideTestRemoveArguments() {
        return new Arguments[]{
                Arguments.of(
                        new Student[]{
                                new HistoryStudent("Hans", "12"),
                                new HistoryStudent("Jane", "42"),
                                new HistoryStudent("Peter", "23")
                        },
                        new Student[]{
                                new HistoryStudent("Hans", "12"),
                                new HistoryStudent("Peter", "23")
                        }
                ),
                Arguments.of(
                        new Student[]{
                                new HistoryStudent("Hans", "12"),
                                new HistoryStudent("Peter", "23")
                        },
                        new Student[]{
                                new HistoryStudent("Hans", "12"),
                                new HistoryStudent("Peter", "23")
                        }
                ),
                Arguments.of(
                        new Student[]{
                                new HistoryStudent("Jane", "42"),
                                new HistoryStudent("Hans", "12"),
                                new HistoryStudent("Peter", "23")
                        },
                        new Student[]{
                                new HistoryStudent("Hans", "12"),
                                new HistoryStudent("Peter", "23")
                        }
                ),
                Arguments.of(
                        new Student[]{
                                new HistoryStudent("Hans", "12"),
                                new HistoryStudent("Peter", "23"),
                                new HistoryStudent("Jane", "42")
                        },
                        new Student[]{
                                new HistoryStudent("Hans", "12"),
                                new HistoryStudent("Peter", "23")
                        }
                ),
                Arguments.of(
                        new Student[]{},
                        new Student[]{}
                ),
                Arguments.of(
                        new Student[]{new HistoryStudent("Jane", "42")},
                        new Student[]{}
                )
        };
    }

    @Test
    @DisplayName("list() returns all students in the db")
    public void testList() {
        // Given
        Student[] students = new Student[]{
                new HistoryStudent("Jane", "42"),
                new HistoryStudent("Klaus", "13"),
                new HistoryStudent("Franky", "100")
        };
        StudentDb studentDb = new StudentDb(students);

        // When
        Student[] actual = studentDb.list();

        // Then
        Student[] expected = new Student[]{
                new HistoryStudent("Jane", "42"),
                new HistoryStudent("Klaus", "13"),
                new HistoryStudent("Franky", "100")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("toString() returns a formatted list of all students")
    public void testToString() {
        // Given
        Student[] students = new Student[]{
                new HistoryStudent("Jane", "42"),
                new HistoryStudent("Klaus", "13"),
                new HistoryStudent("Franky", "100")
        };
        StudentDb studentDb = new StudentDb(students);

        // When
        String actual = studentDb.toString();

        // Then
        String expected = "Student{name='Jane', id='42'}\n"
                + "Student{name='Klaus', id='13'}\n"
                + "Student{name='Franky', id='100'}\n";
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideTestAddArguments")
    public void testAdd(HistoryStudent[] givenStudents, HistoryStudent[] expectedStudents) {
        // Given
        StudentDb studentDb = new StudentDb(givenStudents);
        HistoryStudent student = new HistoryStudent("Jane", "42");

        // When
        studentDb.add(student);
        Student[] actualStudents = studentDb.list();

        // Then
        assertArrayEquals(expectedStudents, actualStudents);
    }

    @ParameterizedTest
    @MethodSource("provideTestRemoveArguments")
    public void testRemove(HistoryStudent[] givenStudents, HistoryStudent[] expectedStudents) {
        // Given
        StudentDb studentDb = new StudentDb(givenStudents);

        // When
        studentDb.remove(new HistoryStudent("Jane", "42"));
        Student[] actualStudents = studentDb.list();

        // Then
        assertArrayEquals(expectedStudents, actualStudents);
    }


    @Test
    @DisplayName("find by id should return student with matching id")
    public void getStudentById() {
        //Given
        HistoryStudent[] givenStudents = {
                new HistoryStudent("Hans", "12"),
                new HistoryStudent("Jane", "42"),
                new HistoryStudent("Peter", "23")
        };
        StudentDb studentDb = new StudentDb(givenStudents);


        //When
        Student student = studentDb.findById("42");

        //THEN
        assertEquals(new HistoryStudent("Jane", "42"), student);

    }

    @Test
    @DisplayName("find by id should return null when id not found")
    public void getStudentByIdNotFound() {
        //Given
        HistoryStudent[] givenStudents = {
                new HistoryStudent("Hans", "12"),
                new HistoryStudent("Jane", "42"),
                new HistoryStudent("Peter", "23")
        };
        StudentDb studentDb = new StudentDb(givenStudents);

        //When
        Student student = studentDb.findById("2");

        //THEN
        assertNull(student);
    }
}
