package org.geradorPF.GeradorCpf;
import org.geradorPF.EnumRegions.UF;
import org.geradorPF.Excecoes.ValorInvalidoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.Arrays;


public class CPFNumber {

    public static final String CPF_MASK = "###.###.###-##";
    private int cpfNumbers[] = new int[11];
    private int regionalDigit;

    /**
     * construtor gera o número de CPF novo
     */
    public CPFNumber() {
        regionalDigit = generateInteger();
        cpfNumbers[8] = regionalDigit;
        generateNumbers();
    }

    /**
     * construtor gera o número de CPF novo em relação ao estado de origem
     * @param state
     */
    public CPFNumber(UF state) {
        regionalDigit = state.getCPFDigit();
        cpfNumbers[8] = regionalDigit;
        generateNumbers();
    }

    /**
     *
     * @param cpfNumber número de CPF completo sem caracteres especiais
     * @throws ValorInvalidoException se o número colocado é diferente de 11 caracteres
     */
    public CPFNumber(String cpfNumber) throws ValorInvalidoException {
        String[] numbersString = cpfNumber.split("");
        if(numbersString.length != 11){
            throw new ValorInvalidoException("valor inserido é invalido: o número deve ter 11 caracteres");
        }

        cpfNumbers = Arrays.stream(numbersString).mapToInt(Integer::parseInt).toArray();
        regionalDigit = cpfNumbers[8];
    }

    /**
     * gera números para o CPF em armazena em um array
     */
    private void generateNumbers() {
        int vd1NumbersQtd = 10;
        int vd2NumbersQtd = 11;
        int vd1Sum = 0;
        int vd2Sum = 0;
        for (int i = 0; i < 8; i++) {
            cpfNumbers[i] = generateInteger();
            vd1Sum += cpfNumbers[i] * vd1NumbersQtd;
            vd2Sum += cpfNumbers[i] * vd2NumbersQtd;
            vd1NumbersQtd--;
            vd2NumbersQtd--;
        }

        vd1Sum += regionalDigit * vd1NumbersQtd;
        vd2Sum += regionalDigit * vd2NumbersQtd;
        cpfNumbers[9] = calculateVd(vd1Sum);
        vd2Sum += cpfNumbers[9] * 2;
        cpfNumbers[10]  = calculateVd(vd2Sum);
    }

    /**
     * Calcula e retorna se o CPF é valido em um valor boolean
     * compara se os valores em 'expectedValidationNumbers()' são iguais aos 2 últimos que estão no array 'cpfNumbers'
     * @return boolean 'true' se o CPF é valido e 'false' para inválido
     */
    private boolean isValid() {

        int[] expectedValidationNumbers = expectedValidationNumbers();

        if(expectedValidationNumbers[0] == cpfNumbers[9] && expectedValidationNumbers[1] == cpfNumbers[10]){
            return true;
        } else return false;
    }

    /**
     * Calcula e retorna os números validadores do CPF (os 2 últimos números)
     * @return um array int[] com os números dois últimos números esperados
     */
    public int[] expectedValidationNumbers(){

        int vd1NumbersQtd = 10;
        int vd2NumbersQtd = 11;
        int vd1Sum = 0;
        int vd2Sum = 0;
        for (int i = 0; i < 8; i++) {
            vd1Sum += cpfNumbers[i] * vd1NumbersQtd;
            vd2Sum += cpfNumbers[i] * vd2NumbersQtd;
            vd1NumbersQtd--;
            vd2NumbersQtd--;
        }
        vd1Sum += regionalDigit * vd1NumbersQtd;
        vd2Sum += regionalDigit * vd2NumbersQtd;

        vd2Sum += cpfNumbers[9] * 2;

        int expectedVd1 = calculateVd(vd1Sum);
        int expectedVd2  = calculateVd(vd2Sum);

        return new int[]{expectedVd1,expectedVd2};

    }

    /**
     * calcula os números validadores do CPF
     * @param vdSum a soma dos produtos dos números anteriores ao número de validação
     * @return retorna o dígito verificador calculado
     */
    private int calculateVd(int vdSum) {
        int remainder = vdSum % 11;
        int verifyingDigit = 0;
        if (remainder > 1) {
            verifyingDigit = 11 - remainder;
        }
        return verifyingDigit;
    }

    /**
     *
     * @return String com os números do CPF sem mascara.
     */
    @Override
    public String toString() {

        String cpfString = "";
        for (int i = 0; i < cpfNumbers.length; i++) {
            cpfString += cpfNumbers[i];
        }
        return cpfString;
    }

    /**
     *
     * @return String com o CPF em máscara "###.###.###-##"
     */
    public String maskedCpfString() {

        String cpfString = toString();
        try {
            MaskFormatter formatter = new MaskFormatter(CPF_MASK);
            formatter.setValueContainsLiteralCharacters(false);
            return formatter.valueToString(cpfString);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * gera um número inteiro de 0 a 9
     * @return o númeor inteiro em 'int'
     */
    public int generateInteger() {

        int generatedNumber = (int) (Math.random() * 10);

        return generatedNumber;
    }



}
