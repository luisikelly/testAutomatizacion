Feature: Busqueda en Dafiti
  Como usuario web,
  Quiero ingresar como usuario a Dafiti Argentina,
  Para realizar una compra.

  @test @login
  Scenario: Login con email invalido
    Given estoy en un navegador con la pagina inicial de Dafiti Argentina
    When presiono boton ingresar
    And ingreso "direccionDeCorreoInvalida" en el campo email
    And presiono boton ingresar en la pagina de login
    Then  el navegador me muestra mensaje de error "Ingrese una dirección de mail válida" sobre el campo "email"
