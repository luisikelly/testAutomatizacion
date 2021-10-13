Feature: Login
  Como usuario web,
  Quiero ingresar a la web de Domestika,
  Para comprar y realizar cursos online.


#@login
 # Scenario: Login correcto
 #   Given estoy en un navegador con la pagina inicial de Domestika
 #   When presiono boton ingresar a la pagina de login
 #   And ingreso el texto "usuarioprueba102021@gmail.com" en el campo email
 #   And ingreso el texto "EstaEsUnaContraseñaDePrueba*" en el campo contraseña
 #   And presiono boton entrar
 #   Then ingreso a la pagina de Domestika como usuario registrado
 @login
  Scenario: Login con credenciales de acceso incorrectas
    Given estoy en un navegador con la pagina inicial de Domestika
    When presiono boton ingresar a la pagina de login
    And ingreso el texto "usuarioprueba102021@gmail.com" en el campo email
    And ingreso el texto "EstaEsUnaContraseñaIncorrecta" en el campo contraseña
    And presiono boton entrar
    Then el navegador muestra un mensaje de error
