package rpg;

import java.util.Scanner;

public class shop {
    static final String[] SHOP_ITEMS = {"Health Potion", "Mana Potion", "Sword", "Shield"};
    static final int[] ITEM_PRICES = {50, 50, 100, 80};

    public static void shopMenu(character ch, Scanner sc) {
        System.out.println("상점에 입장하셨습니다!");
        System.out.println("현재 골드: " + ch.getGold());

        while (true) {
            System.out.println("\n<상점 명령어 목록>");
            for (int i = 0; i < SHOP_ITEMS.length; i++) {
                System.out.println((i + 1) + ". " + SHOP_ITEMS[i] + " - 가격: " + ITEM_PRICES[i]);
            }
            System.out.println("0. 나가기");

            System.out.print("구매할 아이템 번호를 입력하세요: ");
            int choice = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            if (choice == 0) {
                System.out.println("상점을 나갑니다.");
                break;
            }

            if (choice < 1 || choice > SHOP_ITEMS.length) {
                System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                continue;
            }

            int itemIndex = choice - 1;
            if (ch.getGold() < ITEM_PRICES[itemIndex]) {
                System.out.println("골드가 부족합니다. 아이템을 구매할 수 없습니다.");
                continue;
            }

            ch.setGold(-ITEM_PRICES[itemIndex]);
            ch.addInventory(SHOP_ITEMS[itemIndex], 1);
            System.out.println(SHOP_ITEMS[itemIndex] + "를 구매했습니다. 남은 골드: " + ch.getGold());
        }
    }
}