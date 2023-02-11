package org.example;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class GeradorCPF {

    public static final String CPF_MASCARA = "###.###.###-##";
    private int cpfValores[] = new int[9];
    private int dv1;
    private int dv2;
    int somaDV1 = 0;
    int somaDV2 = 0;

    public String gerarCpf() {

        this.gerarNumeros();
        this.calcularDv1();
        this.calcularDv2();

        return this.cpfToStringBeaty();


    }

    private String cpfToString() {

        String cpfString = "";
        for (int i = 0; i < cpfValores.length; i++){
            cpfString += cpfValores[i];
        }
        cpfString+=dv1;
        cpfString+=dv2;
        return cpfString;
    }

    public String cpfToStringBeaty() {

        String cpfString = cpfToString();
        try {
            MaskFormatter formatter = new MaskFormatter(CPF_MASCARA);
            formatter.setValueContainsLiteralCharacters(false);
            return formatter.valueToString(cpfString);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    private void gerarNumeros() {
        int x = 10;
        int y = 11;

        //Gerar numeros
        for (int i = 0; i < cpfValores.length; i++){
            cpfValores[i] = gerarNumeroAleatorio();

            somaDV1 += cpfValores[i] * x;
            somaDV2 += cpfValores[i] * y;

            System.out.println("numero gerado: " + cpfValores[i]);
            System.out.println("fator de multiplicaçao: " + x);
            System.out.println("fator de multiplicaçao2: " + y);
            System.out.println("Soma: " + somaDV1);
            System.out.println("Soma: " + somaDV2);

            x--;
            y--;
        }

    }

    private void calcularDv1() {
        int resultado = somaDV1 % 11;
        System.out.println("SOMA % 11 = " + resultado);

        if (resultado < 2) {
            dv1 = 0;
        } else {
            dv1 = 11 - resultado;
        }
        System.out.println("DV1 = " + dv1);
    }

    private void calcularDv2() {
        somaDV2 += dv1 * 2;
        int resultado = somaDV2 % 11;
        System.out.println("SOMA % 11 = " + resultado);
        if (resultado < 2) {
            dv2 = 0;
        } else {
            dv2 = 11 - resultado;
        }
        System.out.println("DV2 = " + dv2);
    }

    private int gerarNumeroAleatorio() {
        final int valorMaximo = 9;
        final int valorMinimo = 1;
        final int range = valorMaximo - valorMinimo + 1;
        int numeroGerado = (int) (Math.random() * range) + valorMinimo;

        return numeroGerado;
    }


}
