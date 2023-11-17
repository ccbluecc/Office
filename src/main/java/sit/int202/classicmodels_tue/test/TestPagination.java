package sit.int202.classicmodels_tue.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodels_tue.entities.Employee;
import sit.int202.classicmodels_tue.entities.Environment;

import java.util.List;
import java.util.Scanner;

public class TestPagination {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("EMPLOYEE.FINDALL");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of entity per page: ");
        int pageSize = sc.nextInt();
        int beginFrom = 0;
        query.setMaxResults(pageSize);
        while (true){
            query.setFirstResult(beginFrom);
            List<Employee> employeeList = query.getResultList();
            if(employeeList.isEmpty()){
                break;
            }
            displayEmployee(employeeList);
            System.out.println("----------------------------");
            System.out.println("Press any key the enter to see next page ....");
            sc.next();
            beginFrom = beginFrom+pageSize;
        }
        em.close();
    }

    private static void displayEmployee(List<Employee> employeeList) {
        for(Employee employee: employeeList){
            System.out.printf(("%-2s %-20s %-12s\n"),employee.getEmployeeNumber(),employee.getFirstName(),employee.getLastName());
        }
    }
}
