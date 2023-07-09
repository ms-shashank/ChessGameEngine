import java.util.LinkedList;

public class chessPawns {
    //Giving the pawns there axes to be placed
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
        x = xp * 64;  //Reading every rows and columns x = row 
        y = yp * 64;  // y = column
        this.isWhite = isWhite;
        this.ps = ps;
        name = n;
        ps.add(this);
    }

    public void move(int xp , int yp){
        if(chessBoard.getchessPawns(xp * 64, yp * 64) != null) {   
            if (chessBoard.getchessPawns(xp * 64, yp * 64).isWhite != isWhite) {  //if pawns are white then it can't be killed if not it can be killed
                chessBoard.getchessPawns(xp * 64, yp * 64).kill();   //kill the pawns if they are placed on different colour
            }else{
                //if not they move withtout any killing
                x = this.xp * 64;  
                y = this.yp * 64;
                return ;
            }
        }
        //updating the positions after movement
        this.xp = xp;
        this.yp = yp;
        x = xp * 64;
        y = yp * 64;
    }
    public void kill(){

        ps.remove(this);
    }
}
