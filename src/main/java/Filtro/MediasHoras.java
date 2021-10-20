package Filtro;

import Objetos.CalidadAire;
import Objetos.DatosMeteorologicos;

import java.util.List;

public class MediasHoras {

    private int sumaMediaDias=0;

    /**
     * Metodo que saca la media de todas las horas que sean validas de Calidad Aire
     * @param lista
     * @return Media mensual
     */
    public int mediaCalidadAire(List<CalidadAire> lista){

        lista.forEach(ca ->{
            int sumDia=0;
            int totalHoras=0;
            if(ca.getV01().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH01());
            totalHoras+=1;
            if(ca.getV02().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH02());
            totalHoras+=1;
            if(ca.getV03().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH03());
            totalHoras+=1;
            if(ca.getV04().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH04());
            totalHoras+=1;
            if(ca.getV05().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH05());
            totalHoras+=1;
            if(ca.getV06().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH06());
            totalHoras+=1;
            if(ca.getV07().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH07());
            totalHoras+=1;
            if(ca.getV08().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH08());
            totalHoras+=1;
            if(ca.getV09().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH09());
            totalHoras+=1;
            if(ca.getV10().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH10());
            totalHoras+=1;
            if(ca.getV11().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH11());
            totalHoras+=1;
            if(ca.getV12().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH12());
            totalHoras+=1;
            if(ca.getV13().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH13());
            totalHoras+=1;
            if(ca.getV14().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH14());
            totalHoras+=1;
            if(ca.getV15().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH15());
            totalHoras+=1;
            if(ca.getV16().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH16());
            totalHoras+=1;
            if(ca.getV17().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH17());
            totalHoras+=1;
            if(ca.getV18().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH18());
            totalHoras+=1;
            if(ca.getV19().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH19());
            totalHoras+=1;
            if(ca.getV20().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH20());
            totalHoras+=1;
            if(ca.getV21().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH21());
            totalHoras+=1;
            if(ca.getV22().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH22());
            totalHoras+=1;
            if(ca.getV23().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH23());
            totalHoras+=1;
            if(ca.getV24().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH24());
            totalHoras+=1;

            sumaMediaDias+=sumDia/totalHoras;
        });
        return sumaMediaDias/lista.size();
    }

    /**
     * Metodo que saca la media de todas las horas que sean validas de Datos Meteorologicos
     * @param lista
     * @return Media Mensual
     */
    public int mediadatosMeteo(List<DatosMeteorologicos> lista){

        lista.forEach(ca ->{
            int sumDia=0;
            if(ca.getV01().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH01());
            if(ca.getV02().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH02());
            if(ca.getV03().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH03());
            if(ca.getV04().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH04());
            if(ca.getV05().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH05());
            if(ca.getV06().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH06());
            if(ca.getV07().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH07());
            if(ca.getV08().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH08());
            if(ca.getV09().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH09());
            if(ca.getV10().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH10());
            if(ca.getV11().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH11());
            if(ca.getV12().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH12());
            if(ca.getV13().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH13());
            if(ca.getV14().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH14());
            if(ca.getV15().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH15());
            if(ca.getV16().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH16());
            if(ca.getV17().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH17());
            if(ca.getV18().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH18());
            if(ca.getV19().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH19());
            if(ca.getV20().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH20());
            if(ca.getV21().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH21());
            if(ca.getV22().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH22());
            if(ca.getV23().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH23());
            if(ca.getV24().equalsIgnoreCase("V"))
                sumDia+=Integer.parseInt(ca.getH24());

            sumaMediaDias+=sumDia/24;
        });


        return sumaMediaDias/lista.size();
    }
}
