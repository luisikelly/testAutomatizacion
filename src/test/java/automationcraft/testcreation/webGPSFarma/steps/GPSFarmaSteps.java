package automationcraft.testcreation.webGPSFarma.steps;

import automationcraft.engine.database.MongoDBManage;
import automationcraft.engine.selenium.DriverFactory;
import automationcraft.testcreation.webGPSFarma.pages.GPSFarmaHomePage;
import automationcraft.testcreation.webGPSFarma.pages.GPSFarmaProductPage;
import io.cucumber.java.en.*;
import org.bson.Document;
import org.junit.Assert;

public class GPSFarmaSteps {
    String url = "https://gpsfarma.com/index.php/";
    GPSFarmaHomePage homePage;
    GPSFarmaProductPage productPage;

//GIVEN
    @Given("estoy en un navegador con la pagina inicial de GPSFarma")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_gps_farma() {
        homePage = new GPSFarmaHomePage(DriverFactory.getDriver());
        homePage.goToHome(url);
        Assert.assertEquals(url,homePage.getUrl());
    }


    @Given("selecciono mi ubicacion")
    public void selecciono_mi_ubicacion() {
        selecciono_la_provincia("Buenos Aires");
        selecciono_la_ciudad("General Rodríguez");
        presiono_boton_continuar();
    }

    //WHEN
    @When("selecciono la provincia {string}")
    public void selecciono_la_provincia(String string) {
        homePage.selectProvince(string);
    }

    @When("selecciono la ciudad {string}")
    public void selecciono_la_ciudad(String string) {
        homePage.selectCity(string);
    }

    @When("presiono boton continuar")
    public void presiono_boton_continuar() {
        homePage.submitLocation();
    }

    @When("me posiciono en {string}")
    public void me_posiciono_en(String string) {
        homePage.moveTo(string);
    }

    @When("selecciono categoria {string}")
    public void selecciono_categoria(String string) {
        homePage.selectCategory(string);
    }
    @When("selecciono boton {string} del menu")
    public void selecciono_boton_del_menu(String string) {
        homePage.selectMenu(string);
    }

    @When("selecciono el filtro ordenar por {string}")
    public void selecciono_el_filtro_ordenar_por(String string) {
       homePage.orderBy(string);
    }
    @When("ingreso en el campo de busqueda {string}")
    public void ingreso_en_el_campo_de_busqueda(String string) {
        homePage.setTextSearch(string);
    }

    @When("presiono la tecla enter")
    public void presiono_la_tecla_enter() {
        homePage.search();
    }
    @When("selecciono producto {string}")
    public void selecciono_producto(String string) {
        homePage.selectProduct(string);
        productPage = new GPSFarmaProductPage(DriverFactory.getDriver());
        Assert.assertEquals(string,productPage.getTitle());
    }

    @When("presiono el boton agregar")
    public void presiono_el_boton_agregar() {
       productPage.addToCart();
    }


    //THEN
    @Then("el navegador muestra la ubicacion elegida en la barra superior")
    public void el_navegador_muestra_la_ubicacion_elegida_en_la_barra_superior() {
        homePage.validateLocation();
    }

    @Then("el navegador me muestra los productos de la categoria {string}")
    public void el_navegador_me_muestra_los_productos_de_la_categoria(String string) {
        Assert.assertTrue(homePage.getUrl().contains("categorias/"+string));
    }


    @Then("el navegador me muestra los resultados de busqueda")
    public void el_navegador_me_muestra_los_resultados_de_busqueda() {
       Assert.assertTrue(homePage.getUrl().contains("result/?q="));
    }


    @Then("el navegador me muestra el listado de productos listados por {string}")
    public void elNavegadorMeMuestraElListadoDeProductosListadosPor(String arg0) {
        homePage.validateOrderBy(arg0);
    }

    @Then("se añade al carrito de compra el producto {string}")
    public void seAñadeAlCarritoDeCompraElProducto(String arg0) {
        productPage.validateAddToCart(arg0);
    }

}

