package Filtro;

import Mapas.EstacionesMapas;
import Mapas.UdMedidaMapa;
import Objetos.CalidadAire;
import Objetos.DatosMeteorologicos;
import Mapas.MagnitudMap;
import java.util.List;
import java.util.StringTokenizer;

public class InfoMeteorologica {

    private List<Double> valores = null;
    public List<Double> getValores(){return valores;}
    private String nombre = null;
    public String getNombre(){return nombre;}

    MediasHoras mh = MediasHoras.getInstance();
    Filtro f = new Filtro();
    EstacionesMapas mapas = EstacionesMapas.getInstance();
    UdMedidaMapa unidades = UdMedidaMapa.getInstance();

    private InfoMeteorologica(){}
    private static InfoMeteorologica info = null;

    public static InfoMeteorologica getInstance() {
        if(info==null){
            info = new InfoMeteorologica();
        }
        return info;
    }

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
        MagnitudMap magnitudes = MagnitudMap.getInstance();

        if(Integer.parseInt(magnitud)<81 || Integer.parseInt(magnitud)==431){
            List<Object> returnDatos=datosCalidad(datosAire,municipio,magnitud);
            if(returnDatos.get(0).equals("no hay datos en este municipio")){
                return returnDatos.get((0))+" sobre "+magnitudes.getMapa().get(Integer.parseInt(magnitud));
            }

            valores = (List<Double>) returnDatos.get(1);
            StringTokenizer st = new StringTokenizer((String)returnDatos.get(0));

            nombre = magnitudes.getMapa().get(Integer.parseInt(magnitud));
            returner+=nombre+": \n"+
                    "-Media mensual: "+st.nextToken()+" "+unidades.getUdMedida().get(Integer.parseInt(magnitud))+"\n"+
                    "-Maximo del mes: "+st.nextToken()+" "+unidades.getUdMedida().get(Integer.parseInt(magnitud))+"\n"+
                    "-Minimo del mes: "+st.nextToken()+" "+unidades.getUdMedida().get(Integer.parseInt(magnitud))+"\n"+
                    "Estacion/es usadas: ";

            while(st.hasMoreTokens()){
                String estacion = mapas.getCodigoNacional().get(Integer.parseInt(st.nextToken()));
                returner+=estacion+"\n";
            }
        }
        else if(Integer.parseInt(magnitud)>=81 && Integer.parseInt(magnitud)!=431){
            List<Object> returnDatos = datosMeteorologicos(datosMeteo,municipio,magnitud);
            if(returnDatos.get(0).equals("no hay datos en este municipio")){
                return returnDatos.get(0)+" sobre "+magnitudes.getMapa().get(Integer.parseInt(magnitud));
            }

            valores = (List<Double>) returnDatos.get(1);
            StringTokenizer st = new StringTokenizer((String)returnDatos.get(0));
            returner+=magnitudes.getMapa().get(Integer.parseInt(magnitud))+": \n"+
                    "-Media mensual: "+st.nextToken()+" "+unidades.getUdMedida().get(Integer.parseInt(magnitud))+"\n"+
                    "-Maximo del mes: "+st.nextToken()+" "+unidades.getUdMedida().get(Integer.parseInt(magnitud))+"\n"+
                    "-Minimo del mes: "+st.nextToken()+" "+unidades.getUdMedida().get(Integer.parseInt(magnitud))+"\n"+
                    "Estacion/es usadas: ";

            while(st.hasMoreTokens()){
                String estacion = mapas.getCodigoNacional().get(Integer.parseInt(st.nextToken()));
                returner+=estacion+"\n";
            }
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
    private List<Object> datosMeteorologicos(List<DatosMeteorologicos> datos, String municipio, String magnitud){
        return mh.mediadatosMeteo(f.filtroDatosMeteo(municipio,magnitud,datos));
    }

    /**
     *llama al metodo que filtra pasandole los parametros que se necesitan
     * @param datos lista de CalidadAire a filtrar
     * @param municipio que queremos filtrar
     * @param magnitud que queremos obtener
     * @return una string en orden media max min
     */
    private List<Object> datosCalidad(List<CalidadAire> datos,String municipio, String magnitud){
        return mh.mediaCalidadAire(f.filtroCalidadAire(municipio,magnitud,datos));
    }
}
