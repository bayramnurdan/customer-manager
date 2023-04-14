package kodlama.io.customermanager.api.controllers;

import kodlama.io.customermanager.business.abstracts.CustomerService;
import kodlama.io.customermanager.business.dto.requests.create.CreateCustomerRequest;
import kodlama.io.customermanager.business.dto.requests.update.UpdateCustomerRequest;
import kodlama.io.customermanager.business.dto.responses.create.CreateCustomerResponse;
import kodlama.io.customermanager.business.dto.responses.get.GetAllCustomersResponse;
import kodlama.io.customermanager.business.dto.responses.get.GetCustomerResponse;
import kodlama.io.customermanager.business.dto.responses.update.UpdateCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/customers")
public class CustomersController {
    CustomerService service;
    @GetMapping
    List<GetAllCustomersResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    GetCustomerResponse getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreateCustomerResponse add(@RequestBody CreateCustomerRequest request) throws Exception{
        return service.add(request);
    }

    @PutMapping("/{id}")
    UpdateCustomerResponse update(@PathVariable int id,@RequestBody UpdateCustomerRequest request){
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id){
        service.delete(id);
    }
}
