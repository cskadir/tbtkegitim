package locations.battle;

import components.Player;
import components.obstacles.Obstacle;
import locations.Location;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location {
    public static ArrayList<String> defaulAwardList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        if (!getPlayer().getAwards().contains(this.award)) {
            int obsNumber = randomObstacleNumber();
            System.out.println("You are now at: " + this.getName());
            System.out.println("Caution!! " + obsNumber + " " + this.getObstacle().getName() + "is living here");
            System.out.println("Press F for Fight");
            System.out.println("Press R for Run");

            String selectedCase = sc.nextLine();
            selectedCase = selectedCase.toUpperCase(Locale.ROOT);
            if (selectedCase.equals("F") && combat(obsNumber)) {
                System.out.println("You win battle at " + this.getName());
                return true;
            }
            if (this.getPlayer().getHealth() <= 0) {
                System.out.println("You die");
                return false;
            }
            return true;
        } else {
            System.out.println("Player passed this battle location");
            return true;
        }
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrginalHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("Battle Stating....3.2.1..");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Random rd = new Random();
                boolean firstHit = rd.nextBoolean();
/*                System.out.println("Press A for Attack");
                System.out.println("Press R for Run");
                String selectedCombat = sc.nextLine().toUpperCase(Locale.ROOT);*/
                if (firstHit) {
                    System.out.println("Player attacked!");
                    obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println(this.getObstacle().getName() + "Attacked!");
                        int obstacleDamage = this.obstacle.getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else {
                    System.out.println(this.getObstacle().getName() + "Attacked!");
                    int obstacleDamage = this.obstacle.getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                    afterHit();
                    if (this.getPlayer().getHealth() > 0) {
                        System.out.println("Player attacked!");
                        obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    }
                }
            }
            if ((this.getObstacle().getHealth() < this.getPlayer().getHealth()) && i == obsNumber) {
                System.out.println("You passed episode.");
                this.getPlayer().getAwards().add(this.award);
                System.out.println("Award added to player award list.");
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                canavarıkestin();
            } else {
                return false;
            }
        }
        return false;
    }

    protected void canavarıkestin() {
        System.out.println(this.getObstacle().getAward() + " money earned.");
        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.obstacle.getAward());
        System.out.println("New balance: " + this.getPlayer().getMoney());
    }


    private void afterHit() {
        System.out.println("Player health: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " health: " + this.obstacle.getHealth());
        System.out.println("-----------------------");
    }

    private void obstacleStats(int i) {
        System.out.println("################################");
        System.out.println(i + ". " + this.getObstacle().getName() + " Status");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
        System.out.println("################################");
    }

    public void playerStats() {
        System.out.println("################################");
        System.out.println("Player Status ");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getWeapon().getName());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money: " + this.getPlayer().getMoney());

        System.out.println("################################");


    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(3) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
