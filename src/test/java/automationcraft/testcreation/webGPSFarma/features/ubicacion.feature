Feature: Seleccionar ubicacion
  Como usuario web,
  Quiero elegir mi ubicacion,
  Para poder encontrar las farmacias para realizar mi compra.

  @test @location
  Scenario: Seleccionar ubicacion
    Given estoy en un navegador con la pagina inicial de GPSFarma
    When selecciono la provincia "Buenos Aires"
    And selecciono la ciudad "General Rodríguez"
    And presiono boton continuar
    Then el navegador muestra la ubicacion elegida en la barra superior