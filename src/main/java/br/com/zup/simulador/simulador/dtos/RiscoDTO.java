package br.com.zup.simulador.simulador.dtos;

public enum RiscoDTO {

    ALTO(0.025),
    MEDIO(0.015),
    BAIXO(0.005);
    private double taxa;

    RiscoDTO(double valor) {
        this.taxa = valor;
    }

    public double getTaxa() {
        return taxa;
    }

}
