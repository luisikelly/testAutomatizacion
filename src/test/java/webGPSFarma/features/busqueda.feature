Feature: Busqueda en GPS Farma
  Como usuario web,
  Quiero buscar productos en el sitio de GPS Farma
  Para realizar una compra.

  @test @search
  Scenario: Busqueda Simple
    Given estoy en un navegador con la pagina inicial de GPS Farma
    And selecciono mi ubicacion
    When ingreso el texto "protector solar" en la barra de busqueda
    And presiono enter
    Then el navegador me muestra los resultados de busqueda