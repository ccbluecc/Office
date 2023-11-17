package sit.int202.classicmodels_tue.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodels_tue.entities.Employee;
import sit.int202.classicmodels_tue.entities.Environment;
import sit.int202.classicmodels_tue.entities.Office;

import java.util.Scanner;

public class TestEmp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Employee employee = em.find(Employee.class, "1002");
        if(employee != null){
            System.out.println(employee);
        }else {
            System.out.println("No specify Employee !!!");
        }
        em.close();
        emf.close();
    }
}
