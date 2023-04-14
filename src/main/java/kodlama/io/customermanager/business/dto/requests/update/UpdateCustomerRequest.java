package kodlama.io.customermanager.business.dto.requests.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCustomerRequest {
    private String firstName;
    private String lastName;
    private int birthYear;
    private String nationalIdentity;
}
