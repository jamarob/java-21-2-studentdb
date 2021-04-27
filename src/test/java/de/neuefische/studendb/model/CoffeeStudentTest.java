package de.neuefische.studendb.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeStudentTest {

    @Test
    @DisplayName("A students name can be set")
    public void testSetAndGetName(){
        // Given
        CoffeeStudent student = new CoffeeStudent("Jane Doe", "42");

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
        CoffeeStudent student = new CoffeeStudent("Jane Doe", "42");

        // When
        student.setId("113");
        String actual = student.getId();

        // Then
        assertEquals("113", actual);
    }

    @ParameterizedTest(name = "equals() of {0} and {1} is {2}")
    @MethodSource("provideTestEqualsArguments")
    public void testEquals(CoffeeStudent studentA, CoffeeStudent studentB, boolean expected){
        // When
        boolean actual = studentA.equals(studentB);

        // Then
        assertEquals(expected, actual);
    }

    private static Arguments[] provideTestEqualsArguments(){
        return new Arguments[]{
                Arguments.of(new CoffeeStudent("Jane", "42"), new CoffeeStudent("Jane","42"), true),
                Arguments.of(new CoffeeStudent("Jane", "42"), new CoffeeStudent("John","42"), false),
        };
    }

    @Test
    @DisplayName("toString() returns a formatted student")
    public void testToString(){
        // Given
        CoffeeStudent student = new CoffeeStudent("Jane", "42");

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
        CoffeeStudent studentA = new CoffeeStudent("Jane", "42");
        CoffeeStudent studentB = new CoffeeStudent("Jane", "42");

        // When
        boolean actual = studentA.hashCode() == studentB.hashCode();

        // Then
        assertTrue(actual);
    }

    @Test
    @DisplayName("Coffeestudents skill is beeing really awake ALL THE TIME")
    public void testGetSpecialSkill(){
        // GIVEN
        String expected = "Is always fully awake!";
        Student coffeStudent = new CoffeeStudent("Jimmy", "203");

        // WHEN
        String actual = coffeStudent.getSpecialSkill();

        //THEN
        assertEquals(expected, actual);
    }
}
