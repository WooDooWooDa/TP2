package tp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EncoderTest {

    private Encoder encoder;

    public EncoderTest() {
        this.encoder = new Encoder();
    }

    @Test
    void getEightCharCountTest() {
        assertEquals(1, encoder.getBlockCount("1234"));
        assertEquals(1, encoder.getBlockCount("12345678"));
        assertEquals(2, encoder.getBlockCount("123456789"));
    }

}