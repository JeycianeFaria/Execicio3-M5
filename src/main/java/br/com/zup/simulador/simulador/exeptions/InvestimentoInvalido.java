package br.com.zup.simulador.simulador.exeptions;

public class InvestimentoInvalido extends RuntimeException {

    public InvestimentoInvalido(String message) {
        super(message);
    }

}
