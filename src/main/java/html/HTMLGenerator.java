package html;

import Mapas.EstacionesMapas;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class HTMLGenerator {

    EstacionesMapas em = EstacionesMapas.getInstance();

    private  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime now = LocalDateTime.now();
    private String nowSinHora=dtf.format(now).toString().substring(0,10);
    private String fileStart="";
    private String htmlStart ="<html>\n" +
            "    <head>\n" +
            "        <title>Datos Meteorologicos</title>\n" +
            "        <link rel='stylesheet' href='"+System.getProperty("user.dir")+File.separator+"src"+File.separator+
                      "main"+File.separator+"resources"+File.separator+"meteorologia.css' type='text/css'/>\n" +
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
    public void htmlGenerator(String municipio,String texto, String uri,Long tiempoNecesitado, int anio, int mes, int dia){
        fileStart+="<pre class='inicio'>Ciudad:"+em.getCodigoMunicipio().get(Integer.parseInt(municipio))+
                "\nMedicion iniciada el "+dia+"/"+mes+"/"+anio+"\n"+
                "Medicion finalizada el "+nowSinHora+"\n</pre>";

        html = new File(uri+File.separator+em.getCodigoMunicipio().get(Integer.parseInt(municipio))+".html");

        String finish = "<p class='generado'>Informe generado el dia "+dtf.format(now)+" en "+tiempoNecesitado+" segundos</p>\n" +
                "creadores: Eneko Rebollo y Saul Mellado";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(html));
            bw.write(fileStart+htmlStart+texto+htmlFinish+finish);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

