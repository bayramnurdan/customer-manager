package kodlama.io.customermanager.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCustomerResponse {
    private int id;
    private String firstName;
    private String lastName;
    private int birthYear;
    private String nationalIdentity;
}
