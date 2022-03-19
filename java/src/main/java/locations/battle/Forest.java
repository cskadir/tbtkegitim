package locations.battle;

import components.Player;
import components.obstacles.Vampire;

public class Forest extends BattleLoc {

    public Forest(Player player) {
        super(player,"Forest", new Vampire(),"firewood",3);
        BattleLoc.defaulAwardList.add("firewood");
    }
}