package locations.battle;

import components.Player;
import components.Weapon;
import components.obstacles.Zombie;

import java.util.Random;

public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food", 3);
        BattleLoc.defaulAwardList.add("Food");
    }

    @Override
    protected void canavarıkestin() {
        int firstRandom = getRandom();
        if(firstRandom < 15){
            int secondRandom = getRandom();
            if(secondRandom < 20){
                System.out.println("You win a Rifle!");
                this.getPlayer().getInventory().setWeapon(Weapon.weapons()[2]);
            }
            else if(secondRandom< 50){
                System.out.println("You win a Sword!");
                this.getPlayer().getInventory().setWeapon(Weapon.weapons()[0]);
            }
            else {
                System.out.println("You win a Pistol!");
                this.getPlayer().getInventory().setWeapon(Weapon.weapons()[0]);
            }
        }
        else if(firstRandom < 30){
            int secondRandom = getRandom();
            if(secondRandom < 20){
                System.out.println("You win a Ağır Armor!");
                this.getPlayer().getInventory().setWeapon(Weapon.weapons()[2]);
            }
            else if(secondRandom< 50){
                System.out.println("You win a Orta Armor!");
                this.getPlayer().getInventory().setWeapon(Weapon.weapons()[0]);
            }
            else {
                System.out.println("You win a Hafif Armor!");
                this.getPlayer().getInventory().setWeapon(Weapon.weapons()[0]);
            }
        }
        else if(firstRandom < 55){
            int secondRandom = getRandom();
            if(secondRandom < 20){
                System.out.println("You win 10 money!");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+ 10);
            }
            else if(secondRandom< 50){
                System.out.println("You win 5money!");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+ 5);
            }
            else {
                System.out.println("You win 1 money!");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+ 1);
            }
        }
        else {
            System.out.println("You win nothing!");
        }
    }



    private int getRandom(){
        Random r = new Random();
        int low = 1;
        int high = 100;
        int result = r.nextInt(high-low) + low;
        return  result;
    }

}
