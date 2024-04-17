package tech.ada.queroserdev.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class ErrorMessage {
    private String field;
    private String message;

}


//package tech.ada.queroserdev.domain.dto: define o pacote (package) ao qual esta classe pertence.
//Pacotes são usados para organizar classes em um projeto Java.
//Neste caso, a classe ErrorMessage está no pacote tech.ada.queroserdev.domain.dto.

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties: importa a anotação JsonIgnoreProperties
//do pacote com.fasterxml.jackson.annotation. Esta anotação é usada para indicar que determinadas propriedades
//de uma classe devem ser ignoradas durante a serialização/desserialização de objetos JSON usando a biblioteca Jackson.

//import lombok.AllArgsConstructor: importa a anotação AllArgsConstructor do projeto Lombok.
//Esta anotação cria um construtor que aceita todos os campos da classe como argumentos.

//import lombok.Builder: importa a anotação Builder do projeto Lombok. Esta anotação é usada para gerar um padrão
//de construção de objetos, permitindo a criação de instâncias da classe usando um padrão fluente.

//import lombok.Data: importa a anotação Data do projeto Lombok. Esta anotação é um atalho que combina várias
//outras anotações do Lombok, como Getter, Setter, ToString, EqualsAndHashCode e RequiredArgsConstructor,
//economizando a digitação do código.

//import lombok.NoArgsConstructor: importa a anotação NoArgsConstructor do projeto Lombok. Esta anotação cria um construtor
//padrão sem argumentos.

//@Data: Esta anotação do Lombok é usada para gerar automaticamente os métodos getters, setters, toString, hashCode e equals
//para todos os campos da classe.

//@Builder: Esta anotação do Lombok é usada para gerar um padrão de construção de objetos para a classe.
//Ela permite a criação de instâncias da classe usando um padrão fluente, onde os valores dos campos são atribuídos
//usando métodos de configuração encadeados.

//@AllArgsConstructor: Esta anotação do Lombok gera um construtor que aceita todos os campos da classe como argumentos.

//@NoArgsConstructor: Esta anotação do Lombok gera um construtor padrão sem argumentos.

//@JsonIgnoreProperties: Esta anotação do Jackson indica que propriedades desconhecidas no JSON de entrada devem ser
//ignoradas durante a desserialização para esta classe.

//public class ErrorMessage { : define a declaração da classe ErrorMessage, que é uma classe de modelo
//para armazenar informações sobre mensagens de erro.

//private String field: Declaração de um campo privado field do tipo String,
//que armazenará o nome do campo associado ao erro.

//private String message:Declaração de um campo privado message do tipo String,
// que armazenará a mensagem de erro associada.