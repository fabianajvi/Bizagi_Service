package co.com.santander.bizagi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "Cliente", description = "Dto that will have the customer data.")
public class Cliente {
	
	@ApiModelProperty(value = "Type of customer identification." , example = "cc")
    private String Tipodeidentificacion;
	
	@ApiModelProperty(value = "Customer identification number." , example = "10073728393")
    private int NumeroIdentificacion;
	
	@ApiModelProperty(value = "First last name of the customer." , example = "Gutierrez")
    private String Apellido1;
	
	@ApiModelProperty(value = "Second last name of the customer." , example = "Caro")
    private String Apellido2;
	
	@ApiModelProperty(value = "First name of the customer." , example = "Juan")
    private String Nombre1;
	
	@ApiModelProperty(value = "Second name of the customer." , example = "Angel")
    private String Nombre2;

	@ApiModelProperty(value = "Birthdate of the customer." , example = "1990-21-12")
    private String fechaNacimiento;
	
	@ApiModelProperty(value = "Number of telephone of the customer." , example = "33302220")
    private int telefonoResidencia;
	
	@ApiModelProperty(value = "Number of celphone of the customer." , example = "3211233344")
    private Long celularPersonal;
	
	@ApiModelProperty(value = "Email of the customer." , example = "fjend@gmail.com")
    private String correoPersonal;
	
	@ApiModelProperty(value = "Customer revenue." , example = "1200000")
    private int ingresosMensuales;
	
	@ApiModelProperty(value = "Requested value of the amount." , example = "20000000")
    private String valorSolicitado;

    //se añaden nuevos campos

	@ApiModelProperty(value = "Country of issue of the client's document." , example = "1")
    private int paisDeExpedicion;
	
	@ApiModelProperty(value = "Date of issue of the client's document." , example = "2010-22-12")
    private String fechaDeExpedicion;
	
	@ApiModelProperty(value = "Department code." , example = "012")
    private String idDepartamentos;
	
	@ApiModelProperty(value = "Place of issuance of the client's document." , example = "1")
    private int lugarDeExpedicion;
	
	@ApiModelProperty(value = "Client's country of birth." , example = "1")
    private int paisNacimiento;
	
	@ApiModelProperty(value = "Client's nationality." , example = "1")
    private int nacionalidad;
	
	@ApiModelProperty(value = "Place of birth" , example = "Bogota")
    private int lugarDeNacimiento;
	
	@ApiModelProperty(value = "Gender" , example = "1")
    private int genero;
	
	@ApiModelProperty(value = "Civil status." , example = "1")
    private int estadoCivil;
	
	@ApiModelProperty(value = "Stratum" , example = "1")
    private int estrato;
	
	@ApiModelProperty(value = "Country where you live." , example = "1")
    private int paisResidencia;
	
	@ApiModelProperty(value = "City where you live." , example = "Bogota")
    private String ciudadResidencia;
	
	@ApiModelProperty(value = "" , example = "calle")
    private String tipoViaResidencia;
	
	@ApiModelProperty(value = "" , example = "edificio")
    private String nombreViaResidencia;
	
	@ApiModelProperty(value = "" , example = "cll-34#54-09")
    private String direccionViaResidencia;
	
	@ApiModelProperty(value = "Economic activity" , example = "Empleado")
    private String actividadEconomica;
	
	@ApiModelProperty(value = "Type of economic activity" , example = "1")
    private int tipoDeActividad;
	
	@ApiModelProperty(value = "" , example = "Consultores S.A")
    private String empresaActualoActividad;
	
	@ApiModelProperty(value = "Nit of the company" , example = "11110092")
    private int nitEmpresa;
	
	@ApiModelProperty(value = "Actual charge" , example = "Jefe")
    private String cargoActualActividad;
	
	@ApiModelProperty(value = "Date of admission" , example = "2020-21-01")
    private String fechaDeIngreso;
	
	@ApiModelProperty(value = "Type of contract" , example = "1")
    private int tipoDeContrato;
	
	@ApiModelProperty(value = "Company country" , example = "1")
    private int paisEmpresa;
	
	@ApiModelProperty(value = "City company" , example = "1")
    private int ciudadEmpresaActividadActu;
	
	@ApiModelProperty(value = "Type of work route" , example = "calle")
    private String tipoViaLaboral;
	
	@ApiModelProperty(value = "Name of work route" , example = "")
    private String nombreViaLaboral;
	
