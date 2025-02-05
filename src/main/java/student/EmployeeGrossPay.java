package student;

import java.math.BigDecimal;

/**
 * An abstract class which is used to calculate the gross pay for employees.
 */
public abstract class EmployeeGrossPay {
    // A protected abstract method to calculate the gross pay for the pay period.
    protected abstract BigDecimal calculateGrossPay(double hoursWorked);
}
