Feature: Logueo en la página web del Banco
  Como persona natural
  Quiero acceder a la página del Banco
  Para revisar información de mis productos

  Background:
    Given el usuario ingresa a Sucursal Personas de la página del banco

  @Scenario1
  Scenario: Inicio de sesión exitoso en la Sucursal Persona
    When  diligencia sus credenciales de ingreso
    Then  accede de manera exitosa a su cuenta

  @Scenario2
  Scenario: Inicio de sesión fallido en la Sucursal Persona
    When  diligencia sus credenciales de ingreso, teniendo error en alguna
    Then  no puede acceder de manera exitosa a su cuenta