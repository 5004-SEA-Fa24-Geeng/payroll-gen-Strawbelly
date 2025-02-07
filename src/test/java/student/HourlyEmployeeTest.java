package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {

    private HourlyEmployee e;

    @BeforeEach
    void setUp() {
        e = new HourlyEmployee("Luffy","s192",30.00,20000,4530,0);
    }

    @Test
    void getName() {
        assertEquals("Luffy", this.e.getName());
    }

    @Test
    void getId() {
        assertEquals("s192", this.e.getID());
    }

    @Test
    void getType() {
        assertEquals("HOURLY", this.e.getEmployeeType());
    }

    @Test
    void getPayRate() {
        assertEquals(30.00, this.e.getPayRate());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(20000, this.e.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(4530, this.e.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(0, this.e.getPretaxDeductions());
    }

    @Test
    void setName() {
        e.setName("Joe");
        assertEquals("Joe", this.e.getName());
    }

    @Test
    void setId() {
        e.setId("s199");
        assertEquals("s199", this.e.getID());
    }

    @Test
    void setType() {
        e.setType(EmployeeType.SALARY);
        assertEquals("SALARY", this.e.getEmployeeType());
    }

    @Test
    void setPayRate() {
        e.setPayRate(40.0);
        assertEquals(40.0, this.e.getPayRate());
    }

    @Test
    void setYTDEarnings() {
        e.setYtdEarnings(12000.00);
        assertEquals(12000.00, this.e.getYTDEarnings());
    }

    @Test
    void setYTDTaxesPaid() {
        e.setYtdTaxesPaid(3333);
        assertEquals(3333, this.e.getYTDTaxesPaid());
    }

    @Test
    void setPretaxDeductions() {
        e.setPretaxDeductions(300);
        assertEquals(300, this.e.getPretaxDeductions());
    }

    @Test
    void runPayroll() {

        // test case: -9 work hour
        assertEquals(null, e.runPayroll(-9));

        // test case: 0 work hour
        assertEquals("Luffy,0.0,0.0,20000.0,4530.0", e.runPayroll(0).toCSV());

        // test case: 45 work hours
        PayStub test = new PayStub("Luffy", 1102.24, 322.76,21102.24,4852.76);
        assertEquals(test.toCSV(), e.runPayroll(45).toCSV());

    }

    @Test
    void calculateGrossPay() {
        assertEquals(BigDecimal.valueOf(1425.00).setScale(2, RoundingMode.HALF_UP), e.calculateGrossPay(45));
    }

    @Test
    void toCSV() {
        assertEquals("HOURLY,Luffy,s192,30.00,0.00,20000.00,4530.00", this.e.toCSV());
    }

    @Test
    void testToString() {
        assertEquals("{name: Luffy, id: s192, type: HOURLY, payRate: 30.00, ytdEarnings: 20000.00, ytdTaxesPaid: 4530.00, pretaxDeductions: 0.00}", e.toString());

    }
}