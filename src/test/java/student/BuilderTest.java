package student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    @Test
    void buildEmployeeFromCSV() {
        IEmployee emp = Builder.buildEmployeeFromCSV("HOURLY,Luffy,s192,30.0,0.0,22204.48,21425.0");
        assertEquals("{name: Luffy, id: s192, type: HOURLY, payRate: 30.00, ytdEarnings: 22204.48, ytdTaxesPaid: 21425.00, pretaxDeductions: 0.00}", emp.toString());
    }

    @Test
    void buildTimeCardFromCSV() {
        ITimeCard tc = Builder.buildTimeCardFromCSV("x102,35");
        assertEquals("{id: x102, hours: 35.00}", tc.toString());
    }
}