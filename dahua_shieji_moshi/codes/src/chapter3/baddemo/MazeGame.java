package chapter3.baddemo;

/**
 * Created by DaiYan on 2017/4/22.
 */
public class MazeGame {
    public static void main(String[] args){

    }

    public Maze getTheMaze(){
        Maze maze=new Maze();
        Room r1=new Room();
        Room r2=new Room();

        //add rooms to maze
        maze.addRoom(r1);
        maze.addRoom(r2);

        //set the mapsite of room
        r1.setSide(Direction.NORTH,new Wall());
        r1.setSide(Direction.EAST,new Room());
        r1.setSide(Direction.WEST,new Room());
        r1.setSide(Direction.SOURTH,new Door(r1,r2));

        r1.setSide(Direction.NORTH,new Wall());
        r1.setSide(Direction.EAST,new Room());
        r1.setSide(Direction.WEST,new Room());
        r1.setSide(Direction.SOURTH,new Door(r1,r2));

        return maze;
    }
}
