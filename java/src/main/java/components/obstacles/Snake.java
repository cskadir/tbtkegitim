package components.obstacles;

import components.Player;

import java.util.Random;

public class Snake extends Obstacle {
    private int damageMax;
    public Snake(int damageMax) {
        super(4,"Snake",3,12,0);
        this.damageMax=damageMax;
    }

    @Override
    public int getDamage() {
        Random rd = new Random();
        return rd.nextInt(6) + 1;
    }
}
