import java.awt.*;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (validaData(dia, mes, ano)){
            this.ano = ano;
            this.dia = dia;
            this.mes = mes;
        }
    }

    public boolean validaData(int dia, int mes, int ano){
        if (ano >= 0){
            if (mes >= 1 && mes <= 12){
                if ( ( ano % 4 == 0 && ano % 100 != 0 ) || ( ano % 400 == 0 ) ){
                    if (mes == 2) {
                        if (dia >= 0 && dia <= 29) {
                            return true;
                        } else
                            return false;
                    } else
                    if (dia >= 0 && dia <= 31){
                        return true;
                    } else
                        return false;
                } else {
                    if (mes == 2) {
                        if (dia >= 0 && dia <= 28) {
                            return true;
                        } else
                            return false;
                    } else {
                        if (dia >= 0 && dia <= 31){
                            return true;
                        } else
                            return false;
                    }
                }
            } else return false;
        } else return false;
    }

    public static String escreveData(Data data){
        return "Data: " + data.getDia() + "/" + data.getMes() + "/" + data.getAno();
    }

    public static long sgundosEntreDatas(Date inicio, Date fim){
        long secIn = inicio.getTime();
        long secFim = fim.getTime();
        long dif = (secFim - secIn) / 1000;
        return dif;
    }

    public static List<Date> diasDoMesAno (int mes, int ano){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, mes);
        cal.set(Calendar.YEAR, ano);
        int quantidadeDias = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        List<Date> listaDias = new ArrayList<Date>();
        for (int x = 1; x <= quantidadeDias; x++){
            Calendar calendaraio = Calendar.getInstance();
            calendaraio.set(Calendar.DATE, x);
            calendaraio.set(Calendar.MONTH, mes);
            calendaraio.set(Calendar.YEAR, ano);
            Date hoje = calendaraio.getTime();
            listaDias.add(hoje);
        }
        return listaDias;
    }

    public static int diaDaSemana(Calendar cal) {
        return cal.get(Calendar.DAY_OF_WEEK);
    }
    public static String diaDaSemanaEscrito(Calendar cal){
        return new DateFormatSymbols().getWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
    }

    public static int contSabDom(Calendar cal1, Calendar cal2){
        int contSD = 0;
        while (cal1.get(Calendar.DAY_OF_MONTH) != cal2.get(Calendar.DAY_OF_MONTH) ||
                cal1.get(Calendar.MONTH) != cal2.get(Calendar.MONTH) ||
                cal1.get(Calendar.YEAR) != cal2.get(Calendar.YEAR)){
            if (cal1.get(Calendar.DAY_OF_WEEK) == 7 || cal2.get(Calendar.DAY_OF_WEEK) == 6){
                contSD++;
            }
            cal1.add(Calendar.DATE, 1);
        }
        return contSD;
    }

    public static int contUteis(Calendar cal1, Calendar cal2){
        int contUteis = 0;
        while (cal1.get(Calendar.DAY_OF_MONTH) != cal2.get(Calendar.DAY_OF_MONTH) ||
                cal1.get(Calendar.MONTH) != cal2.get(Calendar.MONTH) ||
                cal1.get(Calendar.YEAR) != cal2.get(Calendar.YEAR)){
            if (cal1.get(Calendar.DAY_OF_WEEK) != 7 && cal2.get(Calendar.DAY_OF_WEEK) != 6){
                contUteis++;
            }
            cal1.add(Calendar.DATE, 1);
        }
        return contUteis;
    }

    public static List<Date> parcelasPagamento(Calendar cal1, int parcelas){
        List<Date> listaPagamentos = new ArrayList<Date>();
        for (int i = 1; i < parcelas; i++){
            cal1.add(Calendar.MONTH, 1);
            while (cal1.get(Calendar.DAY_OF_WEEK) == 7 || cal1.get(Calendar.DAY_OF_WEEK) == 6){
                cal1.add(Calendar.DATE,1);
            }
            Date dt = cal1.getTime();
            listaPagamentos.add(dt);
        }
        return listaPagamentos;
    }



    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", ano=" + ano +
                '}';
    }
}
