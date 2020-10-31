/**
 *
 * @author sallasal
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate paate;
    Maksukortti kortti;

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    //Alustuksen testit
    @Test
    public void rahamaaraAluksiOikein() {
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void edullistenMaaraAluksiOikein() {
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void maukkaidenMaaraAluksiOikein() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }

    //Käteismaksujen testit
    @Test
    public void kateismaksuLisaaEdullisen() {
        paate.syoEdullisesti(1000);
        assertEquals(100240, paate.kassassaRahaa());
    }

    @Test
    public void kateismaksuPalauttaaOikeinEdullisesta() {
        int palautus = paate.syoEdullisesti(1000);
        assertEquals(760, palautus);
    }

    @Test
    public void kateismaksuLisaaEdullisia() {
        paate.syoEdullisesti(1000);
        paate.syoEdullisesti(500);
        paate.syoEdullisesti(240);
        assertEquals(3, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void liianVahanRahaaEdulliseen() {
        paate.syoEdullisesti(10);
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void kateismaksuLisaaMaukkaan() {
        paate.syoMaukkaasti(1000);
        assertEquals(100400, paate.kassassaRahaa());
    }

    @Test
    public void kateismaksuPalauttaaOikeinMaukkaasta() {
        int palautus = paate.syoMaukkaasti(1000);
        assertEquals(600, palautus);
    }

    @Test
    public void kateismaksuLisaaMaukkaita() {
        paate.syoMaukkaasti(2000);
        paate.syoMaukkaasti(400);
        assertEquals(2, paate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void liianVahanRahaaMaukkaaseen() {
        paate.syoMaukkaasti(10);
        assertEquals(100000, paate.kassassaRahaa());
    }

    //Maksukorttiostojen testit
    @Test
    public void edullinenOstoVahentaaOikein() {
        paate.syoEdullisesti(kortti);
        assertEquals(760, kortti.saldo());
    }

    @Test
    public void edullinenPalauttaaTrue() {
        boolean palautus = paate.syoEdullisesti(kortti);
        assertTrue(palautus);
    }

    @Test
    public void korttimaksuLisaaEdullisia() {
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        paate.syoEdullisesti(kortti);
        assertEquals(3, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void eiRahaaEdulliseenToimiiOikein() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        boolean palautus = paate.syoEdullisesti(kortti);
        assertEquals(200, kortti.saldo());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertFalse(palautus);
    }

    @Test
    public void maukasOstoVahentaaOikein() {
        paate.syoMaukkaasti(kortti);
        assertEquals(600, kortti.saldo());
    }

    @Test
    public void maukasPalauttaaTrue() {
        boolean palautus = paate.syoMaukkaasti(kortti);
        assertTrue(palautus);
    }

    @Test
    public void korttimaksuLisaaMaukkaita() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        assertEquals(2, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void eiRahaaMaukkaaseenToimiiOikein() {
        paate.syoMaukkaasti(kortti);
        paate.syoMaukkaasti(kortti);
        boolean palautus = paate.syoMaukkaasti(kortti);
        assertEquals(200, kortti.saldo());
        assertEquals(2, paate.maukkaitaLounaitaMyyty());
        assertFalse(palautus);
    }
    
    @Test
    public void kassanSaldoEiMuutuKorttiostoista() {
        paate.syoMaukkaasti(kortti);
        paate.syoEdullisesti(kortti);
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void kortinLatausToimii() {
        paate.lataaRahaaKortille(kortti, 50);
        paate.lataaRahaaKortille(kortti, -50);
        paate.lataaRahaaKortille(kortti, 300);
        assertEquals(1350, kortti.saldo());
    }

}
