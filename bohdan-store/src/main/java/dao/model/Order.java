package dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders", schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_products",
            joinColumns = {@JoinColumn(name = "orders_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "products_id", referencedColumnName = "id")}
    )
    private List<Product> products;

    public Order(List<Product> products, Customer customer) {
        this.products = products;
        this.customer = customer;
    }


}
