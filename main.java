package lobby;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//C:\Users\Uefi\eclipse-workspace
public class main {
	static Scanner sc = new Scanner(System.in);
	final static int Max_Inventory = 30;
	static int Map_Location = 0;
	static ArrayList<String> Inventory = new ArrayList<String>();
	final static String Map[] = { "마을", "숲", "바다", "지하" };
	final static String item[] = { "검", "활", "방패", "단검" };

	public static void meun() {
		try {
			System.out.println("--------------------");
			System.out.println("[RPG 메뉴]");
			System.out.println("1. 내정보");
			System.out.println("2. 상점");
			System.out.println("3. 지도");
			System.out.println("4. 퀘스트");
			System.out.println("-입력 >> ");
			int select = sc.nextInt();
			if (select == 1 || select == 2 || select == 3 || select == 4) {
				MeunSelect(select);
			} else {
				System.out.println("1부터 4 사이만 입력해주세요.");
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("숫자만 입력해주세요");
		}
	}

	public static void MeunSelect(int Number) {
		switch (Number) {
		case 1:
			Character();
			break;
		case 2:
			Shop();
			break;
		case 3:
			Map();
			break;
		case 4:
			Quest();
			break;
		}
	}

	private static void Character() {
		// TODO Auto-generated method stub
		System.out.println("--------------------");
		System.out.println("[내정보]");
		System.out.println("인벤토리 : " + Inventory);
		System.out.println("내위치 : " + Map[Map_Location]);
	}

	private static void Shop() {
		// TODO Auto-generated method stub
		String ItemSelect;
		System.out.println("--------------------");
		String[] strArr = new String[2];
		System.out.println("[상점]");
		System.out.println("[아이템]");

		for (int i = 0; i < item.length; i++) {
			System.out.println(i + "-" + item[i]);
		}
		System.out.println("--------------------");
		System.out.println("1. 선택 [아이템 번호] 2. 취소");
		ItemSelect = sc.next();
		strArr = ItemSelect.split("-");
		int itemNum = Integer.parseInt(strArr[1]);
		if (ItemSelect.equals("1-0") || ItemSelect.equals("1-1") || ItemSelect.equals("1-2")
				|| ItemSelect.equals("1-3")) {
			System.out.println("1.구매 2.취소");
			ItemSelect = sc.next();
			if (ItemSelect.equals("1") || ItemSelect.equals("2")) {
				Inventory.add(item[itemNum]);
				System.out.println(item[itemNum] + "(을)를 구매하셨습니다.");
			}
		}
	}

	private static void Map() {
		// TODO Auto-generated method stub
		System.out.println("[지도]");
		System.out.println("0.마을 1.숲 2. 바다 3.지하");
		Map_Location = sc.nextInt();
		System.out.println(Map[Map_Location] + "(으)로 이동했습니다.");

	}

	private static void Quest() {
		// TODO Auto-generated method stub
		LocalTime lct = LocalTime.now();
		System.out.println("[퀘스트]");
		String obj = "15:00:00.000000000";
		
		if (lct.equals(obj)) {
			System.out.println(lct);
			System.out.println("3시가 아닙니다.");

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			meun();
		}
	}
}
