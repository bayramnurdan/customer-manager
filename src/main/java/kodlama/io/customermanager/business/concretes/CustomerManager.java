package kodlama.io.customermanager.business.concretes;

import kodlama.io.customermanager.business.abstracts.CustomerService;
import kodlama.io.customermanager.business.abstracts.CustomerValidationService;
import kodlama.io.customermanager.business.dto.requests.create.CreateCustomerRequest;
import kodlama.io.customermanager.business.dto.requests.update.UpdateCustomerRequest;
import kodlama.io.customermanager.business.dto.responses.create.CreateCustomerResponse;
import kodlama.io.customermanager.business.dto.responses.get.GetAllCustomersResponse;
import kodlama.io.customermanager.business.dto.responses.get.GetCustomerResponse;
import kodlama.io.customermanager.business.dto.responses.update.UpdateCustomerResponse;
import kodlama.io.customermanager.entities.Customer;
import kodlama.io.customermanager.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerValidationService customerValidationService;
    private final ModelMapper mapper;
    private final CustomerRepository repository;

    @Override
    public List<GetAllCustomersResponse> getAll() {

        List<Customer> customers = repository.findAll();
        List<GetAllCustomersResponse> response = customers
                .stream()
                .map(customer->mapper.map(customer, GetAllCustomersResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetCustomerResponse getById(int id) {
       Customer customer = repository.findById(id).orElseThrow();
       GetCustomerResponse response = mapper.map(customer, GetCustomerResponse.class);
        return response;
    }

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest request) throws Exception{
        checkIfExists(request.getNationalIdentity());
        checkIfRealPerson(request);
        Customer customer = mapper.map(request, Customer.class);
        customer.setId(0);
        repository.save(customer);
        CreateCustomerResponse response = mapper.map(customer, CreateCustomerResponse.class);
        return response;
    }

    @Override
    public UpdateCustomerResponse update(int id, UpdateCustomerRequest request) {
        checkIfCustomer(id);
        Customer customer = mapper.map(request, Customer.class);
        customer.setId(id);
        repository.save(customer);
        UpdateCustomerResponse response = mapper.map(customer, UpdateCustomerResponse.class);
        return response;
    }


    @Override
    public void delete(int id) {
        checkIfCustomer(id);
        repository.deleteById(id);
    }

    //Business Rules

    public void checkIfRealPerson(CreateCustomerRequest request) throws Exception{
    if (!customerValidationService.validateCustomer(request)) throw new RuntimeException("Validasyon sağlanamadı");
    }

    public void checkIfExists(String nationalId){
        if(repository.existsByNationalIdentity(nationalId)){
            throw new RuntimeException("Müşteri sistemde zaten kayıtlı!");
        }
    }

    public void checkIfCustomer(int id){
        if(!repository.existsById(id)) throw  new RuntimeException("Müşteri bulunamadı!");

    }

}
