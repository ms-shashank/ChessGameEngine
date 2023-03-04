import java.util.LinkedList;

public class chessPawns {
    int xp;
    int yp;
    int x;
    int y;
    boolean isWhite;
    String name;
    LinkedList<chessPawns> ps;
    public chessPawns(int xp, int yp, boolean isWhite ,String n, LinkedList<chessPawns> ps){
        this.xp = xp ;
        this.yp = yp;
        x = xp * 64;
        y = yp * 64;
        this.isWhite = isWhite;
        this.ps = ps;
        name = n;
        ps.add(this);
    }

    public void move(int xp , int yp){
        if(chessBoard.getchessPawns(xp * 64, yp * 64) != null) {
            if (chessBoard.getchessPawns(xp * 64, yp * 64).isWhite != isWhite) {
                chessBoard.getchessPawns(xp * 64, yp * 64).kill();
            }else{
                x = this.xp * 64;
                y = this.yp * 64;
                return ;
            }
        }
        this.xp = xp;
        this.yp = yp;
        x = xp * 64;
        y = yp * 64;
    }
    public void kill(){

        ps.remove(this);
    }
}
