package csv;

import Mapas.EstacionesMapas;
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
import java.util.StringTokenizer;

@Data
public class DatosMeteorologicosReader implements Runnable{

    List<String> datosMeteorologicosList;
    List<DatosMeteorologicos> datosMeteorologicosObjetosList = new ArrayList<>();
    List<String> estacionesList;

    private void crearListaDatos(){
        String actualPath = System.getProperty("user.dir");
        String pathMeteo = actualPath+ File.separator+"Datos"+File.separator+"calidad_aire_datos_meteo_mes.csv";
        String pathEstaciones =  actualPath+ File.separator+"Datos"+File.separator+"calidad_aire_estaciones.csv";
        System.out.println(pathEstaciones);

        Path csvMeteo = Paths.get(pathMeteo);
        Path csvEstaciones = Path.of(pathEstaciones);

        try{
            datosMeteorologicosList = Files.readAllLines(csvMeteo);
            estacionesList = Files.readAllLines(csvEstaciones,Charset.forName("windows-1252"));
            estacionesList.remove(0);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

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

        EstacionesMapas em = EstacionesMapas.getInstance();

        for(String a : estacionesList){

            StringTokenizer st = new StringTokenizer(a,";");

            String codigo = st.nextToken();
            st.nextElement();
            String nombre = st.nextToken();
            em.fillCodigoNacional(Integer.parseInt(codigo),nombre);
        }
    }

    @Override
    public void run() {
        crearObjetoDatos();
    }
}

