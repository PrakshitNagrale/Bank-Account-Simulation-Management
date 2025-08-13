package dtos;

import models.Customer;

public class CustomerRequestDTO {

    private Long customerId;
    private String name;
    private Long phoneNo;
    private String address;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer convertCustomerRequestDTOtoCustomer(CustomerRequestDTO customerRequestDTO) {

        Customer customer = new Customer();

        customer.setCustomerId(customerRequestDTO.getCustomerId());
        customer.setCustomerName(customerRequestDTO.getName());
        customer.setPhoneNo(customerRequestDTO.getPhoneNo());
        customer.setAddress(customerRequestDTO.getAddress());

        return customer;
    }
}
