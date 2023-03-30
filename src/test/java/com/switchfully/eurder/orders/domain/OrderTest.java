package com.switchfully.eurder.orders.domain;

import com.switchfully.eurder.items.domain.Currency;
import com.switchfully.eurder.items.domain.Item;
import com.switchfully.eurder.items.domain.Price;
import com.switchfully.eurder.items.repository.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class OrderTest {
    @Autowired
    private ItemRepository itemRepo;

    @Test
    void givenOrder_WhenCalculatePriceWhenOrderingMethodCalled_ThenReturnPriceWithTotalAmountInEURO(){
        //GIVEN
        Order order1 = new Order(1,
                List.of(
                        new ItemGroup(itemRepo.getItemById("1")),
                        new ItemGroup(itemRepo.getItemById("2")),
                        new ItemGroup(itemRepo.getItemById("3"))
                ), Currency.EURO
        );
        double totalToHave = 1 + (Math.round(250 * 1.09)) + (Math.round(1000 / 144.86));
        //WHEN
        Price totalOfOrder = order1.getTotalToPay();
        //THEN
        Assertions.assertEquals(totalToHave, totalOfOrder.getAmount());
        Assertions.assertEquals(Currency.EURO, totalOfOrder.getCurrency());
    }
}
