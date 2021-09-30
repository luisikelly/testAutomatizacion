Feature: Seleccionar país de operacion
  Como usuario web,
  Quiero seleccionar productos,
  Para realizar una compra.


  @test @compras @filter
  Scenario: Filtrar resultados de busqueda
    Given estoy en un navegador con la pagina inicial de Dafiti Argentina
    When selecciono la categoria "Mujer"
    And selecciono la seccion "Calzado"
    And selecciono flitrar por  talle "S"
    And presiono boton aplicar
    Then el navegador me muestra los resultados de busqueda filtrados por talle "S"

  @test @compras @addToCart
  Scenario: Agregar producto al carrito desde resultados
    Given estoy en un navegador con la pagina inicial de Dafiti Argentina
    When selecciono la categoria "Mujer"
    And selecciono la seccion "Accesorios"
    And selecciono el producto "Porta Celular Natural Tropea Tommy Magic Bag G"
    And presiono agregar al carrito
    Then se agrega al carrito de compras el producto