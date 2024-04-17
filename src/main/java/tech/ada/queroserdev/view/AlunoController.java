package tech.ada.queroserdev.view;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.queroserdev.domain.dto.exception.NotFoundException;
import tech.ada.queroserdev.domain.dto.v1.AlunoDto;
import tech.ada.queroserdev.domain.dto.v1.ProfessorDto;
import tech.ada.queroserdev.service.IAlunoService;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final IAlunoService servico;

    public AlunoController(IAlunoService servico) {

        this.servico = servico;
    }

    @GetMapping
    public ResponseEntity<List<AlunoDto>> lerAlunos() {

        return ResponseEntity.ok(servico.listarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> buscarAluno(
            @PathVariable ("id") int id
    ) throws NotFoundException {
        return ResponseEntity.ok(servico.buscarAluno(id));
    }

    @PostMapping
    public ResponseEntity<AlunoDto> criarAluno(
            @RequestBody @Valid AlunoDto pedido
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servico.criarAluno(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> atualizarAluno(
            @PathVariable("id") int id,
            @RequestBody AlunoDto pedido

    ) throws NotFoundException {
        final AlunoDto a = servico.atualizarAluno(id,pedido);

        if (a == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(a);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerAluno(
            @PathVariable("id") int id
    ) throws NotFoundException {
        servico.removerAluno(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/turma/{turma}")
    public ResponseEntity<AlunoDto> buscarPorTurma(@PathParam("turma") String turma) throws NotFoundException {
        return ResponseEntity.ok(servico.buscarPorTurma(turma));
    }

}
