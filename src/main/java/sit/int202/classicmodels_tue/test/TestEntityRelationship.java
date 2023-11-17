package sit.int202.classicmodels_tue.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodels_tue.entities.Employee;
import sit.int202.classicmodels_tue.entities.Environment;
import sit.int202.classicmodels_tue.entities.Office;

import java.util.Scanner;

public class TestEntityRelationship {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Enter office code (0 to stop) :");
            String officecode = sc.next();
            if(officecode.equalsIgnoreCase("0")){
                break;
            }
            Office office = em.find(Office.class, officecode);
            if(office == null){
                System.out.println("Office code " + "dose exist !!");
            }else {
                displayOfficeEmployee(office);
            }

        }while(true);
        em.close();
    }

    private static void displayOfficeEmployee(Office office) {
        System.out.println(office.getOfficeCode() + " " + office.getCity() + ", " +
                office.getCountry());
        System.out.println("------------");
        for(Employee employee: office.getEmployeeList()){
            System.out.printf(("%8s %-10s %-12s\n"),
                    employee.getEmployeeNumber(),employee.getFirstName(),employee.getLastName());
        }
        System.out.println();
    }
}
