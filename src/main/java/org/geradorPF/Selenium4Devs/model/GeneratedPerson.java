package org.geradorPF.Selenium4Devs.model;

import java.util.Objects;

public class GeneratedPerson {

    public String nome;
    public Integer idade;
    public String cpf;
    public String rg;
    public String data_nasc;
    public String sexo;
    public String signo;
    public String mae;
    public String pai;
    public String email;
    public String senha;
    public String cep;
    public String endereco;
    public Integer numero;
    public String bairro;
    public String cidade;
    public String estado;
    public String telefone_fixo;
    public String celular;
    public String altura;
    public Float peso;
    public String tipo_sanguineo;
    public String cor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneratedPerson that = (GeneratedPerson) o;
        return Objects.equals(nome, that.nome) && Objects.equals(idade, that.idade) && Objects.equals(cpf, that.cpf) && Objects.equals(rg, that.rg) && Objects.equals(data_nasc, that.data_nasc) && Objects.equals(sexo, that.sexo) && Objects.equals(signo, that.signo) && Objects.equals(mae, that.mae) && Objects.equals(pai, that.pai) && Objects.equals(email, that.email) && Objects.equals(senha, that.senha) && Objects.equals(cep, that.cep) && Objects.equals(endereco, that.endereco) && Objects.equals(numero, that.numero) && Objects.equals(bairro, that.bairro) && Objects.equals(cidade, that.cidade) && Objects.equals(estado, that.estado) && Objects.equals(telefone_fixo, that.telefone_fixo) && Objects.equals(celular, that.celular) && Objects.equals(altura, that.altura) && Objects.equals(peso, that.peso) && Objects.equals(tipo_sanguineo, that.tipo_sanguineo) && Objects.equals(cor, that.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, cpf, rg, data_nasc, sexo, signo, mae, pai, email, senha, cep, endereco, numero, bairro, cidade, estado, telefone_fixo, celular, altura, peso, tipo_sanguineo, cor);
    }
}
