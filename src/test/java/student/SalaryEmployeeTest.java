package student;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {
    //@Setup
    SalaryEmployee e = new SalaryEmployee("Edward Elric","f103",100000,11000,2333,250);

    @Test
    void getYTDEarnings() {
    }

    @Test
    void getYTDTaxesPaid() {
    }

    @Test
    void getPretaxDeductions() {
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
}