package lk.ijse.gdse.hibernate.layered;
import lk.ijse.gdse.hibernate.layered.dto.CustomerDto;
import lk.ijse.gdse.hibernate.layered.entity.Customer;
import lk.ijse.gdse.hibernate.layered.projection.CustomerDetailDto;
import lk.ijse.gdse.hibernate.layered.service.CustomerService;
import lk.ijse.gdse.hibernate.layered.service.impl.CustomerServiceImpl;

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
    public static void main(String[] args) {

        CustomerService customerService = CustomerServiceImpl
                .getInstance();
        CustomerDto customerDto = getCustomerDto();

        // 1. Performs Save/Insert through Customer Repository
        customerService.saveCustomer(customerDto);

        CustomerDto existingCustomer = customerService.getCustomer(1L);
        existingCustomer.setAddress("Matara");

        customerService.updateCustomer(existingCustomer);

//        customerService.deleteCustomer(existingCustomer);

        List<CustomerDto> customers = customerService.getAllCustomers();
        for (CustomerDto customer1 : customers) {
            System.out.println(customer1);
        }

        List<CustomerDto> jpqlCustomers = customerService.getAllJPQLCustomers();
        for (CustomerDto customer1 : jpqlCustomers) {
            System.out.println(customer1);
        }

        // Now this Projection works. Please refer the CustomerRepository
        List<CustomerDetailDto> jpqlCustomerProj = customerService
                .getAllCustomerProjection();
        for (CustomerDetailDto customer1 : jpqlCustomerProj) {
            System.out.println(customer1);
        }
    }

    private static CustomerDto getCustomerDto() {
        CustomerDto customer = new CustomerDto();
        // Sets Customer table's primary key
        customer.setId(1L);
        // Sets Customer Name
        customer.setName("Kamal");
        // Sets the customer address
        customer.setAddress("Galle");
        // Sets the customer age
        customer.setAge(22);

        return customer;
    }
}
