/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miklas
 */
public class KassapaateTest {

    Kassapaate kassapaate;
    Maksukortti maksukortti;

    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        maksukortti = new Maksukortti(1000);
    }

    @Test
    public void testSetup() {
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisOstoMaukas() {
        int palautus = kassapaate.syoMaukkaasti(500);
        assertEquals(100, palautus);
        assertEquals(100400, kassapaate.kassassaRahaa());
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisOstoMaukasFail() {
        int palautus = kassapaate.syoMaukkaasti(300);
        assertEquals(300, palautus);
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisOstoEdullinen() {
        int palautus = kassapaate.syoEdullisesti(480);
        assertEquals(240, palautus);
        assertEquals(100240, kassapaate.kassassaRahaa());
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateisOstoEdullinenFail() {
        int palautus = kassapaate.syoEdullisesti(200);
        assertEquals(200, palautus);
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void korttiOstoMaukas() {
        boolean palautus = kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(true, palautus);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiOstoMaukasFail() {
        kassapaate.syoMaukkaasti(maksukortti);
        kassapaate.syoMaukkaasti(maksukortti);
        boolean palautus = kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(false, palautus);
        assertEquals(200, maksukortti.saldo());
        assertEquals(2, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiOstoEdullinen() {
        boolean palautus = kassapaate.syoEdullisesti(maksukortti);
        assertEquals(true, palautus);
        assertEquals(760, maksukortti.saldo());
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiOstoEdullinenFail() {
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        boolean palautus = kassapaate.syoEdullisesti(maksukortti);
        assertEquals(false, palautus);
        assertEquals(40, maksukortti.saldo());
        assertEquals(4, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kokeileLataus() {
        kassapaate.lataaRahaaKortille(maksukortti, 1000);
        assertEquals(101000, kassapaate.kassassaRahaa());
        assertEquals(2000, maksukortti.saldo());
    }
    
    @Test
    public void kokeileLatausNegatiivinen() {
        kassapaate.lataaRahaaKortille(maksukortti, -1000);
        assertEquals(100000, kassapaate.kassassaRahaa());
        assertEquals(1000, maksukortti.saldo());
    }

}
