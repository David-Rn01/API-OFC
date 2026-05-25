package io.github.David_Rn01.API_OFC.services;

import io.github.David_Rn01.API_OFC.dto.MotoristaDTO;
import io.github.David_Rn01.API_OFC.dto.MotoristaRespostaDTO;
import io.github.David_Rn01.API_OFC.model.Cidade;
import io.github.David_Rn01.API_OFC.model.Motorista;
import io.github.David_Rn01.API_OFC.model.Veiculo;
import io.github.David_Rn01.API_OFC.repository.CidadeRepository;
import io.github.David_Rn01.API_OFC.repository.MotoristaRepository;
import io.github.David_Rn01.API_OFC.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MotoristaRespostaDTO cadastrar(MotoristaDTO motoristaDTO){
        validar(motoristaDTO);

        Veiculo veiculo = veiculoRepository.findByModeloIgnoreCaseAndPlacaIgnoreCase(motoristaDTO.getModeloVeiculo(), motoristaDTO.getPlacaVeiculo())
                .orElseThrow(() -> new IllegalArgumentException("Veiculo não encontrado"));

        Cidade cidade = cidadeRepository.findByNomeIgnoreCaseAndEstadoIgnoreCase(motoristaDTO.getNomeCidade(), motoristaDTO.getNomeEstado())
                .orElseThrow(() -> new IllegalArgumentException("Cidade não encontrada"));

        String senhaCriptografada = passwordEncoder.encode(motoristaDTO.getSenha());

        Motorista motorista = new Motorista(
                motoristaDTO.getCpf(),
                motoristaDTO.getNome(),
                motoristaDTO.getNumeroCelular(),
                senhaCriptografada,
                motoristaDTO.getCarteiraConducao(),
                cidade,
                veiculo
        );

        motoristaRepository.save(motorista);

        return converterResposta(motoristaDTO);
    }

    //Terminar as validações
    private void validar(MotoristaDTO motoristaDTO){
        if (motoristaDTO.getCpf() == null || motoristaDTO.getCpf().isBlank()){
            throw new IllegalArgumentException("O CPF precisa estar preenchido");
        }

        boolean jaExiste = motoristaRepository.existsByCarteiraConducao(motoristaDTO.getCarteiraConducao());
        if (jaExiste){
            throw new IllegalArgumentException("Motorista já está cadastrado");
        }

        if (motoristaDTO.getNome() == null || motoristaDTO.getNome().isBlank()){
            throw new IllegalArgumentException("Nome é obrigatório");
        }
    }

    private MotoristaRespostaDTO converterResposta(MotoristaDTO motoristaDTO){
        return new MotoristaRespostaDTO(
                motoristaDTO.getNome(),
                motoristaDTO.getNumeroCelular(),
                motoristaDTO.getCarteiraConducao(),
                motoristaDTO.getNomeCidade(),
                motoristaDTO.getModeloVeiculo()
        );
    }
}
