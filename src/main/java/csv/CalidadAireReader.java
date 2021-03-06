package csv;

import Objetos.*;
import lombok.Data;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Data
public class CalidadAireReader implements Runnable {

    List<String> calidadAireList;
    List<String> calidadAireZonasList;

    List<CalidadAire> calidadAireObjetosList = new ArrayList<>();
    List<CalidadAireZonas> calidadAireZonasObjetosList = new ArrayList<>();

    private static CalidadAireReader car = null;
    private CalidadAireReader(){}
    public static CalidadAireReader getInstance(){
        if(car==null){
            car=new CalidadAireReader();
        }
        return car;
    }

    /**
     * creacion de las listas de String donde almacenaremos las lineas del csv correspondiente
     */
    private void crearListaCalidadAire(){
        String actualPath = System.getProperty("user.dir");
        String pathAire = actualPath+ File.separator+"Datos"+File.separator+"calidad_aire_datos_mes.csv";
        String pathZonas = actualPath+ File.separator+"Datos"+File.separator+"calidad_aire_zonas.csv";

        Path csvAire = Paths.get(pathAire);
        Path csvZonas = Paths.get(pathZonas);


        try {
            calidadAireList = Files.readAllLines(csvAire);
            calidadAireZonasList = Files.readAllLines(csvZonas, Charset.forName("windows-1252"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //datosMeteorologicosList.forEach(System.out::println);

    }

    /**
     * creamos los objetos correspondientes a la medicion, a partir de las listas de string del csv
     */
    private void crearObjetosAire(){

        crearListaCalidadAire();

        for(String a : calidadAireList){

            Scanner sc=new Scanner(a);
            sc.useDelimiter(";");
            while(sc.hasNext()){
                calidadAireObjetosList.add(CalidadAire.builder().provincia(sc.next()).municipio(sc.next()).
                        estacion(sc.next()).magnitud(sc.next()).punto_muestreo(sc.next()).ano(sc.next()).mes(sc.next()).
                        dia(sc.next()).h01(sc.next()).v01(sc.next()).h02(sc.next()).v02(sc.next()).h03(sc.next()).
                        v03(sc.next()).h04(sc.next()).v04(sc.next()).h05(sc.next()).v05(sc.next()).h06(sc.next()).
                        v06(sc.next()).h07(sc.next()).v07(sc.next()).h08(sc.next()).v08(sc.next()).h09(sc.next()).
                        v09(sc.next()).h10(sc.next()).v10(sc.next()).h11(sc.next()).v11(sc.next()).h12(sc.next()).
                        v12(sc.next()).h13(sc.next()).v13(sc.next()).h14(sc.next()).v14(sc.next()).h15(sc.next()).
                        v15(sc.next()).h16(sc.next()).v16(sc.next()).h17(sc.next()).v17(sc.next()).h18(sc.next()).
                        v18(sc.next()).h19(sc.next()).v19(sc.next()).h20(sc.next()).v20(sc.next()).h21(sc.next()).
                        v21(sc.next()).h22(sc.next()).v22(sc.next()).h23(sc.next()).v23(sc.next()).h24(sc.next()).
                        v24(sc.next()).build());
            }
        }

        for(String a : calidadAireZonasList){

            Scanner sc=new Scanner(a);
            sc.useDelimiter(";");
            while(sc.hasNext()){
                calidadAireZonasObjetosList.add(CalidadAireZonas.builder().zona_calidad_aire_codigo(sc.next()).zona_calidad_aire_descripcion(sc.next()).
                        zona_calidad_aire_municipio(sc.next()).build());
            }
        }
    }


    @Override
    public void run() {
        crearObjetosAire();
    }
}
