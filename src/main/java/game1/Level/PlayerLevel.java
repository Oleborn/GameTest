package game1.Level;

import game1.CreateEntity.AnyEntity;
import game1.CreateEntity.Player.Player;
import game1.Special.CalculationSpecial;

import java.util.HashMap;
public class PlayerLevel {
    public static HashMap<Integer, Integer> levels = new HashMap<>();
    public void createAndCalculationLevelsForPlayer(){
        levels.put(0, 0);
        levels.put(1, 100);
        int qualityLevels = 20;
        int percentHighLevels = 1;
        for (int j = 2; j <= qualityLevels; j++) {
            levels.put(j, (((levels.get(j-1))*percentHighLevels/100)+(levels.get(j-1)*2)));
        }
    }

    public Integer checkPlayerLevel (Player player, int level, int experience){
        for (int i = 0; i < levels.size(); i++) {
            if ((experience>levels.get(i) && experience<=levels.get(i+1)) && player.getLevel()!=i){
                System.out.println("\nВаш персонаж достиг уровня "+i+"!");
                System.out.printf("""
                        Вам добавлено %d очка(ов) навыков. Распределите их по своему усмотрению!
                        Чтобы начать распределение навыков, введите - SklP.
                        """, new CalculationSpecial().calculationQuantitySkillPointsFromInt(player));
                player.setCurrentSkillPoints(player.getCurrentSkillPoints()+
                        new CalculationSpecial().calculationQuantitySkillPointsFromInt(player));
                return level = i;
            }
        }
        return level;
    }
}
