#language:es
  Característica: Iniciar sesión en la página de Automation Testing
    Como Usuario
    Quiero Autenticarme en la página de Automation Testing
    Para Tener acceso a la App

  @LoginExitoso
  Escenario: Login Exitoso
    Dado que el usuario entra a la pagina AutomationTesting
    Cuando ingrese el usuario namaga777@gmail.com y la clave clave1234
    Entonces verifica el mensaje Hello