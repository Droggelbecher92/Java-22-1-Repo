package de.kittlaus.java221.anotherShop;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductModelControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    //Testobjekte
    final private ProductModel testProduct = new ProductModel("Kartoffel","test");
    final private ProductModel testProduct2 = new ProductModel("Mango","test2");

    @Order(1)
    @Test
    void shouldAddNewProduct(){
        //GIVEN
        //WHEN
        ResponseEntity<ProductModel> actual = testRestTemplate.postForEntity("/products", testProduct, ProductModel.class);
        //THEN
        assertEquals(HttpStatus.OK,actual.getStatusCode());
        assertEquals(testProduct,actual.getBody());

    }

    @Order(2)
    @Test
    void shouldReturnAllProducts(){
        //GIVEN
        testRestTemplate.postForEntity("/products",testProduct2, ProductModel.class);
        //WHEN
        ResponseEntity<ProductModel[]> actual = testRestTemplate.getForEntity("/products", ProductModel[].class);
        //THEN
        assertEquals(HttpStatus.OK,actual.getStatusCode());
        assertTrue(actual.getBody().length==2);
        assertTrue(Arrays.stream(actual.getBody()).toList().contains(testProduct));
        assertTrue(Arrays.stream(actual.getBody()).toList().contains(testProduct2));
    }

    @Order(3)
    @Test
    void shouldReturnTestProduct(){
        //GIVEN
        //WHEN
        ResponseEntity<ProductModel> actual = testRestTemplate.getForEntity("/products/test", ProductModel.class);
        //THEN
        assertEquals(HttpStatus.OK,actual.getStatusCode());
        assertEquals(testProduct,actual.getBody());
    }

    @Order(4)
    @Test
    void shouldTrowWithUnknownID(){
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> testRestTemplate
                .getForEntity("products/unknown", ProductModel.class));
    }

}