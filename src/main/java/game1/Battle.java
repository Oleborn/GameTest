package game1;

import game1.CreateEntity.Enemy.CalculationSpecialEnemyForLevelPlayer;
import game1.CreateEntity.Enemy.Enemy;
import game1.CreateEntity.Enemy.EnemyInitialization;
import game1.CreateEntity.Player.Player;
import game1.CreateEntity.Player.PlayerInitialization;
import game1.Special.CalculationSpecial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Battle {
    Enemy enemy = new EnemyInitialization().createEnemy();

    public void startBattle(Player player) throws IOException, InterruptedException {
        new Messages().questionStartBattle();
        switch (new BufferedReader(new InputStreamReader(System.in)).readLine()){
            case "Go" ->
            {
                if (!(player.getCurrentHealthPoints()<=0)) {
                    new Battle().battle(player);
                } else {
                    new Messages().messageThatHPisNotEnough();
                    new RecreationHP().questionRecreationHP(player);
                }
            }
            case "Rest" ->
            {
                if (player.getCurrentHealthPoints()==player.getHealthPoints()){
                    new Messages().messageThatHPEnough();
                    new Battle().startBattle(player);
                } else {
                    new RecreationHP().recreationHP(player);
                }
            }
            case "DataP" -> new CommandsForAll().outputAllPlayerData(player);
            case "SklP" -> new CommandsForAll().outputSkillsPlayer(player);
            case "Back" -> {
                Thread.sleep(3000);
                new GameActions().startGame();
            }
            default -> {
                new Messages().error();
                System.exit(11);
            }
        }
    }
    public void battle(Player player) throws IOException, InterruptedException {
        new CalculationSpecialEnemyForLevelPlayer().calcSpecialEnemyForlvlEnemy(enemy,player);
        new Messages().enemyForYou(enemy);
        new Messages().startBattle();
        enemy.setIsAlive(true);
        player.setIsAlive(true);
        int countProgress = 0;
        while (player.getIsAlive() & enemy.getIsAlive()){
            if (player.checkIsAlive(player.getCurrentHealthPoints())
                    & enemy.checkIsAlive(enemy.getCurrentHealthPoints()))
            {
                countProgress++;
                new Messages().countBattleProgress(countProgress);
            }
            Thread.sleep(1000);
            attackPlayer(player);
            Thread.sleep(1000);
            attackEnemy(player);
            Thread.sleep(500);
        }
        new Messages().battleEnd();
        if (player.getCurrentHealthPoints()!= player.getHealthPoints()){
            new Messages().messageLowHP(player.getCurrentHealthPoints(), player.getHealthPoints());
            Thread.sleep(3000);
            new RecreationHP().questionRecreationHP(player);
        }else{
            new Messages().questionOfNewBattleNoRest();
            new Battle().startBattle(player);
        }
    }

    public void attackPlayer(Player player) throws IOException {
        if (player.checkIsAlive(player.getCurrentHealthPoints())) {
            if (enemy.checkIsAlive(enemy.getCurrentHealthPoints())) {
                if (new CalculationSpecial().calculationResultAttackForChanceOfHitting(player)){
                    if (!new CalculationSpecial().calculationResultDodgeForChanceDodge(enemy)){
                        int damage = new Randomaizer().randomDamage(player.getDamageHand()); // расчитывается рандомное количество урона
                        int criticalDamage = new CalculationSpecial().calculationDamageCriticalAttack(player.getChanceOfCriticalAttack(), damage);
                        if (criticalDamage!=damage) new Messages().messageOfCriticalAttack();
                        enemy.setCurrentHealthPoints(new Calculations().calculationsDamage(enemy.getCurrentHealthPoints(), criticalDamage));
                        new Messages().logOfBattle(player.getName(), criticalDamage);
                    } else {
                        new Messages().messageOfDodgeEntity(enemy);
                    }
                }else {
                    new Messages().messageOfHittingEntity(player);
                }
            } else {
                new Messages().enemyDefeat(enemy.getName());
                new Messages().logOfExperience(new CalculationSpecial().calculationGivExpPointsFromInt(player.getIntelligence(),
                        enemy.getExperience()));
                player.setExperience(new Calculations().calculationsExperience(player.getExperience(),
                        new CalculationSpecial().calculationGivExpPointsFromInt(player.getIntelligence(),
                                enemy.getExperience())));
                new PlayerInitialization().savePlayer(player);
                enemy.setIsAlive(false);
            }
        }
    }
    public void attackEnemy(Player player) throws IOException {
        if (enemy.checkIsAlive(enemy.getCurrentHealthPoints())) {
            if (player.checkIsAlive(player.getCurrentHealthPoints())) {
                if (new CalculationSpecial().calculationResultAttackForChanceOfHitting(enemy)){
                    if (!new CalculationSpecial().calculationResultDodgeForChanceDodge(player)){
                        int damage = new Randomaizer().randomDamage(enemy.getDamageHand());
                        int criticalDamage = new CalculationSpecial().calculationDamageCriticalAttack(enemy.getChanceOfCriticalAttack(), damage);
                        if (criticalDamage!=damage) new Messages().messageOfCriticalAttack();
                        player.setCurrentHealthPoints(new Calculations().calculationsDamage(
                                player.getCurrentHealthPoints(),criticalDamage));
                        new Messages().logOfBattle(enemy.getName(), criticalDamage);
                    }else {
                        new Messages().messageOfDodgeEntity(player);
                    }
                }else {
                    new Messages().messageOfHittingEntity(enemy);
                }
            } else {
                new Messages().playerDefeat(player);
                player.setIsAlive(false);
                new PlayerInitialization().savePlayer(player);
            }
        }
    }
    public static void finishBattle(){
    }
}
