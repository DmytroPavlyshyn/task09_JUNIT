package com.pavlyshyn;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FinalConditionTest {
    final private  boolean test = true;

    @Test
    void testAssertEquals(){
        assertEquals(test,true);
    }
    @Test
    void testAssertTrue(){
        assertTrue(test);
    }
    @Test
    void testAssertFalse(){
        assertFalse(!test);
    }
    @Test
    void testAssertNotEquals(){
        assertNotEquals(test,false);
    }

}
