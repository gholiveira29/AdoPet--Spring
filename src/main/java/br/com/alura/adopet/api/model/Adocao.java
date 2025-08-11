package br.com.alura.adopet.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "adocoes")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Tutor tutor;

    @OneToOne(fetch = FetchType.LAZY)
    private Pet pet;

    private String motivo;

    @Enumerated(EnumType.STRING)
    private StatusAdocao status = StatusAdocao.AGUARDANDO_AVALIACAO;

    private String justificativaStatus;

    @Builder
    public Adocao(Tutor tutor, Pet pet, String motivo) {
        this.tutor = tutor;
        this.pet = pet;
        this.motivo = motivo;
    }

    public void marcarComoAprovada() {
        this.status = StatusAdocao.APROVADO;
    }

    public void marcarComoReprovada(String justificativa) {
        this.status = StatusAdocao.REPROVADO;
        this.justificativaStatus = justificativa;
    }
}
