package com.brooksource.company.SuprTEK.JavaCodingChallenge.models;

import java.util.HashMap;

public abstract class Employee {
    private final int id;
    private static int nextId = 1;

    private String jobTitle;
    private Double monthlyCost;
    private String name;
    private String organization;
    private String supervisorName;
    // Technically a HashMap is kind of overkill here could have used a List<Employee> since Employee's all
    // hold the same Id we are using here as the key.
    private HashMap<Integer, Employee> directReports = new HashMap<>();

    // Initialize a unique ID -- so long as they don't have 2147483646 employees we are good :)
    public Employee() {
        id = nextId;
        nextId++;
    }

    /**
     * (Used for non managers) Creates an Employee object
     */
    public Employee(String jobTitle, Double monthlyCost, String name, String organization, String supervisorName) {
        this(); // calls the above constructor to set id
        this.jobTitle = jobTitle;
        this.monthlyCost = monthlyCost;
        this.name = name;
        this.organization = organization;
        this.supervisorName = supervisorName;
    }

    /**
     * (Used for Managers) Creates an Employee object
     */
    public Employee(String jobTitle, Double monthlyCost, String name, String organization, String supervisorName, HashMap<Integer, Employee> directReports) {
        this(); // calls the above constructor to set id
        this.jobTitle = jobTitle;
        this.monthlyCost = monthlyCost;
        this.name = name;
        this.organization = organization;
        this.supervisorName = supervisorName;
        this.directReports = directReports;
    }

    public HashMap<Integer, Employee> getDirectReports() {
        return directReports;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public Double getMonthlyCost() {
        return monthlyCost;
    }

    public String getName() {
        return name;
    }

    /**
     * Would be used when a Employee changes their name for whatever reason
     *  (not needed in MVP of provided challenge)
     * @param name - Employees updated name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    /**
     * Would be used when a subordinate changes supervisors for whatever reason
     *  (not needed in MVP of provided challenge)
     * @param supervisorName - New supervisor name for employee
     */
    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Job Title: %s\n" +
                "Organization: %s\n" +
                "Cost: %.2f\n" +
                "Supervisor: %s\n", id, name, jobTitle, organization, monthlyCost, supervisorName);
    }
}
