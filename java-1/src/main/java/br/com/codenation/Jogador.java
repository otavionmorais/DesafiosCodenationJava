package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {

    private String nome;
    private Long id, idTime;
    private LocalDate nascimento;
    private BigDecimal salario;
    private Integer habilidade;
    private boolean isCapitao;
    private int idade;

    public Jogador(Long id, Long idTime, String nome, LocalDate nascimento, Integer habilidade, BigDecimal salario) {
        this.nome = nome;
        this.id = id;
        this.idTime = idTime;
        this.nascimento = nascimento;
        this.salario = salario;
        this.habilidade = habilidade;
        this.isCapitao=false;
    }

    public int getIdade() {
        LocalDate atual=LocalDate.now();
        LocalDate nascimento = this.nascimento;

        if(atual.getMonthValue()<nascimento.getMonthValue()) {
            this.idade = atual.getYear() - nascimento.getYear() - 1;

        } else if(atual.getMonthValue()==nascimento.getMonthValue()) {
            if (atual.getDayOfMonth() < nascimento.getDayOfMonth())
                this.idade = atual.getYear() - nascimento.getYear() - 1;
            else
                this.idade = atual.getYear() - nascimento.getYear();

        } else
           this.idade=atual.getYear()-nascimento.getYear();

        return this.idade;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Integer getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(Integer habilidade) {
        this.habilidade = habilidade;
    }

    public boolean isCapitao() {
        return isCapitao;
    }

    public void setCapitao(boolean capitao) {
        isCapitao = capitao;
    }
}
