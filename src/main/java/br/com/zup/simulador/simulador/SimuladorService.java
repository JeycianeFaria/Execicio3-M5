package br.com.zup.simulador.simulador;

import br.com.zup.simulador.simulador.dtos.RetornoDTO;
import br.com.zup.simulador.simulador.dtos.RiscoDTO;
import br.com.zup.simulador.simulador.dtos.SimuladorDTO;
import br.com.zup.simulador.simulador.exeptions.RiscoInvalido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimuladorService {

    private List<SimuladorDTO> simulacoes = new ArrayList<>();


    public RiscoDTO validarRisco(RiscoDTO risco) {

        for (RiscoDTO referencia : RiscoDTO.values()) {
            if (risco.equals(referencia)) {
                return referencia;
            }
        }

        throw new RiscoInvalido("Risco não reconhecido");
    }

    public void salvarSimulacoes(SimuladorDTO simulacao) {
        simulacoes.add(simulacao);
    }

    public double calcularInvestimento(SimuladorDTO dadosSimulador) {
        double valorTotalLucro = dadosSimulador.getValorInvestido();

        for (int contador = 0; contador < dadosSimulador.getMesesDeAplicacao(); contador++) {
            valorTotalLucro = valorTotalLucro + (valorTotalLucro * dadosSimulador.getRisco().getTaxa());
        }

        return valorTotalLucro;
    }

    public double calcularLucro(SimuladorDTO dadosSimulador) {
        double valorInicial = dadosSimulador.getValorInvestido();
        double valorTotal = calcularInvestimento(dadosSimulador);

        return valorTotal - valorInicial;
    }

    public RetornoDTO retornoDTO(SimuladorDTO simulacao) {
        RetornoDTO retornoSimulacao = new RetornoDTO();

        validarRisco(simulacao.getRisco());
        salvarSimulacoes(simulacao);
        retornoSimulacao.setValorInicial(simulacao.getValorInvestido());
        retornoSimulacao.setValorTotal(calcularInvestimento(simulacao));
        retornoSimulacao.setValorLucro(calcularLucro(simulacao));

        return retornoSimulacao;
    }

}
