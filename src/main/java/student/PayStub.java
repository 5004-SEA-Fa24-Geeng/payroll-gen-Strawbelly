package student;

public class PayStub implements IPayStub{

    /** holds the name.*/
    private String name;

    /** holds the net pay.*/
    private double netPay;

    /** holds the taxes.*/
    private double taxes;

    /** holds the ytd earnings.*/
    private double ytdEarnings;

    /** holds the ytd taxes paid.*/
    private double ytdTaxesPaid;

    /**
     * This is a constructor for the PaySub class.
     * @param name the name of the employee
     * @param netPay the net pay of the employee
     * @param taxes the taxes of the employee
     * @param ytdEarnings the ytdEarnings of the employee
     * @param ytdTaxesPaid the ytdTaxesPaid of the employee
     */
    public PayStub(String name, double netPay, double taxes, double ytdEarnings, double ytdTaxesPaid) {
        this.name = name;
        this.netPay = netPay;
        this.taxes = taxes;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
    }

    /**
     * Get the net pay of the employee.
     * @return the net pay of the employee
     */
    @Override
    public double getPay() {
        return netPay;
    }

    /**
     * Get the taxes of the employee.
     * @return the taxes of the employee.
     */
    @Override
    public double getTaxesPaid() {
        return taxes;
    }

    /**
     * Converts the PayStub object to a CSV string.
     * @return the PayStub object as a string
     */
    @Override
    public String toCSV() {
        return name + "," + netPay + "," + taxes + "," + ytdEarnings + "," + ytdTaxesPaid;
    }
}
