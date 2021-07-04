import com.sun.codemodel.internal.JBlock;
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class TicTacToe extends PApplet {

    Block[][] blocks = new Block[3][3];
    Block blockHere;
    boolean win = false;

    public void setup() {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                blocks[i][j] = new Block(100 * (i + 1), 100 * (j + 1), 100);
            }
        }

    }

    public void draw() {
        background(100);
        if (win == true) {
            text("WIN", 100, 100);
        }

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j].checkHere(mouseX, mouseY)) {
                    blocks[i][j].drawBlock(this, false);
                    blockHere = blocks[i][j];
                } else {
                    blocks[i][j].drawBlock(this, true);
                }
            }
        }
    }


    public void settings() {
        size(500, 500);
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"TicTacToe"};
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }

    int round = 1;

    public void mouseClicked() {
        if (blockHere.checkAvailable() == true) {
            if(win==false){
                if (round == 2) {
                    blockHere.setPlayed(1);
                    round = round - 1;
                } else if (round == 1) {
                    blockHere.setPlayed(2);
                    round = round + 1;
                }
            }
            if (checkWin() == true) {
                System.out.println("Win");
                win = true;


            }
        }
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (blocks[i][0].played == blocks[i][1].played && blocks[i][1].played == blocks[i][2].played) {
                if (blocks[i][0].played != blocks[i][0].E) {
                    return true;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (blocks[0][i].played == blocks[1][i].played && blocks[1][i].played == blocks[2][i].played) {
                if (blocks[0][i].played != blocks[0][i].E) {
                    return true;
                }
            }
        }

        int i = 0;
        if (blocks[i][i].played == blocks[i + 1][i + 1].played && blocks[i + 1][i + 1].played == blocks[i + 2][i + 2].played) {
            if (blocks[i][i].played != blocks[i][i].E) {
                return true;
            }
        }


        if (blocks[i + 2][i].played == blocks[i + 1][i + 1].played && blocks[i + 1][i + 1].played == blocks[i][i + 2].played) {
            if (blocks[i + 2][i].played != blocks[i][i].E) {
                return true;
            }
        }
        return false;
    }
}
