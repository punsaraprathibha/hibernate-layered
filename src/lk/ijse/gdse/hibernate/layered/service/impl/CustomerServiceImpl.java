package lk.ijse.gdse.hibernate.layered.service.impl;

import lk.ijse.gdse.hibernate.layered.dto.CustomerDto;
import lk.ijse.gdse.hibernate.layered.entity.Customer;
import lk.ijse.gdse.hibernate.layered.projection.CustomerDetailDto;
import lk.ijse.gdse.hibernate.layered.repository.CustomerRepository;
import lk.ijse.gdse.hibernate.layered.repository.impl.CustomerRepositoryImpl;
import lk.ijse.gdse.hibernate.layered.service.CustomerService;
import lk.ijse.gdse.hibernate.layered.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private static CustomerService customerService;
    private Session session;

    private final CustomerRepository customerRepository;

    private CustomerServiceImpl() {
        customerRepository = CustomerRepositoryImpl.getInstance();
    }

    public static CustomerService getInstance() {
        return null == customerService
                ? customerService = new CustomerServiceImpl()
                : customerService;
    }

    public Long saveCustomer(CustomerDto customerDto) { // We're getting a DTO type from the controller
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            customerRepository.setSession(session);
            Long id = customerRepository.save(customerDto.toEntity()); // We pass it to the repository by converting it to an entity
            transaction.commit();
            session.close();
            return id;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return -1L;
        }
    }

    public CustomerDto getCustomer(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            customerRepository.setSession(session);
            Customer customer = customerRepository.get(id);
            session.close();
            return customer.toDto(); // We convert the Entity back to a dto type before return to the controller
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public boolean updateCustomer(CustomerDto customerDto) { // We're getting a DTO type from the controller
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            customerRepository.setSession(session);
            customerRepository.update(customerDto.toEntity()); // We pass it to the repository by converting it to an entity
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteCustomer(CustomerDto customerDto) { // We're getting a DTO type from the controller
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            customerRepository.setSession(session);
            customerRepository.delete(customerDto.toEntity()); // We pass it to the repository by converting it to an entity
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        customerRepository.setSession(session);
        List<Customer> allCustomers = customerRepository.getAllCustomers(); // Here we're getting Entity type object result
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer : allCustomers) {
            customerDtoList.add(customer.toDto()); // We convert the Entity back to a dto type before return to the controller
        }
        return customerDtoList;
    }

    @Override
    public List<CustomerDto> getAllJPQLCustomers() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        customerRepository.setSession(session);
        List<Customer> allCustomers = customerRepository.getAllJPQLCustomers(); // Here we're getting Entity type object result
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer : allCustomers) {
            customerDtoList.add(customer.toDto()); // We convert the Entity back to a dto type before return to the controller
        }
        return customerDtoList;
    }

    @Override
    public List<CustomerDetailDto> getAllCustomerProjection() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        customerRepository.setSession(session);
        return customerRepository.getAllCustomerProjection(); // We're already getting a projection dto type since no need to covert
    }

}
