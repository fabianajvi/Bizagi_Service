package co.com.santander.bizagi.service;

import co.com.santander.bizagi.common.generic.GenericResponse;
import co.com.santander.bizagi.dto.Cliente;
import co.com.santander.bizagi.dto.ResponseJson;

import org.json.JSONException;

import java.net.MalformedURLException;
import java.util.Optional;

public interface CaseBizagiService {
	
    Optional<ResponseJson> createCaseString(Cliente cliente) throws MalformedURLException, JSONException;

    GenericResponse createCase(Cliente cliente) throws MalformedURLException, JSONException;
}
