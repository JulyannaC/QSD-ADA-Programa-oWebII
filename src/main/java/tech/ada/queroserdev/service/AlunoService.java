package tech.ada.queroserdev.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import tech.ada.queroserdev.domain.dto.exception.NotFoundException;
import tech.ada.queroserdev.domain.dto.v1.AlunoDto;


@Service
public class AlunoService implements IAlunoService {

    private final List<AlunoDto> alunos = new ArrayList<>();
    private int id = 1;

    @Override
    public AlunoDto criarAluno(AlunoDto alunoDto) {
        AlunoDto a = new AlunoDto(
                id++,
                alunoDto.getNome(),
                alunoDto.getMatricula(),
                alunoDto.getTurma()
        );
        alunos.add(a);
        return a;
    }

    @Override
    public AlunoDto buscarAluno(int id) throws NotFoundException {
        return alunos
                .stream()
                .filter(it -> it.getId()==id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(AlunoDto.class, String.valueOf(id)));
    }

    @Override
    public List<AlunoDto> listarAlunos() {

        return alunos;
    }

    @Override
    public AlunoDto atualizarAluno(int id, AlunoDto pedido){
        final AlunoDto aluno = alunos.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
        if (aluno == null) {
            return null;
        }
        alunos.remove(aluno);
        AlunoDto a = new AlunoDto(aluno.getId(), pedido.getNome(), pedido.getMatricula(), pedido.getTurma());
        alunos.add(a);
        return a;
    }

    @Override
    public void removerAluno(int id) throws NotFoundException {
        final AlunoDto aluno = buscarAluno(id);
        alunos.remove(aluno);
    }

    @Override
    public AlunoDto buscarPorTurma(String turma) throws NotFoundException {
        return null;
    }
}