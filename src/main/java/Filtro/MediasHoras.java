package Filtro;

import Objetos.CalidadAire;
import Objetos.DatosMeteorologicos;

import java.util.*;

public class MediasHoras {

    private int sumaMediaDias=0;

    private static MediasHoras mediaHora = null;
    private MediasHoras(){}
    public static MediasHoras getInstance(){
        if(mediaHora==null){
            mediaHora = new MediasHoras();
        }
        return mediaHora;
    }


    /**
     * a partir de la lista filtrada, sacamos los valores de cada hora
     * @param lista de objetos calidad aire filtrado
     * @return una string con el orden media-maximo-minimo mensual
     */
    public List<Object> mediaCalidadAire(List<CalidadAire> lista){
        if(lista.isEmpty()){
            List<Object> returnerList = List.of("no hay datos en este municipio");
            return returnerList;
        }
        List<Double> valores = new ArrayList<>();
        HashSet<String> estaciones = new HashSet<>();
        String returner="";

        lista.forEach(ca ->{
            double sumDia=0;
            int noNulos=0;

            if(ca.getV01().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH01());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH01()));
            }
            if(ca.getV02().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH02());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH02()));
            }
            if(ca.getV03().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH03());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH03()));
            }
            if(ca.getV04().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH04());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH04()));
            }
            if(ca.getV05().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH05());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH05()));
            }
            if(ca.getV06().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH06());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH06()));
            }
            if(ca.getV07().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH07());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH07()));
            }
            if(ca.getV08().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH08());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH08()));
            }
            if(ca.getV09().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH09());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH09()));
            }
            if(ca.getV10().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH10());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH10()));
            }
            if(ca.getV11().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH11());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH11()));
            }
            if(ca.getV12().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH12());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH12()));
            }
            if(ca.getV13().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH13());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH13()));
            }
            if(ca.getV14().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH14());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH14()));
            }
            if(ca.getV15().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH15());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH15()));
            }
            if(ca.getV16().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH16());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH16()));
            }
            if(ca.getV17().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH17());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH17()));
            }
            if(ca.getV18().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH18());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH18()));
            }
            if(ca.getV19().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH19());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH19()));
            }
            if(ca.getV20().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH20());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH20()));
            }
            if(ca.getV21().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH21());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH21()));
            }
            if(ca.getV22().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH22());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH22()));
            }
            if(ca.getV23().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH23());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH23()));
            }
            if(ca.getV24().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH24());
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(ca.getH24()));
            }

            sumaMediaDias+=sumDia/noNulos;

        });

        Optional<Double> max = valores.stream().max(Comparator.comparing(v -> v));
        Optional<Double> min = valores.stream().min(Comparator.comparing(v -> v));

        returner = sumaMediaDias / lista.size() + " " + max.get() + " " + min.get();
        for(String s : estaciones){
            StringTokenizer st = new StringTokenizer(s,"_");
            returner+=" "+st.nextToken()+" ";
        }

        List<Object> returnerLista = List.of(returner,valores);
        return returnerLista;
    }

    /**
     * a partir de la lista filtrada, sacamos los valores de cada hora
     * @param lista de objetos datos meteorologicos filtrado
     * @return una string con el orden media-maximo-minimo mensual
     */
    public List<Object> mediadatosMeteo(List<DatosMeteorologicos> lista){
        if(lista.isEmpty()){
            List<Object> returnerList = List.of("no hay datos en este municipio");
            return returnerList;
        }
        List<Double> valores = new ArrayList<>();
        HashSet<String> estaciones = new HashSet<>();
        String returner="";

        lista.forEach(ca ->{
            double sumDia=0;
            int noNulos=0;

            if(ca.getV01().equalsIgnoreCase("V")) {
                String h =ca.getH01().replace(",",".");
                sumDia += Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV02().equalsIgnoreCase("V")){
                String h =ca.getH02().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV03().equalsIgnoreCase("V")){
                String h =ca.getH03().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV04().equalsIgnoreCase("V")){
                String h =ca.getH04().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV05().equalsIgnoreCase("V")){
                String h =ca.getH05().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV06().equalsIgnoreCase("V")){
                String h =ca.getH06().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV07().equalsIgnoreCase("V")){
                String h =ca.getH07().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV08().equalsIgnoreCase("V")){
                String h =ca.getH08().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV09().equalsIgnoreCase("V")){
                String h =ca.getH09().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV10().equalsIgnoreCase("V")){
                String h =ca.getH10().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV11().equalsIgnoreCase("V")){
                String h =ca.getH11().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV12().equalsIgnoreCase("V")){
                String h =ca.getH12().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV13().equalsIgnoreCase("V")){
                String h =ca.getH13().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV14().equalsIgnoreCase("V")){
                String h =ca.getH14().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV15().equalsIgnoreCase("V")){
                String h =ca.getH15().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV16().equalsIgnoreCase("V")){
                String h =ca.getH16().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV17().equalsIgnoreCase("V")){
                String h =ca.getH17().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV18().equalsIgnoreCase("V")){
                String h =ca.getH18().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV19().equalsIgnoreCase("V")){
                String h =ca.getH19().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV20().equalsIgnoreCase("V")){
                String h =ca.getH20().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV21().equalsIgnoreCase("V")){
                String h =ca.getH21().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV22().equalsIgnoreCase("V")){
                String h =ca.getH22().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV23().equalsIgnoreCase("V")){
                String h =ca.getH23().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV24().equalsIgnoreCase("V")) {
                String h =ca.getH24().replace(",",".");
                sumDia += Double.parseDouble(h);
                noNulos += 1;
                estaciones.add(ca.getPunto_muestreo());
                valores.add(Double.parseDouble(h));
            }
            sumaMediaDias+=sumDia/noNulos;
        });

        Optional<Double> max = valores.stream().max(Comparator.comparing(v -> v));
        Optional<Double> min = valores.stream().min(Comparator.comparing(v -> v));

        returner = sumaMediaDias / lista.size() + " " + max.get() + " " + min.get();
        for(String s : estaciones){
            StringTokenizer st = new StringTokenizer(s,"_");
            returner+=" "+st.nextToken()+" ";
        }
        List<Object> returnerList = List.of(returner,valores);
        return returnerList;
    }
}
