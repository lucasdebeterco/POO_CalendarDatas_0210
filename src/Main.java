import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Exemplos Slide

        // Crie um método que receba o mês e o ano e retorne uma lista com todos os dias do mês e ano informados.
        List<Date> lista = Data.diasDoMesAno(1,2000);
        //System.out.println(lista);


        //Crie um método que receba duas datas e calcule os segundos de diferença entre estas elas
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,20);
        cal.set(Calendar.MONTH,4);
        cal.set(Calendar.YEAR,1978);

        Date dt = cal.getTime();
        Date hj = new Date();

        long segundos = Data.sgundosEntreDatas(dt,hj);
        //System.out.println(segundos);

        // -------------------

        // Exercícios Slide

        // EX1
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.DAY_OF_MONTH,14);
        calendario.set(Calendar.MONTH,12);
        calendario.set(Calendar.YEAR,2000);

        Calendar calendario2 = Calendar.getInstance();
        calendario2.set(Calendar.DAY_OF_MONTH,30);
        calendario2.set(Calendar.MONTH,12);
        calendario2.set(Calendar.YEAR,2000);

        System.out.println("Exercício 1: " + Data.contSabDom(calendario,calendario2));

        // EX2
        Calendar calendario3 = Calendar.getInstance();
        calendario3.set(Calendar.DAY_OF_MONTH,14);
        calendario3.set(Calendar.MONTH,12);
        calendario3.set(Calendar.YEAR,2000);

        Calendar calendario4 = Calendar.getInstance();
        calendario4.set(Calendar.DAY_OF_MONTH,30);
        calendario4.set(Calendar.MONTH,12);
        calendario4.set(Calendar.YEAR,2000);

        System.out.println("Exercício 2: " + Data.contUteis(calendario3,calendario4));

        // EX3
        Calendar calendario5 = Calendar.getInstance();
        calendario5.set(Calendar.DAY_OF_MONTH,02);
        calendario5.set(Calendar.MONTH,10);
        calendario5.set(Calendar.YEAR,2019);

        System.out.println("Exercício 3: " + Data.parcelasPagamento(calendario5,12));

        //EX4
        System.out.println("Exercício 4: " + Data.diaDaSemanaEscrito(calendario3));

    }
}
