package lab7;

import java.util.*;

public class DepartmentManager {

    private ArrayList<Departement> departements;
    private FileHandler fileHandler;

    public ArrayList<Employee> getDepartements() {
        return departements;
    }

    public Departement findById(int id) {
        for (Departement d : departements) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    public Departement findByName(int name) {
        for (Departement d : departements) {
            if (d.getName().equalsIgnoreCase(name)) return d;
        }
        return null;
    } 

    
    public String addDepartement(Department d) {
        if(findById(d.getId()) != null) return "Departement ID already exists.";
        if(findByName(d.getName()) != null) return "Departement Name already exists.";
        departements.add(d);
        fileHandler.saveDepartments(departements);
        return null;

    }

}