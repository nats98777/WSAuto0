package co.com.metis.definitions;

import co.com.metis.steps.LoginAutomationSteps;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class LoginAutomationDefinition {
    @Steps
    LoginAutomationSteps loginAutomationSteps;
    @Dado("^que el usuario entra a la pagina AutomationTesting$")
    public void que_el_usuario_entra_a_la_pagina_AutomationTesting() {
        loginAutomationSteps.abrirLaPagina();
    }


    @Cuando("^ingrese el usuario (.*) y la clave (.*)$")
    public void ingrese_el_usuario_y_la_clave(int arg1, int arg2) {
        //loginAutomationSteps.
    }

    @Entonces("^verifica el mensaje (.*)$")
    public void verifica_el_mensaje_de_login_exitoso() {

    }

}
