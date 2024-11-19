package _2_JavaCore._2_14_AlgorithmsPartOne.main;

import _2_JavaCore._2_14_AlgorithmsPartOne.main.exception.ElementNotFoundException;
import _2_JavaCore._2_14_AlgorithmsPartOne.main.exception.InvalidIndexException;
import _2_JavaCore._2_14_AlgorithmsPartOne.main.exception.NullItemException;
import _2_JavaCore._2_14_AlgorithmsPartOne.main.exception.StorageIsFullException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class StringListTest {
    private final String itemPositive = "text";

    private final StringList actual = new StringListImpl(3);
    private final StringList actual2 = new StringListImpl(3);
    private final List<String> expected = new ArrayList<>();

    static Stream<Arguments> argumentsForTests() {
        return Stream.of(Arguments.of("item111", "item222", "item555", "item333"),
                Arguments.of("item222", "item888", "item666", "item333"),
                Arguments.of("item333", "item456", "item777", "item333"));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void addTest(String addItem1, String addItem2, String addItem3) {
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
    void addNegativeTest(String addItem1, String addItem2, String addItem3, String addItem4) {
        assertThrows(NullItemException.class, () -> actual.add(null));
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertThrows(StorageIsFullException.class, () -> actual.add(addItem4));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void addIndexTest(String addItem1, String addItem2, String addItem3) {
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
    void addIndexNegativeTest(String addItem1, String addItem2, String addItem3, String addItem4) {
        assertThrows(NullItemException.class, () -> actual.add(null));
        actual.add(addItem1);
        actual.add(0, addItem2);
        assertThrows(InvalidIndexException.class, () -> actual.add(5, addItem3));
        assertThrows(InvalidIndexException.class, () -> actual.add(-1, addItem3));
        assertThrows(InvalidIndexException.class, () -> actual.add(actual.size() + 1, addItem3));
        actual.add(0, addItem3);
        assertThrows(StorageIsFullException.class, () -> actual.add(addItem4));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void setTest(String addItem1, String addItem2, String addItem3) {
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
    void setNegativeTest(String addItem1, String addItem2) {
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
    void removeItemTest(String addItem1, String addItem2, String addItem3) {
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
    void removeItemNegativeTest(String addItem1) {
        actual.add(addItem1);
        actual.add(addItem1);
        actual.add(addItem1);
        assertThrows(ElementNotFoundException.class, () -> actual.remove(itemPositive));
        assertThrows(NullItemException.class, () -> actual.remove(null));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void removeIndexTest(String addItem1, String addItem2, String addItem3) {
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
    void removeIndexNegativeTest(String addItem1, String addItem2, String addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertThrows(InvalidIndexException.class, () -> actual.remove(actual.size()));
        assertThrows(InvalidIndexException.class, () -> actual.remove(-1));
        assertThrows(NullItemException.class, () -> actual.remove(null));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void containsTest(String addItem1, String addItem2, String addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertEquals(0, actual.indexOf(addItem1));
        assertTrue(actual.contains(addItem1));
        assertTrue(actual.contains(addItem3));
        assertTrue(actual.contains(addItem2));
        assertFalse(actual.contains(itemPositive));
        assertFalse(actual.contains(null));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void indexOfTest(String addItem1, String addItem2, String addItem3) {
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
    void lastIndexOfTest(String addItem2, String addItem3) {
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
    void getTest(String addItem1, String addItem2, String addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertEquals(addItem1, actual.get(0));
        assertEquals(addItem2, actual.get(1));
        assertEquals(addItem3, actual.get(2));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void getNegativeTest(String addItem1, String addItem2, String addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertThrows(InvalidIndexException.class, () -> actual.get(-1));
        assertThrows(InvalidIndexException.class, () -> actual.get(actual.size()));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void equalsTest(String addItem1, String addItem2, String addItem3) {
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
    void equalsNegativeTest(String addItem1, String addItem2, String addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        assertThrows(NullItemException.class, () -> actual.equals(null));
    }

    @ParameterizedTest
    @MethodSource("argumentsForTests")
    void sizeTest(String addItem1, String addItem2, String addItem3) {
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
    void toArray(String addItem1, String addItem2, String addItem3) {
        actual.add(addItem1);
        actual.add(addItem2);
        actual.add(addItem3);
        expected.add(addItem1);
        expected.add(addItem2);
        expected.add(addItem3);
        assertArrayEquals(actual.toArray(), expected.toArray());
    }
}
