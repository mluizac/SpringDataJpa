package springDataJpa.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import springDataJpa.model.Customer;
import springDataJpa.repository.CustomerRepository;

import java.util.List;

@RequiredArgsConstructor //construtor com todos os parametros
@Component //é um bean, o spring vai chamar essa classe quando for necessario, injeção de dependencia
public class CustomerService{

    @Autowired //instancia a classe, nao precisa o new
    private CustomerRepository customerRepository;

    //salva um customer
    public ResponseEntity save(Customer customer) { //retorna um objeto e seu status
        customerRepository.save(customer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    //busca todos os customers
    public Iterable<Customer> getAll(){
        return customerRepository.findAll();
    }

    //busca pelo id
    public Customer getId(long id){
        return customerRepository.findById(id);
    }

    //busca pelo sobrenome
    public List<Customer> getLastName(String lastName){
        return customerRepository.findByLastName(lastName);
    }
}

