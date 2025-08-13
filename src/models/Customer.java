package models;

public class Customer {

    private Long customerId;
    private String customerName;
    private Long phoneNo;
    private String address;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    @Override
    public String toString() {
        return "CustomerId: " + this.customerId +
                "\nCustomer Name: " + this.customerName +
                "\nPhoneNo: " + this.phoneNo+
                "\nAddress: " + this.address;
    }
}
