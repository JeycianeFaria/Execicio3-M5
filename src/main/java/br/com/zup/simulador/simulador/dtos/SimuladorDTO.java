package br.com.zup.simulador.simulador.dtos;

public class SimuladorDTO {

    private String email;
    private String nome;
    private String cpf;
    private double valorInvestido;
    private int mesesDeAplicacao;
    //riscoDTO


    public SimuladorDTO() {
    }

    public SimuladorDTO(String email, String nome, String cpf, double valorInvestido, int mesesDeAplicacao) {
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.valorInvestido = valorInvestido;
        this.mesesDeAplicacao = mesesDeAplicacao;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public int getMesesDeAplicacao() {
        return mesesDeAplicacao;
    }

    public void setMesesDeAplicacao(int mesesDeAplicacao) {
        this.mesesDeAplicacao = mesesDeAplicacao;
    }

}
