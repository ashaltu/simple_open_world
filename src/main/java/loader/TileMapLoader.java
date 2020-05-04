package loader;

import map.BlockTypes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Load tile map pieces to form a full map
 */
public class TileMapLoader extends Loader{

    /**
     * Returns an image of the given txt file
     *
     * @param file the txt file to look at and read in the map
     * @return the translated map from the given file
     * @spec.requires file != null, file.endsWith(TXT)
     */
    public BufferedImage loadMap(String file) {
        // TODO: Return a GameMap class instead of BufferedImage
        String map = loadText(file);
        return createMap(map);
    }

    /**
     * Returns an image from the given string
     *
     * Example map: createMap('1 1 1 1 1
     *                         1 1 1 1 1
     *                         1 1 1 1 1')   ,returns a 5x3 map covered in grass blocks,
     *                                      where the units are blocks (16x16 pixels per block)
     *
     * @param map to be translated into a map image
     * @return an map image of the given text map
     */
    public BufferedImage createMap(String map) {
        int[][] intMap = stringToIntMap(map);
        BufferedImage finalMap = new BufferedImage(intMap.length, intMap[0].length, BufferedImage.TYPE_INT_RGB);
        Graphics2D brush = finalMap.createGraphics();
        BlockLoader loader = new BlockLoader();
        for (int row = 0; row < intMap.length; row++) {
            for (int col = 0; col < intMap[row].length; col++) {
                brush.drawImage(loader.loadBlock(intMap[row][col]),
                             row * BlockTypes.BLOCK_SIZE,
                             col * BlockTypes.BLOCK_SIZE,
                        null);
            }
        }
        brush.dispose();
        return finalMap;
    }

    /**
     * Return a 2D array of block IDs
     *
     * @param map to be parsed for block ID's
     * @return 2D array of the parsed map by their block ID's
     * @throws IllegalArgumentException if !types.contains(currBlockID)
     * @spec.requires types.contains(currBlockID)
     */
    public int[][] stringToIntMap(String map) {
        int columns = map.split("\n")[0].split(" ").length;  // # of columns/width - next line char
        int rows = map.split("\n").length;                         // # of columns/width
        int[][] intMap = new int[rows][columns];
        String regex = "[\n, ]+";
        List<Integer> cleaned =
                Arrays.stream(map.split(regex))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int currBlockID = cleaned.get(i * columns + j);
                if (BlockTypes.validBlockID(currBlockID)) {
                    intMap[i][j] = currBlockID;
                } else {
                    throw new IllegalArgumentException("Invalid map, block " + currBlockID + " not a valid type of block");
                }
            }

        }

        return intMap;
    }
}
