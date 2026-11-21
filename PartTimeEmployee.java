public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public PartTimeEmployee(int id, String name, int age, String department,
                            String position, double hourlyRate, double hoursWorked) {
        super(id, name, age, department, position);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() { return hourlyRate; }
    public double getHoursWorked() { return hoursWorked; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }

    public double calculateSalary() { return hourlyRate * hoursWorked; }

    public String getType() { return "Part-Time"; }

    public String getSalaryDetails() { return "Rate " + hourlyRate + " x Hours " + hoursWorked; }

    public String toFileLine() {
        return "P|" + getId() + "|" + getName() + "|" + getAge() + "|" + getDepartment()
                + "|" + getPosition() + "|" + hourlyRate + "|" + hoursWorked;
    }
}
