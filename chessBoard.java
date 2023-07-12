//some are additional packages
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class chessBoard {
    public static LinkedList<chessPawns> ps = new LinkedList<>();
    public static chessPawns selectedchessPawns =  null;
    //Taking a image from folder using IOException and give your path file
    public static void main(String[] args) throws IOException {
        BufferedImage all= ImageIO.read(new File("C:\\Users\\User\\Downloads\\chesspawn images.png"));//give your path files
        Image imgs[]=new Image[12];
        /*based on the images, place your pices appropriatly using for condition as it is used for cutting the images 
            into individual pices and placing on the board*/ 
        int ind=0;
        for(int y=0;y<400;y+=200){
            for(int x=0;x<1200;x+=200){
                imgs[ind]=all.getSubimage(x, y, 200, 200).getScaledInstance(64, 64, BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }
        //Arrangment of the pawns on the board according to the row & column (like in a matrix)
        chessPawns bKing = new chessPawns(3, 0, false, "king", ps);
        chessPawns bQueen = new chessPawns(4, 0, false, "queen",ps);
        chessPawns bBishop = new chessPawns(2, 0, false, "bishop", ps);
        chessPawns bBishop1 = new chessPawns(5, 0, false, "bishop", ps);
        chessPawns bHorse = new chessPawns(1, 0, false, "horse", ps);
        chessPawns bHorse1 = new chessPawns(6, 0, false, "horse", ps);
        chessPawns bRook = new chessPawns(0, 0, false, "rook", ps);
        chessPawns bRook1 = new chessPawns(7, 0, false, "rook", ps);
        chessPawns bPawn = new chessPawns(0, 1, false, "pawn", ps);
        chessPawns bPawn1 = new chessPawns(1, 1, false, "pawn", ps);
        chessPawns bPawn2 = new chessPawns(2, 1, false, "pawn", ps);
        chessPawns bPawn3 = new chessPawns(3, 1, false, "pawn", ps);
        chessPawns bPawn4 = new chessPawns(4, 1, false, "pawn", ps);
        chessPawns bPawn5 = new chessPawns(5, 1, false, "pawn", ps);
        chessPawns bPawn6 = new chessPawns(6, 1, false, "pawn", ps);
        chessPawns bPawn7 = new chessPawns(7, 1, false, "pawn", ps);
        chessPawns wKing = new chessPawns(3, 7, true, "king", ps);
        chessPawns wQueen = new chessPawns(4, 7, true, "queen", ps);
        chessPawns wBishop = new chessPawns(2, 7, true, "bishop", ps);
        chessPawns wBishop1 = new chessPawns(5, 7, true, "bishop", ps);
        chessPawns wHorse = new chessPawns(1, 7, true, "horse", ps);
        chessPawns wHorse1 = new chessPawns(6, 7, true, "horse", ps);
        chessPawns wRook = new chessPawns(0, 7, true, "rook", ps);
        chessPawns wRook1 = new chessPawns(7, 7, true, "rook", ps);
        chessPawns wPawn = new chessPawns(0, 6, true, "pawn", ps);
        chessPawns wPawn1 = new chessPawns(1, 6, true, "pawn", ps);
        chessPawns wPawn2 = new chessPawns(2, 6, true, "pawn", ps);
        chessPawns wPawn3 = new chessPawns(3, 6, true, "pawn", ps);
        chessPawns wPawn4 = new chessPawns(4, 6, true, "pawn", ps);
        chessPawns wPawn5 = new chessPawns(5, 6, true, "pawn", ps);
        chessPawns wPawn6 = new chessPawns(6, 6, true, "pawn", ps);
        chessPawns wPawn7 = new chessPawns(7, 6, true, "pawn", ps);

        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 512, 512);
        frame.setUndecorated(true);//to remove the boarders
        JPanel pn = new JPanel(){   //created a new Jpanel to get the chess like a board
            @Override
            public void paint(Graphics g) {   //giving a color to the each matrix of row & coloumn 
                boolean white = true ;
                for(int x = 0 ; x < 8 ; x++){  //rows
                    for(int y = 0 ; y < 8 ; y++) {   //columns
                        if (white) {
                            g.setColor(new Color(235, 235, 208));  //co-ordinates
                        } else {
                            g.setColor(new Color(119,148, 83));   //co-ordinates
                        }
                        g.fillRect(x * 64, y * 64, 64, 64);
                        white =! white;   //if not black
                    }
                    white =! white;
                }
                //Assiging the pices and giving there frams
                for(chessPawns p:ps){
                    int ind = 0;
                    if(p.name.equalsIgnoreCase("king")){
                        ind = 0;    
                    }
                    if(p.name.equalsIgnoreCase("queen")){
                        ind = 1;
                    }
                    if(p.name.equalsIgnoreCase("bishop")){
                        ind = 2;
                    }
                    if(p.name.equalsIgnoreCase("horse")){
                        ind = 3;
                    }
                    if(p.name.equalsIgnoreCase("rook")){
                        ind = 4;
                    }
                    if(p.name.equalsIgnoreCase("pawn")){
                        ind = 5;
                    }
                    if(!p.isWhite){
                        ind+=6;
                    }
                    g.drawImage(imgs[ind], p.x  , p.y , this);
                }
            }
        };
        frame.add(pn);
        frame.addMouseListener(new MouseListener() {          //getting mouse to be used on piceses 
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {           //to select the pawns after mouse is pressed or right clicked or should be holded
                //System.out.println((getchessPawns(e.getX(), e.getY()).isWhite?"white ":"black ") +getchessPawns(e.getX(), e.getY()).name);
                selectedchessPawns = getchessPawns(e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {           //placing the pawn after realsing the pawn in a specfic place
                selectedchessPawns.move(e.getX() / 64, e.getY() / 64);
                frame.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {            //Mouse event reaction after entered or clicked

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        frame.addMouseMotionListener(new MouseMotionListener() {       //Giving motion to the pawns whereever the pawns moves like (frames)
            @Override
            public void mouseDragged(MouseEvent e) {
                if(selectedchessPawns != null){
                    selectedchessPawns.x = e.getX() - 32;
                    selectedchessPawns.y = e.getY() - 32;
                    frame.repaint();
                }

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);

    }
    public static chessPawns getchessPawns(int x, int y){               //after getting the chess pawns under the mouse click 
        int xp = x / 64;
        int yp = y / 64;
        for(chessPawns p: ps){
            if(p.xp == xp && p.yp == yp){
                return p;
            }
        }
        return null;
    }
}
