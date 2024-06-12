package game1.Special;

import game1.CommandsForAll;
import game1.CreateEntity.Player.Player;
import game1.CreateEntity.Player.PlayerInitialization;
import game1.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecialDistributionPlayer {

    public void distribution(Player player) throws IOException, InterruptedException {
        for (int j = 10; j != 0; j--) {
            System.out.printf("Вам доступно %d очков SPECIAL.\n", j);
            System.out.printf("""
                            Выберите куда вы желаете добавить очки SPECIAL:
                            Сила/Strength           (%d) - введите S
                            Восприятие/Perception   (%d) - введите P
                            Выносливость/Endurance  (%d) - введите E
                            Харизма/Charisma        (%d) - введите C
                            Интеллект/Intelligence  (%d) - введите I
                            Ловкость/Agility        (%d) - введите A
                            Удача/Luck              (%d) - введите L
                            """,
                    player.getStrength(), player.getPerception(), player.getEndurance(),
                    player.getCharisma(), player.getIntelligence(), player.getAgility(),
                    player.getLuck());
            switch (new BufferedReader(new InputStreamReader(System.in)).readLine()) {
                case "S" -> {
                    if (player.getStrength() >= 10) {
                        checkParameterSpecial10("S", player);
                        j++;
                    } else player.setStrength(player.getStrength() + 1);
                }
                case "P" -> {
                    if (player.getPerception() >= 10) {
                        checkParameterSpecial10("P", player);
                        j++;
                    } else player.setPerception(player.getPerception() + 1);
                }
                case "E" -> {
                    if (player.getEndurance() >= 10) {
                        checkParameterSpecial10("E", player);
                        j++;
                    } else player.setEndurance(player.getEndurance() + 1);
                }
                case "C" -> {
                    if (player.getCharisma() >= 10) {
                        checkParameterSpecial10("C", player);
                        j++;
                    } else player.setCharisma(player.getCharisma() + 1);
                }
                case "I" -> {
                    if (player.getIntelligence() >= 10) {
                        checkParameterSpecial10("I", player);
                        j++;
                    } else player.setIntelligence(player.getIntelligence() + 1);
                }
                case "A" ->  {
                    if (player.getAgility() >= 10) {
                        checkParameterSpecial10("A", player);
                        j++;
                    } else player.setAgility(player.getAgility() + 1);
                }
                case "L" -> {
                    if (player.getLuck() >= 10) {
                        checkParameterSpecial10("L", player);
                        j++;
                    } else player.setLuck(player.getLuck() + 1);
                }
                default -> {
                    checkParameterSpecial10("1", player);
                }
            }
        }
        //new PlayerInitialization().savePlayer(player);
    }

    public void checkParameterSpecial10(String letter, Player player) throws IOException, InterruptedException {
        switch (letter) {
            case "S" -> new Messages().messageMaxCountStrength();
            case "P" -> new Messages().messageMaxCountPerception();
            case "E" -> new Messages().messageMaxCountEndurance();
            case "C" -> new Messages().messageMaxCountCharisma();
            case "I" -> new Messages().messageMaxCountIntelligence();
            case "A" -> new Messages().messageMaxCountAgility();
            case "L" -> new Messages().messageMaxCountLuck();
            default -> {
                new Messages().error();
                new Messages().messageResetInputSpecial();
                new CommandsForAll().resetPlayer(player);
                distribution(player);
            }
        }
    }

    public void skillDistribution(Player player) throws IOException {
        for (int i = player.getCurrentSkillPoints(); i > 0; player.setCurrentSkillPoints(i--)) {
            System.out.printf("""
                    Выберите навык, в который хотите добавить очки навыков:
                    Количество очков - %d.
                    
                    Навыки ближнего боя:
                    Рукопашный бой (%d) - введите H.
                    Навык защиты:
                    Уклонение в ближнем бою (%d) - введите D.
                    """,i , player.getSkillMeleeAttack(), player.getSkillDodge()
            );
            switch (new BufferedReader(new InputStreamReader(System.in)).readLine()) {
                case "H" -> {
                    if (player.getSkillMeleeAttack() < 100) {
                        player.setSkillMeleeAttack(player.getSkillMeleeAttack() + 1);
                        player.setChanceOfHitting(new CalculationSpecial().calculationChanceOfHittingFromPer(player));

                    } else {
                        i++;
                        new Messages().messageMaxNestedSkillPoints();
                    }
                }
                case "D" -> {
                    if (player.getSkillDodge() < 100) {
                        player.setSkillDodge(player.getSkillDodge() + 1);
                        player.setChanceDodge(new CalculationSpecial().calculationChanceDodgeFromAg(player));
                    } else {
                        i++;
                        new Messages().messageMaxNestedSkillPoints();
                    }
                }
                default -> {
                    System.out.println("Вы ввели что-то не то.");
                    i++;
                }
            }
        }
        player.setCurrentSkillPoints(0);
        new PlayerInitialization().savePlayer(player);
    }
}
