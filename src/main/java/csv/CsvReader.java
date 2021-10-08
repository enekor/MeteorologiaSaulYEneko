package csv;

import Objetos.CalidadAire;
import Objetos.DatosMeteorologicos;
import lombok.NonNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class CsvReader {

    List<String> calidadAireList;
    List<String> datosMeteorologicosList;
    List<CalidadAire> calidadAireObjetosList = new ArrayList<>();
    List<DatosMeteorologicos> datosMeteorologicosObjetosList = new ArrayList<>();

    private void crearLista(){
        String actualPath = System.getProperty("user.dir");
        String pathAire = actualPath+ File.separator+"Datos"+File.separator+"Calidad_aire_datos_mes.csv";
        String pathMeteo = actualPath+ File.separator+"Datos"+File.separator+"calidad_aire_datos_meteo_mes.csv";
        Path csvAire = Paths.get(pathAire);
        Path csvMeteo = Paths.get(pathMeteo);

        try {
            calidadAireList = Files.readAllLines(csvAire);
            datosMeteorologicosList = Files.readAllLines(csvMeteo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //datosMeteorologicosList.forEach(System.out::println);

    }

    private void crearObjetos(){
        /*
            Start filling calidadAireObjetosList with values from csv
        */
        for(int i=0;i<calidadAireList.size();i++) {
            StringTokenizer st = new StringTokenizer(calidadAireList.get(i), ";");
            System.out.println(st.countTokens());
            while (st.hasMoreTokens()) {
               calidadAireObjetosList.add(CalidadAire.builder().provincia(st.nextToken()).municipio(st.nextToken()).
                        estacion(st.nextToken()).magnitud(st.nextToken()).punto_muestreo(st.nextToken()).ano(st.nextToken()).mes(st.nextToken()).
                        dia(st.nextToken()).h01(st.nextToken()).v01(st.nextToken()).h02(st.nextToken()).v02(st.nextToken()).h03(st.nextToken()).
                        v03(st.nextToken()).h04(st.nextToken()).v04(st.nextToken()).h05(st.nextToken()).v05(st.nextToken()).h06(st.nextToken()).
                        v06(st.nextToken()).h07(st.nextToken()).v07(st.nextToken()).h08(st.nextToken()).v08(st.nextToken()).h09(st.nextToken()).
                        v09(st.nextToken()).h10(st.nextToken()).v10(st.nextToken()).h11(st.nextToken()).v11(st.nextToken()).h12(st.nextToken()).
                        v12(st.nextToken()).h13(st.nextToken()).v13(st.nextToken()).h14(st.nextToken()).v14(st.nextToken()).h15(st.nextToken()).
                        v15(st.nextToken()).h16(st.nextToken()).v16(st.nextToken()).h17(st.nextToken()).v17(st.nextToken()).h18(st.nextToken()).
                        v18(st.nextToken()).h19(st.nextToken()).v19(st.nextToken()).h20(st.nextToken()).v20(st.nextToken()).h21(st.nextToken()).
                        v21(st.nextToken()).h22(st.nextToken()).v22(st.nextToken()).h23(st.nextToken()).v23(st.nextToken()).h24(st.nextToken()).
                        v24(st.nextToken()).build());
            }
            System.out.println(calidadAireObjetosList.size());
        }


        /*
            start filling datosMeteorologicosObjetosList with values from csv
         */
        for(int i=0;i<datosMeteorologicosList.size();i++) {
            StringTokenizer st = new StringTokenizer(calidadAireList.get(i), ";");
            System.out.println(st.countTokens());
            while (st.hasMoreTokens()) {
                datosMeteorologicosObjetosList.add(DatosMeteorologicos.builder().provincia(st.nextToken()).municipio(st.nextToken()).
                        estacion(st.nextToken()).magnitud(st.nextToken()).punto_muestreo(st.nextToken()).ano(st.nextToken()).mes(st.nextToken()).
                        dia(st.nextToken()).h01(st.nextToken()).v01(st.nextToken()).h02(st.nextToken()).v02(st.nextToken()).h03(st.nextToken()).
                        v03(st.nextToken()).h04(st.nextToken()).v04(st.nextToken()).h05(st.nextToken()).v05(st.nextToken()).h06(st.nextToken()).
                        v06(st.nextToken()).h07(st.nextToken()).v07(st.nextToken()).h08(st.nextToken()).v08(st.nextToken()).h09(st.nextToken()).
                        v09(st.nextToken()).h10(st.nextToken()).v10(st.nextToken()).h11(st.nextToken()).v11(st.nextToken()).h12(st.nextToken()).
                        v12(st.nextToken()).h13(st.nextToken()).v13(st.nextToken()).h14(st.nextToken()).v14(st.nextToken()).h15(st.nextToken()).
                        v15(st.nextToken()).h16(st.nextToken()).v16(st.nextToken()).h17(st.nextToken()).v17(st.nextToken()).h18(st.nextToken()).
                        v18(st.nextToken()).h19(st.nextToken()).v19(st.nextToken()).h20(st.nextToken()).v20(st.nextToken()).h21(st.nextToken()).
                        v21(st.nextToken()).h22(st.nextToken()).v22(st.nextToken()).h23(st.nextToken()).v23(st.nextToken()).h24(st.nextToken()).
                        v24(st.nextToken()).build());
            }
            System.out.println(calidadAireObjetosList.size());
        }
    }

    public static void main(String[] args) {
        CsvReader c = new CsvReader();
        c.crearLista();
        c.crearObjetos();
    }

}
