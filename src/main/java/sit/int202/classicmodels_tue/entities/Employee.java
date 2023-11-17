package sit.int202.classicmodels_tue.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = "office")
@Table(name = "Employees")
@NamedQueries({
        @NamedQuery(name = "EMPLOYEE.FINDALL",query = "select e from Employee e"),
        @NamedQuery(name = "EMPLOYEE.FIND_BY_NAME",query = "select e from Employee e where e.firstName like :first_name OR " +
                "e.lastName like :last_name"),

})
public class Employee {
    @Id
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
//    private String officeCode;
    private String reportsTo;
    private String jobTitle;
    @ManyToOne
    @JoinColumn(name = "officeCode",insertable = false,updatable = false)
    private Office office;

}
