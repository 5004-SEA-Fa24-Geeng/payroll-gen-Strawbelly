package student;

/**
 * This is a static class (essentially functions) that will help you build objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {
    
    private Builder() {
    }


     /**
     * Builds an employee object from a CSV string.
     * 
     * You may end up checking the type of employee (hourly or salary) by looking at the first
     * element of the CSV string. Then building an object specific to that type.
     * 
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {

        String[] em = csv.split(",");

        if (em.length != 7) {
            throw new IllegalArgumentException("The csv string is illegal.");
        }

        String type = em[0];
        String name = em[1];
        String id = em[2];

        IEmployee employee = null;

        try {
            double payRate = Double.parseDouble(em[3]);
            double pretaxDeductions = Double.parseDouble(em[4]);
            double ytdEarnings = Double.parseDouble(em[5]);
            double ytdTaxesPaid = Double.parseDouble(em[6]);

            if (type.equals("HOURLY")) {
                employee = new HourlyEmployee(name, id, payRate, ytdEarnings,
                        ytdTaxesPaid, pretaxDeductions);
            } else if (type.equals("SALARY")) {
                employee = new SalaryEmployee(name, id, payRate, ytdEarnings,
                        ytdTaxesPaid, pretaxDeductions);
            }

        } catch (NumberFormatException e) {
            throw new NullPointerException("Invalid number format: " + e.getMessage());
        }

        return employee;
    }


   /**
     * Converts a TimeCard from a CSV String.
     * 
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] tc = csv.split(",");
        String id = tc[0];
        try {
            double hours = Double.parseDouble(tc[1]);
            return new TimeCard(id, hours);
        } catch (NumberFormatException e) {
            throw new NullPointerException("Invalid number format: " + e.getMessage());
        }
    }
}
