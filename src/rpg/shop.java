package rpg;

import java.util.*;

public class shop {
	static final String[] SHOP_ITEMS = { "Health Potion", "Mana Potion", "Sword", "Shield" };
	static final int[] ITEM_PRICES = { 50, 50, 100, 80 }; // 아이템 가격

	public static void shopMenu(character ch) {
		Scanner sc = new Scanner(System.in);
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

			if (choice == 0) {
				System.out.println("상점을 나갑니다.");
				break;
			}

			if (choice < 0 || choice > SHOP_ITEMS.length) {
				System.out.println("잘못된 입력입니다. 다시 시도하세요.");
				continue;
			}

			int itemIndex = choice - 1;
			String selectedItem = SHOP_ITEMS[itemIndex];
			int itemPrice = ITEM_PRICES[itemIndex];

			if (ch.getInventorySize() >= 15) {
				System.out.println("인벤토리가 가득 찼습니다. 구매할 수 없습니다.");
				continue;
			}

			if (ch.getGold() < itemPrice) {
				System.out.println("골드가 부족합니다. 아이템을 구매할 수 없습니다.");
				continue;
			}

			ch.setGold(itemPrice);
			ch.addInventory(selectedItem, 1);
			System.out.println(selectedItem + "를 구매했습니다. 남은 골드: " + ch.getGold());
		}
	}
}
