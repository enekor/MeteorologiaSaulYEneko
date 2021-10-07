package csv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class CsvReader {

    List<String> calidadAireList;
    List<Objetos.calidadAire> objetos;

    private void crearLista(){
        String actualPath = System.getProperty("user.dir");
        String pathCSV = actualPath+ File.separator+"Datos"+File.separator+"Calidad_aire_datos_mes.csv";
        Path pathcsvaire = Paths.get(pathCSV);

        try {
            calidadAireList = Files.readAllLines(pathcsvaire);
        } catch (IOException e) {
            e.printStackTrace();
        }

       // calidadAire.forEach(System.out::println);

    }

    private void crearObjetos(){
        for(int i=0;i<calidadAireList.size();i++){
            StringTokenizer st=new StringTokenizer(calidadAireList.get(i));
            while(st.hasMoreTokens()){
            //Objetos.calidadAire c = new Objetos.calidadAire().setProvincia(st.nextToken());

            }
        }
    }

    public static void main(String[] args) {
        CsvReader c = new CsvReader();
        c.crearLista();
    }

}
