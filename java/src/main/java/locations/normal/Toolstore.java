package locations.normal;

import components.Armor;
import components.Player;
import components.Weapon;

import java.util.Scanner;

public class Toolstore extends NormalLoc {

    private Scanner sc = new Scanner(System.in);

    public Toolstore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the Tool Store.");
        boolean showMenuBool = true;
        while (showMenuBool) {
            showMenu();
            System.out.print("Please Select  an Option:");

            int selectedOption = sc.nextInt();
            while (selectedOption < 1 || selectedOption > 3) {
                showMenu();
                System.out.println("Wrong selection. Please try again");
                selectedOption = sc.nextInt();
            }

            switch (selectedOption) {
                case 1:
                    printWeapon();
                    break;
                case 2:
                    printArmor();
                    break;
                case 3:
                    System.out.println("See you later..");
                    showMenuBool = false;
                    break;
            }
        }
        return true;
    }

    private void showMenu() {
        System.out.println("1. Weapons");
        System.out.println("2. Armors");
        System.out.println("3. Exit");
    }


    private void printWeapon() {
        System.out.println("Weapons->");
        System.out.println("0. ->> Exit");
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.toString());
        }
        System.out.print("Select a weapon:");
        int selectedWeaponId = sc.nextInt();

        while (selectedWeaponId < 0 || selectedWeaponId > Weapon.weapons().length) {
            System.out.println("Wrong selection. Please try again");
            selectedWeaponId = sc.nextInt();
        }
        buyWeapon(selectedWeaponId);


    }

    private void buyWeapon(int selectedWeaponId) {
        if (selectedWeaponId != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjectById(selectedWeaponId);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money !");
                } else {
                    System.out.println(selectedWeapon.getName() + " Purchased!");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() -
                            selectedWeapon.getPrice());

                    System.out.println("Old weapon name: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("New weapon name: " + this.getPlayer().getInventory().getWeapon().getName());
                    System.out.println("Last Balance : " + this.getPlayer().getMoney());

                }
            }
        }
    }


    private void printArmor() {
        System.out.println("Armors->");
        System.out.println("0. ->> Exit");
        for (Armor a : Armor.armors()) {
            System.out.println(a.toString());
        }
        System.out.print("Select an armor:");
        int selectedArmorId = sc.nextInt();

        while (selectedArmorId < 0 || selectedArmorId > Armor.armors().length) {
            System.out.println("Wrong selection. Please try again");
            selectedArmorId = sc.nextInt();
        }
        buyArmor(selectedArmorId);
    }

    private void buyArmor(int selectedArmorId) {

        if(selectedArmorId != 0){
            Armor selectedArmor = Armor.getWeaponObjectById(selectedArmorId);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money !");
                } else {
                    System.out.println(selectedArmor.getName() + " Purchased!");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() -
                            selectedArmor.getPrice());

                    System.out.println("Old armor name: " + this.getPlayer().getInventory().getArmor().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("New armor name: " + this.getPlayer().getInventory().getArmor().getName());
                    System.out.println("Last Balance : " + this.getPlayer().getMoney());

                }
            }
        }
    }

    public void menu() {

    }

}
