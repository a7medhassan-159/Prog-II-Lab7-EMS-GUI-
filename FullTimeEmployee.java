package lab7;

public class FullTimeEmployee extends Employee {
    private double basicSalary;
    private double bonus;

    public FullTimeEmployee(int id, String name, int age, String department,
                            String position, double basicSalary, double bonus) {
        super(id, name, age, department, position);
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    public double getBasicSalary() { return basicSalary; }
    public double getBonus() { return bonus; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    public double calculateSalary() { return basicSalary + bonus; }

    public String getType() { return "Full-Time"; }

    public String getSalaryDetails() { return "Basic " + basicSalary + " + Bonus " + bonus; }

    public String toFileLine() {
        return "F|" + getId() + "|" + getName() + "|" + getAge() + "|" + getDepartment()
                + "|" + getPosition() + "|" + basicSalary + "|" + bonus;
    }
}
