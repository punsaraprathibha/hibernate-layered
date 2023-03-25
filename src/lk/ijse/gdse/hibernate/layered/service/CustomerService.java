package lk.ijse.gdse.hibernate.layered.service;

import lk.ijse.gdse.hibernate.layered.entity.Customer;
import lk.ijse.gdse.hibernate.layered.repository.CustomerRepository;
import lk.ijse.gdse.hibernate.layered.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerService {

    private static CustomerService customerService;
    private final Session session;

    private final CustomerRepository customerRepository;

    private CustomerService () {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        customerRepository = CustomerRepository.getInstance();
    }

    public static CustomerService getInstance() {
        return null == customerService
                ? customerService = new CustomerService()
                : customerService;
    }

    public Long saveCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try {
            customerRepository.setSession();
            Long id = customerRepository.saveCustomer(customer); // <= Hibernate
            // session.persist(customer); <= JPA
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
}
