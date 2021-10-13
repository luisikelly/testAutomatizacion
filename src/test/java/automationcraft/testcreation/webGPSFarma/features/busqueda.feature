Feature: Busqueda en GPS Farma
  Como usuario web,
  Quiero bsucar productos en la web de GPS Farma,
  Para realizar una compra.

  @test @search
  Scenario: Busqueda Simple
    Given estoy en un navegador con la pagina inicial de GPSFarma
    And selecciono mi ubicacion
    When ingreso en el campo de busqueda "protector solar"
    And presiono la tecla enter
    Then el navegador me muestra los resultados de busqueda