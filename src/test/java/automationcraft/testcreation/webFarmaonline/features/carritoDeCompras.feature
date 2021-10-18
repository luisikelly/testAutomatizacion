Feature: Crear pedido en carrito de compra
Como usuario web,
Quiero crear mi pedido,
Para realizar una compra.

  @test @addToCart @shoppingCart
  Scenario: Agregar producto al carrito de compras
  Given estoy en un navegador con la pagina inicial de Farmaonline
  When presiono el boton "Solares"
  And presiono boton Ver Todos
  And presiono el boton agregar del producto de la posicion 1
  Then se añade al carrito de compra el producto

  @test @removeToCart @shoppingCart
  Scenario: Quitar producto del carrito de compras
    Given estoy en un navegador con la pagina inicial de Farmaonline
    And agrego producto al carrito
    When selecciono boton carrito de compras
    And presiono el boton quitar
    Then el navegador me muestra el carrito de compras vacio