package lk.ijse.gdse.hibernate.layered.service;

import lk.ijse.gdse.hibernate.layered.dto.CustomerDto;
import lk.ijse.gdse.hibernate.layered.entity.Customer;
import lk.ijse.gdse.hibernate.layered.projection.CustomerDetailDto;

import java.util.List;

public interface CustomerService {

    Long saveCustomer(CustomerDto customer);

    CustomerDto getCustomer(long id);

    boolean updateCustomer(CustomerDto customer);

    boolean deleteCustomer(CustomerDto customer);

    List<CustomerDto> getAllCustomers();

    List<CustomerDto> getAllJPQLCustomers();

    List<CustomerDetailDto> getAllCustomerProjection();
}
