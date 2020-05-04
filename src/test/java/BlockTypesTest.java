import map.BlockTypes;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Test BlockLoader methods
 */
public class BlockTypesTest {

    @Test
    public void validBlockIDsTest() {
        List<Integer> types = List.of(
                BlockTypes.EMPTY,
                BlockTypes.GRASS,
                BlockTypes.STONE
        );

        for (int blockID : types) {
            Assert.assertTrue(BlockTypes.validBlockID(blockID));
        }
    }

    @Test
    public void invalidBlockIDsTest() {
        List<Integer> fakeTypes = List.of(
                -145, -12, 512, 123, 454
        );

        for (int blockID : fakeTypes) {
            Assert.assertFalse(BlockTypes.validBlockID(blockID));
        }
    }

    @Test
    public void validBlockIDsNameTest() {
        List<Integer> types = List.of(
                BlockTypes.EMPTY,
                BlockTypes.GRASS,
                BlockTypes.STONE
        );

        List<String> names = List.of(
                "EMPTY",
                "GRASS",
                "STONE"
        );

        for (int i = 0; i < types.size(); i++) {
            Assert.assertEquals(names.get(i), BlockTypes.blockIDToName(types.get(i)));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalidBlockIDsNameTest() {
        List<Integer> typesPlusBad = List.of(
                BlockTypes.EMPTY,
                BlockTypes.GRASS,
                -12,
                BlockTypes.STONE
        );

        for (int blockID : typesPlusBad) {
            BlockTypes.blockIDToName(blockID);
        }
    }
}
