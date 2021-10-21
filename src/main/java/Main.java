import Filtro.Filtro;
import csv.CsvThreadReader;
import Filtro.MediasHoras;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CsvThreadReader ctr = new CsvThreadReader();
        InfoMeteorologica im = new InfoMeteorologica();

        System.out.println(im.proveedorDeDatos(ctr.getCalidadList(),ctr.getDatosList(),"4458","83"));
    }
}
