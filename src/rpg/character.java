package rpg;

import java.util.ArrayList;

public class character {
    private String job;
    private int hp;
    private int mag;
    private String name;
    private ArrayList<String> inventory;
    private ArrayList<Integer> inventoryNumber;
    private int gold;
    private String location; // 위치 필드 추가
    private long lastMoveTime; // 플레이어의 마지막 이동 시간을 기록하는 필드

    public character(String name, String job) {
        this.name = name;
        this.job = job;
        this.inventory = new ArrayList<>();
        this.inventoryNumber = new ArrayList<>();
        this.gold = 200;
        this.location = "마을"; // 초기 위치를 마을로 설정
        this.lastMoveTime = System.currentTimeMillis(); // 생성 시간으로 초기화

        // 직업에 따라 초기 체력과 마력 설정
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
                break;
        }
    }

    public void rename(String name) {
        this.name = name;
    }

    public void rejob(String job) {
        this.job = job;
    }

    public void resetInventory() {
        this.inventory.clear();
        this.inventoryNumber.clear();
    }

    public void addInventory(String item, int quantity) {
        int index = inventory.indexOf(item);
        if (index != -1) {
            int currentQuantity = inventoryNumber.get(index);
            inventoryNumber.set(index, currentQuantity + quantity);
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

    public void displayInventory() {
        System.out.println("<현재 인벤토리>");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i) + " : " + inventoryNumber.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public int getInventorySize() {
        return inventory.size();
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold -= gold;
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
        // 공격력 계산 메서드를 추가해야 합니다.
        // 이 예시에서는 공격력을 간단하게 마력의 절반으로 정의합니다.
        return mag / 2;
    }

    public String getJob() {
        return job;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public String getLocation() {
        return location;
    }

    public void move(String newLocation) {
        this.location = newLocation;
        System.out.println(name + "이(가) " + newLocation + "으로 이동했습니다.");
        updateLastMoveTime(); // 이동 시간 업데이트
    }

    public void displayInfo() {
        System.out.println("이름: " + name);
        System.out.println("직업: " + job);
        System.out.println("체력: " + hp);
        System.out.println("마력: " + mag);
        System.out.println("골드: " + gold);
        System.out.println("현재 위치: " + location); // 현재 위치 출력
        displayInventory();
    }

    private void updateLastMoveTime() {
        this.lastMoveTime = System.currentTimeMillis();
    }

    public long getLastMoveTime() {
        return lastMoveTime;
    }
}
