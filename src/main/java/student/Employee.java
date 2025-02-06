package student;

import java.math.BigDecimal;

/**
 * An abstract class which is used to calculate the gross pay for employees.
 */
public abstract class Employee {

    /** holds the name.*/
    private String name;

    /** holds the id.*/
    private String id;

    /** holds the pay rate.*/
    private double payRate;

    /** holds the ytd earnings.*/
    private double ytdEarnings;

    /** holds the ytd taxes paid.*/
    private double ytdTaxesPaid;

    /** holds the pre-tax deductions.*/
    private double pretaxDeductions;

    /**
     * This is a constructor for the Employee class.
     * @param name the name of the hourly employee
     * @param id the id of the hourly employee
     * @param payRate the pay rate of the hourly employee
     * @param ytdEarnings the ytd earnings of the hourly employee
     * @param ytdTaxesPaid the ytd taxes paid of the hourly employee
     * @param pretaxDeductions the pre-tax deductions of the hourly employee
     */
    public Employee(String name, String id, double payRate, double ytdEarnings,
                          double ytdTaxesPaid, double pretaxDeductions) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    /**
     * Return the name.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return the id.
     * @return the id
     */
    public String getID() {
        return this.id;
    }

    /**
     * Return the pay rate.
     * @return the pay rate
     */
    public double getPayRate() {
        return this.payRate;
    }

    /**
     * Return the ytd earnings.
     * @return the ytd earnings
     */
    public double getYTDEarnings() {
        return this.ytdEarnings;
    }

    /**
     * Return the ytd taxes paid.
     * @return the ytd taxes paid
     */
    public double getYTDTaxesPaid() {
        return this.ytdTaxesPaid;
    }

    /**
     * Return the pre-tax deductions.
     * @return the pre-tax deductions
     */
    public double getPretaxDeductions() {
        return this.pretaxDeductions;
    }

    /**
     * Set the name of the employee.
     * @param name the name of the employee
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the id of the employee.
     * @param id the id of the employee
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the pay rate of the employee.
     * @param payRate the pay rate of the employee.
     */
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    /**
     * Set the ytd earnings of the employee.
     * @param ytdEarnings the ytd earnings of the employee
     */
    public void setYtdEarnings(double ytdEarnings) {
        this.ytdEarnings = ytdEarnings;
    }

    /**
     * Set the ytd taxes paid of the employee.
     * @param ytdTaxesPaid the ytd taxes paid of the employee.
     */
    public void setYtdTaxesPaid(double ytdTaxesPaid) {
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    /**
     * Set the pre-tax deductions of the employee.
     * @param pretaxDeductions the pre-tax deductions of the employee
     */
    public void setPretaxDeductions(double pretaxDeductions) {
        this.pretaxDeductions = pretaxDeductions;
    }

    /**
     * Calculate the gross pay for the pay period.
     * @param hoursWorked the work hours of the employee
     * @return the gross pay as BigDecimal
     */
    protected abstract BigDecimal calculateGrossPay(double hoursWorked);
}
