import Mapas.EstacionesMapas;
import csv.DatosMeteorologicosReader;
import html.HTMLCodeGenerator;
import html.HTMLGenerator;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        String municipio=null;
        String uri=null;
        EstacionesMapas em = EstacionesMapas.getInstance();

        try{
            municipio = args[0];
            uri = args[1];
            if(municipio==null){
                System.out.println("no se ha especificado el municipio");
            }
            if(uri==null){
                System.out.println("no se ha especificado la ruta de guardado");
            }
            if(!em.getCodigoMunicipio().containsValue(municipio)){
                System.out.println("municipio no valido");
            }
        }catch(Exception e){

        }

        Long startTime = System.currentTimeMillis();

        HTMLCodeGenerator generator = new HTMLCodeGenerator();
        HTMLGenerator htmlGenerator = new HTMLGenerator();
        DatosMeteorologicosReader dmr = DatosMeteorologicosReader.getInstance();

        municipio=em.getCodigoMunicipio().get(municipio);
        String html = (generator.devolverMagnitudes(municipio));

        Long finishTime = (System.currentTimeMillis()-startTime)/1000;
        htmlGenerator.htmlGenerator(municipio,html,uri,finishTime,
                Integer.parseInt(dmr.getDatosMeteorologicosObjetosList().get(4).getAno()),
                Integer.parseInt(dmr.getDatosMeteorologicosObjetosList().get(4).getMes()),
                Integer.parseInt(dmr.getDatosMeteorologicosObjetosList().get(4).getDia()));
    }
}
