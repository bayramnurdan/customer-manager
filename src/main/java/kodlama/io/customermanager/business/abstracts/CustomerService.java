package kodlama.io.customermanager.business.abstracts;

import kodlama.io.customermanager.business.dto.requests.create.CreateCustomerRequest;
import kodlama.io.customermanager.business.dto.requests.update.UpdateCustomerRequest;
import kodlama.io.customermanager.business.dto.responses.create.CreateCustomerResponse;
import kodlama.io.customermanager.business.dto.responses.get.GetAllCustomersResponse;
import kodlama.io.customermanager.business.dto.responses.get.GetCustomerResponse;
import kodlama.io.customermanager.business.dto.responses.update.UpdateCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    GetCustomerResponse getById(int id);
    CreateCustomerResponse add(CreateCustomerRequest request);
    UpdateCustomerResponse update(int id, UpdateCustomerRequest request);
    void delete(int id);



}
