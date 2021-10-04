package webWAGGGS.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import webWAGGGS.bases.AppHook;
import webWAGGGS.pages.WAGGGSHomePage;
import webWAGGGS.pages.WAGGGSResourcesPage;

public class WAGGGSSteps {

    WAGGGSHomePage homePage = new WAGGGSHomePage(AppHook.getDriver(),AppHook.getWait());
    WAGGGSResourcesPage resourcesPage = new WAGGGSResourcesPage(AppHook.getDriver(),AppHook.getWait());
    String url = "https://www.wagggs.org/es/";
    String urlAGA = "https://www.wagggs.org/es/our-world/asociacion-guias-argentinas/";


    @Given("estoy en un navegador con la pagina inicial de WAGGGS")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_wagggs() {
        homePage.goToUrl(url);
        Assert.assertTrue(homePage.getUrl().contains("www.wagggs.org"));
    }

    @When("presiono icono busqueda")
    public void presiono_icono_busqueda() {
        homePage.clickSearchIcon();
    }

    @When("ingreso {string} en el campo de busqueda")
    public void ingreso_en_el_campo_de_busqueda(String string) {
        homePage.setTextSearch(string);
    }

    @When("presiono boton ir")
    public void presiono_boton_ir() {
        homePage.search();
    }

    @When("presiono recursos")
    public void presiono_recursos() {
        homePage.goToPage("RECURSOS");
    }

    @When("presiono boton busqueda")
    public void presiono_boton_busqueda() {
        resourcesPage.search();
    }

    @Then("el navegador me muestra los resultados de busqueda en recursos")
    public void el_navegador_me_muestra_los_resultados_de_busqueda_en_recursos() {
        Assert.assertTrue(resourcesPage.getUrl().contains("resource-listing/?search"));
    }

    @Then("el navegador me muestra los resultados de busqueda sobre {string}")
    public void el_navegador_me_muestra_los_resultados_de_busqueda_sobre(String string) {
        Assert.assertTrue(homePage.getUrl().contains("search/?q="+string));
    }

    @When("ingreso {string} en el campo de busqueda de la seccion recursos")
    public void ingresoEnElCampoDeBusquedaDeLaSeccionRecursos(String arg0) {
        resourcesPage.setSearchText(arg0);
    }


    @When("presiono boton de idioma {string}")
    public void presionoBotonDeIdioma(String arg0) {
        homePage.clickLanguage();
    }

    @When("selecciono idioma {string}")
    public void selecciono_idioma(String string) {
        homePage.selectLanguage(string);
    }

    @Then("el navegador me muestra la pagina en ingles")
    public void el_navegador_me_muestra_la_pagina_en_ingles() {
        Assert.assertTrue(homePage.getUrl().contains("/en"));
    }

}
