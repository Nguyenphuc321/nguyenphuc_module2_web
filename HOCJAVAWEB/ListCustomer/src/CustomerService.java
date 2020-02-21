import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Mai Văn Toàn", "1983-08-20", "Hà Nội", " http://erg.sh/uyl"));
        customers.put(2, new Customer(2, "Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", " http://erg.sh/uym"));
        customers.put(3, new Customer(3, "Nguyễn Thái Hòa", "1983-08-22", "Nam Định", " http://erg.sh/uyn"));
        customers.put(4, new Customer(4, "Trần Đăng Khoa", "1983-08-17", "Hà Tây", " http://erg.sh/uyo"));
        customers.put(5, new Customer(5, "Nguyễn Đình Thi", "1983-08-19", "Hà Nội", " http://erg.sh/uyp"));
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }
}