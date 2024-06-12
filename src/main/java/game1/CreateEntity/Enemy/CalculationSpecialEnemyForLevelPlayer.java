package game1.CreateEntity.Enemy;

import game1.CreateEntity.Player.Player;
import game1.Randomaizer;
import game1.Special.CalculationSpecial;

public class CalculationSpecialEnemyForLevelPlayer {

    public Integer calcLvlEnemyForLvlPlayer(int levelPl){
       return new Randomaizer().calculationLvlEnemyForLvlPL(levelPl);
    }

    public void calcSpecialEnemyForlvlEnemy(Enemy enemy, Player player){
        enemy.setLevel(calcLvlEnemyForLvlPlayer(player.getLevel()));
        new Randomaizer().calculationSkillEnemyForLvlEnemy(enemy);
        enemy.setChanceOfCriticalAttack(new CalculationSpecial().calculationChanceOfCriticalAttackFromLuck(enemy));
        enemy.setChanceOfHitting(new CalculationSpecial().calculationChanceOfHittingFromPer(enemy));
        enemy.setChanceDodge(new CalculationSpecial().calculationChanceDodgeFromAg(enemy));
        enemy.setHealthPoints(new CalculationSpecial().setHP(enemy));
        enemy.setCurrentHealthPoints(enemy.getHealthPoints());
        enemy.setDamageHand(new CalculationSpecial().setDamageHand(enemy));
    }
}
