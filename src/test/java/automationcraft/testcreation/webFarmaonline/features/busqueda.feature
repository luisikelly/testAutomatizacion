Feature: Busqueda en Farmaonline
  Como usuario web,
  Quiero bsucar productos en la web de Farmaonline,
  Para realizar una compra.

  @test @search
  Scenario: Busqueda Simple
    Given estoy en un navegador con la pagina inicial de Farmaonline
    When ingreso en el campo de busqueda el texto "Shampoo"
    And presiono la tecla enter para realizar la busqueda
    Then el navegador me muestra los resultados de busqueda de "Shampoo"

      @test @search @withdrawalPoint
  Scenario: Busqueda de puntos de retiro
  Given estoy en un navegador con la pagina inicial de Farmaonline
  When presionar botón puntos de retiro
  And ingreso "Buenos Aires" en el campo de busqueda.
  And presiono la tecla enter para buscar puntos de retiro
  Then el navegador me muestra los resultados de busqueda de puntos de retiro
