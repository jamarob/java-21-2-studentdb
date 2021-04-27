package de.neuefische.studendb.db;

import de.neuefische.studendb.model.MagicMathStudent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MagicMathStudentDbTest {

    private static Arguments[] provideTestAddArguments() {
        return new Arguments[]{
                Arguments.of(
                        new MagicMathStudent[]{
                                new MagicMathStudent("Student 1", "1"),
                                new MagicMathStudent("Student 2", "2")
                        },
                        new MagicMathStudent[]{
                                new MagicMathStudent("Student 1", "1"),
                                new MagicMathStudent("Student 2", "2"),
                                new MagicMathStudent("Jane", "42")
                        }
                ),
                Arguments.of(
                        new MagicMathStudent[]{},
                        new MagicMathStudent[]{new MagicMathStudent("Jane", "42")}
                )
        };
    }

    private static Arguments[] provideTestRemoveArguments() {
        return new Arguments[]{
                Arguments.of(
                        new MagicMathStudent[]{
                                new MagicMathStudent("Hans", "12"),
                                new MagicMathStudent("Jane", "42"),
                                new MagicMathStudent("Peter", "23")
                        },
                        new MagicMathStudent[]{
                                new MagicMathStudent("Hans", "12"),
                                new MagicMathStudent("Peter", "23")
                        }
                ),
                Arguments.of(
                        new MagicMathStudent[]{
                                new MagicMathStudent("Hans", "12"),
                                new MagicMathStudent("Peter", "23")
                        },
                        new MagicMathStudent[]{
                                new MagicMathStudent("Hans", "12"),
                                new MagicMathStudent("Peter", "23")
                        }
                ),
                Arguments.of(
                        new MagicMathStudent[]{
                                new MagicMathStudent("Jane", "42"),
                                new MagicMathStudent("Hans", "12"),
                                new MagicMathStudent("Peter", "23")
                        },
                        new MagicMathStudent[]{
                                new MagicMathStudent("Hans", "12"),
                                new MagicMathStudent("Peter", "23")
                        }
                ),
                Arguments.of(
                        new MagicMathStudent[]{
                                new MagicMathStudent("Hans", "12"),
                                new MagicMathStudent("Peter", "23"),
                                new MagicMathStudent("Jane", "42")
                        },
                        new MagicMathStudent[]{
                                new MagicMathStudent("Hans", "12"),
                                new MagicMathStudent("Peter", "23")
                        }
                ),
                Arguments.of(
                        new MagicMathStudent[]{},
                        new MagicMathStudent[]{}
                ),
                Arguments.of(
                        new MagicMathStudent[]{new MagicMathStudent("Jane", "42")},
                        new MagicMathStudent[]{}
                )
        };
    }

    @Test
    @DisplayName("list() returns all students in the db")
    public void testList() {
        // Given
        MagicMathStudent[] students = new MagicMathStudent[]{
                new MagicMathStudent("Jane", "42"),
                new MagicMathStudent("Klaus", "13"),
                new MagicMathStudent("Franky", "100")
        };
        StudentDb studentDb = new StudentDb(students);

        // When
        MagicMathStudent[] actual = studentDb.list();

        // Then
        MagicMathStudent[] expected = new MagicMathStudent[]{
                new MagicMathStudent("Jane", "42"),
                new MagicMathStudent("Klaus", "13"),
                new MagicMathStudent("Franky", "100")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("toString() returns a formatted list of all students")
    public void testToString() {
        // Given
        MagicMathStudent[] students = new MagicMathStudent[]{
                new MagicMathStudent("Jane", "42"),
                new MagicMathStudent("Klaus", "13"),
                new MagicMathStudent("Franky", "100")
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
    public void testAdd(MagicMathStudent[] givenStudents, MagicMathStudent[] expectedStudents) {
        // Given
        StudentDb studentDb = new StudentDb(givenStudents);
        MagicMathStudent student = new MagicMathStudent("Jane", "42");

        // When
        studentDb.add(student);
        MagicMathStudent[] actualStudents = studentDb.list();

        // Then
        assertArrayEquals(expectedStudents, actualStudents);
    }

    @ParameterizedTest
    @MethodSource("provideTestRemoveArguments")
    public void testRemove(MagicMathStudent[] givenStudents, MagicMathStudent[] expectedStudents) {
        // Given
        StudentDb studentDb = new StudentDb(givenStudents);

        // When
        studentDb.remove(new MagicMathStudent("Jane", "42"));
        MagicMathStudent[] actualStudents = studentDb.list();

        // Then
        assertArrayEquals(expectedStudents, actualStudents);
    }
}