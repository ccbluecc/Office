package sit.int202.classicmodels_tue.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "offices")
@ToString(exclude = {"addressLine1", "addressLine2", "territory"})
@NamedQueries({
        @NamedQuery(name = "OFFICE.FINDALL", query = "select o from Office o"),
        @NamedQuery(name = "OFFICE.FIND_BY_CITY_OR_COUNTRY", query = "select o from Office o where lower(o.city) like :city or lower(o.country) like :country"),
        @NamedQuery(name = "OFFICE.FIND_BY_COUNTRY", query = "select o from Office o where o.country like :countryParam"),
        @NamedQuery(name = "OFFICE.DELETE", query = "delete Office o where o.officeCode = :officeCode"),
        @NamedQuery(name = "OFFICE.LASTVALUE", query = "select MAX(o.officeCode) from Office o")
})

public class Office {
    @Id
    private String officeCode;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String territory;
    @OneToMany(mappedBy = "office")
    private List<Employee> employeeList;


}
