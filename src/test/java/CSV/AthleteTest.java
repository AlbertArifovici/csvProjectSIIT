package CSV;

import junit.framework.TestCase;

public class AthleteTest extends TestCase {

    public void testGetTotalTime() {
        Athlete test = new Athlete("11", "Umar Jorgson", "SK", "30:27", "xxxox", "xxxxx", "xxoxo");
        assertEquals(test.getTotalTime(), 1857);
    }
}