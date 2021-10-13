Feature: Crear pedido en carrito de compra
  Como usuario web,
  Quiero agregar un producto al carrito,
  Para realizar una compra.

  @test @addToCart
  Scenario: Agregar al carrito de compras
    Given estoy en un navegador con la pagina inicial de GPSFarma
    And selecciono mi ubicacion
    When selecciono producto "Plancha de Pelo Vapor My Pro B28 100"
    And presiono el boton agregar
    Then se añade al carrito de compra el producto "Plancha de Pelo Vapor My Pro B28 100"