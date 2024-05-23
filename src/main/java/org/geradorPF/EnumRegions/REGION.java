package org.geradorPF.EnumRegions;

public enum REGION {

    CO("Centro-Oeste")
    ,N("Norte")
    ,NE("Nordeste")
    ,S("Sul")
    ,SE("Sudeste")
    ;

    String description;

    REGION(String description) {
        this.description = description;
    }
}
