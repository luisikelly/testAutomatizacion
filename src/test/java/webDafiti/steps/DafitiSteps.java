package webDafiti.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import webDafiti.bases.AppHook;
import webDafiti.pages.DafitiHomePage;
import webDafiti.pages.DafitiHomePageArg;

/***
 * @author Luisina.Kelly
 * @version 1
 */
public class DafitiSteps {

    final static String urlDafiti = "http://www.dafiti.com";
    final static String argentina = ".ar";
    final static String chile = ".cl";
    final static String brasil = ".br";
    final static String colombia = ".co";
    DafitiHomePage homePage = new DafitiHomePage(AppHook.getDriver(), AppHook.getWait());
    DafitiHomePageArg homePageArg = new DafitiHomePageArg(AppHook.getDriver(), AppHook.getWait());


    // -------------- GIVEN --------------

    /***
     *  Carga de la url de Dafiti www.dafiti.com
     */
    @Given("estoy en un navegador con la pagina inicial de Dafiti")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_dafiti() {
        homePage.goToUrl(urlDafiti);
    }

    @Given("estoy en un navegador con la pagina inicial de Dafiti Argentina")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_dafiti_argentina() {
        homePage.goToUrl(urlDafiti);
        elijo_comprar_en("Argentina");
    }
    @Given("tengo un producto en el carrito de compras")
    public void tengo_un_producto_en_el_carrito_de_compras() {
        selecciono_la_categoria("Mujer");
        selecciono_la_seccion("Accesorios");
        homePageArg.addCart(0);
    }


    // -------------- WHEN --------------

    /***
     * Elegir país de operacion
      * @param string Nombre del país
     */

    @When("elijo comprar en {string}")
    public void elijo_comprar_en(String string) {
        homePage.selectCountry(string);
    }


    @When("ingreso el texto {string} en el campo de busqueda")
    public void ingreso_el_texto_en_el_campo_de_busqueda(String string) {
       homePageArg.setTextSearch(string);
    }

    @When("presiono el boton buscar")
    public void presiono_el_boton_buscar() {
        homePageArg.search();
    }

    @When("selecciono la categoria {string}")
    public void selecciono_la_categoria(String string) {
        homePageArg.selectCategory(string);
    }

    @When("selecciono la seccion {string}")
    public void selecciono_la_seccion(String string) {
        homePageArg.selectSection(string);
    }

    @When("selecciono el boton carrito de compras")
    public void selecciono_el_boton_carrito_de_compras() {
        homePageArg.goToCart();
    }

    @When("presiono  el boton eliminar del carrito")
    public void presiono_el_boton_eliminar_del_carrito() {
        homePageArg.removeCart(0)
        ;
    }

    @When("seleccion el producto {string}")
    public void seleccion_el_producto(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("selecciono talle {string}")
    public void selecciono_talle(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("presiono boton comprar")
    public void presiono_boton_comprar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    // -------------- THEN --------------

    /***
     * Verifica que se muestre la web del país seleccionado
     * @param string Nombre del país seleccionado
     */
    @Then("el navegador me muestra el home de Dafiti {string}")
    public void el_navegador_me_muestra_el_home_de_dafiti(String string) {
        String country = "";
        switch (string){
            case "Argentina": country = argentina;
                break;
            case "Chile": country = chile;
                break;
            case "Brasil": country = brasil;
                break;
            case "Colombia": country = colombia;
                break;
            default: throw new IllegalStateException("Unexpected value: " + country);
        }
        Assert.assertTrue(homePage.getUrl().contains(country));
    }


    @Then("el navegador me muestra los resultados de busqueda por nombre")
    public void el_navegador_me_muestra_los_resultados_de_busqueda_por_nombre() {
        Assert.assertTrue(homePageArg.getUrl().contains("catalog"));
    }
    @Then("el navegador me muestra los productos disponibles en la seccion {string} de la categoria {string}")
    public void el_navegador_me_muestra_los_productos_disponibles_en_la_seccion_de_la_categoria(String string, String string2) {
        Assert.assertTrue(homePageArg.getUrl().contains(string));
        Assert.assertTrue(homePageArg.getUrl().contains(string2));
    }
    @Then("se agrega al carrito de compras el producto {string}")
    public void se_agrega_al_carrito_de_compras_el_producto(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("el carrito de compras esta vacio")
    public void el_carrito_de_compras_esta_vacio() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
