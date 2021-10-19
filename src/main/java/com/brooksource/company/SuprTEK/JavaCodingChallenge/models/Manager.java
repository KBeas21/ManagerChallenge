package com.brooksource.company.SuprTEK.JavaCodingChallenge.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager extends Employee {


    public Manager(String jobTitle, String name, String organization, String supervisorName, HashMap<Integer, Employee> directReports) {
        super(jobTitle, 600.00, name, organization, supervisorName, directReports);
    }

    public ArrayList<Employee> getAllDirectReports() {
        ArrayList<Employee> subordinates = new ArrayList<>();
        return getAllDirectReportHelper(this.getDirectReports(), subordinates);
    }

    public Double getTeamsMonthlyExpense() {
        return determineMonthlyExpense();
    }

    /**
     * Gets the managers total monthly expense
     *
     * @return {Double} the givens managers total monthly expense
     */
    private Double determineMonthlyExpense() {
        if (this.getDirectReports().isEmpty()) {
            return this.getMonthlyCost();
        }

        HashMap<Integer, Employee> mangerReports = this.getDirectReports();

        return internalManagerSearchForCost(this.getMonthlyCost(), mangerReports);
    }

    /**
     * Recursively search all for all managers in a
     *
     * @param reports managers direct reports
     *
     * @return {Double} a running total of
     */
    private Double internalManagerSearchForCost(Double accumulator, HashMap<Integer, Employee> reports) {
        for (int key : reports.keySet()) {
            Employee e = reports.get(key);

            // if the employee is a manager and that manager has directReports
            if (e.getClass().getSimpleName().equals("Manager") && !(e.getDirectReports().isEmpty())) {
                accumulator += internalManagerSearchForCost(e.getMonthlyCost(), e.getDirectReports());
            } else {
                accumulator += e.getMonthlyCost();
            }
        }
        return accumulator;
    }

    /**
     * loops over all reports and returns a list on direct reports
     * @return {ArrayList<Employees>} list of a managers direct reports
     */
    private ArrayList<Employee> getAllDirectReportHelper(HashMap<Integer, Employee> directReports, ArrayList<Employee> subordinates) {
        for (int key : directReports.keySet()) {
            Employee e = directReports.get(key);

            // if the employee is a manager and that manager has directReports
            if (e.getClass().getSimpleName().equals("Manager") && !(e.getDirectReports().isEmpty())) {
                getAllDirectReportHelper(e.getDirectReports(), subordinates);
            }
            subordinates.add(e);
        }
        return subordinates;
    }
}
