package Filtro;

import Objetos.CalidadAire;
import Objetos.DatosMeteorologicos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MediasHoras {

    private int sumaMediaDias=0;

    /**
     * a partir de la lista filtrada, sacamos los valores de cada hora
     * @param lista de objetos calidad aire filtrado
     * @return una string con el orden media-maximo-minimo mensual
     */
    public String mediaCalidadAire(List<CalidadAire> lista){
        List<Double> valores = new ArrayList<>();

        lista.forEach(ca ->{
            double sumDia=0;
            int noNulos=0;

            if(ca.getV01().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH01());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH01()));
            }
            if(ca.getV02().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH02());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH02()));
            }
            if(ca.getV03().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH03());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH03()));
            }
            if(ca.getV04().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH04());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH04()));
            }
            if(ca.getV05().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH05());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH05()));
            }
            if(ca.getV06().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH06());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH06()));
            }
            if(ca.getV07().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH07());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH07()));
            }
            if(ca.getV08().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH08());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH08()));
            }
            if(ca.getV09().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH09());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH09()));
            }
            if(ca.getV10().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH10());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH10()));
            }
            if(ca.getV11().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH11());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH11()));
            }
            if(ca.getV12().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH12());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH12()));
            }
            if(ca.getV13().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH13());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH13()));
            }
            if(ca.getV14().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH14());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH14()));
            }
            if(ca.getV15().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH15());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH15()));
            }
            if(ca.getV16().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH16());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH16()));
            }
            if(ca.getV17().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH17());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH17()));
            }
            if(ca.getV18().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH18());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH18()));
            }
            if(ca.getV19().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH19());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH19()));
            }
            if(ca.getV20().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH20());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH20()));
            }
            if(ca.getV21().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH21());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH21()));
            }
            if(ca.getV22().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH22());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH22()));
            }
            if(ca.getV23().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH23());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH23()));
            }
            if(ca.getV24().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH24());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH24()));
            }

            sumaMediaDias+=sumDia/noNulos;

        });

        Optional<Double> max = valores.stream().max(Comparator.comparing(v -> v));
        Optional<Double> min = valores.stream().min(Comparator.comparing(v -> v));

        return sumaMediaDias/lista.size()+" "+max.get()+" "+min.get();
    }

    /**
     * a partir de la lista filtrada, sacamos los valores de cada hora
     * @param lista de objetos datos meteorologicos filtrado
     * @return una string con el orden media-maximo-minimo mensual
     */
    public String mediadatosMeteo(List<DatosMeteorologicos> lista){
        List<Double> valores = new ArrayList<>();

        lista.forEach(ca ->{
            double sumDia=0;
            int noNulos=0;

            if(ca.getV01().equalsIgnoreCase("V")) {
                sumDia += Double.parseDouble(ca.getH01());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH01()));
            }
            if(ca.getV02().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH02());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH02()));
            }
            if(ca.getV03().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH03());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH03()));
            }
            if(ca.getV04().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH04());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH04()));
            }
            if(ca.getV05().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH05());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH05()));
            }
            if(ca.getV06().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH06());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH06()));
            }
            if(ca.getV07().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH07());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH07()));
            }
            if(ca.getV08().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH08());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH07()));
            }
            if(ca.getV09().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH09());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH09()));
            }
            if(ca.getV10().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH10());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH10()));
            }
            if(ca.getV11().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH11());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH11()));
            }
            if(ca.getV12().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH12());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH12()));
            }
            if(ca.getV13().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH13());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH13()));
            }
            if(ca.getV14().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH14());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH14()));
            }
            if(ca.getV15().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH15());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH15()));
            }
            if(ca.getV16().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH16());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH16()));
            }
            if(ca.getV17().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH17());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH17()));
            }
            if(ca.getV18().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH18());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH18()));
            }
            if(ca.getV19().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH19());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH19()));
            }
            if(ca.getV20().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH20());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH20()));
            }
            if(ca.getV21().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH21());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH21()));
            }
            if(ca.getV22().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH22());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH22()));
            }
            if(ca.getV23().equalsIgnoreCase("V")){
                sumDia+=Double.parseDouble(ca.getH23());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH23()));
            }
            if(ca.getV24().equalsIgnoreCase("V")) {
                sumDia += Double.parseDouble(ca.getH24());
                noNulos += 1;
                valores.add(Double.parseDouble(ca.getH24()));
            }
            sumaMediaDias+=sumDia/noNulos;
        });

        Optional<Double> max = valores.stream().max(Comparator.comparing(v -> v));
        Optional<Double> min = valores.stream().min(Comparator.comparing(v -> v));

        return sumaMediaDias/lista.size()+" "+max.get()+" "+min.get();
    }
}
