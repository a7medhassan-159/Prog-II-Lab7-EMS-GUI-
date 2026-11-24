package lab7;

import java.io.*;
import java.nio.*;
import java.util.*;


public class FileHandler {
    private String employeesFile = "data/employees.txt";
    private String departmentsFile = "data/departments.txt";

    public void saveEmployees(ArrayList<Employee> employees) {
        ArrayList<String> lines = new ArrayList<>();
        for (Employee e : employees) {
            lines.add(e.toFileLine());
        }
        writeLines(employeesFile, lines);
    }

    public ArrayList<Employee> loadEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        for (String line : readLines(employeesFile)) {
            String[] p = line.split("\\|");
            int id = Integer.parseInt(p[1]);
            int age = Integer.parseInt(p[3]);
            double a = Double.parseDouble(p[6]);
            double b = Double.parseDouble(p[7]);
            if (p[0].equals("F")) {
                employees.add(new FullTimeEmployee(id, p[2], age, p[4], p[5], a, b));
            } else {
                employees.add(new PartTimeEmployee(id, p[2], age, p[4], p[5], a, b));
            }
        }
        return employees;
    }

    public void saveDepartments(ArrayList<Department> departments) {
        ArrayList<String> lines = new ArrayList<>();
        for (Department d : departments) {
            lines.add(d.getId() + "|" + d.getName());
        }
        writeLines(departmentsFile, lines);
    }

    public ArrayList<Department> loadDepartments() {
        ArrayList<Department> departments = new ArrayList<>();
        for (String line : readLines(departmentsFile)) {
            String[] p = line.split("\\|");
            departments.add(new Department(Integer.parseInt(p[0]), p[1]));
        }
        return departments;
    }

    private void writeLines(String file, ArrayList<String> lines) {
        File folder = new File("data");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File f = new File(file);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(f);
            for (String line : lines) {
                pw.println(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Could not save " + file);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    private ArrayList<String> readLines(String file) {
        ArrayList<String> lines = new ArrayList<>();
        File f = new File(file);
        if (!f.exists()) {
            return lines;
        }

        Scanner sc = null;
        try {
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Could not read " + file);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return lines;
    }
}
