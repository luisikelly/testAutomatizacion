Feature: Listar productos
  Como usuario web,
  Quiero listar los productos de GPS Farma por categoria,
  Para poder encontrar mas facilmente los productos que necesito.

  @test @list
  Scenario: Listar productos por categoria
    Given estoy en un navegador con la pagina inicial de GPSFarma
    And selecciono mi ubicacion
    When me posiciono en "CATEGORÍAS"
    And selecciono categoria "Maquillaje"
    Then el navegador me muestra los productos de la categoria "maquillaje"

  @test @order
  Scenario: Ordenar listado de productos aplicando filtro
  Given estoy en un navegador con la pagina inicial de GPSFarma
  And selecciono mi ubicacion
  When selecciono boton "Skincare" del menu
  And  selecciono el filtro ordenar por "Precio"
  Then el navegador me muestra el listado de productos listados por "Precio"
