package de.kittlaus.java221.anotherShop;

import de.kittlaus.java221.shop.ShopService;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SecondShopServiceTest {

    @Test
    void shouldReturnAllProducts(){
        //GIVEN
        ProductRepo productRepoMock = mock(ProductRepo.class);
        OrderRepo orderRepoMock = mock(OrderRepo.class);
        SecondShopService testShop = new SecondShopService(orderRepoMock,productRepoMock);
        List<ProductModel> mockList = List.of(new ProductModel("Kartoffel"),new ProductModel("Kaffee"));
        when(productRepoMock.list()).thenReturn(mockList);
        //WHEN
        List<ProductModel> actual = testShop.getAllProducts();
        //THEN
        assertEquals(actual,mockList);
    }

    @Test
    void shouldReturnProductById(){
        //GIVEN
        ProductRepo productRepoMock = mock(ProductRepo.class);
        OrderRepo orderRepoMock = mock(OrderRepo.class);
        SecondShopService testShop = new SecondShopService(orderRepoMock,productRepoMock);
        ProductModel mockProduct = new ProductModel("Kartoffel");
        when(productRepoMock.findById("2")).thenReturn(Optional.of(mockProduct));
        //WHEN
        Optional<ProductModel> actual = testShop.getProductById("2");
        //THEN
        assertTrue(actual.isPresent());
        assertEquals(actual.get(),mockProduct);
    }

    @Test
    void shouldReturnEmptyWithUnknownProductId(){
        //GIVEN
        ProductRepo productRepoMock = mock(ProductRepo.class);
        OrderRepo orderRepoMock = mock(OrderRepo.class);
        SecondShopService testShop = new SecondShopService(orderRepoMock,productRepoMock);
        when(productRepoMock.findById("2")).thenReturn(Optional.empty());
        //WHEN
        Optional<ProductModel> actual = testShop.getProductById("2");
        //THEN
        assertTrue(actual.isEmpty());
    }

    @Test
    void shouldAddNewProduct(){
        //GIVEN
        ProductRepo productRepoMock = mock(ProductRepo.class);
        OrderRepo orderRepoMock = mock(OrderRepo.class);
        SecondShopService testShop = new SecondShopService(orderRepoMock,productRepoMock);
        ProductModel mockProduct = new ProductModel("Kartoffel");
        when(productRepoMock.save(mockProduct)).thenReturn(mockProduct);
        //WHEN
        ProductModel actual = testShop.addNewProduct(mockProduct);
        //THEN
        assertEquals(actual,mockProduct);
    }

    @Test
    void shouldReturnAllOrders(){
        //GIVEN
        ProductRepo productRepoMock = mock(ProductRepo.class);
        OrderRepo orderRepoMock = mock(OrderRepo.class);
        SecondShopService testShop = new SecondShopService(orderRepoMock,productRepoMock);
        OrderModel mockOrder = new OrderModel(List.of(new ProductModel("Brot"),new ProductModel("Apfel")));
        when(orderRepoMock.list()).thenReturn(List.of(mockOrder));
        //WHEN
        List<OrderModel> actual = testShop.getAllOrders();
        //THEN
        assertEquals(List.of(mockOrder),actual);
    }

    @Test
    void shouldReturnOrderById(){
        //GIVEN
        ProductRepo productRepoMock = mock(ProductRepo.class);
        OrderRepo orderRepoMock = mock(OrderRepo.class);
        SecondShopService testShop = new SecondShopService(orderRepoMock,productRepoMock);
        OrderModel mockOrder = new OrderModel(List.of(new ProductModel("Brot"),new ProductModel("Apfel")));
        when(orderRepoMock.findById("1")).thenReturn(Optional.of(mockOrder));
        //WHEN
        Optional<OrderModel> actual = testShop.findOrderById("1");
        //THEN
        assertTrue(actual.isPresent());
        assertEquals(mockOrder,actual.get());
    }

    @Test
    void shouldReturnEmptyWithUnknownOrderId(){
        //GIVEN
        ProductRepo productRepoMock = mock(ProductRepo.class);
        OrderRepo orderRepoMock = mock(OrderRepo.class);
        SecondShopService testShop = new SecondShopService(orderRepoMock,productRepoMock);
        when(orderRepoMock.findById("1")).thenReturn(Optional.empty());
        //WHEN
        Optional<OrderModel> actual = testShop.findOrderById("1");
        //THEN
        assertTrue(actual.isEmpty());
    }

    @Test
    void shouldAddNewOrder(){
        //GIVEN
        ProductRepo productRepoMock = mock(ProductRepo.class);
        OrderRepo orderRepoMock = mock(OrderRepo.class);
        SecondShopService testShop = new SecondShopService(orderRepoMock,productRepoMock);
        OrderModel mockOrder = new OrderModel(List.of(new ProductModel("Brot"),new ProductModel("Apfel")));
        when(orderRepoMock.save(mockOrder)).thenReturn(mockOrder);
        //WHEN
        OrderModel actual = testShop.saveNewOrder(mockOrder);
        //THEN
        assertEquals(mockOrder,actual);
    }

}