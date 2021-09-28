package webDomestika.steps;

import io.cucumber.java.en.*;
import webDomestika.bases.AppHook;
import webDomestika.pages.DomestikaHomePage;
import org.junit.Assert;

public class DomestikaSteps {
    DomestikaHomePage home;
    String url = "https://www.domestika.org/es";
    String message = "";
    String nombreCurso;

    // ---------- GIVEN -------------------
    @Given("estoy en un navegador con la pagina inicial de Domestika")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_domestika() {
        home = new DomestikaHomePage(AppHook.getDriver(),AppHook.getWait());
        home.goToUrl(url);
    }

    @Given("Tengo algun curso en el carrito de compras")
    public void tengo_algun_curso_en_el_carrito_de_compras() {
        home.addToCartFromHomeAndGoToHome(0);
    }


    // ---------- WHEN -------------------
    @When("selecciono la seccion cursos")
    public void selecciono_la_seccion_cursos() {
        home.selectCourses();
        home.waitUrlContains("/courses");
        Assert.assertTrue(home.getUrl().contains("/courses"));
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

    @When("selecciono una Gift Card")
    public void selecciono_una_gift_card() {
        home.selectCategory("Tarjetas de regalo");
        home.waitUrlContains("/courses/gift-card");
        Assert.assertTrue(home.getUrl().contains("/courses/gift-card"));
    }
    @When("presiono el boton Regala un curso")
    public void presiono_el_boton_regala_un_curso() {
        home.addGiftCard();
        home.waitUrlContains("/cart/interstitial/gift_card/");
        Assert.assertTrue(home.getUrl().contains("/cart/interstitial/gift_card/"));
    }

    @When("selecciono el carrito de compras")
    public void selecciono_el_carrito_de_compras() {
        home.goToCart();
    }


    @When("presiono el boton agregar al carrito")
    public void presiono_el_boton_agregar_al_carrito() {
        home.setAddToCart();
    }
    @When("presiono el boton eliminar quitar del carrito")
    public void presiono_el_boton_eliminar_quitar_del_carrito() {
       message =  home.removeFromCart();
    }

    @When("selecciono el curso en la posicion {int} de la opciones sugeridas")
    public void seleccionoElCursoEnLaPosicionDeLaOpcionesSugeridas(int arg0) {
        home.selectCourseFromHome(arg0);
    }


    // ---------- THEN -------------------
    @Then("el navegador me muestra los cursos que coincidan con la busqueda")
    public void el_navegador_me_muestra_los_cursos_que_coincidan_con_la_busqueda() {
        home.waitUrlContains("?query=");
        Assert.assertTrue(home.getUrl().contains("?query="));
    }

    @Then("se quita el curso del carrito de compra")
    public void se_quita_el_curso_del_carrito_de_compra() {
        Assert.assertTrue(message.contains("Se ha eliminado"));
    }

    @Then("se agrega al carrito de compras")
    public void seAgregaAlCarritoDeCompras() {
        Assert.assertTrue(home.getUrl().contains("/cart/"));
    }

}
