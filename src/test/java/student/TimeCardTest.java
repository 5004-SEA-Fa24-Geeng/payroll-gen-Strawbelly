package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

class TimeCardTest {

    private TimeCard tc;

    @BeforeEach
    void setUp() {
        tc = new TimeCard("s192",45);
    }

    @Test
    void getEmployeeID() {
        assertEquals("s192", tc.getEmployeeID());
    }

    @Test
    void getHoursWorked() {
        assertEquals(45, tc.getHoursWorked());
    }

    @Test
    void testToString() {
        assertEquals("{id: s192, hours: 45.00}", tc.toString());
    }
}