package br.com.zup.simulador.simulador;

import br.com.zup.simulador.simulador.dtos.RetornoDTO;
import br.com.zup.simulador.simulador.dtos.RiscoDTO;
import br.com.zup.simulador.simulador.dtos.SimuladorDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimuladorService {

    private List<SimuladorDTO> simulacoes = new ArrayList<>();
    private RetornoDTO retornoSimulacao = new RetornoDTO();


    public void salvarSimulacoes(SimuladorDTO simulacao){
        simulacoes.add(simulacao);
    }

    public double calcularInvestimento(SimuladorDTO dadosSimulador){
        double valorTotalLucro = dadosSimulador.getValorInvestido();

        for (int contador = 0; contador < dadosSimulador.getMesesDeAplicacao(); contador ++ ){
            if (dadosSimulador.getRisco() == RiscoDTO.ALTO){
                valorTotalLucro = valorTotalLucro + (valorTotalLucro * 0.025);

            }else if (dadosSimulador.getRisco() == RiscoDTO.MEDIO){
                valorTotalLucro = valorTotalLucro + (valorTotalLucro * 0.015);
            }else if (dadosSimulador.getRisco() == RiscoDTO.BAIXO){
                valorTotalLucro = valorTotalLucro + (valorTotalLucro * 0.005);
            }
        }

        return valorTotalLucro;
    }

    public  double calcularLucro(SimuladorDTO dadosSimulador){
        double valorInicial = dadosSimulador.getValorInvestido();
        double valorTotal = calcularInvestimento(dadosSimulador);
        double valorLucro = valorTotal - valorInicial;

        return valorLucro;
    }


    public RetornoDTO retornoDTO (SimuladorDTO simulacao){
        salvarSimulacoes(simulacao);
        retornoSimulacao.setValorInicial(simulacao.getValorInvestido());
        retornoSimulacao.setValorTotal(calcularInvestimento(simulacao));
        retornoSimulacao.setValorLucro(calcularLucro(simulacao));

        return retornoSimulacao;
    }

}
