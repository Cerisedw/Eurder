package com.switchfully.eurder.orders.domain;

import com.switchfully.eurder.items.domain.Currency;
import com.switchfully.eurder.items.domain.Item;
import com.switchfully.eurder.items.domain.Price;
import com.switchfully.eurder.items.repository.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

@SpringBootTest
public class OrderTest {
    @Autowired
    private ItemRepository itemRepo;
    private Order orderEURO;
    private Order orderDOLLAR;
    private Order orderYen;
    @BeforeEach
    void setup(){
        orderEURO = new Order(1,
                List.of(
                        new ItemGroup(itemRepo.getItemById("1")),
                        new ItemGroup(itemRepo.getItemById("2")),
                        new ItemGroup(itemRepo.getItemById("3"))
                ), Currency.EURO
        );
        orderDOLLAR = new Order(1,
                List.of(
                        new ItemGroup(
                                new Item(1L, "Something", "Somthing description",
                                        new Price(1, Currency.EURO), 1)),
                        new ItemGroup(new Item(2L, "Something", "Somthing description",
                                new Price(250, Currency.DOLLAR), 1)),
                        new ItemGroup(new Item(3L, "Something", "Somthing description",
                                new Price(1000, Currency.YEN), 1))
                ), Currency.DOLLAR
        );
        orderYen = new Order(1,
                List.of(
                        new ItemGroup(
                                new Item(1L, "Something", "Somthing description",
                                        new Price(1, Currency.EURO), 1)),
                        new ItemGroup(new Item(2L, "Something", "Somthing description",
                                new Price(250, Currency.DOLLAR), 1)),
                        new ItemGroup(new Item(3L, "Something", "Somthing description",
                                new Price(1000, Currency.YEN), 1))
                ), Currency.YEN
        );
    }
    @Test
    void givenOrder_WhenCalculatePriceWhenOrderingMethodCalled_ThenReturnPriceWithTotalAmountInEURO(){
        //GIVEN
        double totalToHave = 1 + (Math.round(250 * 1.09)) + (Math.round(1000 / 144.86));
        //WHEN
        Price totalOfOrder = orderEURO.getTotalToPay();
        //THEN
        Assertions.assertEquals(totalToHave, totalOfOrder.getAmount());
        Assertions.assertEquals(Currency.EURO, totalOfOrder.getCurrency());
    }
    @Test
    void givenOrder_WhenCalculatePriceWhenOrderingMethodCalled_ThenReturnPriceWithTotalAmountInDOLLAR(){
        //GIVEN
        double totalToHaveInDollar = (Math.round(1/1.09)) + 250 + (Math.round(1000 / 132.68));
        //WHEN
        Price totalOfOrderInDollar = orderDOLLAR.getTotalToPay();
        //THEN
        Assertions.assertEquals(totalToHaveInDollar, totalOfOrderInDollar.getAmount());
        Assertions.assertEquals(Currency.DOLLAR, totalOfOrderInDollar.getCurrency());
    }
    @Test
    void givenOrder_WhenCalculatePriceWhenOrderingMethodCalled_ThenReturnPriceWithTotalAmountInYEN(){
        //GIVEN
        double totalToHaveInYen = (Math.round(1 * 144.86)) + (Math.round(250 * 132.68)) + 1000;
        //WHEN
        Price totalOfOrderInYen = orderYen.getTotalToPay();
        //THEN
        Assertions.assertEquals(totalToHaveInYen, totalOfOrderInYen.getAmount());
        Assertions.assertEquals(Currency.YEN, totalOfOrderInYen.getCurrency());
    }

}
