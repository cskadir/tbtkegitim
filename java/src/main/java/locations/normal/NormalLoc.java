package locations.normal;

import components.Player;
import locations.Location;

public abstract class NormalLoc extends Location {

    public NormalLoc(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
