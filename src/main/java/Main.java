<<<<<<< refs/remotes/origin/develop
import Filtro.Filtro;
import csv.CsvThreadReader;
import Filtro.MediasHoras;
=======
import csv.DatosMeteorologicosReader;
>>>>>>> Auto stash before rebase of "origin/develop"

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CsvThreadReader c = new CsvThreadReader();
        c.empezar();
        System.out.println(c.calidadList.size());
        Filtro f = new Filtro();
        MediasHoras m = new MediasHoras();
        System.out.println(m.mediaCalidadAire(f.datosMunicipioCalidadAireMeteo("9","14",c.calidadList)));
    }
}
