Feature: Listar productos en Farmaonline
  Como usuario web,
  Quiero listar productos por categoria,
  Para poder encontrar el producto que necesito.


  Scenario: Listar por categoria
    Given estoy en un navegador con la pagina inicial de Farmaonline
    When me posiciono en "CATEGORÍAS"
    And selecciono categoria "Hogar"
    Then el navegador me muestra los productos de la categoria "hogar"