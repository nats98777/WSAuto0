#language:es
Característica: Registrarse en la página de Automation Testing
  Como Usuario
  Quiero Registrarme en la página de Automation Testing
  Para Tener acceso a la App

  @LoginExitoso
  Escenario: Registro Exitoso
    Dado que el usuario ingresa a la pagina AutomationTesting
    Cuando se registra con el usuario nmg1@gmail.com y la clave clave1234
    Entonces verifica en la pantalla el mensaje Hello nmg1