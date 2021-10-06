package webGPSFarma.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import webDomestika.pages.GPSFarmaProductPage;
import webGPSFarma.bases.AppHook;
import webGPSFarma.pages.GPSFarmaHomePage;

public class GPSFarmaSteps {

    GPSFarmaHomePage homePage;
    GPSFarmaProductPage productPage;
    String prov;
    String ciudad;
    String url = "https://gpsfarma.com/index.php/";
    /***
     * ------------ GIVEN -----------------
     */

    @Given("estoy en un navegador con la pagina inicial de GPS Farma")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_gps_farma() {
        homePage = new GPSFarmaHomePage(AppHook.getDriver(), AppHook.getWait());
        homePage.goToUrl(url);
    }
    @Given("selecciono mi ubicacion")
    public void selecciono_mi_ubicacion() {
       selecciono_la_provincia("Buenos Aires");
       selecciono_la_ciudad("General Rodríguez");
       presiono_boton_continuar();
    }

    /***
     * ------------ WHEN -----------------
     */

    @When("presiono boton carrito de compras")
    public void presiono_boton_carrito_de_compras() {
        homePage.goToCart();
    }
    @When("presiono boton quitar del carrito el producto {string}")
    public void presiono_boton_quitar_del_carrito_el_producto(String string) {
        homePage.removeFromCart(string);
    }
    @When("presiono aceptar")
    public void presiono_aceptar() {
        homePage.acceptRemove();
    }
    @When("selecciono la categoria {string}")
    public void selecciono_la_categoria(String string) {
        homePage.selectCategory(string);
    }
    @When("presiono enter")
    public void presiono_enter() {
        homePage.search();
    }
    @When("presiono agregar carrito el producto {string}")
    public void presiono_agregar_carrito_el_producto(String string) {
        homePage.addToCartFromHome(string);
    }
    @When("ingreso el texto {string} en la barra de busqueda")
    public void ingreso_el_texto_en_la_barra_de_busqueda(String string) {
        homePage.setSearchText(string);
    }

    @When("selecciono la provincia {string}")
    public void selecciono_la_provincia(String string) {
        homePage.selectProvince(string);
        prov = string;
    }

    @When("selecciono la ciudad {string}")
    public void selecciono_la_ciudad(String string) {
       homePage.selectCity(string);
       ciudad = string;
    }

    @When("presiono boton continuar")
    public void presiono_boton_continuar() {
        homePage.sendLocation();
    }

    /***
     * ------------ THEN -----------------
     */

    @Then("el navegador me muestra la ubicacion seleccionada")
    public void el_navegador_me_muestra_la_ubicacion_seleccionada() {
        homePage.confirmLocation(prov,ciudad);
    }
    @Then("se quito el producto del carrito")
    public void se_quito_el_producto_del_carrito() {
        //TODO Validacion
    }

    @Then("el navegador me muestra el listado de productos de la categoria {string}")
    public void el_navegador_me_muestra_el_listado_de_productos_de_la_categoria(String string) {
        Assert.assertTrue(homePage.getUrl().contains("categorias/"+string));
    }

    @Then("se agrega al carrito de compras {string}")
    public void se_agrega_al_carrito_de_compras(String string) {
        productPage.confirmAddToCart(string);
    }

    @Then("el navegador me muestra los resultados de busqueda")
    public void el_navegador_me_muestra_los_resultados_de_busqueda() {
        Assert.assertTrue(homePage.getUrl().contains("result/?q="));
    }

    @And("agrego producto al carrito de compras {string}")
    public void agregoProductoAlCarritoDeCompras(String arg0) {
        presiono_agregar_carrito_el_producto(arg0);
    }

    @When("selecciono producto {string}")
    public void seleccionoProducto(String arg0) {
        homePage.selectProduct(arg0);
        productPage = new GPSFarmaProductPage(AppHook.getDriver(),AppHook.getWait());
    }

    @And("presiono agregar carrito el producto")
    public void presionoAgregarCarritoElProducto() {
        productPage.addToCart();
    }

    @When("selecciono seccion {string}")
    public void selecciono_seccion(String string) {
        homePage.selectSection(string);
    }

    @When("selecciono ordenar por {string}")
    public void selecciono_ordenar_por(String string) {
       homePage.orderBy(string);
    }

    @Then("el navegador me muestra los productos ordenadados por {string} de la categoria {string}")
    public void el_navegador_me_muestra_los_productos_ordenadados_por(String string, String string2) {
        String filterOrder ="";
        switch (string){
            case "Precio": filterOrder = "?product_list_order=price";
                break;
            case "Promoción": filterOrder="?product_list_order=gps_catalog_promo";
                break;
            case "Posición": filterOrder ="?product_list_order=position";
                break;
        }
        Assert.assertEquals("https://gpsfarma.com/index.php/"+string2+".html"+filterOrder,homePage.getUrl());
    }


}
