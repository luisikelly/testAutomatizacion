Feature: Navegar por seccion proyectos en Domestika
  Como usuario web,
  Quiero proyectos realizados en el sitio de Domestika
  Para ver que tipo de proyectos realizan los alumnos de los cursos.

 @projects
  Scenario: Filtrar por mas recientes
    Given estoy en un navegador con la pagina inicial de Domestika
    When selecciono la seccion proyectos
    And selecciono boton recientes
    Then el navegador me muestra los resultados de busqueda de proyectos mas recientes
