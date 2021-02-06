package co.com.santander.bizagi.common.generic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Header", description = "Dto that has the request headers.")
public class RequestHeader {
	
	@ApiModelProperty(value = "" , example = "001")
    private String codAliado;
	
	@ApiModelProperty(value = "" , example = "pepito.perez@sanitas.com.co")
    private String usuarioAliado;
    
	@ApiModelProperty(value = "" , example = "fb2e77d.47a0479900504cb3ab4a1f626d174d2d")
    private String sesionId;
    
	@ApiModelProperty(value = "" , example = "127.0.0.1")
    private String ipOrigen;
    
	@ApiModelProperty(value = "" , example = "000012")
    private String numeroSolicitudCredito;
    
	@ApiModelProperty(value = "" , example = "1")
    private String tipoIdentificacion;
    
	@ApiModelProperty(value = "" , example = "1018460254")
    private String identificacion;
}
