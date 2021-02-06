package co.com.santander.bizagi.controller;

import java.net.MalformedURLException;
import java.util.Optional;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.santander.bizagi.common.generic.GeneralPayload;
import co.com.santander.bizagi.common.generic.GenericResponse;
import co.com.santander.bizagi.dto.Cliente;
import co.com.santander.bizagi.dto.ResponseJson;
import co.com.santander.bizagi.dto.ResponsePayLoad;
import co.com.santander.bizagi.service.CaseBizagiService;
import co.com.santander.bizagi.util.ConstanstsExamplesApi;
import co.com.santander.bizagi.util.MessageApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@RestController
@RequestMapping("v1/bizagi")
@Api(value = "Bizagi", tags = { "V1: Create Bizagi case." })
public class CaseBizagiController {
	private final CaseBizagiService caseBizagiService;

	@Autowired
	public CaseBizagiController(CaseBizagiService caseBizagiService) {
		this.caseBizagiService = caseBizagiService;
	}

	@ApiOperation(value = "Create Application.", notes = "This service allows creating a case in bizagi.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = MessageApi.Constants.STATUS_OK, response = ResponsePayLoad.class, examples = @Example(@ExampleProperty(mediaType = MediaType.APPLICATION_JSON_VALUE, value = ConstanstsExamplesApi.CREATE_CASE))),
			@ApiResponse(code = 400, message = MessageApi.Constants.LABELS_ERROR, response = ResponsePayLoad.class),
			@ApiResponse(code = 408, message = MessageApi.Constants.CONNECT_TIMEOUT, response = ResponsePayLoad.class),
			@ApiResponse(code = 404, message = MessageApi.Constants.NOT_FOUND, response = ResponsePayLoad.class) })
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createCase(@RequestBody(required = true) GeneralPayload<Cliente> clientePayload)
			throws MalformedURLException, JSONException {
		Optional<ResponseJson> response = caseBizagiService.createCaseString(clientePayload.getRequestBody());
		if(response.get().getProcesses().getProcess().getProcessRadNumber() != null) {
			return new ResponseEntity<>(ResponsePayLoad.builder().codRespuesta("1")
					.respuestaServicio(response.get().getProcesses().getProcess()).mensajeError("OK").build(), HttpStatus.OK);
		}
		return new ResponseEntity<>(ResponsePayLoad.builder().codRespuesta("0")
				.respuestaServicio(response.get().getProcesses().getProcess()).mensajeError("OK").build(), HttpStatus.BAD_REQUEST);
		

	}

	@PostMapping(value = "/create-case", produces = MediaType.APPLICATION_JSON_VALUE)
	public GenericResponse createCaseObject(@RequestBody GeneralPayload<Cliente> clientePayload)
			throws MalformedURLException, JSONException {
		return this.caseBizagiService.createCase(clientePayload.getRequestBody());
	}
}
