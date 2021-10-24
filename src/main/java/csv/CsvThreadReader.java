package csv;

import Objetos.CalidadAire;
//import Objetos.CalidadAireEstaciones;
import Objetos.CalidadAireZonas;
import Objetos.DatosMeteorologicos;
import lombok.Data;

import java.util.List;

@Data
public class CsvThreadReader {

    ThreadGroup tg = new ThreadGroup("lectoresCSV");
    private List<CalidadAire> calidadList;
    private List<DatosMeteorologicos> datosList;
    private List<CalidadAireZonas> calidadZonasList;
    //List<CalidadAireEstaciones> aireEstacionesList;

    public CsvThreadReader(){
        try {
            empezar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * ejecuta ambos hilos para agilizar la lectura de los csv, y, una vez terminados ambos hilos, inicializamos nuestras listas con las listas de objetos
     * generados en cada hilo
     * @throws InterruptedException
     */
    private void empezar() throws InterruptedException {
        CalidadAireReader car = CalidadAireReader.getInstance();
        DatosMeteorologicosReader dmr = DatosMeteorologicosReader.getInstance();

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

       // System.out.println(calidadList.size()+" "+calidadZonasList.size()+" "+datosList.size());
    }
}
