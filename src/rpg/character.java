package rpg;

import java.util.ArrayList;

public class character {
    private String name;
    private String job;
    private int hp;
    private int mag;
    private int gold;
    private String location;
    private long lastMoveTime;
    private ArrayList<String> inventory;
    private ArrayList<Integer> inventoryNumber;

    public character(String name, String job) {
        this.name = name;
        this.job = job;
        this.gold = 200;
        this.location = "마을";
        this.lastMoveTime = System.currentTimeMillis();
        this.inventory = new ArrayList<>();
        this.inventoryNumber = new ArrayList<>();

        switch (job) {
            case "전사":
                this.hp = 150;
                this.mag = 50;
                break;
            case "마법사":
                this.hp = 100;
                this.mag = 150;
                break;
            case "도적":
                this.hp = 120;
                this.mag = 100;
                break;
            default:
                System.out.println("잘못된 직업입니다. 기본값으로 전사로 설정됩니다.");
                this.job = "전사";
                this.hp = 150;
                this.mag = 50;
        }
    }

    public void addInventory(String item, int quantity) {
        int index = inventory.indexOf(item);
        if (index != -1) {
            inventoryNumber.set(index, inventoryNumber.get(index) + quantity);
            System.out.println("인벤토리에 이미 존재하는 아이템 " + item + "의 수량을 " + quantity + "개 추가했습니다.");
        } else {
            if (inventory.size() < 15) {
                inventory.add(item);
                inventoryNumber.add(quantity);
                System.out.println("아이템 " + item + "을(를) " + quantity + "개 추가했습니다.");
            } else {
                System.out.println("인벤토리가 가득 찼습니다.");
            }
        }
    }

    public void displayInfo() {
        System.out.println("이름: " + name);
        System.out.println("직업: " + job);
        System.out.println("체력: " + hp);
        System.out.println("마력: " + mag);
        System.out.println("골드: " + gold);
        System.out.println("현재 위치: " + location);
        displayInventory();
    }

    public void displayInventory() {
        System.out.println("<현재 인벤토리>");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i) + " : " + inventoryNumber.get(i));
        }
    }

    public void move(String newLocation) {
        this.location = newLocation;
        updateLastMoveTime();
        System.out.println(name + "이(가) " + newLocation + "으로 이동했습니다.");
    }

    private void updateLastMoveTime() {
        this.lastMoveTime = System.currentTimeMillis();
    }

    public String getLocation() {
        return location;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold += gold;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMag() {
        return mag;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public int getAttack() {
        return mag / 2;
    }

    public long getLastMoveTime() {
        return lastMoveTime;
    }

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
