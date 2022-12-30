package byog.Core;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.ArrayList;
import java.util.Random;

/** Generate map
 * */
public class MapGenerator {
    private int WIDTH;
    private int HEIGHT;
    private static final int TIMES=100;
    private Random rnd;
    private ArrayList<Room> roomList;
    /** fill the map with rooms at random
     */
    private void fillRooms() {
        for (int i = 0; i < TIMES; i++) {
            int x = rnd.nextInt(WIDTH);
            int y = rnd.nextInt(HEIGHT);
            int roomWidth = rnd.nextInt(WIDTH/10) + 2;
            int roomHeight = rnd.nextInt(HEIGHT/5) + 2;

            if (y+roomHeight > HEIGHT || x+roomWidth > WIDTH) {
                continue;
            }
            if (isOverlap(x,y,roomHeight,roomWidth)) {
                continue;
            }
            buildRoom(x, y , roomHeight, roomWidth);
            roomList.add(new Room(x, y ,roomWidth, roomHeight));
        }
    }

    private void buildRoom(int x, int y, int roomHeight, int roomWidth) {
        return;
    }

    private boolean isOverlap(int x, int y, int roomHeight, int roomWidth) {
        return true;
    }

    private void buildMaze(){
        return;
    }
}