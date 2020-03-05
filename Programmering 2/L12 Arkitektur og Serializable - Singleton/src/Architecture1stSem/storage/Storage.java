package Architecture1stSem.storage;

import Architecture1stSem.application.model.Company;
import Architecture1stSem.application.model.Employee;

import java.io.Serializable;
import java.util.ArrayList;

public class Storage implements Serializable {

    private static Storage storage;

    private ArrayList<Company> companies = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();

    // -------------------------------------------------------------------------

    public ArrayList<Company> getCompanies() {
        return new ArrayList<Company>(companies);
    }

    public void addCompany(Company company) {
        companies.add(company);
    }

    public void removeCompany(Company company) {
        companies.remove(company);
    }

    // -------------------------------------------------------------------------

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<Employee>(employees);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    // -------------------------------------------------------------------------

    public static Storage getInstance() {
        if (storage == null)
            storage = new Storage();
        return storage;
    }

}
