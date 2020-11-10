package utiles;

import java.util.Date;
import java.util.Scanner;

public class Lectura {

    public static String leerStringM(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        return  sc.nextLine();
    }

    public static int leerIntM(String mensaje){
        int aRetornar;
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        aRetornar = sc.nextInt();
        String residuo = sc.nextLine();
        return  aRetornar;
    }

    public static long leerLongM(String mensaje){
        long aRetornar;
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        aRetornar = sc.nextLong();
        String residuo = sc.nextLine();
        return  aRetornar;
    }

    public static double leerDoubleM(String mensaje){
        double aRetornar;
        Scanner sc = new Scanner(System.in);
        System.out.print(mensaje);
        aRetornar = sc.nextDouble();
        String residuo = sc.nextLine();
        return  aRetornar;
    }
    
    public static String pedirFechaM(String mensaje) {
        int dia;
        int mes;
        int ano;
        System.out.println(mensaje);
        dia = Lectura.leerIntM("dia:");
        mes = Lectura.leerIntM("mes:");
        ano = Lectura.leerIntM("año:");
        Date fecha = Fecha.newDate(dia, mes, ano);
        return Fecha.dateToString(fecha);
    }

    public static Date pedirDateM(String mensaje) {
        int dia;
        int mes;
        int ano;
        System.out.println(mensaje);
        dia = Lectura.leerIntM("dia:");
        mes = Lectura.leerIntM("mes:");
        ano = Lectura.leerIntM("año:");
        Date fecha = Fecha.newDate(dia, mes, ano);
        return fecha;
    }
}
