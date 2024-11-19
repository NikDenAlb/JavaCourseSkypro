package _2_JavaCore._2_16_AlgorithmsPartThree.main;


import _2_JavaCore._2_16_AlgorithmsPartThree.main.exception.ElementNotFoundException;
import _2_JavaCore._2_16_AlgorithmsPartThree.main.exception.InvalidIndexException;
import _2_JavaCore._2_16_AlgorithmsPartThree.main.exception.NullItemException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerListTest {
    private final Integer itemPositive = 12345;

    private final IntegerList actual = new IntegerListImpl(3);
    private final IntegerList actual2 = new IntegerListImpl(3);
    private final List<Integer> expected = new ArrayList<>();

    static Stream<Arguments> argumentsForTests() {
        return Stream.of(Arguments.of(111, 222, 555, 666),
                Arguments.of(222, 333, 666, 343),
                Arguments.of(333, 533, 777, 933));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void addTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        assertEquals(addItem1, actual.add(addItem1));
        assertEquals(addItem2, actual.add(addItem2));
        assertEquals(addItem3, actual.add(addItem3));
        expected.add(addItem1);
        expected.add(addItem2);
        expected.add(addItem3);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void addNegativeTest(Integer addItem1, Integer addItem2, Integer addItem3, Integer addItem4) {
        assertThrows(NullItemException.class, () -> actual.add(null));
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        actual.add(addItem4);
        assertEquals(4, actual.size());
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void addIndexTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        actual.add(addItem1);
        assertEquals(addItem3, actual.add(0, addItem3));
        assertEquals(addItem2, actual.add(1, addItem2));
        expected.add(addItem3);
        expected.add(addItem2);
        expected.add(addItem1);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void addIndexNegativeTest(Integer addItem1, Integer addItem2, Integer addItem3, Integer addItem4) {
        assertThrows(NullItemException.class, () -> actual.add(null));
        actual.add(addItem1);
        actual.add(0, addItem2);
        assertThrows(InvalidIndexException.class, () -> actual.add(5, addItem3));
        assertThrows(InvalidIndexException.class, () -> actual.add(-1, addItem3));
        assertThrows(InvalidIndexException.class, () -> actual.add(actual.size() + 1, addItem3));
        actual.add(0, addItem3);
        actual.add(addItem4);
        assertEquals(4, actual.size());
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void setTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        actual.add(addItem1);
        actual.add(addItem1);
        actual.add(addItem1);
        assertEquals(addItem3, actual.set(2, addItem3));
        assertEquals(addItem1, actual.set(0, addItem1));
        assertEquals(addItem2, actual.set(1, addItem2));
        expected.add(addItem1);
        expected.add(addItem2);
        expected.add(addItem3);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void setNegativeTest(Integer addItem1, Integer addItem2) {
        actual.add(addItem1);
        actual.add(addItem1);
        actual.add(addItem1);
        assertThrows(NullItemException.class, () -> actual.set(0, null));
        assertThrows(InvalidIndexException.class, () -> actual.set(-1, null));
        assertThrows(InvalidIndexException.class, () -> actual.set(actual.size(), null));
        assertThrows(InvalidIndexException.class, () -> actual.set(actual.size() + 1, null));
        assertThrows(InvalidIndexException.class, () -> actual.set(-1, addItem2));
        assertThrows(InvalidIndexException.class, () -> actual.set(actual.size(), addItem2));
        assertThrows(InvalidIndexException.class, () -> actual.set(actual.size() + 1, addItem2));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void removeItemTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertEquals(addItem3, actual.remove(addItem3));
        expected.add(addItem1);
        expected.add(addItem2);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void removeItemNegativeTest(Integer addItem1) {
        actual.add(addItem1);
        actual.add(addItem1);
        actual.add(addItem1);
        assertThrows(ElementNotFoundException.class, () -> actual.remove(itemPositive));
        assertThrows(NullItemException.class, () -> actual.remove(null));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void removeIndexTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertEquals(addItem2, actual.remove(1));
        expected.add(addItem1);
        expected.add(addItem3);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
        actual.add(addItem3);
        assertEquals(addItem3, actual.remove(2));
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
        assertEquals(addItem1, actual.remove(0));
        expected.removeFirst();
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void removeIndexNegativeTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertThrows(InvalidIndexException.class, () -> actual.remove(actual.size()));
        assertThrows(InvalidIndexException.class, () -> actual.remove(-1));
        assertThrows(NullItemException.class, () -> actual.remove(null));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void containsTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertEquals(0, actual.indexOf(addItem1));
        assertTrue(actual.contains(addItem1));
        assertTrue(actual.contains(addItem3));
        assertTrue(actual.contains(addItem2));
        assertFalse(actual.contains(itemPositive));
        assertThrows(NullItemException.class, () -> actual.contains(null));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void indexOfTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(itemPositive);
        assertEquals(0, actual.indexOf(addItem1));
        assertEquals(2, actual.indexOf(itemPositive));
        assertEquals(-1, actual.indexOf(null));
        assertEquals(-1, actual.indexOf(addItem3));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void lastIndexOfTest(Integer addItem2, Integer addItem3) {
        actual.add(itemPositive);
        actual.add(addItem2);
        actual.add(itemPositive);
        assertEquals(1, actual.lastIndexOf(addItem2));
        assertEquals(2, actual.lastIndexOf(itemPositive));
        assertEquals(-1, actual.lastIndexOf(null));
        assertEquals(-1, actual.lastIndexOf(addItem3));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void getTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertEquals(addItem1, actual.get(0));
        assertEquals(addItem2, actual.get(1));
        assertEquals(addItem3, actual.get(2));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void getNegativeTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertThrows(InvalidIndexException.class, () -> actual.get(-1));
        assertThrows(InvalidIndexException.class, () -> actual.get(actual.size()));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void equalsTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        actual2.add(addItem1);
        actual2.add(addItem2);
        actual2.add(addItem3);
        assertTrue(actual.equals(actual2));
        actual2.remove(0);
        assertFalse(actual.equals(actual2));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void equalsNegativeTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertThrows(NullItemException.class, () -> actual.equals(null));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void sizeTest(Integer addItem1, Integer addItem2, Integer addItem3) {
        assertEquals(0, actual.size());
        actual.add(addItem1);
        assertEquals(1, actual.size());
        actual.add(addItem2);
        assertEquals(2, actual.size());
        actual.add(addItem3);
        assertEquals(3, actual.size());
    }

    @Test
    void isEmptyTest() {
        assertTrue(actual.isEmpty());
        actual.add(itemPositive);
        assertFalse(actual.isEmpty());
    }

    @Test
    void cleanTest() {
        actual.add(itemPositive);
        actual.clear();
        assertTrue(actual.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void toArray(Integer addItem1, Integer addItem2, Integer addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        expected.add(addItem1);
        expected.add(addItem2);
        expected.add(addItem3);
        assertArrayEquals(actual.toArray(), expected.toArray());
    }
}
