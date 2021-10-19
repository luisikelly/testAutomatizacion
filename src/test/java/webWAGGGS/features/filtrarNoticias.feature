Feature: Filtrar noticias en WAGGGS
  Como usuario web,
  Quiero buscar noticias de WAGGGS aplicando filtros,
  Para saber mas sobre le movimiento guia.

  @test @news
  Scenario: Filtrar por fecha
    Given estoy en un navegador con la pagina inicial de WAGGGS
    When presiono noticias
    #And selecciono filtrar noticias por region "Hemisferio Occidental"
   # Then el navegador me muestra los resultados de busqueda filtrados por region "Hemisferio Occidental"