package lk.ijse.gdse.hibernate.layered.repository;

import lk.ijse.gdse.hibernate.layered.entity.Customer;
import lk.ijse.gdse.hibernate.layered.projection.CustomerDetailDto;
import org.hibernate.Session;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

    List<Customer> getAllCustomers();

    List<Customer> getAllJPQLCustomers();

    List<CustomerDetailDto> getAllCustomerProjection();
}
