package sit.int202.classicmodels_tue.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "PRODUCT.FIND_ALL",query = "select p from Product p"),
        @NamedQuery(name = "PRODUCT.COUNT",query = "select count(p) as count FROM Product p")
})
public class Product {
    @Id
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantityInStock;
    private Double buyPrice;
    @Column(name = "MSRP")
    private Double price;
}
