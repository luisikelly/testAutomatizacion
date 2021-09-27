Feature: Busqueda de cursos en Domestika
    Como usuario web,
    Quiero buscar cursos en el sitio de Domestika
    Para realizar una compra.

  @test
  Scenario: Busqueda por categoria
    Given estoy en un navegador con la pagina inicial de Domestika
    When selecciono la  seccion cursos
    And selecciono la categoria "Diseño Web y App"
    Then el navegador me muestra los resultados de busqueda

   @test
   Scenario: Busqueda por categoria
     Given estoy en un navegador con la pagina inicial de Domestika
     When ingreso el nombre del curso "Fundamentos del Community Management"
     And realizo la busqueda presionando la lupita
     Then el navegador me muestra los resultados de busqueda