package co.com.santander.bizagi.common.generic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "GeneralPayload", description = "Dto that will have the header and body of the request.")
public class GeneralPayload <T> {

	@ApiModelProperty(value = "header object ")
    private RequestHeader requestHeader;
	
	@ApiModelProperty(value = "Generic object that will have the body of the request.")
    private T requestBody;
}
