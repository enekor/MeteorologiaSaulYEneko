package Objetos;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CalidadAireZonas {
    @NonNull String zona_calidad_aire_codigo,zona_calidad_aire_descripcion,zona_calidad_aire_municipio;
}
