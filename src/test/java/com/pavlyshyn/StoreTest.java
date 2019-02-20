package com.pavlyshyn;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StoreTest {
    @InjectMocks
    private static Store store;

    @Mock
    private static Calculator calculator;

    @BeforeAll
    static void init() {
        store = new Store("Store №1", 1);

    }

    @BeforeEach
    void reinitialize() {
        store.removeAll();
        store.put("Milk", 10);
        store.put("Chocolate", 15);
        store.put("Candy", 1);
        store.put("Cheese", 4);
        store.put("Chicken", 30);
    }

    @Test
    void testPut() {
        assertThrows(RuntimeException.class, () -> {
            store.put("Store №1", 1);
        }, "Can't sell store");
        int previousSize = store.getNumberOfProducts();
        store.put("Cake", 10);
        assertEquals(previousSize + 1, store.getNumberOfProducts());
    }

    @Test
    void testRemove() {
        int previousSize = store.getNumberOfProducts();
        store.remove("Milk");
        assertEquals(previousSize - 1, store.getNumberOfProducts());
    }

    @Test
    void testRemoveAll() {
        store.removeAll();
        assertTrue(store.getNumberOfProducts() == 0);
    }

    @Test
    void testGet() {
        int price = store.findProductPrice("Milk");
        assertAll(
                () -> assertNotNull(store.findProductPrice("Milk")),
                () -> assertEquals(10, price),
                () -> assertNull(store.findProductPrice("Cake"))
        );
    }

    @Test
    void testCalculatePrice() {
        doReturn(40).when(calculator).calculatePrice(4, 10);
        store.calculatePrice("Milk", 4);
        verify(calculator,atLeast(1)).calculatePrice(4,10);
    }
}
