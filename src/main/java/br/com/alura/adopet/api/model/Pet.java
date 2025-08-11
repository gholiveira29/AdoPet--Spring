package br.com.alura.adopet.api.model;

import br.com.alura.adopet.api.dto.CadastroPetDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"abrigo", "adocao"})
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoPet tipo;

    private String nome;

    private String raca;

    private Integer idade;

    private String cor;

    private Float peso;

    private Boolean adotado;

    @ManyToOne(fetch = FetchType.LAZY)
    private Abrigo abrigo;

    @OneToOne(mappedBy = "pet", fetch = FetchType.LAZY)
    private Adocao adocao;

    public Pet(CadastroPetDto dto, Abrigo abrigo) {
        this.tipo = dto.tipo();
        this.nome = dto.nome();
        this.raca = dto.raca();
        this.idade = dto.idade();
        this.cor = dto.cor();
        this.peso = dto.peso();
        this.abrigo = abrigo;
        this.adotado = false;
    }
}
