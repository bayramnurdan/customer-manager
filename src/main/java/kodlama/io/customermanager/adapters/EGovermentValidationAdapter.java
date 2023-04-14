package kodlama.io.customermanager.adapters;

import kodlama.io.customermanager.business.abstracts.CustomerValidationService;
import kodlama.io.customermanager.business.dto.requests.create.CreateCustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class EGovermentValidationAdapter implements CustomerValidationService {
    @Override
    public void validateCustomer(CreateCustomerRequest request) {

        //adapter specific method


    }
}
