package sit.int202.classicmodels_tue.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import sit.int202.classicmodels_tue.entities.Office;

import java.util.List;

import static sit.int202.classicmodels_tue.repository.EntityManagerBuilder.getEntityManager;

public class OfficeRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Office> findAll() {
        return getEntityManager().createNamedQuery("OFFICE.FINDALL").getResultList();
    }

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
    public boolean insert(Office office) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean delete(Office office) {
        if (office != null) {
            EntityManager entityManager = getEntityManager();
            if (entityManager.contains(office)) {
                entityManager.getTransaction().begin();
                entityManager.remove(office);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return delete(office.getOfficeCode());
            }
        }
        return false;
    }

    public boolean delete(String officeCode) {
        EntityManager entityManager = getEntityManager();
        Office office = find(officeCode);
        if (office != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(office);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }
    public boolean update(Office newOffice) {
        if (newOffice != null) {
            EntityManager entityManager = getEntityManager();
            Office office = find(newOffice.getOfficeCode());
            if (office != null) {
                entityManager.getTransaction().begin();
                //set all attributes office with newOffice
                //example: office.setCity(newOffice.getcity());
                office.setOfficeCode(newOffice.getOfficeCode());;
                office.setCountry(newOffice.getCountry());
                office.setCity(newOffice.getCity());
                office.setPhone(newOffice.getPhone());
                office.setState(newOffice.getState());
                office.setPostalCode(newOffice.getPostalCode());
                office.setAddressLine1(newOffice.getAddressLine1());
                office.setAddressLine2(newOffice.getAddressLine2());
                office.setTerritory(newOffice.getTerritory());

                entityManager.getTransaction().commit();
                return true;
            }
        }
        return false;
    }
    public List<Office> findByCityOrCountry(String cityOrCountry) {
        cityOrCountry = cityOrCountry.toLowerCase()+'%';
        Query query = getEntityManager().createNamedQuery("OFFICE.FIND_BY_CITY_OR_COUNTRY");
        query.setParameter("city", cityOrCountry);
        query.setParameter("country", cityOrCountry);
        return query.getResultList();
    }
    public Integer getNextId(){
        TypedQuery<String> query = getEntityManager().createNamedQuery("OFFICE.LASTVALUE", String.class);
        String lastOfficeCode = query.getSingleResult();
        if (lastOfficeCode == null || lastOfficeCode.isEmpty()){
            return 1;
        }
        return Integer.parseInt(lastOfficeCode) + 1;
    }



}


