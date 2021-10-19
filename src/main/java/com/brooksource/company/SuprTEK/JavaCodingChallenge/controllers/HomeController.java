package com.brooksource.company.SuprTEK.JavaCodingChallenge.controllers;

import com.brooksource.company.SuprTEK.JavaCodingChallenge.models.Developer;
import com.brooksource.company.SuprTEK.JavaCodingChallenge.models.Employee;
import com.brooksource.company.SuprTEK.JavaCodingChallenge.models.Manager;
import com.brooksource.company.SuprTEK.JavaCodingChallenge.models.QATester;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class HomeController {

    @GetMapping("/employees/roster")
    public String index(Model model) {
        Developer developer1 = new Developer("Software Engineer", "Developer - Cj Meeks", "Portal", "Ibrahim");
        Developer developer2 = new Developer("Software Engineer", "Developer - John Smith", "Portal", "Drake");
        QATester qaTester1 = new QATester("SE in Test", "QATester - Apuroop", "QA", "Ibrahim");

        HashMap<Integer, Employee> managerEsSubordinates = new HashMap<>();
        managerEsSubordinates.put(developer2.getId(), developer2);
        Manager managerE = new Manager("Engineering Manager", "Manager E - Drake", "Application Development", "Jonathan", managerEsSubordinates);

        HashMap<Integer, Employee> managerBsSubordinates = new HashMap<>();
        managerBsSubordinates.put(developer1.getId(), developer1);
        managerBsSubordinates.put(qaTester1.getId(), qaTester1);
        Manager managerB = new Manager("Team Lead", "Manager B - Ibrahim", "Application Development", "Manager A", managerBsSubordinates);

        HashMap<Integer, Employee> managerAsSubordinates = new HashMap<>();
        managerAsSubordinates.put(managerB.getId(), managerB);
        Manager managerA = new Manager("Engineering Manager", "Manager A - Ed", "Application Development", "Jonathan", managerAsSubordinates);


        HashMap<Integer, Employee> managerDsSubordinates = new HashMap<>();
        Manager managerD = new Manager("Team Lead", "Manager D - Aaron", "Application Development", "Manager C", managerDsSubordinates);

        HashMap<Integer, Employee> managerCsSubordinates = new HashMap<>();
        managerCsSubordinates.put(managerD.getId(), managerD);
        Manager managerC = new Manager("Engineering Manager", "Manager C - Bob", "Application Development", "Jonathan", managerCsSubordinates);

        HashMap<Integer, Employee> vpOfAppDevSubordinates = new HashMap<>();
        vpOfAppDevSubordinates.put(managerA.getId(), managerA);
        vpOfAppDevSubordinates.put(managerC.getId(), managerC);
        vpOfAppDevSubordinates.put(managerE.getId(), managerE);
        Manager vpOfAppDev = new Manager("Vice President", "Jonathan", "Application Development", "Shahzad", vpOfAppDevSubordinates);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(developer1);
        employees.add(developer2);
        employees.add(qaTester1);
        employees.add(managerA);
        employees.add(managerB);
        employees.add(managerC);
        employees.add(managerD);
        employees.add(managerE);
        employees.add(vpOfAppDev);
        model.addAttribute("employees", employees);

        return "homePage";
    }
}
