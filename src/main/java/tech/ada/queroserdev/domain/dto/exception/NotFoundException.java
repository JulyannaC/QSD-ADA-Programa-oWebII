package tech.ada.queroserdev.domain.dto.exception;


import lombok.AllArgsConstructor;
//Importa a anotação AllArgsConstructor do projeto Lombok.
// Esta anotação cria um construtor que aceita todos os campos da classe como argumentos.

import lombok.Getter;
//Importa a anotação Getter do projeto Lombok.
// Esta anotação gera automaticamente um método getter para cada campo da classe.

@Getter
@AllArgsConstructor
public class NotFoundException extends Exception {
//Define a declaração da classe NotFoundException,
// que parece ser uma exceção personalizada que estende a classe Exception.
    private final Class clazz;
    //Declaração de um campo privado clazz do tipo Class,
    // que provavelmente representa a classe ou tipo de objeto que não foi encontrado.
    private final String id;
    //Declaração de um campo privado id do tipo String, que provavelmente
    // representa o identificador único do objeto que não foi encontrado.
}


