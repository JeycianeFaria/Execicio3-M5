package br.com.zup.simulador.simulador;

import br.com.zup.simulador.simulador.dtos.RetornoDTO;
import br.com.zup.simulador.simulador.dtos.RiscoDTO;
import br.com.zup.simulador.simulador.dtos.SimuladorDTO;
import br.com.zup.simulador.simulador.exeptions.InvestimentoInvalido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimuladorService {

    private List<SimuladorDTO> simulacoes = new ArrayList<>();


    public void validarInvestimento(SimuladorDTO dadosSimulador){
        if (dadosSimulador.getValorInvestido() < 5000 && dadosSimulador.getRisco().equals(RiscoDTO.ALTO)){
            throw new InvestimentoInvalido("Investimento de alto risco deve ser acima de R$ 5000");
        }
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

        validarInvestimento(simulacao);
        salvarSimulacoes(simulacao);
        retornoSimulacao.setValorInicial(simulacao.getValorInvestido());
        retornoSimulacao.setValorTotal(calcularInvestimento(simulacao));
        retornoSimulacao.setValorLucro(calcularLucro(simulacao));

        return retornoSimulacao;
    }

}
