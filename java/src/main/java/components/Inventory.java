package components;

public class Inventory {
    /*private boolean water;
    private boolean food;
    private boolean firewood;
    private String weaponName;
    private String armorName;
    private int weaponDamage;
    private int armorDefence;*/

    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.weapon = new Weapon("Punch",-1,0,0);
        this.armor = new Armor(-1,0,"paçavra",0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
