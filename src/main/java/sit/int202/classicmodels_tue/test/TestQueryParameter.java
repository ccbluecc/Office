package sit.int202.classicmodels_tue.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodels_tue.entities.Employee;
import sit.int202.classicmodels_tue.entities.Environment;

import java.util.List;
import java.util.Scanner;

public class TestQueryParameter {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("EMPLOYEE.FIND_BY_NAME");
        Scanner sc = new Scanner(System.in);
        char choice = 'x';
        do{
            System.out.println("Search Employee by name (enter . to stop): ");
            String name = sc.next();
            choice = name.charAt(0);
            if(choice == '.'){
                break;
            }
            query.setParameter("first_name",name + "%");
            query.setParameter("last_name",name + "%");
            List<Employee> employeeList = query.getResultList();
            if (employeeList.isEmpty()){
                System.out.println("Employee name start with " + name + "dose not exist!!!");
            } else {
                displayEmployee(employeeList);
            }

        }while (true);
        em.close();
    }
    private static void displayEmployee(List<Employee> employeeList) {
        for(Employee employee: employeeList){
            System.out.printf(("%-2s %-20s %-12s\n"),employee.getEmployeeNumber(),employee.getFirstName(),employee.getLastName());
        }
    }
}
