import loader.Loader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Objects;

/**
 * Test Loader implementation of loadText
 */
public class LoaderTest {

    @Test
    public void pathNameTest() {
        String fullFilePath = Objects.requireNonNull(getClass().getClassLoader().getResource("single_line_test.txt")).getFile();
        Assert.assertNotEquals(null, fullFilePath);
        File test = new File(fullFilePath);
        Assert.assertTrue(test.exists());
    }

    @Test
    public void loadSingleLineTest() {
        String filename = "single_line_test.txt";
        System.out.println(filename);
        Loader loader = new Loader();
        Assert.assertEquals("hello, this tests if one line is read properly", loader.loadText(filename));
    }

    @Test
    public void loadMultiLineTest() {
        String filename = "multi_line_test.txt";
        Loader loader = new Loader();
        Assert.assertEquals("hello, this test\n" +
                "is for if multiple lines\n" +
                "are detected and\n" +
                "no information\n" +
                "is missed regardless of\n" +
                "the number of extra whitespaces\n" +
                "in this file", loader.loadText(filename));
    }

    @Test (expected = NullPointerException.class)
    public void nonExistentTest() {
        String filename = "baloney_non_existent_map.txt";
        Loader loader = new Loader();
        loader.loadText(filename);
    }

    @Test (expected = IllegalArgumentException.class)
    public void invalidFilenameTest() {
        String filename = "real_file_seriously_map.jk";
        Loader loader = new Loader();
        loader.loadText(filename);
    }

    @Test (expected = IllegalArgumentException.class)
    public void nullFilenameTest() {
        String filename = null;
        Loader loader = new Loader();
        loader.loadText(filename);
    }
}
