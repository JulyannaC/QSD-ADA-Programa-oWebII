package tech.ada.queroserdev.domain.dto;

import java.util.Collection;
//Importa a interface Collection do pacote java.util, que representa uma coleção de objetos.

import java.util.stream.Collectors;
//Importa a classe Collectors do pacote java.util.stream, que fornece operações de coleção para streams.

import org.springframework.web.bind.MethodArgumentNotValidException;
//Importa a exceção MethodArgumentNotValidException do pacote org.springframework.web.bind,
// que é lançada quando um argumento de método anotado com @Valid falha na validação.

import com.fasterxml.jackson.annotation.JsonInclude;
//Importa a anotação JsonInclude do pacote com.fasterxml.jackson.annotation,
// que é usada para indicar que propriedades específicas devem ser incluídas ou excluídas durante a serialização JSON.

import lombok.Data;
//Importa a anotação Data do projeto Lombok, que combina várias outras anotações, como Getter, Setter, EqualsAndHashCode,
// RequiredArgsConstructor, e ToString, economizando a digitação do código.

import tech.ada.queroserdev.domain.dto.exception.NotFoundException;
//Importa a exceção NotFoundException do pacote tech.ada.queroserdev.domain.dto.exception,
// que parece ser uma exceção personalizada definida em outro lugar do código.


@Data
//Anotação Lombok que gera automaticamente os métodos getters, setters, toString, hashCode e equals
// para todos os campos da classe.

public class ErrorResponse {
//Define a declaração da classe ErrorResponse, que provavelmente é usada para encapsular informações
// sobre erros em respostas HTTP.

    private String message;
    //Declaração de um campo privado message do tipo String, que armazenará a mensagem de erro.

    @JsonInclude(JsonInclude.Include.NON_NULL) //Anotação Jackson para indicar que a propriedade errors
    // não deve ser incluída na saída JSON se for nula.

    private Collection<ErrorMessage> errors;
    //Declaração de um campo privado errors do tipo Collection que armazenará uma coleção de mensagens de erro
    // do tipo ErrorMessage.

    private ErrorResponse(String message) { // construtor privado que aceita uma mensagem como argumento e inicializa o campo message.
        this.message = message; //Atribui o valor do argumento message ao campo message do objeto ErrorResponse.
    }

    private ErrorResponse(String message, Collection<ErrorMessage> errors) {
    //Declaração de um segundo construtor privado que aceita uma mensagem e uma coleção de mensagens de erro como argumentos.
        this(message);//Chama o primeiro construtor privado para inicializar o campo message.
        this.errors = errors; //Atribui o valor do argumento errors ao campo errors do objeto ErrorResponse.
    }

    public static ErrorResponse createFromException(NotFoundException ex) {
    //Declaração de um método estático que cria um objeto ErrorResponse a partir de uma exceção NotFoundException.
    // Este método parece gerar uma mensagem personalizada para a exceção.

        String message = "No record of " + ex.getClazz().getSimpleName() + " found for id " + ex.getId();
        //Cria uma mensagem personalizada usando informações da exceção NotFoundException.

        return new ErrorResponse(message); // Retorna um novo objeto ErrorResponse com a mensagem personalizada criada.
    }

    public static ErrorResponse createFromException(MethodArgumentNotValidException ex) {
    // Declaração de um método estático que cria um objeto ErrorResponse a partir de uma
    //exceção MethodArgumentNotValidException. Este método parece gerar uma lista de mensagens de erro
    //a partir dos erros de validação.

        var violations = ex //Declara uma variável local chamada violations, que armazenará os erros de validação.
                .getFieldErrors()
                //Obtém uma lista de erros de campo da exceção MethodArgumentNotValidException.
                .stream()
                //Converte a lista de erros de campo em uma stream, permitindo operações de pipeline.
                .map(it -> new ErrorMessage(it.getField(), it.getDefaultMessage()))
                // Mapeia cada erro de campo para uma instância de ErrorMessage,
                // usando o nome do campo e a mensagem de erro padrão.
                .collect(Collectors.toList()); //Coleta os resultados mapeados em uma lista.
        return new ErrorResponse("Validation errors", violations);
        // Retorna um novo objeto ErrorResponse com a mensagem "Validation errors"
        // e a lista de mensagens de erro de validação.
    }
}



