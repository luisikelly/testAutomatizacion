Feature: Realizar orden de compra en Domestika
    Como usuario web,
    Quiero realizar una orden de compraen el sitio de Domestika
    Para realizar una compra.

  @test @compras
  Scenario: Agregar tarjeta de regalo al carrito de compra
    Given estoy en un navegador con la pagina inicial de Domestika
    When selecciono la  seccion cursos
    And selecciono una Gift Card
    And presiono el boton Regala un curso
    Then se agrega al carrito de compras

  @test @compras
  Scenario: Eliminar elemento del carrito de compra
    Given estoy en un navegador con la pagina inicial de Domestika
    When selecciono el carrito de compras
    And presiono el boton eliminar para el curso
    Then se quita el curso del carrito de compra

  @test @compras
  Scenario: Agregar curso al carrito
    Given estoy en un navegador con la pagina de Domestika en la seccion cursos
    When selecciono el curso "Dibujo para principiantes nivel-1"
    And se carga la pagina del curso ""
    And presiono el boton agregar al carrito
    Then se agrega al carrito de compra