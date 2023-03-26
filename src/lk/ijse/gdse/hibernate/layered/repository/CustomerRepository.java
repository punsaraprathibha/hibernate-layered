package lk.ijse.gdse.hibernate.layered.repository;

import lk.ijse.gdse.hibernate.layered.entity.Customer;
import lk.ijse.gdse.hibernate.layered.projection.CustomerDetailDto;
import org.hibernate.Session;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

    // All the custom queries other than CRUD operation defined at CRUD Repository,
    // you need for this repository should define here and implementation should
    // define inside the implementation class
    List<Customer> getAllCustomers();

    List<Customer> getAllJPQLCustomers();

    List<CustomerDetailDto> getAllCustomerProjection();
}
