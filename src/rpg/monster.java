package rpg;

import java.util.Random;

public class monster {
    private String name;
    private int hp;
    private int attack;

    public monster(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void attack(character player) {
        System.out.println(name + "이(가) 공격합니다!");
        int damage = calculateDamage();
        player.setHp(player.getHp() - damage);
        System.out.println("플레이어에게 " + damage + "의 피해를 입혔습니다.");
    }

    private int calculateDamage() {
        Random rand = new Random();
        return rand.nextInt(10) + attack;
    }

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
