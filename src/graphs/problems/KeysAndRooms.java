package graphs.problems;
/*
    841. Keys and Rooms - LeetCode
    There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
    Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
    Initially, all the rooms start locked (except for room 0).
    You can walk back and forth between rooms freely.
    Return true if and only if you can enter every room.
 */
import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // start at 0 and perform dfs, mark all visited rooms as true
        // if in the end we have unvisited rooms, then we return false
        int n = rooms.size();
        boolean[] roomVisited = new boolean[n];
        dfs(0, roomVisited, rooms);
        for(int i=0; i<n; i++){
            if(!roomVisited[i])
                return false;
        }
        return true;
    }
    public void dfs(int currRoom, boolean[] roomVisited, List<List<Integer>> rooms){
        roomVisited[currRoom] = true;
        List<Integer> keys = rooms.get(currRoom);
        for(int key : keys){
            if(!roomVisited[key]){
                dfs(key, roomVisited, rooms);
            }
        }
    }
}
