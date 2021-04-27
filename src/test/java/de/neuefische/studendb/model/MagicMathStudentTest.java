package de.neuefische.studendb.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class MagicMathStudentTest {

    @Test
    @DisplayName("A students name can be set")
    public void testSetAndGetName(){
        // Given
        MagicMathStudent student = new MagicMathStudent("Jane Doe", "42");

        // When
        student.setName("John Doe");
        String actual = student.getName();

        // Then
        assertEquals("John Doe", actual);
    }

    @Test
    @DisplayName("A students id can be set")
    public void setAndGetId(){
        // Given
        MagicMathStudent student = new MagicMathStudent("Jane Doe", "42");

        // When
        student.setId("113");
        String actual = student.getId();

        // Then
        assertEquals("113", actual);
    }

    @ParameterizedTest(name = "equals() of {0} and {1} is {2}")
    @MethodSource("provideTestEqualsArguments")
    public void testEquals(MagicMathStudent studentA, MagicMathStudent studentB, boolean expected){
        // When
        boolean actual = studentA.equals(studentB);

        // Then
        assertEquals(expected, actual);
    }

    private static Arguments[] provideTestEqualsArguments(){
        return new Arguments[]{
            Arguments.of(new MagicMathStudent("Jane", "42"), new MagicMathStudent("Jane","42"), true),
            Arguments.of(new MagicMathStudent("Jane", "42"), new MagicMathStudent("John","42"), false),
        };
    }

    @Test
    @DisplayName("toString() returns a formatted student")
    public void testToString(){
        // Given
        MagicMathStudent student = new MagicMathStudent("Jane", "42");

        // When
        String actual = student.toString();

        // Then
        String expected = "Student{name='Jane', id='42'}";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Students with same name and id have the same hash code")
    public void testHashCode(){
        // Given
        MagicMathStudent studentA = new MagicMathStudent("Jane", "42");
        MagicMathStudent studentB = new MagicMathStudent("Jane", "42");

        // When
        boolean actual = studentA.hashCode() == studentB.hashCode();

        // Then
        assertTrue(actual);
    }
}
