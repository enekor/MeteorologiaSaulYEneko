import Mapas.EstacionesMapas;
import csv.CsvThreadReader;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException {
        String municipio = null;
        String uri = null;
        CsvThreadReader ctr = new CsvThreadReader();
        EstacionesMapas em = EstacionesMapas.getInstance();
        Scanner sc = new Scanner(System.in);
        Funcional funcional = Funcional.getInstance();
/*
        if (args.length < 2 || args.length > 2) {
            System.out.println("datos introducidos no validos");
            if (args.length < 2) {
                System.out.println("datos esperados: municipio uri");
            } else {
                System.out.println("Recuerde que si quiere buscar un municipio compuesto por mas de una palabra tendra que meterla entre comillas");
            }
        } else {
            if (em.getCodigoMunicipio().containsValue(municipio)) {

                String codigoMunicipio = null;

                for (Map.Entry<Integer, String> entry : em.getCodigoMunicipio().entrySet()) {
                    if (Objects.equals(entry.getValue(), municipio)) {
                        codigoMunicipio = String.valueOf(entry.getKey());
                    }
                    File directorio = new File(uri);
                    if (!directorio.exists()) {
                        directorio.mkdirs();
                    }
                    directorio = new File(uri + File.separator + municipio + "html");
                    if (directorio.isFile()) {
                        System.out.println("el archivo ya existe, ¿quiere reemplazarlo? (s=si, n=no)");
                        String ans = sc.next();
                        switch (ans) {
                            case "si":
                            case "Si":
                            case "s":
                            case "S": {
                                funcional.start(codigoMunicipio, uri);
                                System.out.println("archivo html generado con exito");
                                break;
                            }
                            case "n":
                            case "N":
                            case "no":
                            case "No": {
                                System.out.println("proceda a quitar el archivo de la carpeta de destino y vuelva a ejecutar de nuevo el programa por favor");
                            }
                        }
                    }
                }
            }
            else {
                System.out.println("municipio indicado no existente, pruebe con otro, por ejemplo, "+em.getCodigoMunicipio().get(9));
            }
        }*/

        funcional.start("9", "C:\\Users\\eneko\\Desktop\\prueba");
    }
}
