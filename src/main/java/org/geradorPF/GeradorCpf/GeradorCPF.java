package org.geradorPF.GeradorCpf;

import org.geradorPF.Enum.ESTADO;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class GeradorCPF {

    public static final String CPF_MASCARA = "###.###.###-##";
    private int cpfValores[] = new int[8];
    private ESTADO estado;
    private int digitoRegional;
    private int dv1;
    private int dv2;
    int somaDV1;
    int somaDV2;

    public String gerarCpf(ESTADO estado) {

        if(estado == null){
            digitoRegional = gerarNumeroAleatorio();
        } else {
            digitoRegional = estado.getDigitoCpf();
        }

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
        cpfString+=digitoRegional;
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
            x--;
            y--;
        }

        somaDV1 += digitoRegional * x;
        somaDV2 += digitoRegional * y;


    }

    private void calcularDv1() {
        int resultado = somaDV1 % 11;
        if (resultado < 2) {
            dv1 = 0;
        } else {
            dv1 = 11 - resultado;
        }
    }

    private void calcularDv2() {
        somaDV2 += dv1 * 2;
        int resultado = somaDV2 % 11;
        if (resultado < 2) {
            dv2 = 0;
        } else {
            dv2 = 11 - resultado;
        }
    }

    private int gerarNumeroAleatorio() {
        final int valorMaximo = 9;
        final int valorMinimo = 0;
        final int range = valorMaximo - valorMinimo + 1;
        int numeroGerado = (int) (Math.random() * range) + valorMinimo;

        return numeroGerado;
    }


}
