package lab7;

public abstract class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String position;

    public Employee(int id, String name, int age, String department, String position) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.position = position;
    }

    public abstract double calculateSalary();
    public abstract String getType();
    public abstract String getSalaryDetails();
    public abstract String toFileLine();

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public String getPosition() { return position; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setDepartment(String department) { this.department = department; }
    public void setPosition(String position) { this.position = position; }
}
