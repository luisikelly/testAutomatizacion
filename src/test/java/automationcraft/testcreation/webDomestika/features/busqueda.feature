Feature: Busqueda de cursos en Domestika
    Como usuario web,
    Quiero buscar cursos en el sitio de Domestika
    Para realizar una compra.

  @test @busqueda
  Scenario: Busqueda por categoria
    Given estoy en un navegador con la pagina inicial de Domestika
    When selecciono la seccion cursos
    And selecciono la categoria "Diseño Web y App" en la barra lateral
    Then el navegador me muestra los resultados de busqueda por categoria

   @test @busqueda
   Scenario: Busqueda por nombre
     Given estoy en un navegador con la pagina inicial de Domestika
     When ingreso el nombre del curso "Fundamentos del Community Management"
   #  And realizo la busqueda presionando buscar
     Then el navegador me muestra los cursos que coincidan con la busqueda

  @test @busqueda @support
  Scenario: Busqueda en seccion soporte
    Given estoy en un navegador con la pagina inicial de Domestika
    When me posiciono en los tres puntos
    And selecciono "Ayuda"
    And ingreso "como comprar" en la barra de busqueda
    And presiono enter
    Then el navegador muestra las respuestas asociadas a la consulta