package Filtro;

import Objetos.CalidadAire;
import Objetos.DatosMeteorologicos;

import java.util.List;
import java.util.stream.Collectors;

public class Filtro {
    /**
     * Metodo que filtra datosMeteorologicosObjetosList y returnea solo los que sean iguales a el muncipio pasado por parametro
     * @param municipio
     * @return
     */
    public List<CalidadAire> filtroCalidadAire(String municipio, String magnitud, List<CalidadAire> datos) {
        return datos.stream().filter(p -> p.getMunicipio().equalsIgnoreCase(municipio)).filter(p -> p.getMagnitud().equalsIgnoreCase(magnitud)).collect(Collectors.toList());
    }

    public List<DatosMeteorologicos> filtroDatosMeteo(String municipio, String magnitud, List<DatosMeteorologicos> datos){
        return datos.stream().filter(p -> p.getMunicipio().equalsIgnoreCase(municipio)).filter(p -> p.getMagnitud().equalsIgnoreCase(magnitud)).collect(Collectors.toList());
    }
}
