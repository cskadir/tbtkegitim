package locations.battle;

import components.Player;
import components.obstacles.Bear;

public class River extends BattleLoc {
    public River(Player player) {
        super(player,"River", new Bear(),"Water",2);
        BattleLoc.defaulAwardList.add("Water");
    }
}
