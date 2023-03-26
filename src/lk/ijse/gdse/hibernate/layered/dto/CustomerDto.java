package lk.ijse.gdse.hibernate.layered.dto;

import lk.ijse.gdse.hibernate.layered.entity.Customer;

import java.io.Serializable;

public class CustomerDto implements Serializable {

    private long id;
    private String name;
    private String address;
    private int age;

    public CustomerDto() {}

    public CustomerDto(long id, String name, String address, int age) {
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
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }

    public Customer toEntity() {
        Customer customerDto = new Customer();
        customerDto.setId(this.id);
        customerDto.setName(this.name);
        customerDto.setAddress(this.address);
        customerDto.setAge(this.age);
        return customerDto;
    }
}
