package J2SE.Thread;

import J2SE.charactor.Hero;

public class killThread extends Thread{
    private Hero h1;
    private Hero h2;
    public killThread(Hero h1,Hero h2){
        this.h1=h1;
        this.h2=h2;
    }
    @Override
    public void run() {
        while(!h2.isDie()){
            h1.attackHero(h2);
        }
    }
}
