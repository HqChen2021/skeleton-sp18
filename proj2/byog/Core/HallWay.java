package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class HallWay {


    private static void initMaze(TETile[][] world) {
        for (int i=0; i<world.length; i += 2) {
            for (int j=0; j<world[0].length; j += 2) {
                world[i][j] = Tileset.WALL;
            }
        }
        for (int i=1; i<world.length; i += 2) {
            for (int j=1; j<world[0].length; j += 2) {
                world[i][j] = Tileset.NOTHING;
            }
        }
    }

    private static void generateMaze(TETile[][] world) {

    }

}