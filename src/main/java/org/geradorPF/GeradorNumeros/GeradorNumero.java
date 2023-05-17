package org.geradorPF.GeradorNumeros;

import org.geradorPF.Excecoes.ValorInvalidoException;

public class GeradorNumero {

    private String valorGerado;
    private int valorMaximo;
    private int valorMinimo;
    private int quantidade;

    public GeradorNumero(int valorMaximo, int valorMinimo, int quantidade) throws ValorInvalidoException {
        this.valorMaximo = valorMaximo;
        this.valorMinimo = valorMinimo;
        this.quantidade = quantidade;
        this.verificarValorQuantidade();
        this.verificarValorMinimo();
        this.verificarValorMaximo();
        this.gerarNumeros();

    }

    public String getValorGerado() {
        return valorGerado;
    }

    public int getValorMaximo() {
        return valorMaximo;
    }

    public int getValorMinimo() {
        return valorMinimo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    private void verificarValorQuantidade() throws ValorInvalidoException {
        if (quantidade < 1) {
            throw new ValorInvalidoException("Valor quantidade inválido: quantidade deve ser maior que '0' ");
        }
    }

    private void verificarValorMaximo() throws ValorInvalidoException {
        StringBuilder mensagem = new StringBuilder("Valor máximo inválido: ");
        boolean isValorValido = true;

        if (valorMaximo < valorMinimo) {
            mensagem.append(" valor máximo não pode ser menor que valor mínimo");
            isValorValido = false;
        }
        if (valorMaximo < 0) {
            mensagem.append(" valor máximo não pode ser menor '0'");
            isValorValido = false;
        }
        if (valorMaximo == valorMinimo) {
            mensagem.append(" valor máximo não pode ser igual a valor mínimo");
            isValorValido = false;
        }

        if (!isValorValido) {
            throw new ValorInvalidoException(String.valueOf(mensagem));
        }

    }

    private void verificarValorMinimo() throws ValorInvalidoException {
        if (valorMinimo < 0) {
            throw new ValorInvalidoException("Valor minimo inválido: não pode ser menor que '0' ");
        }
    }

    private void gerarNumeros() {

        if (quantidade == 1) {
            this.valorGerado = String.valueOf(gerarNumeroAleatorio());
        } else {
            StringBuilder valor = new StringBuilder("");
            for (int i = 0; i < this.quantidade; i++) {
                valor.append(gerarNumeroAleatorio());
            }
            this.valorGerado = String.valueOf(valor);
        }

    }

    public static int gerarNumeroAleatorio() {
        final int valorMaximo = 9;
        final int valorMinimo = 0;
        final int range = valorMaximo - valorMinimo + 1;
        int numeroGerado = (int) (Math.random() * range) + valorMinimo;

        return numeroGerado;
    }


}
