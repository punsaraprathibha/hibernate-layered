package lk.ijse.gdse.hibernate.layered.repository.impl;

import lk.ijse.gdse.hibernate.layered.entity.Customer;
import lk.ijse.gdse.hibernate.layered.projection.CustomerDetailDto;
import lk.ijse.gdse.hibernate.layered.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Defines a Customer Repository to Manage All
 * the CRUD Operations in a single place
 */
public class CustomerRepositoryImpl implements CustomerRepository {

    private Session session;
    private static CustomerRepositoryImpl customerRepositoryImpl;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * No Args Constructor
     * Initializes Session Object which is later going to
     * be used for below CRUD operations
     */
    private CustomerRepositoryImpl() {}

    public static CustomerRepositoryImpl getInstance() {
        return null == customerRepositoryImpl
                ? customerRepositoryImpl = new CustomerRepositoryImpl()
                : customerRepositoryImpl;
    }

    /**
     * @param customer : lk.ijse.gdse.hibernate.entity.Customer
     * @return java.lang.Long
     * Performs a customer object save (persistence) operation
     */
    public Long save(Customer customer) {
        return (Long) session.save(customer);
    }

    /**
     * @param customer : lk.ijse.gdse.hibernate.entity.Customer
     * @return boolean
     * Performs a given customer object update operation
     */
    public void update(Customer customer) {
        session.update(customer);
    }

    /**
     * @param id : long
     * @return lk.ijse.gdse.hibernate.entity.Customer
     * Retrieves customer object data based on the given customer id
     */
    @Override
    public Customer get(Long id) {
        return session.get(Customer.class, id);
    }

    /**
     * @param customer : lk.ijse.gdse.hibernate.entity.Customer
     * @return boolean
     * Deletes a specific customer by customer object which is passed
     */
    public void delete(Customer customer) {
        session.delete(customer);
    }

    // HQL - Hibernate Query Language
    public List<Customer> getAllCustomers() {
        String sqlQuery = "FROM Customer";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        session.close();
        return list;
    }

    // JPQL
    public List<Customer> getAllJPQLCustomers() {
        String sql = "SELECT C FROM Customer AS C"; // alias
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }

    // Here we're going to do a projection (which means getting only a set of selected attributes as the result)
    public List<CustomerDetailDto> getAllCustomerProjection() {
        String sql = "SELECT new lk.ijse.gdse.hibernate.layered.projection.CustomerDetailDto(C.name, C.address, C.age) FROM Customer AS C"; // In here the error was not defining the new keyword
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }
}
