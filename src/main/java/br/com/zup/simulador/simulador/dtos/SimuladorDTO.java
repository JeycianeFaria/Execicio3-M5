package br.com.zup.simulador.simulador.dtos;

import br.com.zup.simulador.simulador.conversor.ConversorRiscoDTO;
import br.com.zup.simulador.simulador.conversor.RiscoDTOJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

public class SimuladorDTO {

    @Email(message = "Email inválido")
    private String email;
    private String nome;
    @CPF(message = "CPF inválido")
    private String cpf;
    private double valorInvestido;
    @Min(2)
    private int mesesDeAplicacao;
    @JsonDeserialize(using = RiscoDTOJsonDeserializer.class)
    private RiscoDTO risco;


    public SimuladorDTO() {
    }

    public SimuladorDTO(String email, String nome, String cpf, double valorInvestido, int mesesDeAplicacao, RiscoDTO risco) {
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.valorInvestido = valorInvestido;
        this.mesesDeAplicacao = mesesDeAplicacao;
        this.risco = risco;
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

    public RiscoDTO getRisco() {
        return risco;
    }

    public void setRisco(RiscoDTO risco) {
        this.risco = risco;
    }

}
