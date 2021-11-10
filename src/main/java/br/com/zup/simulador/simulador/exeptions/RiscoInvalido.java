package br.com.zup.simulador.simulador.exeptions;

public class RiscoInvalido extends RuntimeException{

    public RiscoInvalido(String mensagem) {
        super(mensagem);
    }
}
