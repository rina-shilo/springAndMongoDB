package springAndMongoDB;
//import springAndMongoDB.Models.Customer;
//import springAndMongoDB.Repositories.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//@SpringBootApplication
//public class Application {
//    public static void main(String[] args) {
//        SpringApplication.run(springAndMongoDB.Application.class, args);
//    }
//}
import springAndMongoDB.Models.Customer;
import springAndMongoDB.Models.Pets;
import springAndMongoDB.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springAndMongoDB.Repositories.PetsRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PetsRepository petsRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();

        // save a couple of customers
        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Smith"));
        customerRepository.save(new Customer("rina", "s"));

        petsRepository.save(new Pets("name2","sp2","breed"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(customerRepository.findByFirstName("Alice"));
        System.out.println("Customer found with findByFirstName('Yaniv'):");
        System.out.println("--------------------------------");
        System.out.println(customerRepository.findByFirstName("Yaniv"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : customerRepository.findByLastName("Smith")) {
            System.out.println(customer);
        }


    }

}
