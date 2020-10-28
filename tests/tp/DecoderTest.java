package tp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DecoderTest {

    private final String CORRUPTED = Console.ANSI_RED + "Corruption dans la séquence" + Console.ANSI_RESET;
    private Decoder decoder;

    public DecoderTest() {

    }

    @Test
    public void getDecodedString() {
        decoder = new Decoder();
        decoder.setBitsLine("011000011011011000011011000011011110000011101");
        decoder.decode();
        assertEquals("allo", decoder.getDecodedString());
        decoder = new Decoder();
        decoder.setBitsLine("001100011001100101001100111001101001001101010001101100001101111001110001000010001001110010001100011001100000101110001");
        decoder.decode();
        assertEquals("12345678910", decoder.getDecodedString());
        decoder = new Decoder();
        decoder.setBitsLine("011000011011011000011011001011011110000111101");
        decoder.decode();
        assertEquals(CORRUPTED, decoder.getDecodedString());
    }
}