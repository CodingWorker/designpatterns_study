package chapter3.baddemo;

import java.util.ArrayList;

/**
 * Created by DaiYan on 2017/4/22.
 */
public class Maze {
    private static ArrayList<MapSite> _maze=new ArrayList<>();
    public void addRoom(Room r){
        _maze.add(r);
    }

    public MapSite getRoom(int index){
        return _maze.get(index);
    }
}
