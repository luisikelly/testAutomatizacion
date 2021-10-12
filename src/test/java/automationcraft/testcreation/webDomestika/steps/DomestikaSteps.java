package automationcraft.testcreation.webDomestika.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import automationcraft.testcreation.webDomestika.bases.AppHook;
import automationcraft.testcreation.webDomestika.pages.DomestikaHomePage;
import org.junit.Assert;
import automationcraft.testcreation.webDomestika.pages.DomestikaProjectPage;
import automationcraft.testcreation.webDomestika.pages.DomestikaSupportPage;

public class DomestikaSteps {
    DomestikaHomePage homePage;
    DomestikaSupportPage supportPage;
    DomestikaProjectPage projectsPage;
    String url = "https://www.domestika.org/es";
    String message = "";
    String nombreCurso;

    // ---------- GIVEN -------------------
    @Given("estoy en un navegador con la pagina inicial de Domestika")
    public void estoy_en_un_navegador_con_la_pagina_inicial_de_domestika() {
        homePage = new DomestikaHomePage(AppHook.getDriver(),AppHook.getWait());
        homePage.goToUrl(url);
        Assert.assertEquals(url, homePage.getUrl());
    }

    @Given("Tengo algun curso en el carrito de compras")
    public void tengo_algun_curso_en_el_carrito_de_compras() {
        homePage.addToCartFromHomeAndGoToHome(0);
    }


    // ---------- WHEN -------------------
    @When("selecciono la seccion cursos")
    public void selecciono_la_seccion_cursos() {
        homePage.selectCourses();
        homePage.waitUrlContains("/courses");
        Assert.assertTrue(homePage.getUrl().contains("/courses"));
    }
    @When("selecciono la categoria {string} en la barra lateral")
    public void selecciono_la_categoria_en_la_barra_lateral(String string) {
        homePage.selectCategory(string);
    }
    @Then("el navegador me muestra los resultados de busqueda por categoria")
    public void el_navegador_me_muestra_los_resultados_de_busqueda_por_categoria() {
        homePage.waitUrlContains("/courses/category/");
        Assert.assertTrue(homePage.getUrl().contains("/courses/category/"));
    }

    @When("ingreso el nombre del curso {string}")
    public void ingreso_el_nombre_del_curso(String string) {
       Assert.assertEquals(string, homePage.setTextSearch(string));
    }


    @When("selecciono una Gift Card")
    public void selecciono_una_gift_card() {
        homePage.selectCategory("Tarjetas de regalo");
        homePage.waitUrlContains("/courses/gift-card");
        Assert.assertTrue(homePage.getUrl().contains("/courses/gift-card"));
    }
    @When("presiono el boton Regala un curso")
    public void presiono_el_boton_regala_un_curso() {
        homePage.addGiftCard();
        homePage.waitUrlContains("/cart/interstitial/gift_card/");
        Assert.assertTrue(homePage.getUrl().contains("/cart/interstitial/gift_card/"));
    }

    @When("selecciono el carrito de compras")
    public void selecciono_el_carrito_de_compras() {
        homePage.goToCart();
    }


    @When("presiono el boton agregar al carrito")
    public void presiono_el_boton_agregar_al_carrito() {
        homePage.setAddToCart();
    }
    @When("presiono el boton eliminar quitar del carrito")
    public void presiono_el_boton_eliminar_quitar_del_carrito() {
       message =  homePage.removeFromCart();
    }

    @When("selecciono el curso en la posicion {int} de la opciones sugeridas")
    public void seleccionoElCursoEnLaPosicionDeLaOpcionesSugeridas(int arg0) {
        homePage.selectCourseFromHome(arg0);
    }

    /***
     * Ir a pagina de login
     */
    @When("presiono boton ingresar a la pagina de login")
    public void presiono_boton_ingresar_a_la_pagina_de_login() {
        homePage.clickLogin();
    }

    /***
     *  @function Ingresar direccion de email
     * @param string direccion de email
     */
    @When("ingreso el texto {string} en el campo email")
    public void ingreso_el_texto_en_el_campo_email(String string) {
        homePage.setTextLogin(string,"email");
    }



    /***
     * @function Ingresar contraseña
     * @param string
     */
    @When("ingreso el texto {string} en el campo contraseña")
    public void ingreso_el_texto_en_el_campo_contraseña(String string) {
        homePage.setTextLogin(string,"password");
    }

    /***
     * @function Presionar boton entrar para ingresar a la pagina como usuario registrado
     */
    @When("presiono boton entrar")
    public void presiono_boton_entrar() {
        homePage.login();
    }


    // ---------- THEN -------------------
    @Then("el navegador me muestra los cursos que coincidan con la busqueda")
    public void el_navegador_me_muestra_los_cursos_que_coincidan_con_la_busqueda() {
        homePage.waitUrlContains("?query=");
        Assert.assertTrue(homePage.getUrl().contains("?query="));
    }

    @Then("se quita el curso del carrito de compra")
    public void se_quita_el_curso_del_carrito_de_compra() {
        Assert.assertTrue(message.contains("Se ha eliminado"));
    }

    @Then("se agrega al carrito de compras")
    public void seAgregaAlCarritoDeCompras() {
        Assert.assertTrue(homePage.getUrl().contains("/cart/"));
    }

    /***
     * Valida ingreso a la pagina como usuario registrado
     */
    @Then("ingreso a la pagina de Domestika como usuario registrado")
    public void ingreso_a_la_pagina_de_domestika_como_usuario_registrado() {
        Assert.assertTrue(homePage.getUrl().contains("auth/login"));
    }
    @Then("el navegador muestra un mensaje de error")
    public void el_navegador_muestra_un_mensaje_de_error() {
        homePage.loginErrorCredentials();
    }

    @When("me posiciono en los tres puntos")
    public void me_posiciono_en_los_tres_puntos() {
        homePage.moveToIconDots();
    }

    @When("selecciono {string}")
    public void selecciono(String string) {
        homePage.clickHelp();
        supportPage = new DomestikaSupportPage(AppHook.getDriver(),AppHook.getWait());
    }

    @When("ingreso {string} en la barra de busqueda")
    public void ingreso_en_la_barra_de_busqueda(String string) {
        supportPage.setSearchText(string);
    }

    @When("presiono enter")
    public void presiono_enter() {
        supportPage.pressEnterSearchBox(Keys.ENTER);
    }


    @Then("el navegador muestra las respuestas asociadas a la consulta")
    public void elNavegadorMuestraLasRespuestasAsociadasALaConsulta() {
        Assert.assertTrue(supportPage.getUrl().contains("search"));
        Assert.assertTrue(supportPage.getUrl().contains("query"));
    }

    @When("selecciono la seccion proyectos")
    public void selecciono_la_seccion_proyectos() {
        homePage.goToProjects();
        projectsPage = new DomestikaProjectPage(AppHook.getDriver(),AppHook.getWait());

    }

    @When("selecciono boton recientes")
    public void selecciono_boton_recientes() {
        projectsPage.filterProjects("Recientes");
    }

    @Then("el navegador me muestra los resultados de busqueda de proyectos mas recientes")
    public void el_navegador_me_muestra_los_resultados_de_busqueda_de_proyectos_mas_recientes() {
        Assert.assertTrue(projectsPage.getUrl().contains("projects/recent"));
    }

}
