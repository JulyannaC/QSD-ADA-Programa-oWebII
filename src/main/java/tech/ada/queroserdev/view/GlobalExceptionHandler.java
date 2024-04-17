package tech.ada.queroserdev.view;

import org.springframework.http.HttpStatus;
//Importa a classe HttpStatus do pacote org.springframework.http, que fornece códigos de status HTTP.

import org.springframework.http.ResponseEntity;
//Importa a classe ResponseEntity do pacote org.springframework.http, que representa uma resposta HTTP.

import org.springframework.web.bind.MethodArgumentNotValidException;
//Importa a exceção MethodArgumentNotValidException do pacote org.springframework.web.bind,
// que é lançada quando um argumento de método anotado com @Valid falha na validação.

import org.springframework.web.bind.annotation.ControllerAdvice;
//Importa a anotação ControllerAdvice do pacote org.springframework.web.bind.annotation,
// que permite que classes anotadas com ela possam lidar com exceções em toda a aplicação.

import org.springframework.web.bind.annotation.ExceptionHandler;
//Importa a anotação ExceptionHandler do pacote org.springframework.web.bind.annotation,
// que indica que o método é responsável por tratar exceções específicas.

import tech.ada.queroserdev.domain.dto.ErrorResponse;
//Importa a classe ErrorResponse do pacote tech.ada.queroserdev.domain.dto,
// que representa uma estrutura para mensagens de erro.

import tech.ada.queroserdev.domain.dto.exception.NotFoundException;
//Importa a exceção NotFoundException do pacote tech.ada.queroserdev.domain.dto.exception,
// que parece ser uma exceção personalizada usada quando um objeto não é encontrado.

@ControllerAdvice //Anotação Spring que marca a classe como um componente
// que pode lidar com exceções globalmente em toda a aplicação.

public class GlobalExceptionHandler { //Define a declaração da classe GlobalExceptionHandler, que é responsável
// por lidar com exceções globalmente em toda a aplicação.

    @ExceptionHandler(value = NotFoundException.class)
//Anotação que marca o método handleNotFoundException como responsável por lidar com exceções do tipo NotFoundException.

    public ResponseEntity<ErrorResponse> handleNotFoundException(final NotFoundException exception) {
     //Método que lida com exceções do tipo NotFoundException. Ele retorna uma resposta HTTP
    // com o status 404 (Not Found) e um corpo contendo a mensagem de erro encapsulada em um objeto ErrorResponse.
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.createFromException(exception));
        // Retorna uma resposta HTTP com o status 404 (Not Found) e um corpo contendo a mensagem de erro encapsulada
        // em um objeto ErrorResponse, criado a partir da exceção NotFoundException.
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    //Anotação que marca o método handleConstraintViolationException como responsável por lidar com exceções
    // do tipo MethodArgumentNotValidException.
    public ResponseEntity<ErrorResponse> handeConstraintViolationException(final MethodArgumentNotValidException ex) {
        //Método que lida com exceções do tipo MethodArgumentNotValidException. Ele retorna uma resposta HTTP
        // com o status 400 (Bad Request) e um corpo contendo a mensagem de erro encapsulada em um objeto ErrorResponse.
        return ResponseEntity.badRequest().body(ErrorResponse.createFromException(ex));
        // Retorna uma resposta HTTP com o status 400 (Bad Request) e um corpo contendo a mensagem de erro encapsulada
        // em um objeto ErrorResponse, criado a partir da exceção MethodArgumentNotValidException.
    }

}



