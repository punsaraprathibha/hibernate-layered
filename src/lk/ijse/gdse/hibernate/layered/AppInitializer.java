package lk.ijse.gdse.hibernate.layered;
import lk.ijse.gdse.hibernate.layered.entity.Customer;
import lk.ijse.gdse.hibernate.layered.projection.CustomerDetailDto;
import lk.ijse.gdse.hibernate.layered.repository.CustomerRepository;
import lk.ijse.gdse.hibernate.layered.service.CustomerService;

import java.util.List;

/**
 * This is the Main class of this Hibernate Application
 * So, let's call it as "AppInitializer"
 */
public class AppInitializer {
    /**
     * @param args : java.lang.String[]
     * Main method of this Application
     */
    public static void main(String[] args) throws InterruptedException {

        CustomerService customerService = CustomerService
                .getInstance();
        Customer customer = getCustomerEntity();

        // 1. Performs Save/Insert through Customer Repository
        customerService.saveCustomer(customer);

        Customer existingCustomer = customerService.getCustomer(1L);
        existingCustomer.setAddress("Matara");

        customerService.updateCustomer(existingCustomer);

        customerService.deleteCustomer(customer);

//        List<Customer> customers = customerService
//                .getAllCustomers();
//        for (Customer customer1 : customers) {
//            System.out.println(customer1);
//        }
//
//        List<Customer> jpqlCustomers = customerService
//                .getAllJPQLCustomers();
//        for (Customer customer1 : jpqlCustomers) {
//            System.out.println(customer1);
//        }
//
//        // Now this Projection works. Please refer the CustomerRepository
//        List<CustomerDetailDto> jpqlCustomerProj = customerService.getAllCustomerProjection();
//        for (CustomerDetailDto customer1 : jpqlCustomerProj) {
//            System.out.println(customer1);
//        }
    }

    private static Customer getCustomerEntity() {
        Customer customer = new Customer();
        // Sets Customer table's primary key
        customer.setId(1L);

        // Sets the NameIdentifier object data as Name in Customer Entity
//        customer.setName(nameIdentifier);

        // Sets the customer address
        customer.setAddress("Galle");
        // Sets the customer salary
//        customer.setSalary(30000.00);
        // Sets the customer age
        customer.setAge(22);

        return customer;
    }
}
