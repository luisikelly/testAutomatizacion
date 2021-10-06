package webDafiti.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import webDafiti.bases.AppHook;
import webDafiti.pages.DafitiHomePage;
import webDafiti.pages.DafitiHomePageArg;
import webDafiti.pages.DafitiLoginPage;

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
    DafitiLoginPage loginPage = new DafitiLoginPage(AppHook.getDriver(),AppHook.getWait());

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


    @When("selecciono el producto {string}")
    public void selecciono_el_producto(String string) {
        homePageArg.selectProduct(string);
    }

    @When("presiono agregar al carrito")
    public void presiono_agregar_al_carrito() {
        homePageArg.addCart();
    }

    @When("selecciono flitrar por  talle {string}")
    public void selecciono_flitrar_por_talle(String string) {
        homePageArg.filterBySize(string);
    }
    @When("presiono boton aplicar")
    public void presiono_boton_aplicar() {
        homePageArg.applyFilterSize();
    }
    @When("ingreso en el campo mail {string}")
    public void ingreso_en_el_campo_mail(String string) {
        homePageArg.setTextNewletter(string);
    }

    @When("presiono boton {string}")
    public void presiono_boton(String string) {
        homePageArg.clickBtnNewsletter(string);
    }
    @When("presiono boton ingresar")
    public void presiono_boton_ingresar() {
       homePageArg.goToLogin();
       Assert.assertTrue(homePageArg.getUrl().contains("login"));
    }

    @When("ingreso {string} en el campo email")
    public void ingreso_en_el_campo_email(String string) {
        loginPage.setText(string,"email");
    }

    @When("presiono boton ingresar en la pagina de login")
    public void presiono_boton_ingresar_en_la_pagina_de_login() {
        loginPage.clickIngresar();
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
    @Then("se agrega al carrito de compras el producto")
    public void se_agrega_al_carrito_de_compras_el_producto() {
       homePageArg.cartBoxDisplayed();
    }

    @Then("el navegador me muestra los resultados de busqueda filtrados por talle {string}")
    public void el_navegador_me_muestra_los_resultados_de_busqueda_filtrados_por_talle(String string) {
        System.out.println(homePageArg.getUrl());
        Assert.assertTrue(homePageArg.getUrl().contains("size="+string));
    }
    @Then("el navegador me muestra mensaje de error {string}")
    public void el_navegador_me_muestra_mensaje_de_error(String string) {
        homePageArg.getMessageNewsletter(string);
    }

    @Then("el navegador me muestra mensaje de error {string} sobre el campo {string}")
    public void el_navegador_me_muestra_mensaje_de_error_sobre_el_campo(String string, String string2) {
        loginPage.validateMessageError(string,string2);
    }


}
