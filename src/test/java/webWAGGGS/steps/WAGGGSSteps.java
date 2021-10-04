package webWAGGGS.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import webWAGGGS.bases.AppHook;
import webWAGGGS.pages.WAGGGSGuiasArgentinasPage;
import webWAGGGS.pages.WAGGGSHomePage;
import webWAGGGS.pages.WAGGGSNewsPage;
import webWAGGGS.pages.WAGGGSResourcesPage;

public class WAGGGSSteps {

    WAGGGSHomePage homePage;
    WAGGGSResourcesPage resourcesPage;
    WAGGGSNewsPage newsPage;
    WAGGGSGuiasArgentinasPage agaPage;

    String url = "https://www.wagggs.org/es/";
    String urlAGA = "https://www.wagggs.org/es/our-world/asociacion-guias-argentinas/";


    @Given("estoy en un navegador con la pagina inicial de WAGGGS")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_wagggs() {
        homePage= new WAGGGSHomePage(AppHook.getDriver(),AppHook.getWait());
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
        resourcesPage = new WAGGGSResourcesPage(AppHook.getDriver(),AppHook.getWait());
        Assert.assertTrue(resourcesPage.getUrl().contains("resources"));
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

    @When("presiono noticias")
    public void presiono_noticias() {
        homePage.goToNews();
        newsPage = new WAGGGSNewsPage(AppHook.getDriver(),AppHook.getWait());
        Assert.assertTrue(newsPage.getUrl().contains("news"));
    }

    @When("selecciono filtrar noticias por region {string}")
    public void selecciono_filtrar_noticias_por_region(String string) {
        newsPage.selectRegionFilter(string);
    }

    @Then("el navegador me muestra los resultados de busqueda filtrados por region {string}")
    public void el_navegador_me_muestra_los_resultados_de_busqueda_filtrados_por_region(String string) {
        String region =  "region=";
        switch (string){
            case "Global": region = region + "global";
                break;
            case "África": region = region + "africa";
                break;
            case "Árabe": region = region + "arab";
                break;
            case "Asia-Pacífico": region = region + "asia_pacific";
                break;
            case "Europa": region = region + "europe";
                break;
            case "Hemisferio Occidental": region = region + "western_hemisphere";
                break;
            }
        Assert.assertTrue(newsPage.getUrl().contains(region));
    }

    @Given("estoy en un navegador con la seccion de la AGA en WAGGGGS")
    public void estoy_en_un_navegador_con_la_seccion_de_la_aga_en_waggggs() {
        agaPage = new WAGGGSGuiasArgentinasPage(AppHook.getDriver(),AppHook.getWait());
        agaPage.goToUrl(urlAGA);
    }

    @When("presiono boton comunidades guias")
    public void presiono_boton_comunidades_guias() {
        agaPage.goToCommunities();
    }

    @When("selecciono provincia {string}")
    public void selecciono_provincia(String string) {
        agaPage.selectProvince(string);
    }

    @Then("el navegador me muestra el mapa de comunidades guias")
    public void el_navegador_me_muestra_el_mapa_de_comunidades_guias() {
        Assert.assertTrue(agaPage.getUrl().contains("www.google.com/maps"));
    }


}
