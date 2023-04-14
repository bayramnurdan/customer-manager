package kodlama.io.customermanager.business.abstracts;

import kodlama.io.customermanager.business.dto.requests.create.CreateCustomerRequest;

public interface CustomerValidationService {
    void validateCustomer(CreateCustomerRequest request);
}
