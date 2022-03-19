package locations.normal;

import components.Player;
import locations.battle.BattleLoc;

import java.util.ArrayList;

public class SafeHause extends NormalLoc{

    public SafeHause(Player player) {
        super(player, "Safe Hause");
    }


    @Override
    public boolean onLocation() {
        System.out.println("You are in Safe Hause.");
        chechkAwardList();
        System.out.println("Your healty fulled.");
        this.getPlayer().setHealth(this.getPlayer().getOrginalHealth());
        return true;
    }


    public void chechkAwardList(){
        if(BattleLoc.defaulAwardList.equals(getPlayer().getAwards())){
            System.out.println("You collect all awards and  win the game!");
            System.exit(0);
        }
    }
}
