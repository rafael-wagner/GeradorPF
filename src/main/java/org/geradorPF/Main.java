package org.geradorPF;


import org.geradorPF.GeradorCpf.GeradorCPF;

public class Main {
    public static void main(String[] args) {

        GeradorCPF g = new GeradorCPF();

        System.out.println(g.gerarCpf(null));

    }


}