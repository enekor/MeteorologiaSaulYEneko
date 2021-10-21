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
     *dependiendo de los valores de municipio y magnitud llama a un metodo u otro pasandole por parametro los valores necesarios para que este funcione
     * @param datosAire lista recien hecha y para filtrar de objetos CalidadAire
     * @param datosMeteo lista recien hecha y para filtrar de objetos DatosMeteorologicos
     * @param municipio codigo del municipio a mirar
     * @param magnitud codigo de la magnitud que queremos sacar
     * @return la respuesta de cada metodo, y, en caso de que la lista sea nula ya que en dicho municipio no hay los datos requeridos, un mensaje personalizado
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
     *llama al metodo que filtra pasandole los parametros que se necesitan
     * @param datos lista de DatosMeteorologicos a filtrar
     * @param municipio que queremos filtrar
     * @param magnitud que queremos obtener
     * @return una string en orden media max min
     */
    private String datosMeteorologicos(List<DatosMeteorologicos> datos, String municipio, String magnitud){
        return mh.mediadatosMeteo(f.filtroDatosMeteo(municipio,magnitud,datos));
    }

    /**
     *llama al metodo que filtra pasandole los parametros que se necesitan
     * @param datos lista de CalidadAire a filtrar
     * @param municipio que queremos filtrar
     * @param magnitud que queremos obtener
     * @return una string en orden media max min
     */
    private String datosCalidad(List<CalidadAire> datos,String municipio, String magnitud){
        return mh.mediaCalidadAire(f.filtroCalidadAire(municipio,magnitud,datos));
    }
}
