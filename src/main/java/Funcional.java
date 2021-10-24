import Mapas.EstacionesMapas;
import csv.DatosMeteorologicosReader;
import html.HTMLCodeGenerator;
import html.HTMLGenerator;

import java.io.IOException;

public class Funcional {

    private static Funcional funcional= null;
    private Funcional(){}
    public static Funcional getInstance(){
        if(funcional==null){
            funcional= new Funcional();
        }
        return funcional;
    }

    /**
     * a partir de el codigo de municipio y la uri de guardado del html generamos este
     * @param municipio es el codigo del municipio que queremos buscar
     * @param uri la direccion donde guardaremos el html
     * @throws IOException si el generador de imagenes tiene problemas para guardar la imagen
     */
    public void start(String municipio,String uri) throws IOException {
        EstacionesMapas em = EstacionesMapas.getInstance();
        Long startTime = System.currentTimeMillis();

        HTMLCodeGenerator generator = new HTMLCodeGenerator();
        HTMLGenerator htmlGenerator = new HTMLGenerator();
        DatosMeteorologicosReader dmr = DatosMeteorologicosReader.getInstance();

        String html = (generator.devolverMagnitudes(municipio,uri));

        Long finishTime = (System.currentTimeMillis()-startTime)/1000;
        htmlGenerator.htmlGenerator(municipio,html,uri,finishTime,
                Integer.parseInt(dmr.getDatosMeteorologicosObjetosList().get(4).getAno()),
                Integer.parseInt(dmr.getDatosMeteorologicosObjetosList().get(4).getMes()),
                Integer.parseInt(dmr.getDatosMeteorologicosObjetosList().get(4).getDia()));
    }
}
