package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {

    private SalaryEmployee e;

    @BeforeEach
    void setUp() {
        e = new SalaryEmployee("Edward Elric","f103",100000,11000,2333,250);
    }

    @Test
    void getName() {
        assertEquals("Edward Elric", this.e.getName());
    }

    @Test
    void getId() {
        assertEquals("f103", this.e.getID());
    }

    @Test
    void getType() {
        assertEquals("SALARY", this.e.getEmployeeType());
    }

    @Test
    void getPayRate() {
        assertEquals(100000, this.e.getPayRate());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(11000.00, this.e.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(2333, this.e.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(250, this.e.getPretaxDeductions());
    }

    @Test
    void setName() {
        e.setName("John Elric");
        assertEquals("John Elric", this.e.getName());
    }

    @Test
    void setId() {
        e.setId("f188");
        assertEquals("f188", this.e.getID());
    }

    @Test
    void setType() {
        e.setType(EmployeeType.HOURLY);
        assertEquals("HOURLY", this.e.getEmployeeType());
    }

    @Test
    void setPayRate() {
        e.setPayRate(500000);
        assertEquals(500000, this.e.getPayRate());
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
        PayStub test = new PayStub("Edward Elric", 3029.54, 887.13,14029.54,3220.13);
        assertEquals(test.toCSV(), e.runPayroll(40).toCSV());
        System.out.println(e.getYTDEarnings());
        System.out.println(e.getYTDTaxesPaid());
    }

    @Test
    void calculateGrossPay() {
        assertEquals(BigDecimal.valueOf(4166.67), e.calculateGrossPay(50));
    }

    @Test
    void toCSV() {
        assertEquals("SALARY,Edward Elric,f103,100000.00,250.00,11000.00,2333.00", this.e.toCSV());
    }

    @Test
    void testToString() {
        assertEquals("{name: Edward Elric, id: f103, type: SALARY, payRate: 100000.00, ytdEarnings: 11000.00, ytdTaxesPaid: 2333.00, pretaxDeductions: 250.00}", e.toString());
    }
}