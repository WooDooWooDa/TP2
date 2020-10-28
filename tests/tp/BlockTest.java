package tp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockTest {

    private Block block;

    public BlockTest() {
        this.block = new Block();
    }

    @Test
    public void getParityLineTest() {
        block.addLine(new Line("001100011"));
        block.addLine(new Line("001100101"));
        block.createParityLine();
        assertEquals("000000110", block.getParityLine());
    }

    @Test
    public void decodeBlock() {
        block.addLine(new Line("001100011"));
        block.addLine(new Line("001100101"));
        block.createParityLine();
        assertEquals("12", block.decodeBlock());
        block = new Block();
        block.addLine(new Line("011000011"));
        block.createParityLine();
        assertEquals("a", block.decodeBlock());
    }
}