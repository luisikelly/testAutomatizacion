Feature: Realizar pedido
  Como usuario web,
  Quiero seleccionar productos,
  Para realizar una compra.


  #@test @compras @addToCart
  Scenario: Agregar producto al carrito desde resultados
    Given estoy en un navegador con la pagina inicial de Dafiti Argentina
    When selecciono la categoria "Mujer"
    And selecciono la seccion "Accesorios"
    And selecciono el producto "Porta Celular Natural Tropea Tommy Magic Bag G"
    And presiono agregar al carrito
    Then se agrega al carrito de compras el producto