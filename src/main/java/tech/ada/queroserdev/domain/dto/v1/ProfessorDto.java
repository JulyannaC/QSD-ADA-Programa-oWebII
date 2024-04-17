package tech.ada.queroserdev.domain.dto.v1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
//Importa a anotação Email do pacote jakarta.validation.constraints, que é uma anotação de validação usada
// para verificar se uma string representa um endereço de e-mail válido.

import jakarta.validation.constraints.NotBlank;
//Importa a anotação NotBlank do pacote jakarta.validation.constraints, que é uma anotação de validação
// usada para verificar se uma string não é nula e não é composta apenas por espaços em branco.

import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
//Importa a anotação Positive do pacote jakarta.validation.constraints, que é uma anotação de validação usada
// para verificar se um valor numérico é estritamente positivo.

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
////Importa a anotação NoArgsConstructor do projeto Lombok. Esta anotação cria um construtor padrão sem argumentos.
import org.hibernate.validator.constraints.br.CPF;
//Importa a anotação CPF do pacote org.hibernate.validator.constraints.br, que é uma anotação de validação
// usada para verificar se uma string representa um número de CPF válido de acordo com as regras brasileiras.

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties

public class ProfessorDto {
    @Positive//Anotação de validação que especifica que o valor do campo id deve ser estritamente positivo.
    private int id;//Declaração de um campo privado id do tipo int, que provavelmente representa
    // o identificador único do professor.
    @NotBlank//Anotação de validação que especifica que o campo nome não pode ser nulo ou vazio.
    private String nome;//Declaração de um campo privado nome do tipo String, que provavelmente representa o nome do professor.
    @CPF //Anotação de validação que especifica que o valor do campo cpf deve ser um número
    // de CPF válido de acordo com as regras brasileiras.
    private String cpf;//Declaração de um campo privado cpf do tipo String, que provavelmente representa o CPF do professor.
    @Email//Anotação de validação que especifica que o valor do campo email deve ser um endereço de e-mail válido.
    private String email;//Declaração de um campo privado email do tipo String,
    // que provavelmente representa o endereço de e-mail do professor.
    @Null
    private String activity;
}