
import Filtro.Filtro;
import csv.CsvThreadReader;
import Filtro.MediasHoras;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        CsvThreadReader c = new CsvThreadReader();
        c.empezar();
        System.out.println(c.calidadList.size());
        Filtro f = new Filtro();
        MediasHoras m = new MediasHoras();
        System.out.println(f.filtroCalidadAire("92","10",c.calidadList));
        System.out.println(m.mediaCalidadAire(f.filtroCalidadAire("92","10",c.calidadList)));
    }
}
