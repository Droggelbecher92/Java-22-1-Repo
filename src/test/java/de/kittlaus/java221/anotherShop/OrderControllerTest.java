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
class OrderControllerTest {

   @LocalServerPort
   private int port;

   @Autowired
   TestRestTemplate testRestTemplate;

   //Testobjekte
   final private OrderModel testOrder = new OrderModel(List
           .of(new ProductModel("Kartoffel","test"),
                   new ProductModel("Mango","test2")),"order1");

   @Test
   @Order(1)
   void shouldAddNewOrder(){
       //GIVEN
       //WHEN
       ResponseEntity<OrderModel> actual = testRestTemplate.postForEntity("/order", testOrder, OrderModel.class);
       //THEN
       assertEquals(HttpStatus.OK,actual.getStatusCode());
       assertEquals(testOrder,actual.getBody());
   }


   @Test
   @Order(2)
   void shouldReturnAllOrders(){
       //GIVEN
       //WHEN
       ResponseEntity<OrderModel[]> actual = testRestTemplate.getForEntity("/order", OrderModel[].class);
       //THEN
       assertEquals(HttpStatus.OK,actual.getStatusCode());
       assertTrue(Arrays.stream(actual.getBody()).toList().contains(testOrder));
   }


   @Test
   @Order(3)
   void shouldReturnTestOrder(){
       //GIVEN
       //WHEN
       ResponseEntity<OrderModel> actual = testRestTemplate.getForEntity("/order/order1", OrderModel.class);
       //THEN
       assertEquals(HttpStatus.OK,actual.getStatusCode());
       assertEquals(testOrder,actual.getBody());
   }

   @Test
   @Order(4)
   void shouldTrowWithUnknownID(){
       //GIVEN
       //WHEN
       //THEN
       assertThrows(IllegalArgumentException.class,
               () -> testRestTemplate.getForEntity("order/unknown",OrderModel.class));
   }

}