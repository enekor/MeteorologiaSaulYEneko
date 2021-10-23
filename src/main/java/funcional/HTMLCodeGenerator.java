package funcional;

import Filtro.InfoMeteorologica;
import JfreeChart.FreeChart;
import Mapas.MagnitudMap;
import csv.CsvThreadReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HTMLCodeGenerator {

    String respuesta="";

    MagnitudMap map = MagnitudMap.getInstance();
    CsvThreadReader ctr = new CsvThreadReader();
    InfoMeteorologica im = InfoMeteorologica.getInstance();
    FreeChart fChart = FreeChart.getInstance();

    public String devolverMagnitudes(String municipio) throws IOException {

        for (int i = 0; i<=89;i++){
            if(map.getMapa().containsKey(i)){
                String html="<p>"+im.proveedorDeDatos(ctr.getCalidadList(),ctr.getDatosList(),municipio,String.valueOf(i))+"</p>";

                respuesta+=html+"\n";
                List<Double> valores= im.getValores();
                if(!html.equalsIgnoreCase("no hay datos en este municipio sobre "+im.getNombre())){
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
        return respuesta;
    }

}
