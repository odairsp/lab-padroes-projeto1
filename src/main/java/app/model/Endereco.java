package app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tab_endereco")
public @Data class Endereco {

    @Id
    private String cep;
    private String logradouro;
//    private String numero;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;

//    @ManyToMany(mappedBy = "enderecos")
//    @JsonIgnoreProperties("users")
//    private List <User> users;

}
