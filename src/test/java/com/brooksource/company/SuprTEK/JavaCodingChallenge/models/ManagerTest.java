package com.brooksource.company.SuprTEK.JavaCodingChallenge.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;


public class ManagerTest {
    private Developer developer1, developer2;
    private QATester qaTester1;
    private Manager managerA, managerB, managerC, managerD, managerE, vpOfAppDev;
    private HashMap<Integer, Employee> managerAsSubordinates, managerBsSubordinates, managerCsSubordinates,
            managerDsSubordinates, managerEsSubordinates, vpOfAppDevSubordinates;

    @BeforeEach
    public void setUp() throws Exception {
        developer1 = new Developer("Software Engineer", "Cj Meeks", "Portal", "Ibrahim");
        developer2 = new Developer("Software Engineer", "John Smith", "Portal", "Drake");
        qaTester1 = new QATester("SE in Test", "Apuroop", "QA", "Ibrahim");

        managerEsSubordinates = new HashMap<>();
        managerEsSubordinates.put(developer2.getId(), developer2);
        managerE = new Manager("Engineering Manager", "Drake", "Application Development", "Jonathan", managerEsSubordinates);

        managerBsSubordinates = new HashMap<>();
        managerBsSubordinates.put(developer1.getId(), developer1);
        managerBsSubordinates.put(qaTester1.getId(), qaTester1);
        managerB = new Manager("Team Lead", "Ibrahim", "Application Development", "Manager A", managerBsSubordinates);

        managerAsSubordinates = new HashMap<>();
        managerAsSubordinates.put(managerB.getId(), managerB);
        managerA = new Manager("Engineering Manager", "Ed", "Application Development", "Jonathan", managerAsSubordinates);


        managerDsSubordinates = new HashMap<>();
        managerD = new Manager("Team Lead", "Aaron", "Application Development", "Manager C", managerDsSubordinates);

        managerCsSubordinates = new HashMap<>();
        managerCsSubordinates.put(managerD.getId(), managerD);
        managerC = new Manager("Engineering Manager", "Bob", "Application Development", "Jonathan", managerCsSubordinates);

        vpOfAppDevSubordinates = new HashMap<>();
        vpOfAppDevSubordinates.put(managerA.getId(), managerA);
        vpOfAppDevSubordinates.put(managerC.getId(), managerC);
        vpOfAppDevSubordinates.put(managerE.getId(), managerE);
        vpOfAppDev = new Manager("Vice President", "Jonathan", "Application Development", "Shahzad", vpOfAppDevSubordinates);
    }

    // NOTE: I could, and really should, break up each test into smaller parts but since this is a mock project who cares :)
    @Test
    public void testGetAllDirectReports() {
        ArrayList<Employee> expectA = new ArrayList<>();
        expectA.add(developer1);
        expectA.add(qaTester1);
        expectA.add(managerB);
        ArrayList<Employee> expectC = new ArrayList<>();
        expectC.add(managerD);
        ArrayList<Employee> expectD = new ArrayList<>();
        ArrayList<Employee> expectE = new ArrayList<>();
        expectE.add(developer2);

        // Was Assertions.assertEquals(expectE, managerE.getAllDirectReports()); but this cares about order :(
        Assertions.assertTrue(expectA.size() == managerA.getAllDirectReports().size()
                && expectA.containsAll(managerA.getAllDirectReports())
                /*&& managerA.getAllDirectReports().containsAll(expectA)*/);
        Assertions.assertTrue(expectC.size() == managerC.getAllDirectReports().size()
                && expectC.containsAll(managerC.getAllDirectReports())
                /*&& managerC.getAllDirectReports().containsAll(expectC)*/);
        Assertions.assertTrue(expectD.size() == managerD.getAllDirectReports().size()
                && expectD.containsAll(managerD.getAllDirectReports())
                /*&& managerD.getAllDirectReports().containsAll(expectD)*/);
        Assertions.assertTrue(expectE.size() == managerE.getAllDirectReports().size()
                && expectE.containsAll(managerE.getAllDirectReports())
                /*&& managerE.getAllDirectReports().containsAll(expectE)*/);
    }

    @Test
    public void testGetTeamsMonthlyExpense() {
        Assertions.assertEquals(4200.00, managerA.getTeamsMonthlyExpense());
        Assertions.assertEquals(3600.00, managerB.getTeamsMonthlyExpense());
        Assertions.assertEquals(1200.00, managerC.getTeamsMonthlyExpense());
        Assertions.assertEquals(600.00, managerD.getTeamsMonthlyExpense());
        Assertions.assertEquals(2600.00, managerE.getTeamsMonthlyExpense());
        // This is not 8000 because the VP himself is a manager
        Assertions.assertEquals(8600.00, vpOfAppDev.getTeamsMonthlyExpense());
    }
}