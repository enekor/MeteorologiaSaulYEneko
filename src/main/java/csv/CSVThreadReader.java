package csv;

import Objetos.CalidadAire;
import Objetos.DatosMeteorologicos;

import java.util.List;

public class CSVThreadReader {

    static ThreadGroup tg = new ThreadGroup("lectoresCSV");
    static List<CalidadAire> calidadList;
    static List<DatosMeteorologicos> datosList;

    private static void empezar(){
        CalidadAireReader car = new CalidadAireReader();
        DatosMeteorologicosReader dmr = new DatosMeteorologicosReader();

        Thread hilo1 = new Thread(tg, car);
        Thread hilo2 = new Thread(tg, dmr);
        hilo1.start();
        hilo2.start();

        calidadList = car.getCalidadAireObjetosList();
        datosList = dmr.getDatosMeteorologicosObjetosList();

        calidadList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        empezar();
    }
}
