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
    public void alkusaldoOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void latausToimiiOikein() {
        kortti.lataaRahaa(100);
        //Kortilla nyt saldoa 1 euro 10 senttiä
        assertEquals("saldo: 1.10", kortti.toString());
    }
    
    @Test
    public void ottoToimiiKunRahaaOn() {
        kortti.lataaRahaa(1000);
        //Kortilla on nyt rahaa 10 euroa ja 10 senttiä
        kortti.otaRahaa(510);
        assertEquals("saldo: 5.0", kortti.toString());
    }
    
    @Test
    public void ottoToimiiKunRahaaEiOle() {
        kortti.otaRahaa(510);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void palautusOikeinKunRahaaOn() {
        boolean palautus = kortti.otaRahaa(5);
        assertEquals(true,palautus);
    }
    
    @Test
    public void palautusOikeinKunRahaaEiOle() {
        boolean palautus = kortti.otaRahaa(500);
        assertEquals(false,palautus);
    }
}
