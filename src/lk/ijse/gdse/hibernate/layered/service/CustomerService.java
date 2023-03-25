package lk.ijse.gdse.hibernate.layered.service;

import lk.ijse.gdse.hibernate.layered.entity.Customer;
import lk.ijse.gdse.hibernate.layered.repository.CustomerRepository;
import lk.ijse.gdse.hibernate.layered.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerService {

    private static CustomerService customerService;
    private Session session;

    private final CustomerRepository customerRepository;

    private CustomerService () {
        customerRepository = CustomerRepository.getInstance();
    }

    public static CustomerService getInstance() {
        return null == customerService
                ? customerService = new CustomerService()
                : customerService;
    }

    public Long saveCustomer(Customer customer) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            customerRepository.setSession(session);
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

    public Customer getCustomer(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            customerRepository.setSession(session);
            Customer customer = customerRepository.getCustomer(id);
            session.close(); // We've closed the unclosed sessions in previous week's code
            return customer;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public boolean updateCustomer(Customer customer) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            customerRepository.setSession(session);
            customerRepository.updateCustomer(customer);
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

    public boolean deleteCustomer(Customer customer) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            customerRepository.setSession(session);
            customerRepository.deleteCustomer(customer);
            transaction.commit();
            session.close(); // We've closed the unclosed sessions in previous week's code
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close(); // We've closed the unclosed sessions in previous week's code
            return false;
        }
    }
}
