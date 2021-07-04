public class Block{
    final int x;
    final int y;
    int size;
    int played;

    final int E = 0;
    final int X = 1;
    final int O = 2;

    public void setPlayed(int x) {
        played = x;
    }

    public Block(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.played = E;

    }

    public boolean checkAvailable() {
        if (played == E) {
            return true;
        } else {
            return false;
        }
    }



        public void drawBlock(TicTacToe main, boolean lightBg){
            if(lightBg == true){
                main.fill(0,255,221);
            }else {
                main.fill(43, 224, 91);
            }

            main.rect(x,y,size,size);

            main.fill(155,155,0);
            main.textSize(90);
            if(played==X){
                main.text("X",x+22,y+80);
            }else if(played==O){
                main.text("O",x+18,y+80);
            }


    }



        public boolean checkHere( int x1, int y1){
            if(x<x1 && x1<x+size){
                if(y<y1 && y1<y+size){
                    return true;
                }
            }
            return false;
        }
    }

