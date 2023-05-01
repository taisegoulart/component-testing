package dev.ifrs;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@QuarkusTest
public class ComponentTestingTest {

/*     @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    } */

    @Test
    @DisplayName("Cupom 10% off")
    public void testCoupon(){
        given()
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
        .body("value=1150.23&coupon=COUPON10")
        .when().post("/coupon").then()
           .statusCode(200)
           .body(is("103521"));  
    }
    @Test
    @DisplayName("Cupom 15% off")
    public void testCoupon15() {
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
            .body("value=1150.23&cupom=COUPON15")
            .when()
                .post("/coupon")
            .then()
                .statusCode(200)
                .body(is("97770"));
    }

    @Test
    @DisplayName("Cupom 100% off")
    public void testCoupon100() {
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
            .body("value=1150.23&cupom=COUPON100")
            .when()
                .post("/coupon")
            .then()
                .statusCode(200)
                .body(is("0"));
    }


    @Test
    @DisplayName("Valor nulo")
    public void testValueNull() {
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
            .body("valor=0&cupom=CUPOM10")
            .when()
                .post("/cupom")
            .then()
                .statusCode(200)
                .body(is("0"));
    }

    @Test
    @DisplayName("Valor caractere inválido")
    public void testValueInvalidAlphabetic() {
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED)
            .body("valor=AAA&cupom=CUPOM10")
            .when()
                .post("/cupom")
            .then()
                .statusCode(400);
    }

}