package codegym2019.customermanagementrestfull;

import codegym2019.customermanagementrestfull.repository.CustomerRepository;
import codegym2019.customermanagementrestfull.repository.impl.CustomerRepositoryImpl;
import codegym2019.customermanagementrestfull.service.CustomerService;
import codegym2019.customermanagementrestfull.service.impl.CustomerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerManagementRestfullApplication {
    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerRepositoryImpl();
    }

    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerManagementRestfullApplication.class, args);
    }

}
