package tech.ada.queroserdev.service;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tech.ada.queroserdev.domain.dto.exception.NotFoundException;
import tech.ada.queroserdev.domain.dto.v1.AlunoDto;
import tech.ada.queroserdev.domain.entities.Aluno;
import tech.ada.queroserdev.domain.mappers.AlunoMapper;
import tech.ada.queroserdev.repositories.AlunoRepository;

import java.util.List;

@Service
@Primary
public class AlunoServicoBD implements IAlunoService {

    private final AlunoRepository repositorio;

    public AlunoServicoBD(AlunoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public AlunoDto criarAluno(AlunoDto pedido) {

        Aluno a = AlunoMapper.toEntity(pedido);
        return AlunoMapper.toDto(repositorio.save(a));

    }

    @Override
    public AlunoDto buscarAluno(int id) throws NotFoundException {
        return AlunoMapper.toDto(buscarAlunoPorId(id));
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return repositorio.findAll().stream().map(AlunoMapper::toDto).toList();
    }

    @Override
    public AlunoDto atualizarAluno(int id, AlunoDto pedido) throws NotFoundException {
        final Aluno a = buscarAlunoPorId(id);
        a.setTurma(pedido.getTurma());
        a.setNome(pedido.getNome());
        a.setMatricula(pedido.getMatricula());
        return AlunoMapper.toDto(repositorio.save(a));

    }

    @Override
    public void removerAluno(int id) throws NotFoundException {

        final Aluno a = buscarAlunoPorId(id);
        repositorio.delete(a);
        repositorio.deleteById(id);

    }

    private Aluno buscarAlunoPorId(int id) throws NotFoundException {
        return repositorio.findById(id).orElseThrow(() -> new NotFoundException(Aluno.class, String.valueOf(id)));
    }

    @Override
    public AlunoDto buscarPorTurma(String turma) throws NotFoundException {

        return AlunoMapper.toDto(repositorio.findByTurma(turma).orElseThrow(() -> new NotFoundException(Aluno.class, turma)));
    }
}
