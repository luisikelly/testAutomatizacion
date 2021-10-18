package automationcraft.testcreation.webFarmaonline.steps;

import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.webFarmaonline.pages.FarmaonlineHomePage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class FarmaonlineSteps {
    FarmaonlineHomePage homePage;
    private final String url = "https://www.farmaonline.com/";

    // GIVEN

    @Given("estoy en un navegador con la pagina inicial de Farmaonline")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_farmaonline() {
        homePage = new FarmaonlineHomePage(DriverFactory.getDriver());
        homePage.goToUrl(url);
    }

    @Given("agrego producto al carrito")
    public void agregoProductoAlCarrito() {
        presionoElBotonAgregarDelProducto(0);
    }

    // WHEN

    @When("ingreso en el campo de busqueda el texto {string}")
    public void ingresoEnElCampoDeBusquedaElTexto(String arg0) {
        homePage.setTextSearch(arg0);
    }

    @When("presiono la tecla enter para realizar la busqueda")
    public void presiono_la_tecla_enter_para_realizar_la_busqueda() {
        homePage.search();
    }

    @When("presiono el boton agregar del producto de la posicion {int}")
    public void presionoElBotonAgregarDelProducto(int pos) {
        homePage.addToCart(pos);
    }

    @When("selecciono boton carrito de compras")
    public void seleccionoBotonCarritoDeCompras() {
        homePage.goToShoppingCart();
    }

    @When("presiono el boton quitar")
    public void presionoElBotonQuitar() {
        homePage.removeFromShoppingCart();
    }
    @When("selecciono categoria {string}")
    public void selecciono_categoria(String string) {
        homePage.selectCategory(string);
    }
    @When("me posiciono en {string}")
    public void me_posiciono_en(String string) {
        homePage.moveToCategory();
    }


    // THEN

    @Then("el navegador me muestra los resultados de busqueda de {string}")
    public void el_navegador_me_muestra_los_resultados_de_busqueda_de(String string) {
        Assert.assertTrue(homePage.getUrl().contains(string.toLowerCase()));
    }

    @Then("se añade al carrito de compra el producto")
    public void seAnadeAlCarritoDeCompraElProducto() {
        homePage.validateAddToCart();
    }

    @Then("el navegador me muestra el carrito de compras vacio")
    public void elNavegadorMeMuestraElCarritoDeComprasVacio() {
        homePage.validateRemove();
    }

    @Then("el navegador me muestra los productos de la categoria {string}")
    public void el_navegador_me_muestra_los_productos_de_la_categoria(String string) {
        Assert.assertTrue(homePage.getUrl().contains("categorias/"+string));
    }


    @When("presiono boton Ver Todos")
    public void presionoBotonVerTodos() {
        homePage.clickVerTodos();
    }

    @When("presiono el boton {string}")
    public void presionoElBoton(String string) {
        homePage.goToSection(string);
    }
}
