package rpg;

import java.util.Random;
import java.util.Scanner;

public class lobby {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        character player = new character("no name", "전사");
        int cmd;
        // 이름 입력
        System.out.println("캐릭터를 생성합니다. 이름을 입력하세요:");
        String name = sc.nextLine();

        // 직업 선택
        System.out.println("직업을 선택하세요:");
        System.out.println("1. 전사");
        System.out.println("2. 마법사");
        System.out.println("3. 도적");
        int job = sc.nextInt();

        switch (job) {
            case 1:
                player = new character(name, "전사");
                break;
            case 2:
                player = new character(name, "마법사");
                break;
            case 3:
                player = new character(name, "도적");
                break;
            default:
                System.out.println("잘못된 선택입니다. 기본값으로 전사로 생성됩니다.");
                player = new character(name, "전사");
                break;
        }

        WorldMap worldMap = new WorldMap(); // 예시로 5x5 세계 지도 생성
        worldMap.updateLocationInfo("마을", "마을"); // 캐릭터의 초기 위치 설정

        while (true) {
            System.out.println("<메인 명령어 목록>");
            System.out.println("1. 내정보");
            System.out.println("2. 상점");
            System.out.println("3. 지도");
            System.out.println("4. 이동");
            System.out.println("5. 나가기");
            System.out.print("명령어를 선택해주세요 : ");
            cmd = sc.nextInt();
            switch (cmd) {
                case 1:
                    player.displayInfo();
                    break;
                case 2:
                    callShopMenu(player);
                    break;
                case 3:
                    worldMap.displayMap();
                    break;
                case 4:
                    moveCharacter(player, worldMap, sc);
                    break;
                case 5:
                    System.out.println("게임을 종료합니다.");
                    System.exit(0);
            }
        }
    }

    // 캐릭터 이동 기능 구현 메서드 추가
    public static void moveCharacter(character player, WorldMap worldMap, Scanner sc) {
        // 이동할 지역 이름 입력 받기
        System.out.print("이동할 지역 이름을 입력하세요: ");
        String destination = sc.next();

        // 입력한 지역 이름으로 이동
        if (worldMap.isValidLocation(destination)) {
            if (destination.equals(player.getLocation())) {
                System.out.println("이미 해당 지역에 있습니다. 이동이 불필요합니다.");
            } else {
                if (destination.equals("숲") || destination.equals("동굴")) {
                    System.out.println("경고: 이 지역에는 몬스터가 출현할 수 있습니다!");
                    monster monster = generateRandomMonster();
                    battleSystem battleSystem = new battleSystem(player, monster, sc);
                    battleSystem.startBattle();
                } else if (destination.equals("마을")) {
                    System.out.println("이 지역에서는 몬스터가 출현하지 않습니다.");
                }
                player.move(destination);
                System.out.println("이동했습니다. 새로운 위치: " + destination);
            }
        } else {
            System.out.println("해당 지역으로는 이동할 수 없습니다.");
        }
    }

    private static monster generateRandomMonster() {
        Random rand = new Random();
        int monsterType = rand.nextInt(3); // 총 3종류의 몬스터가 있다고 가정
        switch (monsterType) {
            case 0:
                return new monster("고블린", 100, 20);
            case 1:
                return new monster("오크", 150, 30);
            case 2:
                return new monster("드래곤", 200, 50);
            default:
                return new monster("고블린", 100, 20);
        }
    }

    public static void callShopMenu(character player) {
        if (!player.getLocation().equals("마을")) {
            System.out.println("상점은 마을에서만 이용할 수 있습니다.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("상점에 입장하시겠습니까? (y/n)");
        char answer = sc.next().charAt(0);
        if (answer == 'y') {
            shop.shopMenu(player);
        } else if (answer == 'n') {
            System.out.println("메인으로 돌아갑니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
