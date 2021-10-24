package html;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class HTMLGenerator {

    private  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime now = LocalDateTime.now();
    private String htmlStart ="<html>\n" +
            "    <head>\n" +
            "        <title>Datos Meteorologicos</title>\n" +
            "        <link rel='stylesheet' href='meteorologia.css' type='text/css'/>\n" +
            "\n" +
            "    </head>\n" +
            "    <body>\n";
    private String htmlFinish = "    </body>\n" +
            "</html>";

    private File html;

    /**
     * generamos el html en base a el inicio y final pre-definidos en las variables privadas de la clase y la String que se pasa por parametro
     * @param municipio al que hace referencia la medicion
     * @param texto que continene el codigo html que generara el contenido de la pagina web
     * @param uri donde se guardara el archivo html generado
     * @param tiempoNecesitado para generar el informe
     */
    public void htmlGenerator(String municipio,String texto, String uri,Long tiempoNecesitado){
        html = new File(uri+File.separator+municipio+".html");
        String finish = "<p class='generado'>Informe generado el dia "+dtf.format(now)+" en "+tiempoNecesitado+" segundos";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(html));
            bw.write(htmlStart+texto+htmlFinish+finish);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

