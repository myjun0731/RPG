package rpg;

import java.util.Random;
import java.util.Scanner;

public class battleSystem {
    private character player;
    private monster monster;
    private Scanner scanner;

    public battleSystem(character player, monster monster, Scanner scanner) {
        this.player = player;
        this.monster = monster;
        this.scanner = scanner;
    }

    public void startBattle() {
        if (isBattleAvailable()) { // 배틀 가능 여부를 확인
            System.out.println("전투가 시작됩니다!");
            System.out.println(player.getName() + " vs " + monster.getName());

            while (true) {
                playerTurn();
                if (!player.isAlive()) {
                    System.out.println("플레이어가 전투에서 사망했습니다.");
                    break;
                }
                if (isBattleEnd()) break;
                monsterTurn();
                if (isBattleEnd()) break;
            }
        } else {
            System.out.println("일정 시간 동안은 배틀이 일어나지 않습니다.");
        }
    }


    private void playerTurn() {
        System.out.println("플레이어의 턴입니다.");
        System.out.println("1. 공격");
        System.out.println("2. 방어");
        System.out.print("행동을 선택하세요: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                int playerDamage = calculateDamage(player.getAttack());
                monster.setHp(monster.getHp() - playerDamage);
                System.out.println("몬스터에게 " + playerDamage + "의 피해를 입혔습니다.");
                break;
            case 2:
                // 방어 기능 구현(진행중)
                break;
            default:
                System.out.println("잘못된 입력입니다. 턴을 종료합니다.");
                break;
        }
    }

    private void monsterTurn() {
        System.out.println("몬스터의 턴입니다.");
        try {
            // 랜덤한 시간 동안 대기
            Random rand = new Random();
            int delay = rand.nextInt(3000) + 1000; // 1초 ~ 4초 사이의 랜덤한 대기 시간
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.out.println("스레드 대기 중 예외가 발생했습니다: " + e.getMessage());
        }

        int monsterDamage = calculateDamage(monster.getAttack());
        player.setHp(player.getHp() - monsterDamage);
        System.out.println("플레이어에게 " + monsterDamage + "의 피해를 입혔습니다.");
    }

    private int calculateDamage(int attack) {
        Random rand = new Random();
        int damage = rand.nextInt(10) + attack;
        return damage;
    }

    private boolean isBattleEnd() {
        if (player.getHp() <= 0) {
            System.out.println("플레이어가 전투에서 패배했습니다.");
            return true;
        } else if (monster.getHp() <= 0) {
            System.out.println("몬스터를 처치했습니다!");
            return true;
        }
        return false;
    }

    private boolean isBattleAvailable() {
        // 플레이어가 이동한 후 15초가 경과했는지 확인
        long currentTime = System.currentTimeMillis();
        long lastMoveTime = player.getLastMoveTime();
        long elapsedTime = currentTime - lastMoveTime;
        return elapsedTime > 15000; // 15초 이상 경과한 경우에만 배틀 가능
    }
}
