package loader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Load any kind of text, png, or jpg file. Place files in /resources folder
 *
 * Not meant to be directly instantiated
 */
public class Loader {

    /**
     *  Loads an image by it's file name
     *
     * @return the image to be loaded from the /resources folder
     * @param file to be loaded, must be of type JPG, JPEG, PNG, BMP, WEBP, or GIF
     * @spec.requires file != null, file.endsWith(JPG or JPEG or PNG or BMP or WEBP or GIF)
     */
    public BufferedImage loadImage(String file) {
        if (file == null) {
            throw new IllegalArgumentException("Filename can't be of null type");
        }
        if (!(file.endsWith(".jpg") || file.endsWith(".jpeg") || file.endsWith(".png")
            || file.endsWith(".bmp") || file.endsWith(".webp") || file.endsWith(".gif"))) {
            throw new IllegalArgumentException("File must be of type JPG, JPEG, PNG, BMP, WEBP, or GIF");
        }

        BufferedImage image = null;
        String fullFilePath = Objects.requireNonNull(getClass().getClassLoader().getResource(file)).getFile();
        try {
            image = ImageIO.read(new File(fullFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    /**
     * Load a sub-image from a given file
     *
     * @param file    the name of the image to be loaded
     * @param x       the x coordinate of where to begin the image crop
     * @param y       the y coordinate of where to begin the image crop
     * @param width   the width of the crop starting at the x coordinate
     * @param height  the height of the crop starting at the y coordinate
     * @spec.requires file != null, file.endsWith(JPG or JPEG or PNG or BMP or WEBP or GIF),
     * width > 0, height > 0, x >= 0, x <= originalImage.width-1, y >= 0, y <= originalImage.height-1
     * @return the cropped image from the given file name
     */
    public BufferedImage loadCroppedImage(String file, int x, int y, int width, int height) {
        return loadImage(file).getSubimage(x, y, width, height);
    }

    /**
     * Load text from a given file
     *
     * @return the text of the specified file
     * @param file the name of the txt
     * @spec.requires file != null, file.endsWith(TXT)
     */
    public String loadText(String file) {
        if (file == null) {
            throw new IllegalArgumentException("Filename can't be of null type");
        }
        if (!file.endsWith(".txt")) {
            throw new IllegalArgumentException("File must be of type TXT");
        }

        StringBuilder text = new StringBuilder();
        try {
            String fullFilePath = Objects.requireNonNull(getClass().getClassLoader().getResource(file)).getFile();
            BufferedReader reader = new BufferedReader(new FileReader(fullFilePath));
            String currLine;
            while ((currLine = reader.readLine()) != null) {
                if(!currLine.isBlank() && !currLine.isEmpty()) {
                    text.append(currLine);
                    text.append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text.toString().stripTrailing();
    }

}
