Feature: Seleccionar país de operacion
  Como usuario web,
  Quiero seleccionar productos,
  Para realizar una compra.

  @test @compras @removeCart
  Scenario: Eliminar elemento del carrito de compra
    Given estoy en un navegador con la pagina inicial de Dafiti Argentina
    And tengo un producto en el carrito de compras
    When selecciono el boton carrito de compras
    And presiono  el boton eliminar del carrito
    Then el carrito de compras esta vacio

  @test @compras @addToCart
  Scenario: Agregar producto al carrito
    Given estoy en un navegador con la pagina inicial de Dafiti Argentina
    When selecciono la categoria "Mujer"
    And selecciono la seccion "Calzado"
    And seleccion el producto "Zueco Violeta Crocs Crocband"
    And selecciono talle "37"
    And presiono boton comprar
    Then se agrega al carrito de compras el producto "Zueco Violeta Crocs Crocband"