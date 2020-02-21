package Dao;

import Model.Customer;

import java.util.*;

public class CustomerDao {
    private static final Map<Integer, Customer> listCustomer = new HashMap<Integer, Customer>();

    static {
        initCustomers();
    }

    private static void initCustomers() {
        Customer customer1 = new Customer(1, "nguyen van A", "098867876676", "phuckt567@gmail.com");
        Customer customer2 = new Customer(2, "nguyen van B", "098867876616", "phuckt667@gmail.com");
        Customer customer3 = new Customer(3, "nguyen van C", "098867876626", "phuckt767@gmail.com");
        Customer customer4 = new Customer(4, "nguyen van D", "098867876636", "phuckt867@gmail.com");
        listCustomer.put(customer1.getId(), customer1);
        listCustomer.put(customer2.getId(), customer2);
        listCustomer.put(customer3.getId(), customer3);
        listCustomer.put(customer4.getId(), customer4);
    }

    //viết phương thức xử lí thông tin của Customer theo id
    public static Customer getCustomer(int customerId) {
        return listCustomer.get(customerId);
    }

    //viết phương thức thêm mới một customer vào danh sách
    public static void addCustomer(Customer customer) {
        listCustomer.put(customer.getId(), customer);
    }

    //viết phương thức update customer
    public static Customer updateAndCreateCustomer(Customer customer) {
        listCustomer.put(customer.getId(), customer);
        return customer;
    }

    //viết phương thức xóa thông tin của customer theo id
    public static void deleteCustomer(int CustomerId) {
        listCustomer.remove(CustomerId);
    }

    //viết phương thức lấy danh sách của tất cả customer
    public static List<Customer> getAllCustomer() {
        Collection<Customer> c = listCustomer.values();
        List<Customer> list = new ArrayList<Customer>();
        list.addAll(c);
        return list;
    }
}
