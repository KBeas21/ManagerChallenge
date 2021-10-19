package com.brooksource.company.SuprTEK.JavaCodingChallenge.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;


class EmployeeTest {
    private static Employee EmployeeNonManager;
    private static Employee EmployeeManager;
    @BeforeAll
    static void setUp() {
        EmployeeNonManager = new Developer("testJobTitle", "testName", "test org", "Mr. Boss");
        HashMap<Integer, Employee> EmployeeManagerSubordinates = new HashMap<>();
        EmployeeManagerSubordinates.put(EmployeeNonManager.getId(), EmployeeNonManager);
        EmployeeManager = new Manager("Engineering Manager", "testManagerName", "test mgt org", "Jonathan", EmployeeManagerSubordinates);
    }

    @Test
    public void testSettingJobId(){
        Assertions.assertEquals(1, EmployeeManager.getId() - EmployeeNonManager.getId());
    }

    @Test
    public void testGetDirectReports() {
        Assertions.assertEquals(EmployeeNonManager, EmployeeManager.getDirectReports().get(EmployeeNonManager.getId()));
    }

    @Test
    void getJobTitle() {
        Assertions.assertEquals("testJobTitle", EmployeeNonManager.getJobTitle());
        Assertions.assertEquals("Engineering Manager", EmployeeManager.getJobTitle());
    }

    @Test
    void getMonthlyCost() {
        Assertions.assertEquals(2000.00, EmployeeNonManager.getMonthlyCost());
        Assertions.assertEquals(600.00, EmployeeManager.getMonthlyCost());
    }

    @Test
    void getName() {
        Assertions.assertEquals("testName", EmployeeNonManager.getName());
        Assertions.assertEquals("testManagerName", EmployeeManager.getName());
    }

    @Test
    void setName() {
        Employee e = new Developer("testJobTitle", "testName", "test org", "Mr. Boss");
        e.setName("my new name");

        Assertions.assertEquals("my new name", e.getName());
    }

    @Test
    void getOrganization() {
        Assertions.assertEquals("test org", EmployeeNonManager.getOrganization());
        Assertions.assertEquals("test mgt org", EmployeeManager.getOrganization());
    }

    @Test
    void getSupervisorName() {
        Assertions.assertEquals("Mr. Boss", EmployeeNonManager.getSupervisorName());
        Assertions.assertEquals("Jonathan", EmployeeManager.getSupervisorName());
    }

    @Test
    void setSupervisorName() {
        Employee e = new Developer("testJobTitle", "testName", "test org", "Mr. Boss");
        e.setSupervisorName("new Mr. Boss");

        Assertions.assertEquals("new Mr. Boss", e.getSupervisorName());
    }

    @Test
    void getId() {
        Assertions.assertEquals(1, EmployeeNonManager.getId());
        Assertions.assertEquals(2, EmployeeManager.getId());
    }

    @Test
    void testToString() {
        String output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Job Title: %s\n" +
                "Organization: %s\n" +
                "Cost: %.2f\n" +
                "Supervisor: %s\n", EmployeeNonManager.getId(), EmployeeNonManager.getName(), EmployeeNonManager.getJobTitle(),
                EmployeeNonManager.getOrganization(), EmployeeNonManager.getMonthlyCost(), EmployeeNonManager.getSupervisorName());

        Assertions.assertEquals(output, EmployeeNonManager.toString());
    }
}