package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoOikea() {
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void latausToimii() {
        kortti.lataaRahaa(10);
        assertEquals(20, kortti.saldo());
    }
    
    @Test
    public void rahanOttaminen() {
        kortti.otaRahaa(10);
        assertEquals(0, kortti.saldo());
    }
    
    @Test
    public void saldoEiVaheneJosEiRahaa() {
        int sal = kortti.saldo();
        kortti.otaRahaa(200);
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void rahanOttaminenTrue() {;
        assertEquals(true, kortti.otaRahaa(10));
    }
    
    @Test
    public void rahanOttaminenFalse() {;
        assertEquals(false, kortti.otaRahaa(100));
    }
    
    @Test
    public void stringKokeilu() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
}
