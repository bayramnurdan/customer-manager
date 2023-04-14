package kodlama.io.customermanager.business.concretes;

import kodlama.io.customermanager.business.abstracts.CustomerService;
import kodlama.io.customermanager.business.abstracts.CustomerValidationService;
import kodlama.io.customermanager.business.dto.requests.create.CreateCustomerRequest;
import kodlama.io.customermanager.business.dto.requests.update.UpdateCustomerRequest;
import kodlama.io.customermanager.business.dto.responses.create.CreateCustomerResponse;
import kodlama.io.customermanager.business.dto.responses.get.GetAllCustomersResponse;
import kodlama.io.customermanager.business.dto.responses.get.GetCustomerResponse;
import kodlama.io.customermanager.business.dto.responses.update.UpdateCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerValidationService customerValidationService;
    @Override
    public List<GetAllCustomersResponse> getAll() {
        return null;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        return null;
    }

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest request) {

        customerValidationService.validateCustomer(request);
        return null;
    }

    @Override
    public UpdateCustomerResponse update(int id, UpdateCustomerRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
