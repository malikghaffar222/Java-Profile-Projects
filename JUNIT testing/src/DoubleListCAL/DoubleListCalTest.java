package DoubleListCAL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleListCalTest {

    DoubleListCAL v;



    @BeforeEach
    void setup(){
        v = new DoubleListCAL();
    }


    @Test
    void insertLastElementEmpty() {
        v.insertLastElement("toto");
        assertEquals(1, v.getNbElements());
        assertEquals("toto", v.getElementAt(0));
        assertTrue(v.checkIntegrity());
    }


    @Test
    void insertLastElementNull() {
        //fill up the initial tab (4 elements by default)
        v.insertLastElement("toto");
        v.insertLastElement("titi");

        //add a new element (resize is called internally)
        try {
            v.insertLastElement(null);
        }
        catch (IllegalArgumentException e){
            assertEquals(2, v.getNbElements());
            assertEquals("toto", v.getElementAt(0));
            assertEquals("titi", v.getElementAt(1));
            assertTrue(v.checkIntegrity());
            return;
        }
        fail();
    }




    @Test
    void insertFirstElementEmpty() {
        v.insertFirstElement("toto");
        assertEquals(1, v.getNbElements());
        assertEquals("toto", v.getElementAt(0));
        assertTrue(v.checkIntegrity());
        assertEquals("toto", v.getFirstElement());
        assertEquals("toto", v.getLastElement());
    }


    @Test
    void insertFirstElementNull() {
        //fillup the initial tab (4 elements by default)
        v.insertLastElement("toto");
        v.insertLastElement("titi");

        //add a new element (resize is called internally)
        try {
            v.insertFirstElement(null);
        }
        catch (IllegalArgumentException e){
            assertEquals(2, v.getNbElements());
            assertEquals("toto", v.getElementAt(0));
            assertEquals("titi", v.getElementAt(1));
            assertTrue(v.checkIntegrity());
            assertEquals("toto", v.getFirstElement());
            assertEquals("titi", v.getLastElement());
            return;
        }
        fail();
    }



    @Test
    void insertElementAtNegativePosition() {
        v.insertElementAt("toto", 0);
        v.insertElementAt("titi", 1);

        try {
            v.insertElementAt("tonton", -1);
        }
        catch (IllegalArgumentException e){
            assertEquals(2, v.getNbElements());
            assertEquals("toto", v.getElementAt(0));
            assertEquals("titi", v.getElementAt(1));
            assertTrue(v.checkIntegrity());
            assertEquals("toto", v.getFirstElement());
            assertEquals("titi", v.getLastElement());
            return;
        }
        fail();
    }



    @Test
    void insertElementAtNull() {
        //fillup the initial tab (4 elements by default)
        v.insertLastElement("toto");
        v.insertLastElement("titi");

        //add a new element (resize is called internally)
        try {
            v.insertElementAt(null, 1);
        }
        catch (IllegalArgumentException e){
            assertEquals(2, v.getNbElements());
            assertEquals("toto", v.getElementAt(0));
            assertEquals("titi", v.getElementAt(1));
            assertTrue(v.checkIntegrity());
            assertEquals("toto", v.getFirstElement());
            assertEquals("titi", v.getLastElement());
            return;
        }
        fail();
    }


    @Test
    void insertElementAtTooFar() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");

        //add a new element (resize is called internally)
        try {
            v.insertElementAt("tonton", v.getNbElements()+19);
        }
        catch (IllegalArgumentException e){
            assertEquals(2, v.getNbElements());
            assertEquals("toto", v.getElementAt(0));
            assertEquals("titi", v.getElementAt(1));
            assertTrue(v.checkIntegrity());
            assertEquals("toto", v.getFirstElement());
            assertEquals("titi", v.getLastElement());
            return;
        }
        fail();
    }

    @Test
    void insertElementAt() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");

        v.insertElementAt("tonton", 1);

        assertEquals(3, v.getNbElements());
        assertEquals("toto", v.getElementAt(0));
        assertEquals("tonton", v.getElementAt(1));
        assertEquals("titi", v.getElementAt(2));
        assertEquals("toto", v.getFirstElement());
        assertEquals("titi", v.getLastElement());
        assertTrue(v.checkIntegrity());
    }

    @Test
    void insertElementAtFirst() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");

        v.insertElementAt("tonton", 0);

        assertEquals(3, v.getNbElements());
        assertEquals("tonton", v.getElementAt(0));
        assertEquals("toto", v.getElementAt(1));
        assertEquals("titi", v.getElementAt(2));
        assertTrue(v.checkIntegrity());
        assertEquals("tonton", v.getFirstElement());
        assertEquals("titi", v.getLastElement());
    }

    @Test
    void insertElementAtLast() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");

        v.insertElementAt("tonton", 2);

        assertEquals(3, v.getNbElements());
        assertEquals("toto", v.getElementAt(0));
        assertEquals("titi", v.getElementAt(1));
        assertEquals("tonton", v.getElementAt(2));
        assertTrue(v.checkIntegrity());
        assertEquals("toto", v.getFirstElement());
        assertEquals("tonton", v.getLastElement());
    }



    @Test
    void getElementAtGeneral() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        assertEquals("toto", v.getElementAt(0));
        assertEquals("titi", v.getElementAt(1));
        assertEquals("tonton", v.getElementAt(2));
        assertTrue(v.checkIntegrity());
    }



    @Test
    void getElementAtTooFar() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        try {
            assertEquals("toto", v.getElementAt(10));
        }
        catch(IllegalArgumentException e){
            assertTrue(v.checkIntegrity());
            return;
        }
        fail();
    }

    @Test
    void getElementAtNegative() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        try {
            assertEquals("toto", v.getElementAt(-1));
        }
        catch(IllegalArgumentException e){
            assertTrue(v.checkIntegrity());
            return;
        }
        fail();
    }


    @Test
    void removeElementAtFirst() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        v.removeElementAt(0);

        assertEquals(2, v.getNbElements());
        assertEquals("titi", v.getElementAt(0));
        assertEquals("tonton", v.getElementAt(1));
        assertTrue(v.checkIntegrity());
        assertEquals("titi", v.getFirstElement());
        assertEquals("tonton", v.getLastElement());
    }

    @Test
    void removeElementAtLast() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        v.removeElementAt(2);

        assertEquals(2, v.getNbElements());
        assertEquals("toto", v.getElementAt(0));
        assertEquals("titi", v.getElementAt(1));
        assertEquals("toto", v.getFirstElement());
        assertEquals("titi", v.getLastElement());
        assertTrue(v.checkIntegrity());
    }

    @Test
    void removeElementAtMiddle() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");
        v.insertLastElement("tutu");

        v.removeElementAt(1);

        assertEquals(3, v.getNbElements());
        assertEquals("toto", v.getElementAt(0));
        assertEquals("tonton", v.getElementAt(1));
        assertEquals("tutu", v.getElementAt(2));
        assertEquals("toto", v.getFirstElement());
        assertEquals("tutu", v.getLastElement());
        assertTrue(v.checkIntegrity());

    }

    @Test
    void removeElementAtJustOne() {
        v.insertLastElement("titi");

        v.removeElementAt(0);
        assertTrue(v.checkIntegrity());
        boolean success = false;
        try {
            v.getFirstElement();
        }catch(NullPointerException e){
            success = true;
        }

        try {
            v.getLastElement();
        }catch(NullPointerException e){
            if (success){
                return;
            }
        }
        fail();
    }




    @Test
    void removeElementAtTooFar() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        try {
            v.removeElementAt(10);
        }
        catch(IllegalArgumentException e){
            assertTrue(v.checkIntegrity());
            assertEquals("toto", v.getFirstElement());
            assertEquals("tonton", v.getLastElement());
            return;
        }
        fail();
    }

    @Test
    void removeElementAtNegative() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        try {
            v.removeElementAt(-1);
        }
        catch(IllegalArgumentException e){
            assertTrue(v.checkIntegrity());
            assertEquals("toto", v.getFirstElement());
            assertEquals("tonton", v.getLastElement());
            return;
        }
        fail();
    }







    @Test
    void removeElementNull() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        try {
            v.removeElement(null);
        }
        catch(IllegalArgumentException e){
            assertTrue(v.checkIntegrity());
            assertEquals("toto", v.getFirstElement());
            assertEquals("tonton", v.getLastElement());
            return;
        }
        fail();
    }

    @Test
    void removeElementNotHere() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        boolean res = v.removeElement("tata");
        assertFalse(res);
        assertEquals("toto", v.getFirstElement());
        assertEquals("tonton", v.getLastElement());
        assertTrue(v.checkIntegrity());
    }

    @Test
    void removeElementGeneral() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        boolean res = v.removeElement("titi");

        assertTrue(res);
        assertEquals("toto",v.getElementAt(0));
        assertEquals("tonton",v.getElementAt(1));
        assertEquals(2,v.getNbElements());
        assertTrue(v.checkIntegrity());
        assertEquals("toto", v.getFirstElement());
        assertEquals("tonton", v.getLastElement());
    }

    @Test
    void removeElementStart() {
        v.insertLastElement("titi");
        v.insertLastElement("toto");
        v.insertLastElement("tonton");

        boolean res = v.removeElement("titi");

        assertTrue(res);
        assertEquals("toto",v.getElementAt(0));
        assertEquals("tonton",v.getElementAt(1));
        assertEquals(2,v.getNbElements());
        assertTrue(v.checkIntegrity());
        assertEquals("toto", v.getFirstElement());
        assertEquals("tonton", v.getLastElement());
    }

    @Test
    void removeElementEnd() {
        v.insertLastElement("toto");
        v.insertLastElement("tonton");
        v.insertLastElement("titi");

        boolean res = v.removeElement("titi");

        assertTrue(res);
        assertEquals("toto",v.getElementAt(0));
        assertEquals("tonton",v.getElementAt(1));
        assertEquals(2,v.getNbElements());
        assertTrue(v.checkIntegrity());
        assertEquals("toto", v.getFirstElement());
        assertEquals("tonton", v.getLastElement());
    }


    @Test
    void removeElementJustOne() {
        v.insertLastElement("toto");

        v.removeElementAt(0);

        assertEquals(0, v.getNbElements());
        assertTrue(v.checkIntegrity());
        boolean success = false;
        try {
            v.getFirstElement();
        }catch(NullPointerException e){
            success = true;
        }

        try {
            v.getLastElement();
        }catch(NullPointerException e){
            if (success){
                return;
            }
        }
        fail();

    }


    @Test
    void removeElementMultipleValues() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");
        assertTrue(v.checkIntegrity());

        boolean res = v.removeElement("titi");

        assertEquals("toto",v.getElementAt(0));
        assertEquals("tonton",v.getElementAt(1));
        assertEquals("titi",v.getElementAt(2));
        assertEquals("tonton",v.getElementAt(3));
        assertEquals(4,v.getNbElements());
        assertTrue(v.checkIntegrity());
        assertEquals("toto", v.getFirstElement());
        assertEquals("tonton", v.getLastElement());
    }


    @Test
    void removeElementAllOccurenceNull() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        try {
            v.removeAllOccurences(null);
        }
        catch(IllegalArgumentException e){
            assertTrue(v.checkIntegrity());
            assertEquals("toto", v.getFirstElement());
            assertEquals("tonton", v.getLastElement());
            return;
        }
        fail();
    }


    @Test
    void removeElementAllOccurenceNotHere() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");
        assertEquals(0,v.removeAllOccurences("tata"));
        assertTrue(v.checkIntegrity());
        assertEquals("toto", v.getFirstElement());
        assertEquals("tonton", v.getLastElement());
    }

    @Test
    void removeAllOccurencesGeneral() {
        v.insertLastElement("toto");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        int nbRemoved = v.removeAllOccurences("titi");

        assertEquals(2, nbRemoved);
        assertEquals("toto", v.getElementAt(0));
        assertEquals("tonton", v.getElementAt(1));
        assertEquals("tonton", v.getElementAt(2));
        assertEquals(3, v.getNbElements());
        assertTrue(v.checkIntegrity());

        assertEquals("toto", v.getFirstElement());
        assertEquals("tonton", v.getLastElement());

    }


    @Test
    void removeAllOccurencesJustOne() {
        v.insertLastElement("titi");
        v.insertLastElement("titi");
        v.insertLastElement("titi");

        assertEquals(3,v.removeAllOccurences("titi"));
        assertTrue(v.checkIntegrity());
        boolean success = false;
        try {
            v.getFirstElement();
        }catch(NullPointerException e){
            success = true;
        }

        try {
            v.getLastElement();
        }catch(NullPointerException e){
            if (success){
                return;
            }
        }
        fail();
    }



    @Test
    void removeFirstElementEmpty() {
        assertFalse(v.removeFirstElement());
        assertTrue(v.checkIntegrity());

        boolean success = false;
        try {
            v.getFirstElement();
        }catch(NullPointerException e){
            success = true;
        }

        try {
            v.getLastElement();
        }catch(NullPointerException e){
            if (success){
                return;
            }
        }
        fail();
    }

    @Test
    void removeFirstElementGeneral() {
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        assertTrue(v.removeFirstElement());
        assertEquals("tonton", v.getElementAt(0));
        assertEquals(1, v.getNbElements());
        assertTrue(v.checkIntegrity());

        assertEquals("tonton", v.getFirstElement());
        assertEquals("tonton", v.getLastElement());

    }

    @Test
    void removeFirstElementJustOne() {
        v.insertLastElement("titi");

        assertTrue(v.removeFirstElement());
        assertTrue(v.checkIntegrity());
        boolean success = false;
        try {
            v.getFirstElement();
        }catch(NullPointerException e){
            success = true;
        }

        try {
            v.getLastElement();
        }catch(NullPointerException e){
            if (success){
                return;
            }
        }
        fail();
    }


    @Test
    void removeLastElementEmpty() {
        assertFalse(v.removeLastElement());
        assertTrue(v.checkIntegrity());
    }


    @Test
    void removeLastElementJustOne() {
        v.insertLastElement("titi");

        assertTrue(v.removeLastElement());
        assertTrue(v.checkIntegrity());
        boolean success = false;
        try {
            v.getFirstElement();
        }catch(NullPointerException e){
            success = true;
        }

        try {
            v.getLastElement();
        }catch(NullPointerException e){
            if (success){
                return;
            }
        }
        fail();
    }




    @Test
    void removeLastElementGeneral() {
        v.insertLastElement("titi");
        v.insertLastElement("tonton");

        assertTrue(v.removeLastElement());
        assertEquals("titi", v.getElementAt(0));
        assertEquals(1, v.getNbElements());
        assertTrue(v.checkIntegrity());

        assertEquals("titi", v.getFirstElement());
        assertEquals("titi", v.getLastElement());

    }





}