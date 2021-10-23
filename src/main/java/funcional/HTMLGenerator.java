package funcional;

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


    public void htmlGenerator(String municipio,String texto, String uri,Long tiempoNecesitado){
        html = new File(uri+File.separator+municipio+".html");
        String finish = "<p>Informe generado el dia "+dtf.format(now)+" en "+tiempoNecesitado+" segundos";
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

