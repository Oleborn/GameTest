package game1;

import game1.CreateEntity.Enemy.Enemy;
import game1.Special.CalculationSpecial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Randomaizer {
    public TextOfLogsAttack textOfMessagesAttack() {
        List<TextOfLogsAttack> listOfText = new ArrayList<>();
        Collections.addAll(listOfText, TextOfLogsAttack.TEXTATTACK1, TextOfLogsAttack.TEXTATTACK2, TextOfLogsAttack.TEXTATTACK3,
                TextOfLogsAttack.TEXTATTACK4, TextOfLogsAttack.TEXTATTACK5, TextOfLogsAttack.TEXTATTACK6, TextOfLogsAttack.TEXTATTACK7,
                TextOfLogsAttack.TEXTATTACK8, TextOfLogsAttack.TEXTATTACK9, TextOfLogsAttack.TEXTATTACK10, TextOfLogsAttack.TEXTATTACK11,
                TextOfLogsAttack.TEXTATTACK12);
        return listOfText.get(new Random().nextInt(12));
    }

    public String selectionsOfEnemy() {
        List<EnemyNames> enemies = new ArrayList<>();
        Collections.addAll(enemies, EnemyNames.SKELETON, EnemyNames.ZOMBIE, EnemyNames.VAMPIRE,
                EnemyNames.ORC, EnemyNames.WITCH, EnemyNames.ANGRY_WIZARD);
        return String.valueOf(enemies.get(new Random().nextInt(6)));
    }

    public TextOfLogsRecreation textOfMessageRecreationsHP() {
        List<TextOfLogsRecreation> listOfText = new ArrayList<>();
        Collections.addAll(listOfText, TextOfLogsRecreation.TEXTRECRATIONS1, TextOfLogsRecreation.TEXTRECRATIONS2,
                TextOfLogsRecreation.TEXTRECRATIONS3,
                TextOfLogsRecreation.TEXTRECRATIONS4, TextOfLogsRecreation.TEXTRECRATIONS5, TextOfLogsRecreation.TEXTRECRATIONS6,
                TextOfLogsRecreation.TEXTRECRATIONS7, TextOfLogsRecreation.TEXTRECRATIONS8, TextOfLogsRecreation.TEXTRECRATIONS9,
                TextOfLogsRecreation.TEXTRECRATIONS10, TextOfLogsRecreation.TEXTRECRATIONS11, TextOfLogsRecreation.TEXTRECRATIONS12,
                TextOfLogsRecreation.TEXTRECRATIONS13, TextOfLogsRecreation.TEXTRECRATIONS14, TextOfLogsRecreation.TEXTRECRATIONS15,
                TextOfLogsRecreation.TEXTRECRATIONS16, TextOfLogsRecreation.TEXTRECRATIONS17, TextOfLogsRecreation.TEXTRECRATIONS18,
                TextOfLogsRecreation.TEXTRECRATIONS19, TextOfLogsRecreation.TEXTRECRATIONS20, TextOfLogsRecreation.TEXTRECRATIONS21);
        return listOfText.get(new Random().nextInt(21));
    }

    public Integer randomDamage(int damageHand) {
        double s = new Random().nextDouble(new Random().nextDouble(0.1, 0.9),
                new Random().nextDouble(1.1, 1.9));
        return ((int) (s * damageHand));
    }

    public Boolean oddsCalculation(int chance) {
        int i = new Random().nextInt(100);
        if (chance >= i) {
            return true;
        } else {
            return false;
        }
    }

    public Integer calculationLvlEnemyForLvlPL(int levelPlayer) {
        return new Random().nextInt(Math.max((levelPlayer - 2), 0), levelPlayer + 2);
    }

    public void calculationSkillEnemyForLvlEnemy(Enemy enemy) {
        for (int i = new CalculationSpecial().calculationQuantitySkillPointsFromInt(enemy) * enemy.getLevel(); i > 0; i--) {
            switch (new Random().nextInt(0, 2)) {
                case 0 -> enemy.setSkillMeleeAttack(enemy.getSkillMeleeAttack() + 1);
                case 1 -> enemy.setSkillDodge(enemy.getSkillDodge() + 1);
            }
        }
    }
}
