package lab7;

import java.util.*;

public class EmployeeManager {
    private ArrayList<Employee> employees;
    private FileHandler fileHandler;

    public EmployeeManager(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        employees = fileHandler.loadEmployees();
    }

    public ArrayList<Employee> getAll() {
        return employees;
    }

    public Employee findById(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    public boolean isUsedId(Employee emp) {
        if (emp == null)  return false;
        return findById(emp.getId()) != null;

    }

    public ArrayList<Employee> searchByName(String text) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getName().toLowerCase().contains(text.toLowerCase())) result.add(e);
        }
        return result;
    }

    public ArrayList<Employee> filterByDepartment(String department) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getDepartment().equalsIgnoreCase(department)) result.add(e);
        }
        return result;
    }

    public boolean isDepartmentInUse(String department) {
        return !filterByDepartment(department).isEmpty();
    }


    public double totalPayroll() {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary();
        }
        return total;
    }

    public int countFullTime() {
        int n = 0;
        for (Employee e : employees) {
            if (e instanceof FullTimeEmployee) n++;
        }
        return n;
    }

    public int countPartTime() {
        return employees.size() - countFullTime();
    }

    public String add(Employee employee) {
        if (findById(employee.getId()) != null) return "Employee ID already exists.";
        employees.add(employee);
        fileHandler.saveEmployees(employees);
        return null;
    }

    public String update(int oldId, Employee updated) {
        Employee other = findById(updated.getId());
        if (other != null && other.getId() != oldId) return "Employee ID already exists.";
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == oldId) {
                employees.set(i, updated);
                break;
            }
        }
        fileHandler.saveEmployees(employees);
        return null;
    }

    public void delete(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                break;
            }
        }
        fileHandler.saveEmployees(employees);
    }
}
