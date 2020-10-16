package tp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    public void getBinaryStringTest() {
        Line line = new Line('w');
        assertEquals("011101110", line.getBinaryString());
        line = new Line('Y');
        assertEquals("010110010", line.getBinaryString());
        line = new Line('a');
        assertEquals("011000011", line.getBinaryString());
    }

    @Test
    public void getStringCharTest() {
        Line line = new Line('w');
        assertEquals("w", line.getStringChar());
        line = new Line('a');
        assertEquals("a", line.getStringChar());
        line = new Line(' ');
        assertEquals(" ", line.getStringChar());
    }

    @Test
    public void getCharAtTest() {
        Line line = new Line('a');
        assertEquals('1', line.getParityBit());
    }

}