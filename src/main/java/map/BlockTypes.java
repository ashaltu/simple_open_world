package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Strictly for retrieving information about blocks
 *
 * All blocks are 16x16 pixels wide
 */
public class BlockTypes {

    public static final int BLOCK_SIZE = 16;

    /**
     * Block types by their IDs
     */
    public static final int EMPTY = 0;
    public static final int GRASS = 1;
    public static final int STONE = 2;

    /**
     * Block IDs to their associated names
     */
    private static final HashMap<Integer, String> blockIDToText = (HashMap<Integer, String>) Stream.of(new Object[][] {
            { BlockTypes.EMPTY, "EMPTY" },
            { BlockTypes.GRASS, "GRASS" },
            { BlockTypes.STONE, "STONE" }
    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));

    /**
     * All block types in the game
     */
    private static final List<Integer> types = Collections.unmodifiableList(List.of(
            EMPTY,
            GRASS,
            STONE
    ));

    /**
     * Return the name of the given blockID
     *
     * @param blockID the id of the block type
     * @return the name of the associated blockID
     */
    public static String blockIDToName(int blockID) {
        if (!blockIDToText.containsKey(blockID)) {
            throw new IllegalArgumentException("Invalid map, block " + blockID + " not a valid type of block");
        }

        return blockIDToText.get(blockID);
    }

    /**
     * Checks if given blockID is a valid block type
     *
     * @param blockID to be checked if a valid type
     * @return true if types.contains(blockID), otherwise return false
     */
    public static boolean validBlockID(int blockID) {
        return types.contains(blockID);
    }
}
