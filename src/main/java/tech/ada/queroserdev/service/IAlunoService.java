package tech.ada.queroserdev.service;

import tech.ada.queroserdev.domain.dto.exception.NotFoundException;
import tech.ada.queroserdev.domain.dto.v1.AlunoDto;
import tech.ada.queroserdev.domain.dto.v1.ProfessorDto;

import java.util.List;

public interface IAlunoService {

    AlunoDto criarAluno(AlunoDto pedido);

    AlunoDto buscarAluno(int id) throws NotFoundException;

    List<AlunoDto> listarAlunos();

    AlunoDto atualizarAluno(int id, AlunoDto pedido) throws NotFoundException;

    void removerAluno(int id) throws NotFoundException;

    AlunoDto buscarPorTurma(String turma) throws NotFoundException;

}
