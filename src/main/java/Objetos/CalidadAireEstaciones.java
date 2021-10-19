package Objetos;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CalidadAireEstaciones {
    @NonNull String estacion_codigo,zona_calidad_aire_descripcion,estacion_municipio,estacion_fecha_alta,
            estacion_tipo_area,estacion_tipo_estacion,estacion_subarea_rural,estacion_direccion_postal,
            estacion_coord_UTM_ETRS89_x,estacion_coord_UTM_ETRS89_y,estacion_coord_longitud,
            estacion_coord_latitud,estacion_altitud,estacion_analizador_NO,estacion_analizador_NO2,
            estacion_analizador_PM10,estacion_analizador_PM2_5,estacion_analizador_O3,estacion_analizador_TOL,
            estacion_analizador_BEN,estacion_analizador_XIL,estacion_analizador_CO,estacion_analizador_SO2,
            estacion_analizador_HCT,estacion_analizador_HNM;
}
