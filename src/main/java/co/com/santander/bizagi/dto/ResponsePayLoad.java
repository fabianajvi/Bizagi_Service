package co.com.santander.bizagi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePayLoad<T> {

    private String codRespuesta;
    private T respuestaServicio;
    private String mensajeError;

}
