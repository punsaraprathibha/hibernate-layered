package lk.ijse.gdse.hibernate.layered.util;

import lk.ijse.gdse.hibernate.layered.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * Purpose of creating this class to do the necessary Session Factory Configurations
 * by creating;
 * 1. Service Registry
 * 2. Metadata Object
 * 3. Session Factory
 * 4. Session Object
 */
public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfiguration;
    private final SessionFactory sessionFactory;

    /**
     * Private Default Constructor
     * Restricts creating new instances again and again
     * from this class from outside this class
     */
    private SessionFactoryConfig() {
        sessionFactory = new Configuration()
                .mergeProperties(Utility.getProperties())
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
    }

    /**
     * @return lk.ijse.gdse.hibernate.util.SessionFactoryConfiguration
     * Purpose of this method is to get an Instance of this same class
     * by limiting the object recreation (Limiting again and again Object creation)
     */
    public static SessionFactoryConfig getInstance() {
        return (null == factoryConfiguration)
                ? factoryConfiguration = new SessionFactoryConfig()
                : factoryConfiguration;
    }

    /**
     * @return org.hibernate.Session
     * @throws HibernateException
     * Purpose of this method is to get a Session from the Session Factory
     */
    public Session getSession() throws HibernateException {
        // Opens a new Session through the Session Factory & returns the Session created
        return sessionFactory.openSession();
    }
}
