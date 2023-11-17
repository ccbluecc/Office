package sit.int202.classicmodels_tue.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodels_tue.entities.Employee;
import sit.int202.classicmodels_tue.entities.Environment;
import sit.int202.classicmodels_tue.entities.Office;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Scanner;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("OFFICE.FINDALL");
        List<Office> officeList = query.getResultList();
        for (Office office : officeList){
            System.out.printf("%-2s %-20s %-12s %-12s\n",office.getOfficeCode(),office.getAddressLine1(),office.getCity(),office.getCountry());
        }
        System.out.println("------------------------");
        for(Employee employee: (List<Employee>) em.createNamedQuery("EMPLOYEE.FINDALL").getResultList()){
            System.out.printf(("%-2s %-20s %-12s\n"),employee.getEmployeeNumber(),employee.getFirstName(),employee.getLastName());
        }
        Office office = em.find(Office.class, "");
        if(office != null){
            System.out.println(office);
            System.out.println("New Office Added\n");
            Office newOffice = new Office();
            newOffice.setOfficeCode("9");
            newOffice.setCountry("Thailand");
            newOffice.setCity("Bangkok");
            newOffice.setAddressLine1("126 Pracha-utit");
            newOffice.setPhone("123456789");
            newOffice.setPostalCode("10140");
            newOffice.setTerritory("XXX");
            em.getTransaction().begin();
            em.persist(newOffice);
            em.getTransaction().commit();
        }else {
//            System.out.println("No specify office !!!");
        }
//        System.out.println("Enter office code you want to delete");
//        String x = new Scanner(System.in).next();
//        Office delOffice = em.find(Office.class, x);
//        if(delOffice != null){
//            em.getTransaction().begin();
//            em.remove(delOffice);
//            em.getTransaction().commit();
//        }
        em.close();
        emf.close();
    }
}
