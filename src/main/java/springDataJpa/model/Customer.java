package springDataJpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@RequiredArgsConstructor
@Data
@Entity
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    @NotBlank(message = "nome é obrigatorio")
    @Pattern(regexp="[a-zA-Z]*", message = "nome só aceita letras") //expressao regular
    private String firstName;

    @NotBlank
    @Pattern(regexp="[a-zA-Z]*")
    private String lastName;

}
