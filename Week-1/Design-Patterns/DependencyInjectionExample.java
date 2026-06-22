// Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {
        return "Customer Found: ID = " + id + ", Name = Ruchikesha";
    }
}

// Service Class
class CustomerService {

    private CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void getCustomerDetails(int id) {
        System.out.println(customerRepository.findCustomerById(id));
    }
}

// Main Class
public class DependencyInjectionExample {

    public static void main(String[] args) {

        // Inject dependency through constructor
        CustomerRepository repository =
                new CustomerRepositoryImpl();

        CustomerService service =
                new CustomerService(repository);

        service.getCustomerDetails(101);
    }
}