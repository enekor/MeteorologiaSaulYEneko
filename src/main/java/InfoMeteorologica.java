import Filtro.Filtro;
import Filtro.MediasHoras;
import Objetos.CalidadAire;
import Objetos.DatosMeteorologicos;
import extras.MagnitudMap;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class InfoMeteorologica {
    MediasHoras mh = new MediasHoras();
    Filtro f = new Filtro();

    /**
     *
     * @param datosAire
     * @param datosMeteo
     * @param municipio
     * @param magnitud
     * @return
     */
    public String proveedorDeDatos(List<CalidadAire> datosAire, List<DatosMeteorologicos> datosMeteo,String municipio, String magnitud){
        String returner="";
        MagnitudMap magnitudes = new MagnitudMap();

        if(Integer.parseInt(magnitud)<81 || Integer.parseInt(magnitud)==431){
            String returnDatos=datosCalidad(datosAire,municipio,magnitud);
            if(returnDatos.equalsIgnoreCase("no hay datos en este municipio")){
                return returnDatos+" sobre "+magnitudes.getMapa().get(Integer.parseInt(magnitud));
            }

            StringTokenizer st = new StringTokenizer(returnDatos);

            returner+=magnitudes.getMapa().get(Integer.parseInt(magnitud))+": \n"+
                    "-Media mensual: "+st.nextToken()+"\n"+
                    "-Maximo del mes: "+st.nextToken()+"\n"+
                    "-Minimo del mes: "+st.nextToken();
        }
        else if(Integer.parseInt(magnitud)>=81 && Integer.parseInt(magnitud)!=431){
            String returnDatos = datosMeteorologicos(datosMeteo,municipio,magnitud);
            if(returnDatos.equalsIgnoreCase("no hay datos en este municipio")){
                return returnDatos+" sobre "+magnitudes.getMapa().get(Integer.parseInt(magnitud));
            }

            StringTokenizer st = new StringTokenizer(returnDatos);
            returner+=magnitudes.getMapa().get(Integer.parseInt(magnitud))+": \n"+
                    "-Media mensual: "+st.nextToken()+"\n"+
                    "-Maximo del mes: "+st.nextToken()+"\n"+
                    "-Minimo del mes: "+st.nextToken();
        }
        return returner;
    }

    /**
     *
     * @param datos
     * @param municipio
     * @param magnitud
     * @return
     */
    private String datosMeteorologicos(List<DatosMeteorologicos> datos, String municipio, String magnitud){
        return mh.mediadatosMeteo(f.filtroDatosMeteo(municipio,magnitud,datos));
    }

    /**
     *
     * @param datos
     * @param municipio
     * @param magnitud
     * @return
     */
    private String datosCalidad(List<CalidadAire> datos,String municipio, String magnitud){
        return mh.mediaCalidadAire(f.filtroCalidadAire(municipio,magnitud,datos));
    }
}
