import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {

    @Test
    public void test_fractions() throws Exception {
        long[][] lst;
        lst = new long[][] { {10, 40}, {1, 2}, {1, 3} };
        assertEquals("(3,12)(6,12)(4,12)", Main.convertFrac(lst));
    }

    @Test
    public void test_fractions2() throws Exception {
        long[][] lst = new long[][] { {1, 2}, {1, 3}, {1, 4} };
        String result = "(6,12)(4,12)(3,12)";
        assertEquals(result, Main.convertFrac(lst));
    }


    @Test
    public void test_fractions3() throws Exception {
        long[][] lst = new long[][] { {69, 130}, {87, 1310}, {30, 40} };
        String result = "(18078,34060)(2262,34060)(25545,34060)";
        assertEquals(result, Main.convertFrac(lst));
    }


    @Test
    public void test_fractions4() throws Exception {
        long[][] lst = new long[][] { {26, 78}, {54, 108}, {50, 250}, {55, 275}, {77, 231}, {80, 400}, {30, 60}, {43, 129}, {48, 192} };
        String result = "(20,60)(30,60)(12,60)(12,60)(20,60)(12,60)(30,60)(20,60)(15,60)";
        assertEquals(result, Main.convertFrac(lst));
    }








}
