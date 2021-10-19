package Filtro;

import Objetos.DatosMeteorologicos;

import java.util.List;
import java.util.stream.Collectors;

public class Filtro {
    /**
     * Metodo que filtra datosMeteorologicosObjetosList y returnea solo los que sean iguales a el muncipio pasado por parametro
     * @param municipio
     * @return
     */
    public static List<DatosMeteorologicos> datosMunicipioCalidadAireMeteo(String municipio, List<DatosMeteorologicos> datos) {
        return datos.stream().filter(p -> p.getMunicipio().equalsIgnoreCase(municipio)).collect(Collectors.toList());
    }
}
