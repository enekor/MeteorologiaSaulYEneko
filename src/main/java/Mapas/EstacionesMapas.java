package Mapas;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class EstacionesMapas {

    private static EstacionesMapas estaciones = null;

    private EstacionesMapas(){}

    public static EstacionesMapas getInstance(){
        if(estaciones==null){
            estaciones = new EstacionesMapas();
        }
        return estaciones;
    }

    private Map<Integer,String> codigoMunicipio = new LinkedHashMap<>();
    private Map<Integer,String> codigoNacional = new LinkedHashMap<>();

    private void fillCodigoMunicipio(){
        codigoMunicipio.put(5,"Alcala De Henares");
        codigoMunicipio.put(6,"Alcobendas");
        codigoMunicipio.put(7,"Alcorcon");
        codigoMunicipio.put(9,"Algete");
        codigoMunicipio.put(13,"Aranjuez");
        codigoMunicipio.put(14,"Arganda del rey");
        codigoMunicipio.put(16,"El Atazar");
        codigoMunicipio.put(45,"colmenar viejo");
        codigoMunicipio.put(47,"collado villaba");
        codigoMunicipio.put(49,"coslada");
        codigoMunicipio.put(58,"fuenlabrada");
        codigoMunicipio.put(65,"getafe");
        codigoMunicipio.put(67,"guadalix de la sierra");
        codigoMunicipio.put(74,"leganes");
        codigoMunicipio.put(80,"majadahonda");
        codigoMunicipio.put(92,"mostoles");
        codigoMunicipio.put(102,"orusco de tajuña");
        codigoMunicipio.put(120,"puerto de cotos");
        codigoMunicipio.put(123,"rivas-vaciamadrid");
        codigoMunicipio.put(133,"sanmartin de los valdeiglesias");
        codigoMunicipio.put(148,"torrejon de ardoz");
        codigoMunicipio.put(161,"valdemoro");
        codigoMunicipio.put(171,"villa del prado");
        codigoMunicipio.put(180,"villarejo de salvanes");
    }

    public void fillCodigoNacional(int codigo, String estacion){
        codigoNacional.put(codigo,estacion);
    }
}