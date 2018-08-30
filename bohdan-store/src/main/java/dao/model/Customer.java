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
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> customerOrders;

    public Customer(String name, String email, List<Order> orders) {
        this.name = name;
        this.email = email;
        this.customerOrders = orders;
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addOrder(Order order) {
        this.customerOrders.add(order);
    }
}
