package html;

import Filtro.InfoMeteorologica;
import JfreeChart.FreeChart;
import Mapas.MagnitudMap;
import csv.CsvThreadReader;

import java.io.IOException;
import java.util.List;

public class HTMLCodeGenerator {

    String respuesta="";

    MagnitudMap map = MagnitudMap.getInstance();
    CsvThreadReader ctr = new CsvThreadReader();
    InfoMeteorologica im = InfoMeteorologica.getInstance();
    FreeChart fChart = FreeChart.getInstance();

    /**
     * recorremos una array de 89 posiciones viendo si la i coincide con algun codigo de municipio, si coincide, lo pasa a generar los datos, y, si estos datos tienen
     * unos valores asociados, es decir, no es una medicion sin valores, le genera una etiqueta html y suma la String a la String donde se almacena todo el
     * codigo del cuerpo del html, y luego lo mismo conla medicion 431 (no se iba a hacer un for de 431 solo para esa medicion)
     * @param municipio al que hace referencia el codigo
     * @return el codigo html con/sin la etiqueta imagen
     * @throws IOException si el generador de imagen tiene problemas para guardar la imagen
     */
    public String devolverMagnitudes(String municipio) throws IOException {

        for (int i = 0; i<=89;i++){
            if(map.getMapa().containsKey(i)){
                String html="<p>"+im.proveedorDeDatos(ctr.getCalidadList(),ctr.getDatosList(),municipio,String.valueOf(i))+"</p>";

                respuesta+=html+"\n";
                List<Double> valores= im.getValores();
                if(html.length()>90){
                    if(valores!=null) {
                        String imagenGenerada = fChart.generarPng(valores, im.getNombre());
                        String imagen = "<img src='" +
                                imagenGenerada+
                                "'>";
                        respuesta += imagen+"\n\n";
                    }
                }
            }
        }

        String html="<p>"+im.proveedorDeDatos(ctr.getCalidadList(),ctr.getDatosList(),municipio,String.valueOf(431))+"</p>";

        respuesta+=html+"\n";
        List<Double> valores= im.getValores();
        if(html.length()>90){
            if(valores!=null) {
                String imagenGenerada = fChart.generarPng(valores, im.getNombre());
                String imagen = "<img src='" +
                        imagenGenerada+
                        "'>";
                respuesta += imagen+"\n\n";
            }
        }

        return respuesta;
    }
}
