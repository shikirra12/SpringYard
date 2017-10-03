package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testAddGet() throws InterruptedException {

            //Set up is to create and add a test customer and test that we can retrieve both with getAll and getById
            System.out.print("Adding test customer to database...");
            Customer expected = createTestCustomer();
            customerService.add(expected);
            System.out.println("Customer was created!");
            assertTrue(true);

            //Test getAllCustomers()
            System.out.print("Getting all customers from the database...");
            List<Customer> customers = customerService.get();
            System.out.println("Done!");
            System.out.print("Gettting expected customer...");
            Customer receivedFromAll = customers.iterator().next();
            System.out.println("Done!");
            System.out.print("Testing getAllCustomers()....");
            Assert.assertNotNull(receivedFromAll);
            Assert.assertEquals(receivedFromAll.getFirstName(),expected.getFirstName());
            Assert.assertEquals(receivedFromAll.getLastName(),expected.getLastName());
            Assert.assertEquals(receivedFromAll.getPhone(),expected.getPhone());
            Assert.assertEquals(receivedFromAll.getText(),expected.getText());
            System.out.println("Passed!");

            //Test getCustomerById()
            System.out.println("Running ID test using the customer:");
            System.out.println("\t" + receivedFromAll);
            System.out.print("Getting customer by ID...");
            Customer receivedById = customerService.getById(receivedFromAll.getId());
            System.out.println("\tFound the following customer:");
            System.out.println("\t\t" + receivedById);
            System.out.println("Done!");
            System.out.print("Testing getCustomerById()....");
            Assert.assertNotNull(receivedById);
            Assert.assertEquals(receivedById.getFirstName(),receivedFromAll.getFirstName());
            Assert.assertEquals(receivedById.getLastName(),receivedFromAll.getLastName());
            Assert.assertEquals(receivedById.getPhone(),receivedFromAll.getPhone());
            Assert.assertEquals(receivedById.getText(),receivedFromAll.getText());
            System.out.println("Passed!");

        }

        private Customer createTestCustomer() throws InterruptedException {

            Customer testCustomer = new Customer();

            testCustomer.setFirstName(Long.toString(System.currentTimeMillis()));
            Thread.sleep(500l);
            testCustomer.setLastName(Long.toString(System.currentTimeMillis()));
            Thread.sleep(500l);
            testCustomer.setPhone(Long.toString(System.currentTimeMillis()));
            Thread.sleep(500l);
            testCustomer.setText(Long.toString(System.currentTimeMillis()));
            Thread.sleep(500l);


            return testCustomer;
        }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

    }




}
