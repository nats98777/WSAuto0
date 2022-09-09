@Feature
Feature: Acceder al aplicativo METIS
  Como Usuario
  Quiero Autenticarme en METIS
  Para Tener acceso a la App

  @LoginExitoso
  Scenario: Login exitoso en METIS
    Given el Usuario quiere ingresar a METIS
    When escribe el usuario prueba y la clave password
    Then ve el mensaje Bootstrap-Admin-Template