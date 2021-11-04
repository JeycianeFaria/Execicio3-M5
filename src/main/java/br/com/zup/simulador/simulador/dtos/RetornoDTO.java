package br.com.zup.simulador.simulador.dtos;

public class RetornoDTO {

    private double valorInicial;
    private double valorLucro;
    private double valorTotal;


    public RetornoDTO() {
    }

    public RetornoDTO(double valorInicial, double valorLucro, double valorTotal) {
        this.valorInicial = valorInicial;
        this.valorLucro = valorLucro;
        this.valorTotal = valorTotal;
    }


    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorLucro() {
        return valorLucro;
    }

    public void setValorLucro(double valorLucro) {
        this.valorLucro = valorLucro;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
