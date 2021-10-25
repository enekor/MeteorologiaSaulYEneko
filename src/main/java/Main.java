import Mapas.EstacionesMapas;
import csv.CsvThreadReader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import java.io.File;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        if(args.length==2){
            Funcional funcional = Funcional.getInstance();
            funcional.start(args[0],args[1]);
        }
        else{
            System.out.println("valores aportados no validos, se busca: municipio uri");
        }
    }
}
