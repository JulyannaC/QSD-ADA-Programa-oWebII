package tech.ada.queroserdev.domain.mappers;

import tech.ada.queroserdev.domain.dto.v1.AlunoDto;
import tech.ada.queroserdev.domain.entities.Aluno;

public class AlunoMapper {

    public static Aluno toEntity(AlunoDto dto) {
        return Aluno
                .builder()
                .nome(dto.getNome())
                .matricula(dto.getMatricula())
                .turma(dto.getTurma())
                .build();
    }

    public static AlunoDto toDto(Aluno entity){
        return new AlunoDto(
                entity.getId(),
                entity.getNome(),
                entity.getMatricula(),
                entity.getTurma()
        );
    }
}

