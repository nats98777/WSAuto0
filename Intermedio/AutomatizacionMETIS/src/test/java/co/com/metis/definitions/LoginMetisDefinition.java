package co.com.metis.definitions;

import co.com.metis.steps.LoginMetisSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginMetisDefinition {
    @Steps
    LoginMetisSteps loginMetisSteps;

    @Given("^el Usuario quiere ingresar a METIS$")
    public void elUsuarioQuiereIngresarAMETIS() {
        loginMetisSteps.abrirLaPagina();
    }


    @When("^escribe el usuario prueba y la clave password$")
    public void escribeElUsuarioPruebaYLaClavePassword() {
        loginMetisSteps.realizarLaAutenticacion();
    }

    @Then("^ve el mensaje Bootstrap-Admin-Template$")
    public void veElMensajeBootstrapAdminTemplate() {
        loginMetisSteps.verificarElAccesoExitoso();
    }

}
