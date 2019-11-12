package com.example.applogin;

public class Estructura_BD {

    private Estructura_BD() {
    }

    public static final String TABLE_NAME = "Usuarios";
    public static final String CAMPO_ID = "Id_Usuario";
    public static final String CAMPO_NOMBRE = "Usuario";
    public static final String CAMPO_CONTRASENHA = "Contrasenha";


    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Estructura_BD.TABLE_NAME + " (" +
                    Estructura_BD.CAMPO_ID + " INTEGER PRIMARY KEY," +
                    Estructura_BD.CAMPO_NOMBRE + " TEXT," +
                    Estructura_BD.CAMPO_CONTRASENHA + " TEXT)";

    protected static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Estructura_BD.TABLE_NAME;
}
