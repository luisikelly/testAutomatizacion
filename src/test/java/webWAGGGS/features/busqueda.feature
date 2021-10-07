Feature: Busqueda en WAGGGS
  Como usuario web,
  Quiero buscar informacion,
  Para saber mas sobre le movimiento guia.

  @test @search
  Scenario: Busqueda Simple
    Given estoy en un navegador con la pagina inicial de WAGGGS
    When presiono icono busqueda
    And ingreso "Argentina" en el campo de busqueda
    And presiono boton ir
    Then el navegador me muestra los resultados de busqueda sobre "Argentina"

  @test @busqueda
  Scenario: Busqueda en seccion recursos
    Given estoy en un navegador con la pagina inicial de WAGGGS
    When presiono recursos
    And ingreso "Surf Smart" en el campo de busqueda de la seccion recursos
    And presiono boton busqueda
    Then el navegador me muestra los resultados de busqueda en recursos

