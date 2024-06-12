package game1;

public class Calculations {
    public int calculationsDamage(int hp, int dmg) {
        return hp - dmg;
    }

    public int calculationsExperience(int playerExp, int enemyGivExp) {
        return playerExp + enemyGivExp;
    }

    public int calculationsRestHP(int currentHP) throws InterruptedException {
        //speedRestHP = 1;
        currentHP++;
        Thread.sleep(1000);
        return currentHP;
    }
}
