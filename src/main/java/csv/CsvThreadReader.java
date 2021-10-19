package csv;

import Objetos.CalidadAire;
//import Objetos.CalidadAireEstaciones;
import Objetos.CalidadAireZonas;
import Objetos.DatosMeteorologicos;

import java.util.List;

public class CsvThreadReader {

    ThreadGroup tg = new ThreadGroup("lectoresCSV");
    public List<CalidadAire> calidadList;
    List<DatosMeteorologicos> datosList;
    List<CalidadAireZonas> calidadZonasList;
    //List<CalidadAireEstaciones> aireEstacionesList;

    public void empezar() throws InterruptedException {
        CalidadAireReader car = new CalidadAireReader();
        DatosMeteorologicosReader dmr = new DatosMeteorologicosReader();

        Thread hilo1 = new Thread(tg,car);
        Thread hilo2 = new Thread(tg,dmr);

        hilo1.start();
        hilo2.start();
        hilo1.join();
        hilo2.join();


        calidadList = car.getCalidadAireObjetosList();
        calidadZonasList = car.getCalidadAireZonasObjetosList();
        datosList = dmr.getDatosMeteorologicosObjetosList();
        //aireEstacionesList = dmr.getAireEstacionesObjetosList();

        System.out.println(calidadList.size()+" "+calidadZonasList.size()+" "+datosList.size());
    }
}