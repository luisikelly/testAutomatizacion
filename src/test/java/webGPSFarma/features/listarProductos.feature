Feature: Listar productos
  Como usuario web,
  Quiero ver catalogo de productos en el sitio de GPS Farma,
  Para realizar una compra.

  @test @category
  Scenario: Listar por Categoria
    Given estoy en un navegador con la pagina inicial de GPS Farma
    And selecciono mi ubicacion
    When selecciono la categoria "Maquillaje"
    Then el navegador me muestra el listado de productos de la categoria "maquillaje"

  @test @order
  Scenario: Ordenar listado de productos
    Given estoy en un navegador con la pagina inicial de GPS Farma
    And selecciono mi ubicacion
    When selecciono seccion "Skincare"
    And selecciono ordenar por "Precio"
    Then el navegador me muestra los productos ordenadados por "Precio" de la categoria "skincare"
