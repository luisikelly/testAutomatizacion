Feature: Crear pedido de compra
  Como usuario web,
  Quiero realizar un pedido,
  Para realizar una compra en GPS Farma

  @test @addToCart @compras
  Scenario: Agregar producto al carrito de compras desde pagina del producto
    Given estoy en un navegador con la pagina inicial de GPS Farma
    And selecciono mi ubicacion
    When selecciono producto "Dermaglós Facial Tónico Hidratante"
    And presiono agregar carrito el producto
    Then se agrega al carrito de compras "Dermaglós Facial Tónico Hidratante"


  Scenario: Eliminar producto del carrito de compras
    Given estoy en un navegador con la pagina inicial de GPS Farma
    And selecciono mi ubicacion
    And agrego producto al carrito de compras "Vogue Resist Romantica labial líquido x 3ml"
    When presiono boton carrito de compras
    And presiono boton quitar del carrito el producto "Vogue Resist Romantica labial líquido x 3ml"
    And presiono aceptar
    Then se quito el producto del carrito