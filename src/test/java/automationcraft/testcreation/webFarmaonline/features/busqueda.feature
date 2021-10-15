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