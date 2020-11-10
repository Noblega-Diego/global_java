package utiles;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {

    public static Date newDate(int dia,int mes, int ano){
        return new Date(ano - 1900,mes -1, dia);
    }

    public static Date newDate(int mes, int ano){
        return new Date(ano - 1900,mes -1, 1);
    }

    public static int compararDate(Date dateA, Date dateB) {
        return dateA.compareTo(dateB);
    }
    
    public static int compararFechaConDateActual(int dia,int mes, int ano) {
        Date fecha = new Date(ano -1900, mes -1, dia);
        Date actual = new Date();
        return fecha.compareTo(actual);
    }

    public static String dateToString(Date date){
        String format = "dd/MM/y";//como quiero que me muestre la fecha
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static int compararFechaConFechaActual(int ano, int mes) {
        Date fecha = new Date();

        if(ano < ( fecha.getYear() + 1900)){                            //el año es menor al actual
            return -1;                                                  //retorna -1
        }else if(ano == ( fecha.getYear() + 1900)){                     //si el año es el mismo que el actual
            if(mes < fecha.getMonth() + 1)          return -1;          //si el mes es menor al actual retorna -1
            else if(mes == fecha.getMonth() + 1)    return 0;           //en caso de ser igual retorna 0
            else                                    return 1;           //y si no 1
        }else{
            return 1;
        }
    }

    public static int anosTranscurridos(Date fecha, Date fechaSiguiente){
        int year, year2;
        year = fecha.getYear();
        year2= fechaSiguiente.getYear();
        return year2 - year;
    }

}
