Feature: Logueo en la página web del Banco
  Como persona natural
  Quiero acceder a la página del Banco
  Para revisar información de mis productos

  Background:
    Given el usuario ingresa a Sucursal Persona de la página del banco
  @Escenario1
  Scenario Outline: Inicio de sesión en la Sucursal Persona
    When  diligencia su usuario <user> y contraseña <password>
    Then  valida que el sistema redirige a la página <page> y muestra el mensaje <message>
  Examples:
    | user   | password | page             | message                      |
    | namaga | 1234     | Mis Productos    | Acceso correcto              |
    | namaga | 123456   | Inicio de sesión | Acceso denegado              |
    |        | 1234     | Inicio de sesión | Debe ingresar un usuario     |
    | namaga |          | Inicio de sesión | Debe ingresar una contraseña |
    #Ejecuta todas las instrucciones completas para cada fila - Varios casos de prueba

    @Escenario2
    Scenario: Login en Banca Personas
      When diligencia su usuario <user> y contraseña <password>
      | user       | password    |
      | correcto   | correcto    |
      | erroneo    | erroneo     |
      Then verifica el mensaje
      |Bienvenido a la App Personas   |
      |Error con el usuario y/o clave |
      #Ejecuta todo lo que esté en el When para cada fila de datos, y luego sí continúa con la ejecución
      # para verificar lo que están en el Then - Solo un caso de prueba
