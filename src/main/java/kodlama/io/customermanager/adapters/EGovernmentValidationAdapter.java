package kodlama.io.customermanager.adapters;

import kodlama.io.customermanager.business.abstracts.CustomerValidationService;
import kodlama.io.customermanager.business.dto.requests.create.CreateCustomerRequest;
import kodlama.io.customermanager.mernis.EESKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class EGovernmentValidationAdapter implements CustomerValidationService {
    @Override
    public boolean validateCustomer(CreateCustomerRequest request) throws Exception{
        EESKPSPublicSoap client = new EESKPSPublicSoap();
        return client.TCKimlikNoDogrula(Long.parseLong(request.getNationalIdentity()), request.getFirstName(),
                request.getLastName(), request.getBirthYear());


    }
}
