package tech.ada.queroserdev.service;

import java.util.List;
//Importa a interface List do pacote java.util, que representa uma lista ordenada de elementos.

import tech.ada.queroserdev.domain.dto.exception.NotFoundException;
//Importa a exceção NotFoundException do pacote tech.ada.queroserdev.domain.dto.exception,
// que parece ser uma exceção usada quando um objeto não é encontrado.

import tech.ada.queroserdev.domain.dto.v1.ProfessorDto;

public interface IProfessorService {
//Define a declaração da interface IProfessorService, que contém métodos relacionados
// à manipulação de dados de professores.

    ProfessorDto criarProfessor(ProfessorDto pedido);
    // Declaração do método criarProfessor, que aceita um objeto ProfessorDto como argumento e retorna
    // um objeto ProfessorDto. Este método é usado para criar um novo professor.

    List<ProfessorDto> listarProfessores();
    //Declaração do método listarProfessores, que retorna uma lista de objetos ProfessorDto.
    // Este método é usado para listar todos os professores.
    ProfessorDto buscarProfessor(int id) throws NotFoundException;
    //Declaração do método buscarProfessor, que aceita um ID de professor como argumento e retorna um objeto
    // ProfessorDto. Este método lança uma exceção NotFoundException se o professor não for encontrado.
    ProfessorDto atualizarProfessor(int id, ProfessorDto pedido) throws NotFoundException;
    // Declaração do método atualizarProfessor, que aceita um ID de professor e um objeto ProfessorDto
    // como argumentos e retorna um objeto ProfessorDto. Este método é usado para atualizar um professor existente.

    void removerProfessor(int id) throws NotFoundException;
    //Declaração do método removerProfessor, que aceita um ID de professor como argumento e não retorna nenhum valor.
    // Este método lança uma exceção NotFoundException se o professor não for encontrado.

    ProfessorDto buscarPorCpf(String cpf) throws NotFoundException;

}
