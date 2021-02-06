package co.com.santander.bizagi.service.impl;

import co.com.santander.bizagi.client.CaseBizagiClient;
import co.com.santander.bizagi.common.generic.GenericResponse;
import co.com.santander.bizagi.common.properties.ServiciosProperties;
import co.com.santander.bizagi.dto.BizAgiWSParam;
import co.com.santander.bizagi.dto.Case;
import co.com.santander.bizagi.dto.Cliente;
import co.com.santander.bizagi.dto.ResponseJson;
import co.com.santander.bizagi.dto.SolicitudCredito;
import co.com.santander.bizagi.service.CaseBizagiService;
import co.com.santander.bizagi.util.StringUtilities;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import java.io.StringWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CaseBizagiServiceImpl implements CaseBizagiService {
	public static final String TEMPLATES_REQUEST_CREATE_CASE_CONSUMO_DIGITAL = "templates/requestCreateCaseConsumoDigital.vm";
	public static final String TEMPLATES_REQUEST_CREATE_CASE_CONSUMO_PERSONA_NATURAL = "templates/requestCreateCaseConsumoPersonaNatural.vm";
	private final CaseBizagiClient caseBizagiClient;
	private final VelocityEngine velocityEngine;
	private final VelocityContext context;
	private final StringUtilities stringUtilities;
	private final ServiciosProperties serviciosProperties;

	@Autowired
	public CaseBizagiServiceImpl(CaseBizagiClient caseBizagiClient, VelocityEngine velocityEngine,
			VelocityContext context, StringUtilities stringUtilities, ServiciosProperties serviciosProperties) {
		this.caseBizagiClient = caseBizagiClient;
		this.velocityEngine = velocityEngine;
		this.context = context;
		this.stringUtilities = stringUtilities;
		this.serviciosProperties = serviciosProperties;
	}

	@Override
	public Optional<ResponseJson> createCaseString(Cliente cliente) throws MalformedURLException, JSONException {
		if (cliente.getValorSolicitado() == null) {
			String request = putParametersVelocityConsumoDigital(cliente).replaceAll("\r", "");
			String r = stringUtilities
					.xmlToJson(stringUtilities.cdataToJson(caseBizagiClient.createCaseString(request)));
			String respuesta = r;
			Gson g = new Gson();
			ResponseJson p = g.fromJson(respuesta, ResponseJson.class);
			if (p != null) {
				return Optional.of(p);

			}
			return Optional.empty();

		} else {
			String requestString = putParametersVelocityConsumoPersonaNatural(cliente).replaceAll("\r", "");
			String r1 = stringUtilities
					.xmlToJson(stringUtilities.cdataToJson(caseBizagiClient.createCaseString(requestString)));
			String respuesta1 = r1;
			Gson g = new Gson();
			ResponseJson p = g.fromJson(respuesta1, ResponseJson.class);
			if (p != null) {
				return Optional.of(p);

			}
			return Optional.empty();

		}
	}

	@Override
	public GenericResponse createCase(Cliente cliente) throws MalformedURLException, JSONException {
		BizAgiWSParam request = setParams(cliente, serviciosProperties);
		return GenericResponse.builder().codRespuesta("1").respuestaError("null")
				.respuestaServicio(caseBizagiClient.createCase(request)).build();
	}

	private BizAgiWSParam setParams(Cliente cliente, ServiciosProperties serviciosProperties) {
		return BizAgiWSParam.builder().domain(serviciosProperties.getDomain())
				.userName(serviciosProperties.getUserName()).Case(setCase(cliente)).build();
	}

	private List<Case> setCase(Cliente cliente) {
		List<Case> result = new ArrayList<>();
		result.add(Case.builder().Entities(setSolicitudCredito(cliente))
				.Process(serviciosProperties.getConsumoPersona()).build());
		return result;
	}

	private List<SolicitudCredito> setSolicitudCredito(Cliente cliente) {
		List<SolicitudCredito> result = new ArrayList<>();
		result.add(SolicitudCredito.builder()
				.AutorizaConsultaaCentrales(serviciosProperties.getAutorizaConsultaaCentrales()).cliente(cliente)
				.build());
		return result;
	}

	private String putParametersVelocityConsumoDigital(Cliente cliente) {
		Template template = velocityEngine.getTemplate(TEMPLATES_REQUEST_CREATE_CASE_CONSUMO_DIGITAL, "UTF-8");
		context.put("domain", serviciosProperties.getDomain());
		context.put("username", serviciosProperties.getUserName());
		context.put("consumoDigital", serviciosProperties.getConsumoDigital());
		context.put("documentnumber", cliente.getNumeroIdentificacion());
		context.put("typedocument", cliente.getTipodeidentificacion());
		context.put("apellido1", cliente.getApellido1());
		context.put("apellido2", cliente.getApellido2());
		context.put("nombre1", cliente.getNombre1());
		context.put("nombre2", cliente.getNombre2());

		context.put("fechanacimiento", cliente.getFechaNacimiento());
		context.put("telefono", cliente.getTelefonoResidencia());
		context.put("celular", cliente.getCelularPersonal());
		context.put("correo", cliente.getCorreoPersonal());
		context.put("ingresosmensuales", cliente.getIngresosMensuales());
		context.put("autorizaContactoWhatsapp", cliente.getAutorizaContactoWhatsapp());

		context.put("lugarDeExpedicion", cliente.getLugarDeExpedicion());
		context.put("modalidadDePagoSeguro", cliente.getModalidadDePagoSeguro());
		context.put("valorSubvecionado", cliente.getValorSubvecionado());
		context.put("tasa", cliente.getTasa());
		context.put("cupoSolicitadoAprobado", cliente.getCupoSolicitadoAprobado());
		context.put("personaConReconPublico", cliente.getPersonaConReconPublico());
		context.put("personaPubicamenteExpuesta", cliente.getPersonaPubicamenteExpuesta());
		context.put("diaDePago", cliente.getDiaDePago());
		context.put("concesionarioCuenta", cliente.getConcesionarioCuenta());
		context.put("tipoDeCuenta", cliente.getTipoDeCuenta());
		context.put("bancoDebito", cliente.getBancoDebito());
		context.put("autorizacionDebitoAutomatico", cliente.getAutorizacionDebitoAutomatico());
		context.put("numeroCuentaDebito", cliente.getNumeroCuentaDebito());
		context.put("primaSeguro", cliente.getPrimaSegurodeVida());
		context.put("autorizaContacto", cliente.getAutorizaContactoWhatsapp());
		context.put("planSubvencionado", cliente.getPlanSubvencionado());
		context.put("planFinanciacionConsumo", cliente.getPlanFinanciacionConsumo());
		context.put("tipoCredito", cliente.getTipoDeCredito());
		context.put("convenioConsumo", cliente.getConvenioConsumo());
		context.put("paisDeExpedicion", cliente.getPaisDeExpedicion());
		context.put("fechaDeExpedicion", cliente.getFechaDeExpedicion());
		context.put("idDepartamentos", cliente.getIdDepartamentos());
		context.put("paisNacimiento", cliente.getPaisNacimiento());
		context.put("nacionalidad", cliente.getNacionalidad());
		context.put("lugarDeNacimiento", cliente.getLugarDeNacimiento());
		context.put("genero", cliente.getGenero());
		context.put("estadoCivil", cliente.getEstadoCivil());
		context.put("estrato", cliente.getEstrato());
		context.put("paisResidencia", cliente.getPaisResidencia());
		context.put("ciudadResidencia", cliente.getCiudadResidencia());
		context.put("tipoViaResidencia", cliente.getTipoViaResidencia());
		context.put("nombreViaResidencia", cliente.getNombreViaResidencia());
		context.put("direccionViaResidencia", cliente.getDireccionViaResidencia());
		context.put("actividadEconomica", cliente.getActividadEconomica());
		context.put("tipoDeActividad", cliente.getTipoDeActividad());
		context.put("empresaActualoActividad", cliente.getEmpresaActualoActividad());
		context.put("nitEmpresa", cliente.getNitEmpresa());
		context.put("cargoActualActividad", cliente.getCargoActualActividad());
		context.put("fechaDeIngreso", cliente.getFechaDeIngreso());
		context.put("tipoDeContrato", cliente.getTipoDeContrato());
		context.put("paisEmpresa", cliente.getPaisEmpresa());
		context.put("ciudadEmpresaActividadActu", cliente.getCiudadEmpresaActividadActu());
		context.put("tipoViaLaboral", cliente.getTipoViaLaboral());
		context.put("nombreViaLaboral", cliente.getNombreViaLaboral());
		context.put("direccionLaboral", cliente.getDireccionLaboral());
		context.put("telefonoLaboral", cliente.getTelefonoLaboral());
		context.put("ciudadLaboral", cliente.getCiudadLaboral());
		context.put("codigosciiDian", cliente.getCodigosCiiDian());
		context.put("numeroDeEmpleados", cliente.getNumeroDeEmpleados());
		context.put("fechaDeConstitucionEmpresa", cliente.getFechaDeConstitucionEmpresa());
		context.put("poseeProductosMoneda", cliente.getPoseeProductosDeMonedaExtr());
		context.put("realizaOperacionesInternac", cliente.getRealizaOperacionesInternac());
		context.put("egresosMensuales", cliente.getEgresosMensuales());
		context.put("activos", cliente.getActivos());
		context.put("pasivos", cliente.getPasivos());
		context.put("ingresosAdicionales", cliente.getIngresosAdicionales());
		context.put("descripcionIngresos", cliente.getDescripcionIngresosAdicion());
		context.put("clientePep", cliente.getClientePep());
		context.put("programaReincorporacion", cliente.getProgramaReincorporacion());
		context.put("numeroResolucion", cliente.getNumeroResolucion());
		context.put("fechaResolucion", cliente.getFechaResolucion());
		context.put("tomaPolizaRiesgo", cliente.getTomaPolizaSeguro());
		context.put("primaSeguroAuto", cliente.getPrimaSeguroAutomovil());
		context.put("ingresosMensualesViabiliza", cliente.getIngresosMensualesViabiliza());
		StringWriter writer = new StringWriter();
		template.merge(context, writer);
		return writer.toString();
	}

	private String putParametersVelocityConsumoPersonaNatural(Cliente cliente) {
		Template template = velocityEngine.getTemplate(TEMPLATES_REQUEST_CREATE_CASE_CONSUMO_PERSONA_NATURAL, "UTF-8");
		context.put("domain", serviciosProperties.getDomain());
		context.put("username", serviciosProperties.getUserName());
		context.put("consumoPersona", serviciosProperties.getConsumoPersona());
		context.put("documentnumber", cliente.getNumeroIdentificacion());
		context.put("typedocument", cliente.getTipodeidentificacion());
		context.put("apellido1", cliente.getApellido1());
		context.put("apellido2", cliente.getApellido2());
		context.put("nombre1", cliente.getNombre1());
		context.put("nombre2", cliente.getNombre2());

		context.put("fechanacimiento", cliente.getFechaNacimiento());
		context.put("telefono", cliente.getTelefonoResidencia());
		context.put("celular", cliente.getCelularPersonal());
		context.put("correo", cliente.getCorreoPersonal());
		context.put("ingresosmensuales", cliente.getIngresosMensuales());
		context.put("valorvehiculo", cliente.getValorSolicitado());
		context.put("autorizaCentrales", serviciosProperties.getAutorizaConsultaaCentrales());
		StringWriter writer = new StringWriter();
		template.merge(context, writer);
		return writer.toString();
	}
}
