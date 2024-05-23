package org.geradorPF.EnumRegions;

public enum UF {

    AC("Acre",2, REGION.N,new int[] {68})
    ,AL("Alagoas",4, REGION.NE, new int[] {82})
    ,AP("Amapá",2, REGION.N, new int[] {96})
    ,AM("Amazonas",2, REGION.N, new int[] {92,97})
    ,BA("Bahia",5, REGION.NE, new int[] {71,73,74,75,77})
    ,CE("Ceará",3, REGION.NE, new int[] {85,88})
    ,DF("Distrito Federal",1, REGION.CO, new int[] {61})
    ,ES("Espírito Santo",7, REGION.SE, new int[] {27,28})
    ,GO("Goiás",1, REGION.CO, new int[] {62,64})
    ,MA("Maranhão",3, REGION.N, new int[] {98,99})
    ,MT("Mato Grosso",1, REGION.CO, new int[] {65,66})
    ,MS("Mato Grosso do Sul",1, REGION.CO, new int[] {67})
    ,MG("Minas Gerais",6, REGION.SE, new int[] {31,32,33,34,35,37,38})
    ,PA("Pará",2, REGION.N, new int[] {91,93,94})
    ,PB("Paraíba",4, REGION.NE, new int[] {83})
    ,PE("Pernambuco",4, REGION.NE, new int[] {81,87})
    ,PI("Piauí",3, REGION.NE, new int[] {86,89})
    ,PR("Paraná",9, REGION.S, new int[] {41,42,43,44,45,46})
    ,RJ("Rio de Janeiro",7, REGION.SE, new int[] {21,22,24})
    ,RN("Rio Grande do Norte",4, REGION.NE, new int[] {84})
    ,RS("Rio Grande do Sul",0, REGION.S, new int[] {51,53,54,55})
    ,RO("Rondônia",2, REGION.N, new int[] {69})
    ,RR("Roraima",2, REGION.N, new int[] {95})
    ,SC("Santa Catarina",9, REGION.S, new int[] {47,48,49})
    ,SP("São Paulo",8, REGION.SE, new int[] {11,12,13,14,15,16,17,18,19})
    ,SE("Sergipe",5, REGION.NE, new int[] {79})
    ,TO("Tocantins",1, REGION.N, new int[] {63})
    ;

    private String regionName;
    private int CPFDigit;
    private int[] ddds;
    private REGION regiao;

    UF(String regionName, int CPFDigit, REGION regiao, int[] ddds) {
        this.regionName = regionName;
        this.CPFDigit = CPFDigit;
        this.ddds = ddds;
        this.regiao = regiao;
    }

    public String getRegionName() {
        return regionName;
    }

    public int getCPFDigit() {
        return CPFDigit;
    }

    public int[] getDdds() {
        return ddds;
    }

    public REGION getRegiao() {
        return regiao;
    }

}
