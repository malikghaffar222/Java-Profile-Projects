package DoubleListCAL;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class DoubleDoubleNodeTest {

    @Test
    void constructorGeneral() {
        DoubleNode n = new DoubleNode(new DoubleNode("titi"), new DoubleNode("tonton"), "toto");
        assertEquals("toto", n.getValue());
        assertEquals("tonton", n.getNext().getValue());
        assertEquals("titi", n.getPrevious().getValue());
    }


    @Test
    void constructorGeneralNull() {
        try{
            DoubleNode n = new DoubleNode(new DoubleNode("titi"), new DoubleNode("tonton"), null);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }


    @Test
    void getValue() {
        DoubleNode n = new DoubleNode(new DoubleNode("titi"), new DoubleNode("tonton"), "toto");
        assertEquals(n.getValue(), "toto");
    }

    @Test
    void getNext() {
        DoubleNode n = new DoubleNode(new DoubleNode("titi"), new DoubleNode("tonton"), "toto");
        assertEquals("titi", n.getPrevious().getValue());
        assertEquals("tonton", n.getNext().getValue());
        assertEquals(null, n.getNext().getNext());
        assertEquals(null, n.getPrevious().getPrevious());
    }

    @Test
    void setValue() {
        DoubleNode n = new DoubleNode(new DoubleNode("titi"), new DoubleNode("tonton"), "toto");
        n.setValue("tata");
        assertEquals("tata", n.getValue());
    }

    @Test
    void setValueNull() {
        DoubleNode n = new DoubleNode(new DoubleNode("titi"), new DoubleNode("tonton"), "toto");
        try{
            n.setValue(null);
        }catch(IllegalArgumentException e){
            return;
        }
        fail();
    }

    @Test
    void setNext() {
        DoubleNode n = new DoubleNode(new DoubleNode("titi"), new DoubleNode("tonton"), "toto");
        n.setNext(new DoubleNode(null, null, "tata"));
        assertEquals("tata", n.getNext().getValue());
    }

    @Test
    void setPrevious() {
        DoubleNode n = new DoubleNode(new DoubleNode("titi"), new DoubleNode("tonton"), "toto");
        n.setPrevious(new DoubleNode(null, null, "tata"));
        assertEquals("tata", n.getPrevious().getValue());
    }
}