package lk.ijse.gdse.hibernate.layered.entity;

import lk.ijse.gdse.hibernate.layered.dto.CustomerDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long id;
    @Column(name = "customer_name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "age")
    private int age;

    public Customer() {}

    public Customer(long id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    // Use as a custom converter to easily convert Entity to a DTO type (Code Re-usability)
    public CustomerDto toDto() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(this.id);
        customerDto.setName(this.name);
        customerDto.setAddress(this.address);
        customerDto.setAge(this.age);
        return customerDto;
    }
}
