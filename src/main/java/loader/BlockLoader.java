package loader;

import map.BlockTypes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Load block images here
 */
public class BlockLoader extends Loader{

    /**
     * Mapped blockIDs to their associated images, blockIDs -> image
     */
    private final HashMap<Integer, BufferedImage> blockIDToImage = (HashMap<Integer, BufferedImage>) Stream.of(new Object[][] {
            { BlockTypes.EMPTY, loadEmptyBlock() },
            { BlockTypes.GRASS, loadImage("grassBlock.png") },
            { BlockTypes.STONE, loadImage("stoneBlock.png") }
    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (BufferedImage) data[1]));

    /**
     * Helper function to load images by their blockIDS
     * @param blockID to used in returning the associated block image
     * @return image of associated blockID
     */
    public BufferedImage loadBlock(int blockID) {
        if (!blockIDToImage.containsKey(blockID)) {
            throw new IllegalArgumentException("Invalid map, blockID " + blockID + " not a valid type of blockID");
        }
        return blockIDToImage.get(blockID);
    }

    /**
     * Returns an image of an empty block, associated with BlockTypes.EMPTY
     *
     * For purpose of game development, BlockTypes.EMPTY will be RED
     *
     * @return an image of an empty block
     */
    public BufferedImage loadEmptyBlock() {
        BufferedImage empty =  new BufferedImage(BlockTypes.BLOCK_SIZE, BlockTypes.BLOCK_SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics2D brush = empty.createGraphics();
        brush.setColor(Color.WHITE);
        brush.fillRect(0, 0, BlockTypes.BLOCK_SIZE, BlockTypes.BLOCK_SIZE);
        brush.dispose();
        return empty;
    }
}
