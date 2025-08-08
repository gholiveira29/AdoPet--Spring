package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.excption.ValidacaoExcption;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private PetRepository petRepository;

    public void validar(SolicitacaoAdocaoDTO solicitacaoAdocaoDTO) {
        Pet pet = petRepository.getReferenceById(solicitacaoAdocaoDTO.pedId());
        if (pet.getAdotado()) throw new ValidacaoExcption("Pet já foi adotado!");
    }
}
