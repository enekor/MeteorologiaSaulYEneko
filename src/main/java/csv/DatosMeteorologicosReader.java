package csv;

import Objetos.CalidadAireEstaciones;
import Objetos.DatosMeteorologicos;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
public class DatosMeteorologicosReader implements Runnable{

    List<String> datosMeteorologicosList;
    List<String> aireEstacionesList;
    List<DatosMeteorologicos> datosMeteorologicosObjetosList = new ArrayList<>();
    List<CalidadAireEstaciones> aireEstacionesObjetosList = new ArrayList<>();

    /**
     * Metodo que crea las listas de los ficheros calidad_aire_datos_meteo_mes y calidad_aire_estaciones
     */
    private void crearListaDatos(){
        String actualPath = System.getProperty("user.dir");
        String pathMeteo = actualPath+ File.separator+"Datos"+File.separator+"calidad_aire_datos_meteo_mes.csv";
        String pathEstaciones = actualPath+ File.separator+"MeteorologiaSaulYEneko"+File.separator+"Datos"+File.separator+"calidad_aire_estaciones.csv";

        Path csvMeteo = Paths.get(pathMeteo);
        Path csvEstaciones = Path.of(pathEstaciones);

        try{
            datosMeteorologicosList = Files.readAllLines(csvMeteo);
            //aireEstacionesList = Files.readAllLines(csvEstaciones, Charset.forName("windows-1252"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que crea los objetos a partir de las listas del metodo anterior crearListasDatos
     */
    private void crearObjetoDatos(){

        crearListaDatos();

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

        }

        /*
        for(String a : aireEstacionesList){
            Scanner sc = new Scanner(a);
            sc.useDelimiter(";");
            while(sc.hasNext()){
                aireEstacionesObjetosList.add(CalidadAireEstaciones.builder().estacion_codigo(sc.next()).zona_calidad_aire_descripcion(sc.next()).estacion_municipio(sc.next()).
                        estacion_fecha_alta(sc.next()).estacion_tipo_area(sc.next()).estacion_tipo_estacion(sc.next()).estacion_subarea_rural(sc.next()).estacion_direccion_postal(sc.next()).
                        estacion_coord_UTM_ETRS89_x(sc.next()).estacion_coord_UTM_ETRS89_y(sc.next()).estacion_coord_longitud(sc.next()).
                        estacion_coord_latitud(sc.next()).estacion_altitud(sc.next()).estacion_analizador_NO(sc.next()).estacion_analizador_NO2(sc.next()).
                        estacion_analizador_PM10(sc.next()).estacion_analizador_PM2_5(sc.next()).estacion_analizador_O3(sc.next()).estacion_analizador_TOL(sc.next()).
                        estacion_analizador_BEN(sc.next()).estacion_analizador_XIL(sc.next()).estacion_analizador_CO(sc.next()).estacion_analizador_SO2(sc.next()).
                        estacion_analizador_HCT(sc.next()).estacion_analizador_HNM(sc.next()).build());
            }
        }*/
    }

    @Override
    public void run() {
        crearObjetoDatos();
    }
}

