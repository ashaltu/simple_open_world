import loader.Loader;
import loader.TileMapLoader;
import org.junit.Assert;
import org.junit.Test;

public class TileMapLoaderTest {

    @Test
    public void stringToIntMapTest() {
        TileMapLoader tml = new TileMapLoader();
        int[][] intMap = tml.stringToIntMap("1 2 1 2 1\n" +
                                            "1 1 0 1 1\n" +
                                            "2 1 1 2 1");
        int[][] realMap = {{1, 2, 1, 2, 1},
                           {1, 1, 0, 1, 1},
                           {2, 1, 1, 2, 1}};
        Assert.assertArrayEquals(realMap, intMap);
    }

    @Test
    public void singleBlockMapTest() {
        String filename = "single_block_map_test.txt";
        TileMapLoader tml = new TileMapLoader();
        int[][] realMap = {{1}};
        Assert.assertArrayEquals(realMap, tml.stringToIntMap(tml.loadText(filename)));
    }

    @Test
    public void singleLineHorizontalMapTest() {
        String filename = "single_line_horizontal_map_test.txt";
        TileMapLoader tml = new TileMapLoader();
        int[][] realMap = {{1, 2, 1, 2, 1}};
        Assert.assertArrayEquals(realMap, tml.stringToIntMap(tml.loadText(filename)));
    }

    @Test
    public void singleLineVerticalMapTest() {
        String filename = "single_line_vertical_map_test.txt";
        TileMapLoader tml = new TileMapLoader();
        int[][] realMap = {{1}, {2}, {1}, {2}, {1}};
        Assert.assertArrayEquals(realMap, tml.stringToIntMap(tml.loadText(filename)));
    }

    @Test
    public void multiLineMapTest() {
        String filename = "multi_line_map_test.txt";
        TileMapLoader tml = new TileMapLoader();
        int[][] realMap = {{1, 2, 1, 2, 1},
                           {1, 1, 0, 1, 1},
                           {2, 1, 1, 2, 1}};
        Assert.assertArrayEquals(realMap, tml.stringToIntMap(tml.loadText(filename)));
    }

    @Test (expected = IllegalArgumentException.class)
    public void badMapTest() {
        String filename = "bad_map_test.txt";
        TileMapLoader tml = new TileMapLoader();
        tml.stringToIntMap(tml.loadText(filename));
    }


}
