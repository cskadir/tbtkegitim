package components;

import components.character.Archer;
import components.character.Chevalier;
import components.character.GameChar;
import components.character.Samurai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private int damage;
    private int health;
    private int orginalHealth;
    private int money;
    private String name;
    private String charNAme;
    private List<String> awards;
    private GameChar[] gameCharList = {new Samurai(), new Archer(), new Chevalier()};


    private Scanner sc = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {


        System.out.println("###############################################################################");
        for (GameChar gameChar : gameCharList) {
            System.out.println(gameChar.toString());
        }
        System.out.println("###############################################################################");

        System.out.print("Please select a character: ");
        int selectChar = sc.nextInt();
        if (selectChar >= 0 && selectChar <= gameCharList.length) {
            initPlayer(gameCharList[selectChar - 1]);
        } else {
            initPlayer(gameCharList[0]);
        }

        System.out.println("Selected character:" + this.getCharNAme());
    }

    public void printInfo() {
        String s = "Weapon: " + this.getInventory().getWeapon().getName() +
                "\tArmor: " + this.getInventory().getArmor().getName() +
                "\tArmor Block: " + this.getInventory().getArmor().getBlock() +
                "\tDamage: " + this.getTotalDamage() +
                "\tHealty: " + this.getHealth()+
                "\tMoney: " + this.getMoney();
        System.out.println(s);


    }

    public void initPlayer(GameChar gc) {
        this.setDamage(gc.getDamage());
        this.setHealth(gc.getHealth());
        this.setMoney(gc.getMoney());
        this.setCharNAme(gc.getName());
        this.setOrginalHealth(gc.getHealth());
        this.setAwards(new ArrayList<>());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getTotalDamage(){
        return damage + getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharNAme() {
        return charNAme;
    }

    public void setCharNAme(String charNAme) {
        this.charNAme = charNAme;
    }

    public Weapon getWeapon(){
        return this.inventory.getWeapon();
    }

    public int getOrginalHealth() {
        return orginalHealth;
    }

    public void setOrginalHealth(int orginalHealth) {
        this.orginalHealth = orginalHealth;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }
}
