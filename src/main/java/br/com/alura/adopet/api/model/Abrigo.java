package br.com.alura.adopet.api.model;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "abrigos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String email;

    public Abrigo(CadastroAbrigoDto dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
    }
}
