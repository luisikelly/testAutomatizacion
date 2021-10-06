Feature: Seleccionar ubicacion
  Como usuario web,
  Quiero seleccionar mi ubicacion en el sitio de GPS Farma,
  Para poder encontrar farmacias donde retirar mi compra.

  @test @location
  Scenario: Seleccionar ubicacion
    Given estoy en un navegador con la pagina inicial de GPS Farma
    When selecciono la provincia "Buenos Aires"
    And selecciono la ciudad "General Rodríguez"
    And presiono boton continuar
    Then el navegador me muestra la ubicacion seleccionada