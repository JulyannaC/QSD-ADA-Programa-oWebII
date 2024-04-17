package tech.ada.queroserdev.view;

import jakarta.validation.Valid;
//Importa a anotação Valid do pacote jakarta.validation, que é usada para indicar que
// um argumento de método deve ser validado.

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
//Importa a anotação Autowired do pacote org.springframework.beans.factory.annotation,
// que é usada para injetar dependências automaticamente.

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
//Importa a classe HttpStatus do pacote org.springframework.http, que fornece códigos de status HTTP.

import org.springframework.http.ResponseEntity;
//Importa a classe ResponseEntity do pacote org.springframework.http, que representa uma resposta HTTP.

import org.springframework.web.bind.annotation.*;
//Importa várias anotações de mapeamento do Spring MVC, como @RestController, @RequestMapping, @GetMapping,
// @PostMapping, @PutMapping e @DeleteMapping.

import tech.ada.queroserdev.domain.dto.v1.ProfessorDto;
//Importa a classe ProfessorDto do pacote tech.ada.queroserdev.domain.dto.v1, que representa um DTO para
// dados relacionados a professores.

import tech.ada.queroserdev.service.IProfessorService;
//Importa a interface IProfessorService do pacote tech.ada.queroserdev.service, que define os métodos
// de serviço relacionados a professores.

import tech.ada.queroserdev.domain.dto.exception.NotFoundException;
//Importa a exceção NotFoundException do pacote tech.ada.queroserdev.domain.dto.exception,
// que é lançada quando um objeto não é encontrado.

import java.util.List;


@RestController //Anotação Spring que marca a classe como um controlador REST, indicando que os métodos desta classe
// serão mapeados para endpoints RESTful.

@RequestMapping("/professor") //Anotação que mapeia todos os métodos deste controlador para o path /professor.
// Isso significa que todos os endpoints neste controlador terão o prefixo /professor.

public class ProfessorController {
//Define a declaração da classe ProfessorController, que é responsável por lidar com as requisições relacionadas
// a professores.

    private final IProfessorService servico;
//Declaração de um campo final servico do tipo IProfessorService, que representa o serviço relacionado a professores.

    public ProfessorController(IProfessorService servico) {
    //Construtor da classe ProfessorController que aceita uma instância de IProfessorService como argumento.

        this.servico = servico; //  Atribui a instância fornecida de IProfessorService ao campo servico.
    }

    @GetMapping
    //Anotação que mapeia o método lerProfessores para requisições GET no endpoint /professor.
    // Retorna uma lista de professores.

    public ResponseEntity<List<ProfessorDto>> lerProfessores() {
    //Método que lida com requisições GET para listar todos os professores.
    // Retorna uma resposta HTTP com a lista de professores.

        return ResponseEntity.ok(servico.listarProfessores());
    //Retorna uma resposta HTTP com o status OK (200) e o corpo contendo a lista de professores.
    }

    @PostMapping
    //Anotação que mapeia o método criarProfessor para requisições POST no endpoint /professor.
    // Cria um novo professor.

    public ResponseEntity<ProfessorDto> criarProfessor(
            @RequestBody @Valid ProfessorDto pedido
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servico.criarProfessor(pedido));
        //Método que lida com requisições POST para criar um novo professor. Aceita um objeto ProfessorDto
        // no corpo da requisição, que é validado pela anotação @Valid. Retorna uma resposta HTTP com o status
        // CREATED (201) e o corpo contendo o novo professor.
    }

    @PutMapping("/{id}")
    //Anotação que mapeia o método atualizarProfessor para requisições PUT no endpoint /professor/{id}.
    // Atualiza um professor existente.

    public ResponseEntity<ProfessorDto> atualizarProfessor(
            @PathVariable("id") int id,
            @RequestBody ProfessorDto pedido
            //Método que lida com requisições PUT para atualizar um professor existente com o ID fornecido.
            // Aceita o ID do professor a ser atualizado como parte da URL e um objeto ProfessorDto
            // no corpo da requisição.

    ) throws NotFoundException {
        final ProfessorDto p = servico.atualizarProfessor(id, pedido);

        if (p == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            //NOT_FOUND (404) se o professor não for encontrado.
        }
        return ResponseEntity.ok(p);
        //Retorna uma resposta HTTP com o status OK (200) e o corpo contendo o professor atualizado
    }

    @GetMapping("/{id}")
    //Anotação que mapeia o método buscarProfessor para requisições GET no endpoint /professor/{id}.
    // Busca um professor pelo ID.

    public ResponseEntity<ProfessorDto> buscarProfessor(
            @PathVariable("id") int id
    ) throws NotFoundException {
    //Método que lida com requisições GET para buscar um professor pelo ID fornecido. Aceita o ID do professor
    // como parte da URL e lança uma exceção NotFoundException se o professor não for encontrado.
        return ResponseEntity.ok(servico.buscarProfessor(id));
        // Retorna uma resposta HTTP com o status OK (200) e o corpo contendo o professor encontrado.
    }

    @DeleteMapping("/{id}")
    //Anotação que mapeia o método removerProfessor para requisições DELETE no endpoint /professor/{id}.
    // Remove um professor pelo ID.

    public ResponseEntity<Void> removerProfessor(
            @PathVariable("id") int id
    ) throws NotFoundException {
    //Método que lida com requisições DELETE para remover um professor pelo ID fornecido.
    // Aceita o ID do professor como parte da URL e lança uma exceção NotFoundException
        // se o professor não for encontrado.
        servico.removerProfessor(id);
        return ResponseEntity.noContent().build();
        //Retorna uma resposta HTTP com o status NO_CONTENT (204) se o professor for removido com sucesso.
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<ProfessorDto> buscarPorCpf(@PathParam("cpf") String cpf) throws NotFoundException {
        return ResponseEntity.ok(servico.buscarPorCpf(cpf));
    }

}

