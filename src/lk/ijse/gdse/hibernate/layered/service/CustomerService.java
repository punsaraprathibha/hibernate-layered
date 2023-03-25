package lk.ijse.gdse.hibernate.layered.service;

import lk.ijse.gdse.hibernate.layered.entity.Customer;
import lk.ijse.gdse.hibernate.layered.repository.CustomerRepository;
import lk.ijse.gdse.hibernate.layered.repository.impl.CustomerRepositoryImpl;
import lk.ijse.gdse.hibernate.layered.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface CustomerService {

    Long saveCustomer(Customer customer);

    Customer getCustomer(long id);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(Customer customer);
}