	@ApiModelProperty(value = "Work address" , example = "calle 100 #45-90")
    private String direccionLaboral;
	
	@ApiModelProperty(value = "Number telephone of the work" , example = "2203982")
    private int telefonoLaboral;
	
	@ApiModelProperty(value = "" , example = "22")
    private int codigosCiiDian;
	
	@ApiModelProperty(value = "Number of the employee of the company" , example = "100")
    private int numeroDeEmpleados;
	
	@ApiModelProperty(value = "Company constitution date" , example = "1995-01-01")
    private String fechaDeConstitucionEmpresa;
	
	@ApiModelProperty(value = "" , example = "true")
    private Boolean poseeProductosDeMonedaExtr;
	
	@ApiModelProperty(value = "" , example = "true")
    private Boolean realizaOperacionesInternac;
	
	@ApiModelProperty(value = "Monthly expenses" , example = "1200000")
    private int egresosMensuales;
	
	@ApiModelProperty(value = "Assets" , example = "123")
    private int activos;
	
	@ApiModelProperty(value = "Passives" , example = "222")
    private int pasivos;
	
	@ApiModelProperty(value = "Additional income" , example = "5000000")
    private int ingresosAdicionales;
	
	@ApiModelProperty(value = "Description income addition" , example = "descripcion")
    private String descripcionIngresosAdicion;
	
	@ApiModelProperty(value = "" , example = "")
    private String clientePep;
	
	@ApiModelProperty(value = "Publicly exposed person" , example = "1")
    private int personaPubicamenteExpuesta;
	
	@ApiModelProperty(value = "" , example = "1")
    private int personaConReconPublico;
	
	@ApiModelProperty(value = "Requested quota approved" , example = "1")
    private int cupoSolicitadoAprobado;
	
	@ApiModelProperty(value = "Life insurance premium" , example = "1")
    private int primaSegurodeVida;
	
	@ApiModelProperty(value = "Type of credit" , example = "Activos")
    private String tipoDeCredito;
	
	@ApiModelProperty(value = "Consumption financing plan" , example = "")
    private String convenioConsumo;
	
	@ApiModelProperty(value = "Term" , example = "6")
    private String plazo;
	
	@ApiModelProperty(value = "" , example = "")
    private String planFinanciacionConsumo;
	
	@ApiModelProperty(value = "Payday" , example = "30")
    private String diaDePago;
	
	@ApiModelProperty(value = "Rate" , example = "15")
    private String tasa;
	
	@ApiModelProperty(value = "Subsidized plan" , example = "true")
    private Boolean planSubvencionado;
	
	@ApiModelProperty(value = "Subsidized value" , example = "")
    private String valorSubvecionado;
	
	@ApiModelProperty(value = "Authorization for contact by whatsapp" , example = "true")
    private Boolean autorizaContactoWhatsapp;
	
	@ApiModelProperty(value = "Reinstatement program" , example = "ok")
    private String programaReincorporacion;
	
	@ApiModelProperty(value = "Resolution number" , example = "1")
    private int numeroResolucion;
	
	@ApiModelProperty(value = "Resolution date" , example = "2020-12-23")
    private String fechaResolucion;
	
	@ApiModelProperty(value = "Dealership number" , example = "1")
    private int idConcesionarios;
	
	@ApiModelProperty(value = "Dealer account" , example = "")
    private String concesionarioCuenta;
	
	@ApiModelProperty(value = "Secure payment method" , example = "1")
    private int modalidadDePagoSeguro;
	
	@ApiModelProperty(value = "Authorization for automatic debit" , example = "true")
    private Boolean autorizacionDebitoAutomatico;
	
	@ApiModelProperty(value = "" , example = "1")
    private int bancoDebito;
	
	@ApiModelProperty(value = "Debit account number" , example = "11122224")
    private String numeroCuentaDebito;
	
	@ApiModelProperty(value = "account type" , example = "1")
    private int tipoDeCuenta;
	
	@ApiModelProperty(value = "Labor city." , example = "Bogota")
    private String ciudadLaboral;
	
	@ApiModelProperty(value = "Secure policy" , example = "ok")
    private Boolean tomaPolizaSeguro;
	
	@ApiModelProperty(value = "Car insurance premium" , example = "ok")
    private Boolean primaSeguroAutomovil;
	
	@ApiModelProperty(value = "" , example = "1")
	private int ingresosMensualesViabiliza;
}
