import Mapas.EstacionesMapas;
import csv.CsvThreadReader;
import csv.DatosMeteorologicosReader;
import html.HTMLCodeGenerator;
import html.HTMLGenerator;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Funcional {

    private String codMunicipio=null;

    private static Funcional funcional = null;
    private Funcional() {}
    public static Funcional getInstance() {
        if (funcional == null) {
            funcional = new Funcional();
        }
        return funcional;
    }

    /**
     * a partir de el codigo de municipio y la uri de guardado del html generamos este
     *
     * @param municipio es el codigo del municipio que queremos buscar
     * @param uri       la direccion donde guardaremos el html
     * @throws IOException si el generador de imagenes tiene problemas para guardar la imagen
     */
    public void start(String municipio, String uri) throws IOException, InterruptedException {
        Long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        EstacionesMapas em = EstacionesMapas.getInstance();
        CsvThreadReader ctr = CsvThreadReader.getInstance();
        HTMLCodeGenerator generator = new HTMLCodeGenerator();
        HTMLGenerator htmlGenerator = new HTMLGenerator();
        DatosMeteorologicosReader dmr = DatosMeteorologicosReader.getInstance();

        if(dirExists(municipio,uri)){
            System.out.println("quieres reemplazar el archivo existente? si/no");
            String ans = sc.next();
            if(ans.equalsIgnoreCase("no")){
                System.out.println("proceda a guardar el archivo en otro directorio");
                System.exit(0);
        }
        municipioExists(municipio);
        if (codMunicipio==null){
            System.out.println("municipio no encontrado");
            }
        }
        else {
            String html = (generator.devolverMagnitudes(codMunicipio, uri));

            Long finishTime = (System.currentTimeMillis() - startTime) / 1000;
            htmlGenerator.htmlGenerator(codMunicipio, html, uri, finishTime,
                    Integer.parseInt(dmr.getDatosMeteorologicosObjetosList().get(4).getAno()),
                    Integer.parseInt(dmr.getDatosMeteorologicosObjetosList().get(4).getMes()),
                    Integer.parseInt(dmr.getDatosMeteorologicosObjetosList().get(4).getDia()));
        }
    }

    private void municipioExists(String municipio) {
        EstacionesMapas em = EstacionesMapas.getInstance();
        if (em.getCodigoMunicipio().containsValue(municipio)) {
            for (Map.Entry<Integer, String> entry : em.getCodigoMunicipio().entrySet()) {
                if (Objects.equals(entry.getValue(), municipio)) {
                    codMunicipio = String.valueOf(entry.getKey());
                }
            }
        }
    }

    private boolean dirExists(String municipio,String uri){
        File archivo = new File(uri+File.separator+municipio+".html");
        if(!archivo.exists()){
            return false;
        }
        else return true;
    }
}
