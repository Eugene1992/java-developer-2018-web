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
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "orders_products",
            joinColumns = {@JoinColumn(name = "orders_id")},
            inverseJoinColumns = {@JoinColumn(name = "products_id")}
    )
    private List<Product> products;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order(List<Product> products, Customer customer) {
        this.products = products;
        this.customer = customer;
    }


}
