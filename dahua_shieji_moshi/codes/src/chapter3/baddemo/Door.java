package chapter3.baddemo;

/**
 * Created by DaiYan on 2017/4/22.
 */
public class Door implements MapSite {
    private boolean IsOpen;
    private Room R1;
    private Room R2;
    public Door(Room r1,Room r2){
        this.R1=r1;
        this.R2=r2;
    }

    public Room otherSideFrom(Room r1){
        return null;
    }

    public void enter(){

    }
}
