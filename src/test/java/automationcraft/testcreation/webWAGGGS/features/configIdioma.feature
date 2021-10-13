Feature: Cambio de idioma WAGGGS
  Como usuario web,
  Quiero personalizar la pagina en el idioma que hablo,
  Para poder navegar de la mejor manera en la web de WAGGGS.

  @test @language
  Scenario: Español a Ingles
    Given estoy en un navegador con la pagina inicial de WAGGGS
    When presiono boton de idioma "ESP"
    And selecciono idioma "ENG"
    Then el navegador me muestra la pagina en ingles