package csv;

import Objetos.*;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.ISO_8859_1;

public class CsvReader {

    List<String> calidadAireList;
    List<String> datosMeteorologicosList;
    List<String> calidadAireEstacionesList;
    List<String> calidadAireZonasList;

    static List<CalidadAire> calidadAireObjetosList = new ArrayList<>();
    static List<DatosMeteorologicos> datosMeteorologicosObjetosList = new ArrayList<>();
    List<CalidadAireEstaciones> calidadAireEstacionesObjetosList = new ArrayList<>();
    List<CalidadAireZonas> calidadAireZonasObjetosList = new ArrayList<>();

    private void crearListas(){
        String actualPath = System.getProperty("user.dir");
        String pathAire = actualPath+File.separator+"MeteorologiaSaulYEneko"+File.separator+"Datos"+File.separator+"calidad_aire_datos_mes.csv";
        String pathMeteo = actualPath+ File.separator+"MeteorologiaSaulYEneko"+File.separator+"Datos"+File.separator+"calidad_aire_datos_meteo_mes.csv";
        String pathEstaciones = actualPath+ File.separator+"MeteorologiaSaulYEneko"+File.separator+"Datos"+File.separator+"calidad_aire_estaciones.csv";
        String pathZonas = actualPath+ File.separator+"MeteorologiaSaulYEneko"+File.separator+"Datos"+File.separator+"calidad_aire_zonas.csv";

        Path csvAire = Paths.get(pathAire);
        Path csvMeteo = Paths.get(pathMeteo);
        Path csvEstaciones = Paths.get(pathEstaciones);
        Path csvZonas = Paths.get(pathZonas);

        try {
            calidadAireList = Files.readAllLines(csvAire);
            datosMeteorologicosList = Files.readAllLines(csvMeteo);
            calidadAireEstacionesList = Files.readAllLines(csvEstaciones, Charset.forName("Cp1252"));
            calidadAireZonasList = Files.readAllLines(csvZonas, Charset.forName("Cp1252"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //datosMeteorologicosList.forEach(System.out::println);


    }

    private void crearObjetos1(){
        /*
            Start filling calidadAireObjetosList with values from csv
        */
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
        System.out.println("datos de calidad de aire aniadidos: "+calidadAireObjetosList.size());

        /*
            start filling datosMeteorologicosObjetosList with values from csv
        */
        for(String a : datosMeteorologicosList){

            Scanner sc=new Scanner(a);
            sc.useDelimiter(";");
            while(sc.hasNext()){
                datosMeteorologicosObjetosList.add(DatosMeteorologicos.builder().provincia(sc.next()).municipio(sc.next()).
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

        }System.out.println("datos meteorologicos aniadidos: "+datosMeteorologicosObjetosList.size());
    }

    private void crearObjetos2(){
        /*
            Start filling calidadAireEstacionesList with values from csv
        */
        /*
        for(String a : calidadAireEstacionesList){

                Scanner sc = new Scanner(a);
                sc.useDelimiter(";");
                while(sc.hasNext()){
                    calidadAireEstacionesObjetosList.add(CalidadAireEstaciones.builder().estacion_codigo(sc.next()).zona_calidad_aire_descripcion(sc.next()).estacion_municipio(sc.next()).
                            estacion_fecha_alta(sc.next()).estacion_tipo_area(sc.next()).estacion_tipo_estacion(sc.next()).estacion_subarea_rural(sc.next()).estacion_direccion_postal(sc.next()).
                            estacion_coord_UTM_ETRS89_x(sc.next()).estacion_coord_UTM_ETRS89_y(sc.next()).estacion_coord_longitud(sc.next()).
                            estacion_coord_latitud(sc.next()).estacion_altitud(sc.next()).estacion_analizador_NO(sc.next()).estacion_analizador_NO2(sc.next()).
                            estacion_analizador_PM10(sc.next()).estacion_analizador_PM2_5(sc.next()).estacion_analizador_O3(sc.next()).estacion_analizador_TOL(sc.next()).
                            estacion_analizador_BEN(sc.next()).estacion_analizador_XIL(sc.next()).estacion_analizador_CO(sc.next()).estacion_analizador_SO2(sc.next()).
                            estacion_analizador_HCT(sc.next()).estacion_analizador_HNM(sc.next()).build());
                }
            }System.out.println("datos de calidad de aire en estaciones: "+calidadAireEstacionesObjetosList.size());
*/
        /*
            start filling calidadAireZonasList with values from csv
        */
        for(String a : calidadAireZonasList){

            Scanner sc=new Scanner(a);
            sc.useDelimiter(";");
            while(sc.hasNext()){
                calidadAireZonasObjetosList.add(CalidadAireZonas.builder().zona_calidad_aire_codigo(sc.next()).zona_calidad_aire_descripcion(sc.next()).
                        zona_calidad_aire_municipio(sc.next()).build());
            }

        }System.out.println("datos de zonas: "+calidadAireZonasList.size());
    }

    /**
     * Metodo que printea la lista de los datos de Datos Meteorologicos pasando un municipio por parametro, llama al metodo datosMunicipioCalidadAireMeteo
     * @param municipio
     */
    /*
    public static void datosPorMunicipioCalidadAireMeteo(String municipio) {
        System.out.println("Datos de la ciudad: " +municipio);
        List<DatosMeteorologicos> datos = datosMunicipioCalidadAireMeteo(municipio, );

        datos.stream().forEach(System.out::println);

    }
    */


    public static void main(String[] args) {
        CsvReader c = new CsvReader();
        c.crearListas();
        c.crearObjetos1();
        c.crearObjetos2();


    }

}
