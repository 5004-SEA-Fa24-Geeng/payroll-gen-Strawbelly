package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryEmployee extends Employee implements IEmployee {

    /** holds the type.*/
    private EmployeeType type = EmployeeType.SALARY;

    /** holds the payment times.*/
    private static final int TIMES = 24;

    /** holds the tax rate as BigDecimal.*/
    private static final BigDecimal TAX_RATE = BigDecimal.valueOf(0.2265);

    /**
     * This is a constructor for the SalaryEmployee class.
     * @param name the name of the hourly employee
     * @param id the id of the hourly employee
     * @param payRate the pay rate of the hourly employee
     * @param ytdEarnings the ytd earnings of the hourly employee
     * @param ytdTaxesPaid the ytd taxes paid of the hourly employee
     * @param pretaxDeductions the pre-tax deductions of the hourly employee
     */
    public SalaryEmployee(String name, String id, double payRate, double ytdEarnings,
                          double ytdTaxesPaid, double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
    }

    /**
     * Return the string representation of the employee type.
     * @return the string representation of the employee type
     */
    public String getEmployeeType() {
        return this.type.name();
    }

    /**
     * Set the type of the employee.
     * @param type the type of the employee.
     */
    public void setType(EmployeeType type) {
        this.type = type;
    }

    /**
     * Calculate the pay for the current pay, update the YTD earnings, and update the taxes paid YTD.
     * @param hoursWorked the hours worked for the pay period
     * @return an instance of PayStub class
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }
        BigDecimal grossPay = calculateGrossPay(hoursWorked);
        BigDecimal payAfterDeductions = grossPay.subtract(BigDecimal.valueOf(getPretaxDeductions()));
        BigDecimal taxesBD = payAfterDeductions.multiply(TAX_RATE);
        BigDecimal netPayBD = payAfterDeductions.subtract(taxesBD);

        setYtdEarnings(BigDecimal.valueOf(getYTDEarnings()).add(netPayBD)
                .setScale(2, RoundingMode.HALF_UP).doubleValue());
        setYtdTaxesPaid(BigDecimal.valueOf(getYTDTaxesPaid()).add(taxesBD)
                .setScale(2, RoundingMode.HALF_UP).doubleValue());

        double taxes = taxesBD.setScale(2, RoundingMode.HALF_UP).doubleValue();
        double netPay = netPayBD.setScale(2, RoundingMode.HALF_UP).doubleValue();

        return new PayStub(getName(), netPay, taxes, getYTDEarnings(), getYTDTaxesPaid());
    }

    /**
     * Converts the employee to a CSV string.
     * @return the employee as a string
     */
    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                getEmployeeType(), getName(), getID(), getPayRate(), getPretaxDeductions(),
                getYTDEarnings(), getYTDTaxesPaid());
    }

    /**
     * Calculate the gross pay for the salary employee.
     * @param hoursWorked the work hours of the salary employee
     * @return the gross pay as a BigDecimal
     */
    @Override
    protected BigDecimal calculateGrossPay(double hoursWorked) {
        BigDecimal payRateBD = BigDecimal.valueOf(getPayRate());
        return payRateBD.divide(BigDecimal.valueOf(TIMES), 2, RoundingMode.HALF_UP);
    }

    /**
     * Convert a SalaryEmployee object to a String.
     * @return the SalaryEmployee abject as a string
     */
    @Override
    public String toString() {
        return String.format("{name: %s, id: %s, type: %s, payRate: %.2f, "
                        + "ytdEarnings: %.2f, ytdTaxesPaid: %.2f, pretaxDeductions: %.2f}",
                getName(), getID(), getEmployeeType(), getPayRate(),
                getYTDEarnings(), getYTDTaxesPaid(), getPretaxDeductions());
    }
}
