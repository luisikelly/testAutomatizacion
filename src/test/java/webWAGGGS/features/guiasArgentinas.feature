Feature: Navegar en seccion Guias Argentinas
  Como usuario web,
  Quiero navegar en la seccion de las guias argentinas,
  Para poder conocer mas como es en dicho pais.

  @test @language
  Scenario: Buscar Comunidades Guias
    Given estoy en un navegador con la seccion de la AGA en WAGGGGS
    When presiono boton comunidades guias
    And selecciono provincia "Buenos Aires"
    Then el navegador me muestra el mapa de comunidades guias