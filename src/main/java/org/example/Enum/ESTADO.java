package org.example.Enum;

public enum ESTADO {

/*
    Acre (AC)
    Alagoas (AL)
    Amapá (AP)
    Amazonas (AM)
    Bahia (BA)
    Ceará (CE)
    Distrito Federal (DF)
    Espírito Santo (ES)
    Goiás (GO)
    Maranhão (MA)
    Mato Grosso (MT)
    Mato Grosso do Sul (MS)
    Minas Gerais (MG)
    Pará (PA)
    Paraíba (PB)
    Paraná (PR)
    Pernambuco (PE)
    Piauí (PI)
    Rio de Janeiro (RJ)
    Rio Grande do Norte (RN)
    Rio Grande do Sul (RS)
    Rondônia (RO)
    Roraima (RR)
    Santa Catarina (SC)
    São Paulo (SP)
    Sergipe (SE)
    Tocantins (TO)
* */

    AC("Acre",2)
    ,AL("Alagoas",4)
    ,AP("Amapá",2)
    ,AM("Amazonas",2)
    ,BA("Bahia",5)
    ,CE("Ceará",3)
    ,DF("Distrito Federal",1)
    ,ES("Espírito Santo",7)
    ,GO("Goiás",1)
    ,MA("Maranhão",3)
    ,MT("Mato Grosso",1)
    ,MS("Mato Grosso do Sul",1)
    ,MG("Minas Gerais",6)
    ,PA("Pará",2)
    ,PB("Paraíba",4)
    ,PE("Pernambuco",4)
    ,PI("Piauí",3)
    ,PR("Paraná",9)
    ,RJ("Rio de Janeiro",7)
    ,RN("Rio Grande do Norte",4)
    ,RS("Rio Grande do Sul",0)
    ,RO("Rondônia",2)
    ,RR("Roraima",2)
    ,SC("Santa Catarina",9)
    ,SP("São Paulo",8)
    ,SE("Sergipe",5)
    ,TO("Tocantins",1)
    ;

    private String nome;
    private int digitoCpf;
    ESTADO(String nome, int digitoCpf) {
        this.nome = nome;
        this.digitoCpf = digitoCpf;
    }

    public String getNome() {
        return nome;
    }

    public int getDigitoCpf() {
        return digitoCpf;
    }
}
