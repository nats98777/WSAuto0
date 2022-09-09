package co.com.metis.steps;

import co.com.metis.pageobjects.LoginAutomationPage;
import net.thucydides.core.annotations.Step;

public class LoginAutomationSteps {
    LoginAutomationPage loginAutomationPage;

    @Step
    public void abrirLaPagina() {
        loginAutomationPage.open();
    }



}
