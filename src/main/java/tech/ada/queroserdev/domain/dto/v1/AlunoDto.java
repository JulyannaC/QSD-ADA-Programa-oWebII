package tech.ada.queroserdev.domain.dto.v1;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties

public class AlunoDto {
    @Positive
    private int id;
    @NotBlank
    private String nome;
    @NotNull
    private int matricula;
    @NotBlank
    private String turma;
    @Null
    private String activity;
}
