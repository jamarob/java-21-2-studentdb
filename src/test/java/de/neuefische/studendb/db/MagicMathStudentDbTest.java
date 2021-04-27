package de.neuefische.studendb.db;

import de.neuefische.studendb.model.CoffeeStudent;
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
                        new CoffeeStudent[]{
                                new CoffeeStudent("Student 1", "1"),
                                new CoffeeStudent("Student 2", "2")
                        },
                        new CoffeeStudent[]{
                                new CoffeeStudent("Student 1", "1"),
                                new CoffeeStudent("Student 2", "2"),
                                new CoffeeStudent("Jane", "42")
                        }
                ),
                Arguments.of(
                        new CoffeeStudent[]{},
                        new CoffeeStudent[]{new CoffeeStudent("Jane", "42")}
                )
        };
    }

    private static Arguments[] provideTestRemoveArguments() {
        return new Arguments[]{
                Arguments.of(
                        new CoffeeStudent[]{
                                new CoffeeStudent("Hans", "12"),
                                new CoffeeStudent("Jane", "42"),
                                new CoffeeStudent("Peter", "23")
                        },
                        new CoffeeStudent[]{
                                new CoffeeStudent("Hans", "12"),
                                new CoffeeStudent("Peter", "23")
                        }
                ),
                Arguments.of(
                        new CoffeeStudent[]{
                                new CoffeeStudent("Hans", "12"),
                                new CoffeeStudent("Peter", "23")
                        },
                        new CoffeeStudent[]{
                                new CoffeeStudent("Hans", "12"),
                                new CoffeeStudent("Peter", "23")
                        }
                ),
                Arguments.of(
                        new CoffeeStudent[]{
                                new CoffeeStudent("Jane", "42"),
                                new CoffeeStudent("Hans", "12"),
                                new CoffeeStudent("Peter", "23")
                        },
                        new CoffeeStudent[]{
                                new CoffeeStudent("Hans", "12"),
                                new CoffeeStudent("Peter", "23")
                        }
                ),
                Arguments.of(
                        new CoffeeStudent[]{
                                new CoffeeStudent("Hans", "12"),
                                new CoffeeStudent("Peter", "23"),
                                new CoffeeStudent("Jane", "42")
                        },
                        new CoffeeStudent[]{
                                new CoffeeStudent("Hans", "12"),
                                new CoffeeStudent("Peter", "23")
                        }
                ),
                Arguments.of(
                        new CoffeeStudent[]{},
                        new CoffeeStudent[]{}
                ),
                Arguments.of(
                        new CoffeeStudent[]{new CoffeeStudent("Jane", "42")},
                        new CoffeeStudent[]{}
                )
        };
    }

    @Test
    @DisplayName("list() returns all students in the db")
    public void testList() {
        // Given
        CoffeeStudent[] students = new CoffeeStudent[]{
                new CoffeeStudent("Jane", "42"),
                new CoffeeStudent("Klaus", "13"),
                new CoffeeStudent("Franky", "100")
        };
        StudentDb studentDb = new StudentDb(students);

        // When
        CoffeeStudent[] actual = studentDb.list();

        // Then
        CoffeeStudent[] expected = new CoffeeStudent[]{
                new CoffeeStudent("Jane", "42"),
                new CoffeeStudent("Klaus", "13"),
                new CoffeeStudent("Franky", "100")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("toString() returns a formatted list of all students")
    public void testToString() {
        // Given
        CoffeeStudent[] students = new CoffeeStudent[]{
                new CoffeeStudent("Jane", "42"),
                new CoffeeStudent("Klaus", "13"),
                new CoffeeStudent("Franky", "100")
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
    public void testAdd(CoffeeStudent[] givenStudents, CoffeeStudent[] expectedStudents) {
        // Given
        StudentDb studentDb = new StudentDb(givenStudents);
        CoffeeStudent student = new CoffeeStudent("Jane", "42");

        // When
        studentDb.add(student);
        CoffeeStudent[] actualStudents = studentDb.list();

        // Then
        assertArrayEquals(expectedStudents, actualStudents);
    }

    @ParameterizedTest
    @MethodSource("provideTestRemoveArguments")
    public void testRemove(CoffeeStudent[] givenStudents, CoffeeStudent[] expectedStudents) {
        // Given
        StudentDb studentDb = new StudentDb(givenStudents);

        // When
        studentDb.remove(new CoffeeStudent("Jane", "42"));
        CoffeeStudent[] actualStudents = studentDb.list();

        // Then
        assertArrayEquals(expectedStudents, actualStudents);
    }
}