/*
 * Students, build off this class. We are providing one sample test case as file reading is new to
 * you.
 * 
 * NOTE: you may end up changing this completely depending on how you setup your project.
 * 
 * we are just using .main() as we know that is an entry point that we specified.
 * 
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import student.PayrollGenerator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestPayrollGenerator {

    @TempDir
    static Path tempDir;


    @Test
    public void testFinalPayStub() throws IOException {
        // Test1: happy path

        // copy employees.csv into tempDir
        Path employees = tempDir.resolve("employees.csv");
        Files.copy(Paths.get("resources/employees.csv"), employees);

        // get the path of the paystubs.csv
        Path payStubs = tempDir.resolve("paystubs.csv");



        String[] args = {"-e", employees.toString(), "-t", "resources/time_cards.csv", // allowed,
                                                                                       // this isn't
                                                                                       // modified -
                                                                                       // so safe
                "-o", payStubs.toString()};

        // run main method
        PayrollGenerator.main(args);



        String expectedPayStubs = Files
                .readString(Paths.get("resources/original/pay_stubs_solution_to_original.csv"));

        String actualPayStubs = Files.readString(payStubs);

        assertEquals(expectedPayStubs, actualPayStubs);


        // you could also read lines and compared the lists

    }

    @Test
    public void testFinalPayStub1() throws IOException {
        // Test2: the work hours of all the employees are 0

        // copy employees.csv into tempDir
        Path emp1 = tempDir.resolve("employees_original.csv");
        Files.copy(Paths.get("resources/original/employees_original.csv"), emp1);

        // get the path of the paystubs.csv
        Path ps1 = tempDir.resolve("paystubs1.csv");

        String[] args1 = {"-e", emp1.toString(), "-t", "resources/student/time_cards_test1.csv", // allowed,
                // this isn't
                // modified -
                // so safe
                "-o", ps1.toString()};

        // run main method
        PayrollGenerator.main(args1);

        String expectedPayStubs1 = Files
                .readString(Paths.get("resources/student/pay_stubs_solution_to_test1.csv"));

        String actualPayStubs1 = Files.readString(ps1);

        assertEquals(expectedPayStubs1, actualPayStubs1);
    }

    @Test
    public void testFinalPayStub2() throws IOException {
        // Test3: the work hours of all the employees are negative numbers

        // copy employees.csv into tempDir
        Path emp2 = tempDir.resolve("employees_original.csv");
        Files.copy(Paths.get("resources/original/employees_original.csv"), emp2);

        // get the path of the paystubs.csv
        Path ps2 = tempDir.resolve("paystubs2.csv");

        String[] args1 = {"-e", emp2.toString(), "-t", "resources/student/time_cards_test2.csv", // allowed,
                // this isn't
                // modified -
                // so safe
                "-o", ps2.toString()};

        // run main method
        PayrollGenerator.main(args1);

        String expectedPayStubs2 = Files
                .readString(Paths.get("resources/student/pay_stubs_solution_to_test2.csv"));

        String actualPayStubs2 = Files.readString(ps2);

        assertEquals(expectedPayStubs2, actualPayStubs2);
    }
}
