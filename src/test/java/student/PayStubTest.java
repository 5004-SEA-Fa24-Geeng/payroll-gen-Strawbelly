package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayStubTest {

    private PayStub p;

    @BeforeEach
    void setUp() {
        p = new PayStub("Nami",5672.33,1661.0,28361.66,8305.0);
    }

    @Test
    void getPay() {
        assertEquals(5672.33, p.getPay());
    }

    @Test
    void getTaxesPaid() {
        assertEquals(1661.0, p.getTaxesPaid());
    }

    @Test
    void toCSV() {
        assertEquals("Nami,5672.33,1661.0,28361.66,8305.0", p.toCSV());
    }

    @Test
    void testToString() {
        assertEquals("{name: Nami, netPay: 5672.33, taxes: 1661.00, " +
                "ytdEarnings: 28361.66, ytdTaxesPaid: 8305.00}", p.toString());

    }
}