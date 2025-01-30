package day02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionPart2Test {
    @Test
    void testIsSafeIncreasing() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 6, 7, 9));
        assertTrue(SolutionPart2.isSafe(input,true));
    }

    @Test
    void testIsSafeDecreasing() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(7, 6, 4, 2, 1));
        assertTrue(SolutionPart2.isSafe(input,true));
    }

    @Test
    void testUnsafeIncreasing() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 7, 8, 9));
        assertFalse(SolutionPart2.isSafe(input,true));
    }

    @Test
    void testUnsafeDecreasing() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(9, 7, 6, 2, 1));
        assertFalse(SolutionPart2.isSafe(input,true));
    }

    @Test
    void testSafeByRemovingSecondLevel() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5));
        assertTrue(SolutionPart2.isSafe(input,true));
    }

    @Test
    void testSafeByRemovingThirdLevel() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(8, 6, 4, 4, 1));
        assertTrue(SolutionPart2.isSafe(input,true));
    }

    @Test
    void testFirstElementMuchBigger() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(12, 7, 6, 3, 1));
        assertTrue(SolutionPart2.isSafe(input,true));
    }

    @Test
    void testFirstElementMuchBiggerIncrease() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(12, 1, 3, 5, 7));
        assertTrue(SolutionPart2.isSafe(input,true));
    }

    @Test
    void testSecondElementMuchBiggerIncrease() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 10, 3, 5, 7));
        assertTrue(SolutionPart2.isSafe(input,true));
    }

    @Test
    void testSecondElementDifferentIncrease() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(5, 3, 6, 7, 8));
        assertTrue(SolutionPart2.isSafe(input,true));
    }

    @Test
    void testSecondElementDifferentDecrease() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(5, 7, 4, 2, 1));
        assertTrue(SolutionPart2.isSafe(input,true));
    }

    @Test
    void testFirstElementBiggerIncrease() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(12, 10, 11, 12, 14));
        assertTrue(SolutionPart2.isSafe(input,true));
    }

//    @Test
//    void testFirstElementLessDecrease() {
//        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(8, 11, 10, 9, 8));
//        assertTrue(SolutionPart2.isSafe(input,true));
//    }
}
