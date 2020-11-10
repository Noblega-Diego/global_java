package utiles;

import java.util.Scanner;



public class Utiles {
    public static boolean continuarM(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje +" ingrese la (Y) ó cualquier otra letra para salir \ninresar:");
        String next = sc.nextLine();
        return next.equalsIgnoreCase("y");
    }

    public static String rellenarEspacios(String string, int espaciosTotal) {
        String nuevoString;

        if (string == null || string == "") nuevoString = " ";
        else nuevoString = string;

        if(string.length() < espaciosTotal){
            nuevoString = string;
            for(int i = string.length(); i<espaciosTotal; i++){
                nuevoString += " ";
            }
        }else{
            nuevoString = "";
            for(int i = 0; i<(espaciosTotal-3); i++){
                nuevoString += string.charAt(i);
            }
            nuevoString += "...";
        }
        return nuevoString;
    }

    public static String rellenarEspaciosSimple(String string, int espaciosTotal) {
        String nuevoString;
        if (string == null || string == "") nuevoString = " ";
        else nuevoString = string;

        for(int i = string.length(); i<espaciosTotal; i++){     //inicio con el espacio del array hasta el espacio que tendria que tener
            nuevoString += " ";                                 //añade espacio
        }
        return nuevoString;                                     //retorna string con los espacios
    }

}
