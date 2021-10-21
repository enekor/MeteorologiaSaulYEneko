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
        if(lista.isEmpty()){
            return "no hay datos en este municipio";
        }
        List<Integer> valores = new ArrayList<>();

        lista.forEach(ca ->{
            Integer sumDia=0;
            int noNulos=0;

            if(ca.getV01().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH01());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH01()));
            }
            if(ca.getV02().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH02());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH02()));
            }
            if(ca.getV03().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH03());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH03()));
            }
            if(ca.getV04().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH04());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH04()));
            }
            if(ca.getV05().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH05());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH05()));
            }
            if(ca.getV06().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH06());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH06()));
            }
            if(ca.getV07().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH07());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH07()));
            }
            if(ca.getV08().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH08());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH08()));
            }
            if(ca.getV09().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH09());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH09()));
            }
            if(ca.getV10().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH10());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH10()));
            }
            if(ca.getV11().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH11());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH11()));
            }
            if(ca.getV12().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH12());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH12()));
            }
            if(ca.getV13().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH13());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH13()));
            }
            if(ca.getV14().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH14());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH14()));
            }
            if(ca.getV15().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH15());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH15()));
            }
            if(ca.getV16().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH16());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH16()));
            }
            if(ca.getV17().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH17());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH17()));
            }
            if(ca.getV18().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH18());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH18()));
            }
            if(ca.getV19().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH19());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH19()));
            }
            if(ca.getV20().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH20());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH20()));
            }
            if(ca.getV21().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH21());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH21()));
            }
            if(ca.getV22().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH22());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH22()));
            }
            if(ca.getV23().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH23());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH23()));
            }
            if(ca.getV24().equalsIgnoreCase("V")){
                sumDia+=Integer.parseInt(ca.getH24());
                noNulos += 1;
                valores.add(Integer.parseInt(ca.getH24()));
            }

            sumaMediaDias+=sumDia/noNulos;

        });

        Optional<Integer> max = valores.stream().max(Comparator.comparing(v -> v));
        Optional<Integer> min = valores.stream().min(Comparator.comparing(v -> v));

        return sumaMediaDias/lista.size()+" "+max.get()+" "+min.get();
    }

    /**
     * a partir de la lista filtrada, sacamos los valores de cada hora
     * @param lista de objetos datos meteorologicos filtrado
     * @return una string con el orden media-maximo-minimo mensual
     */
    public String mediadatosMeteo(List<DatosMeteorologicos> lista){
        if(lista.isEmpty()){
            return "no hay datos en este municipio";
        }
        List<Double> valores = new ArrayList<>();

        lista.forEach(ca ->{
            double sumDia=0;
            int noNulos=0;

            if(ca.getV01().equalsIgnoreCase("V")) {
                String h =ca.getH01().replace(",",".");
                sumDia += Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV02().equalsIgnoreCase("V")){
                String h =ca.getH02().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV03().equalsIgnoreCase("V")){
                String h =ca.getH03().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV04().equalsIgnoreCase("V")){
                String h =ca.getH04().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV05().equalsIgnoreCase("V")){
                String h =ca.getH05().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV06().equalsIgnoreCase("V")){
                String h =ca.getH06().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV07().equalsIgnoreCase("V")){
                String h =ca.getH07().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV08().equalsIgnoreCase("V")){
                String h =ca.getH08().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV09().equalsIgnoreCase("V")){
                String h =ca.getH09().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV10().equalsIgnoreCase("V")){
                String h =ca.getH10().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV11().equalsIgnoreCase("V")){
                String h =ca.getH11().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV12().equalsIgnoreCase("V")){
                String h =ca.getH12().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV13().equalsIgnoreCase("V")){
                String h =ca.getH13().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV14().equalsIgnoreCase("V")){
                String h =ca.getH14().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV15().equalsIgnoreCase("V")){
                String h =ca.getH15().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV16().equalsIgnoreCase("V")){
                String h =ca.getH16().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV17().equalsIgnoreCase("V")){
                String h =ca.getH17().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV18().equalsIgnoreCase("V")){
                String h =ca.getH18().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV19().equalsIgnoreCase("V")){
                String h =ca.getH19().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV20().equalsIgnoreCase("V")){
                String h =ca.getH20().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV21().equalsIgnoreCase("V")){
                String h =ca.getH21().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV22().equalsIgnoreCase("V")){
                String h =ca.getH22().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV23().equalsIgnoreCase("V")){
                String h =ca.getH23().replace(",",".");
                sumDia+=Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            if(ca.getV24().equalsIgnoreCase("V")) {
                String h =ca.getH24().replace(",",".");
                sumDia += Double.parseDouble(h);
                noNulos += 1;
                valores.add(Double.parseDouble(h));
            }
            sumaMediaDias+=sumDia/noNulos;
        });

        Optional<Double> max = valores.stream().max(Comparator.comparing(v -> v));
        Optional<Double> min = valores.stream().min(Comparator.comparing(v -> v));

        return sumaMediaDias/lista.size()+" "+max.get()+" "+min.get();
    }
}
