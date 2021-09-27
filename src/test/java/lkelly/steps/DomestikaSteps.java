package lkelly.steps;

import io.cucumber.java.en.*;
import lkelly.bases.AppHook;
import lkelly.pages.DomestikaHomePage;
import org.junit.Assert;

public class DomestikaSteps {
    DomestikaHomePage home;
    String url = "https://www.domestika.org/es";

    @Given("estoy en un navegador con la pagina inicial de Domestika")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_domestika() {
        home = new DomestikaHomePage(AppHook.getDriver(),AppHook.getWait());
        home.goToUrl(url);
    }

    @When("selecciono la seccion cursos")
    public void selecciono_la_seccion_cursos() {
        home.selectCourses();
    }
    @When("selecciono la categoria {string} en la barra lateral")
    public void selecciono_la_categoria_en_la_barra_lateral(String string) {
        home.selectCategory(string);
    }
    @Then("el navegador me muestra los resultados de busqueda por categoria")
    public void el_navegador_me_muestra_los_resultados_de_busqueda_por_categoria() {
        home.waitUrlContains("/courses/category/");
        Assert.assertTrue(home.getUrl().contains("/courses/category/"));
    }

    @When("ingreso el nombre del curso {string}")
    public void ingreso_el_nombre_del_curso(String string) {
       home.setTextSearch(string);
    }
    @When("realizo la busqueda presionando buscar")
    public void realizo_la_busqueda_presionando_buscar() {
        home.search();
    }
    @Then("el navegador me muestra los cursos que coincidan con la busqueda")
    public void el_navegador_me_muestra_los_cursos_que_coincidan_con_la_busqueda() {
        home.waitUrlContains("?query=");
        Assert.assertTrue(home.getUrl().contains("?query="));
    }
    @When("selecciono una Gift Card")
    public void selecciono_una_gift_card() {
        home.selectCourse("Tarjetas de regalo");
    }
    @When("presiono el boton Regala un curso")
    public void presiono_el_boton_regala_un_curso() {
        home.addGiftCard();
    }
    @When("selecciono el carrito de compras")
    public void selecciono_el_carrito_de_compras() {

    }
    @When("selecciono el curso {string}")
    public void selecciono_el_curso(String string) {

    }
    @When("se carga la pagina del curso {string}")
    public void se_carga_la_pagina_del_curso(String string) {

    }
    @When("presiono el boton agregar al carrito")
    public void presiono_el_boton_agregar_al_carrito() {

    }

    @Then("se agrega al carrito de compras")
    public void se_agrega_al_carrito_de_compras() {

    }
    @Then("se quita el curso del carrito de compra")
    public void se_quita_el_curso_del_carrito_de_compra() {

    }

}
