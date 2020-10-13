package tp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EncoderTest {

    @Test
    void getEightCharCountTest() {
        Encoder encoder = new Encoder("1234");
        assertEquals(1, encoder.getBlockCount());
        encoder = new Encoder("12345678");
        assertEquals(1, encoder.getBlockCount());
        encoder = new Encoder("123456789");
        assertEquals(2, encoder.getBlockCount());
    }

    @Test
    void getLineInLastBlockTest() {
        Encoder encoder = new Encoder("1234");
        assertEquals(4, encoder.getLineInLastBlock());
        encoder = new Encoder("123456781234");
        assertEquals(4, encoder.getLineInLastBlock());
        encoder = new Encoder("123456781");
        assertEquals(1, encoder.getLineInLastBlock());
    }

}