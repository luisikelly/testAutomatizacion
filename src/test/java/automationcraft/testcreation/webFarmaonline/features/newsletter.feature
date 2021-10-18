Feature: Suscripción al newsletter
  Como usuario web,
  Quiero suscribirse al newsletter de Farma online,
  Para poder recibir las ofertas en mi email.

  @test @newsletter @error
  Scenario: Suscripcion con email invalido
    Given estoy en un navegador con la pagina inicial de Farmaonline
    When ingreso "email invalido" en el campo email
    And presiono boton ok para confirmar suscripcion
    Then el navegador muestra indica direccion invalida