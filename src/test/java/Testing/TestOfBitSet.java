package Testing;

import Main.BitSet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestOfBitSet {
    @Test
    public void testAdd() {
        BitSet<Integer> testBitSet = new BitSet(3);
        testBitSet.add(12);
        testBitSet.add(0);
        testBitSet.add(-5);
        assertEquals(Arrays.asList(12, 0, -5), testBitSet.getElements());
        testBitSet.add(0);
        assertEquals(Arrays.asList(12, 0, -5), testBitSet.getElements());
    }

    @Test
    public void testAddAll(){
        BitSet<Integer> testBitSet = new BitSet(6);
        testBitSet.addAll(new Integer[] {10, 12, 14, 14});
        assertEquals(Arrays.asList(10, 12, 14), testBitSet.getElements());
        testBitSet.addAll(new Integer[] {10, 5});
        assertEquals(Arrays.asList(10, 12, 14, 5), testBitSet.getElements());
        testBitSet.addAll(new Integer[] {6, 7});
        assertEquals(Arrays.asList(10, 12, 14, 5, 6, 7), testBitSet.getElements());
    }

    @Test
    public void testIntersectionWith(){
        BitSet<String> testBitSet1 = new BitSet(8);
        testBitSet1.addAll(new String[] {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "56"});
        BitSet<String> testBitSet2 = new BitSet(3);
        testBitSet2.addAll(new String[] {"bb", "aa", "55"});
        testBitSet1.intersectionWith(testBitSet2);
        assertEquals(Arrays.asList("aa", "bb"), testBitSet1.getElements());
    }

    @Test
    public void testUnificationWith(){
        BitSet<String> testBitSet1 = new BitSet(9);
        testBitSet1.addAll(new String[] {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "56"});
        BitSet<String> testBitSet2 = new BitSet(3);
        testBitSet2.addAll(new String[] {"bb", "aa", "55"});
        testBitSet1.unificationWith(testBitSet2);
        assertEquals(
                Arrays.asList("aa", "bb", "cc", "dd", "ee", "ff", "gg", "56", "55"), testBitSet1.getElements()
        );
    }

    @Test
    public void testRemoving() {
        BitSet<Integer> testBitSet = new BitSet(9);
        testBitSet.addAll(new Integer[] {2, 4, 6, 10, 15, 6, 6});
        testBitSet.remove(6);
        testBitSet.removeAll(new Integer[] {2, 4});
        assertEquals(
                Arrays.asList(10, 15), testBitSet.getElements()
        );
    }

    @Test
    public void testFun() {
        BitSet<String> testBitSet1 = new BitSet(9);
        testBitSet1.addAll(new String[] {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "56"});
        assertTrue(testBitSet1.contains("aa"));
        assertFalse(testBitSet1.contains("45"));
        testBitSet1.removeAll(new String[] {"aa", "bb"});
        testBitSet1.addAll(new String[] {"45", "46"});
        assertFalse(testBitSet1.contains("aa"));
        assertTrue(testBitSet1.contains("45"));
        assertEquals(6, testBitSet1.indexOf("45"));
        assertEquals(-1, testBitSet1.indexOf("1134"));
        assertEquals(0, testBitSet1.indexOf("cc"));
    }
}