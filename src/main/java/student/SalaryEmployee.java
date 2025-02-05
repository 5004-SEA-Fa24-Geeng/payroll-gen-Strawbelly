package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryEmployee extends EmployeeGrossPay implements IEmployee{

    /** holds the name.*/
    private String name;

    /** holds the id.*/
    private String id;

    /** holds the name.*/
    private EmployeeType type;

    /** holds the pay rate.*/
    private double payRate;

    /** holds the ytd earnings.*/
    private double ytdEarnings;

    /** holds the ytd taxes paid.*/
    private double ytdTaxesPaid;

    /** holds the pre-tax deductions.*/
    private double pretaxDeductions;

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
    public SalaryEmployee(String name, String id, EmployeeType type, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    /**
     * Return the name.
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Return the id.
     * @return the id
     */
    @Override
    public String getID() {
        return id;
    }

    /**
     * Return the pay rate.
     * @return the pay rate
     */
    @Override
    public double getPayRate() {
        return payRate;
    }

    /**
     * Return the string representation of the employee type.
     * @return the string representation of the employee type
     */
    @Override
    public String getEmployeeType() {
        return type.name();
    }

    /**
     * Return the ytd earnings.
     * @return the ytd earnings
     */
    @Override
    public double getYTDEarnings() {
        return ytdEarnings;
    }

    /**
     * Return the ytd taxes paid.
     * @return the ytd taxes paid
     */
    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid;
    }

    /**
     * Return the pre-tax deductions.
     * @return the pre-tax deductions
     */
    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions;
    }

    /**
     * Set the name of the salary employee.
     * @param name the name of the salary employee
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the id of the salary employee.
     * @param id the id of the salary employee
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the type of the salary employee.
     * @param type the type of the salary employee.
     */
    public void setType(EmployeeType type) {
        this.type = type;
    }

    /**
     * Set the pay rate of the salary employee.
     * @param payRate the pay rate of the salary employee.
     */
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    /**
     * Set the ytd earnings of the salary employee.
     * @param ytdEarnings the ytd earnings of the salary employee
     */
    public void setYtdEarnings(double ytdEarnings) {
        this.ytdEarnings = ytdEarnings;
    }

    /**
     * Set the ytd taxes paid of the salary employee.
     * @param ytdTaxesPaid the ytd taxes paid of the salary employee.
     */
    public void setYtdTaxesPaid(double ytdTaxesPaid) {
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    /**
     * Set the pre-tax deductions of the salary employee.
     * @param pretaxDeductions the pre-tax deductions of the salary employee
     */
    public void setPretaxDeductions(double pretaxDeductions) {
        this.pretaxDeductions = pretaxDeductions;
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
        BigDecimal payAfterDeductions = grossPay.subtract(BigDecimal.valueOf(pretaxDeductions));
        BigDecimal taxesBD = payAfterDeductions.multiply(TAX_RATE);
        BigDecimal netPayBD = payAfterDeductions.subtract(taxesBD);

        ytdEarnings = netPayBD.add(BigDecimal.valueOf(ytdEarnings)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        ytdTaxesPaid = taxesBD.add(BigDecimal.valueOf(ytdTaxesPaid)).setScale(2, RoundingMode.HALF_UP).doubleValue();

        double taxes = taxesBD.setScale(2, RoundingMode.HALF_UP).doubleValue();
        double netPay = netPayBD.setScale(2, RoundingMode.HALF_UP).doubleValue();

        return new PayStub(name, netPay, taxes, ytdEarnings, ytdTaxesPaid);
    }

    /**
     * Converts the employee to a CSV string.
     * @return the employee as a string
     */
    @Override
    public String toCSV() {
        return getEmployeeType() + "," + name + "," + id + "," + payRate + "," + pretaxDeductions + "," + ytdEarnings + "," + ytdTaxesPaid;
    }

    /**
     * Calculate the gross pay for the salary employee
     * @param hoursWorked the work hours of the salary employee
     * @return the gross pay as a BigDecimal
     */
    @Override
    protected BigDecimal calculateGrossPay(double hoursWorked) {
        BigDecimal BDPayRate = BigDecimal.valueOf(payRate);
        return BDPayRate.multiply(BigDecimal.valueOf(1.0 / TIMES));
    }
}
