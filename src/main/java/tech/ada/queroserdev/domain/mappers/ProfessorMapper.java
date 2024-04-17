package tech.ada.queroserdev.domain.mappers;

import tech.ada.queroserdev.domain.dto.v1.ProfessorDto;
import tech.ada.queroserdev.domain.entities.Professor;

public class ProfessorMapper {

    public static Professor toEntity(ProfessorDto dto) {
        return Professor
                .builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .build();
    }

    public static ProfessorDto toDto(Professor entity, String activity){
        return new ProfessorDto(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail(),
                activity
        );
    }
}
