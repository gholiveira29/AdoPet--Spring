package br.com.alura.adopet.api.model;

import br.com.alura.adopet.api.dto.AtualizacaoTutorDto;
import br.com.alura.adopet.api.dto.CadastroTutorDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tutores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "adocoes")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String email;

    @OneToMany(mappedBy = "tutor")
    private List<Adocao> adocoes = new ArrayList<>();

    public Tutor(CadastroTutorDto dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
    }

    public void atualizarDados(AtualizacaoTutorDto dto) {
        this.nome = dto.nome();
        this.telefone = dto.telefone();
        this.email = dto.email();
    }
}
