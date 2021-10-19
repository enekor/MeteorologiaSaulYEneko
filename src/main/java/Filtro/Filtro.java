package Filtro;

import Objetos.CalidadAire;
import Objetos.DatosMeteorologicos;

import java.util.List;
import java.util.stream.Collectors;

public class Filtro {
    /**
     * Metodo que filtra Calidad Aire y returnea solo los que sean igual al muncipio y magnitud pasados por parametro
     * @param municipio
     * @param magnitud
     * @param datos
     * @return
     */
    public List<CalidadAire> filtroCalidadAire(String municipio, String magnitud, List<CalidadAire> datos) {
        return datos.stream().filter(p -> p.getMunicipio().equalsIgnoreCase(municipio)).filter(p -> p.getMagnitud().equalsIgnoreCase(magnitud)).collect(Collectors.toList());
    }

    /**
     * Metodo que filtra Datos Meteorologicos y returnea solo los que sean igual al muncipio y magnitud pasados por parametro
     * @param municipio
     * @param magnitud
     * @param datos
     * @return
     */
    public static List<DatosMeteorologicos> filtroDatosMetorologicos(String municipio, String magnitud, List<DatosMeteorologicos> datos) {
        return datos.stream().filter(p -> p.getMunicipio().equalsIgnoreCase(municipio)).filter(p -> p.getMagnitud().equalsIgnoreCase(magnitud)).collect(Collectors.toList());
    }
}
