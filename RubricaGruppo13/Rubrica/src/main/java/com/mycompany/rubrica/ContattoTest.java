package com.mycompany.rubrica;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @class ContattoTest
 * @brief Classe impiegata per l'Unit test della classe Contatto.
 * 
 * Dopo un primo tentativo, il test ha dimostrato una criticità nei metodi getter,
 * ovvero che quando un attributo era vuoto restituiva null invece della stringa vuota "".
 * Ciò creava problemi nel salvataggio e upload/download dei file, poiché essendo presente null in uno o più campi del file di testo,
 * e non una stringa vuota, il contatto veniva salvato con attributi che presentavano stringhe "null", e quindi non vuote.
 * 
 * 
 *
 * @author Francesco, Antonio, Gennaro
 * 
 */
public class ContattoTest {
    
    public ContattoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Contatto instance = new Contatto();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Contatto instance = new Contatto();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setCognome method, of class Contatto.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "";
        Contatto instance = new Contatto();
        instance.setCognome(cognome);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        Contatto instance = new Contatto();
        String expResult = "";
        String result = instance.getCognome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setNumeroTelefono1 method, of class Contatto.
     */
    @Test
    public void testSetNumeroTelefono1() {
        System.out.println("setNumeroTelefono1");
        String numeroTelefono1 = "";
        Contatto instance = new Contatto();
        instance.setNumeroTelefono1(numeroTelefono1);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setNumeroTelefono2 method, of class Contatto.
     */
    @Test
    public void testSetNumeroTelefono2() {
        System.out.println("setNumeroTelefono2");
        String numeroTelefono2 = "";
        Contatto instance = new Contatto();
        instance.setNumeroTelefono2(numeroTelefono2);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setNumeroTelefono3 method, of class Contatto.
     */
    @Test
    public void testSetNumeroTelefono3() {
        System.out.println("setNumeroTelefono3");
        String numeroTelefono3 = "";
        Contatto instance = new Contatto();
        instance.setNumeroTelefono3(numeroTelefono3);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getNumeroTelefono1 method, of class Contatto.
     */
    @Test
    public void testGetNumeroTelefono1() {
        System.out.println("getNumeroTelefono1");
        Contatto instance = new Contatto();
        String expResult = "";
        String result = instance.getNumeroTelefono1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getNumeroTelefono2 method, of class Contatto.
     */
    @Test
    public void testGetNumeroTelefono2() {
        System.out.println("getNumeroTelefono2");
        Contatto instance = new Contatto();
        String expResult = "";
        String result = instance.getNumeroTelefono2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getNumeroTelefono3 method, of class Contatto.
     */
    @Test
    public void testGetNumeroTelefono3() {
        System.out.println("getNumeroTelefono3");
        Contatto instance = new Contatto();
        String expResult = "";
        String result = instance.getNumeroTelefono3();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setEmail1 method, of class Contatto.
     */
    @Test
    public void testSetEmail1() {
        System.out.println("setEmail1");
        String email1 = "";
        Contatto instance = new Contatto();
        instance.setEmail1(email1);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setEmail2 method, of class Contatto.
     */
    @Test
    public void testSetEmail2() {
        System.out.println("setEmail2");
        String email2 = "";
        Contatto instance = new Contatto();
        instance.setEmail2(email2);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setEmail3 method, of class Contatto.
     */
    @Test
    public void testSetEmail3() {
        System.out.println("setEmail3");
        String email3 = "";
        Contatto instance = new Contatto();
        instance.setEmail3(email3);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getEmail method, of class Contatto.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Contatto instance = new Contatto();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getEmai2 method, of class Contatto.
     */
    @Test
    public void testGetEmai2() {
        System.out.println("getEmai2");
        Contatto instance = new Contatto();
        String expResult = "";
        String result = instance.getEmai2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getEmai3 method, of class Contatto.
     */
    @Test
    public void testGetEmai3() {
        System.out.println("getEmai3");
        Contatto instance = new Contatto();
        String expResult = "";
        String result = instance.getEmai3();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of equals method, of class Contatto.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Contatto instance = new Contatto();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of compareTo method, of class Contatto.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Contatto c = new Contatto("b","");
        Contatto instance = new Contatto("a","");
        int expResult = -1;
        int result = instance.compareTo(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of toString method, of class Contatto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Contatto instance = new Contatto();
        String expResult = " ";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
