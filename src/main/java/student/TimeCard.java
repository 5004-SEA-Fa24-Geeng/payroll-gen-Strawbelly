package student;


public class TimeCard implements ITimeCard {

    /** holds the id.*/
    private String id;

    /** holds the work hours.*/
    private double hours;

    /**
     * This is a constructor for the TimeCard class.
     * @param id the id of the employee
     * @param hours the work hours of the employee
     */
    public TimeCard(String id, double hours) {
        this.id = id;
        this.hours = hours;
    }

    /**
     * Return the id of the employee.
     * @return the id of the employee
     */
    @Override
    public String getEmployeeID() {
        return id;
    }

    /**
     * Return the work hours of the employee.
     * @return the work hours of the employee
     */
    @Override
    public double getHoursWorked() {
        return hours;
    }

    /**
     * Convert a TimeCard object to a String.
     * @return a TimeCard object as a String
     */
    @Override
    public String toString() {
        return String.format("{id: %s, hours: %.2f}", id, hours);
    }
}
