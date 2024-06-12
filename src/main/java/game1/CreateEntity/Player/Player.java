package game1.CreateEntity.Player;

import game1.CreateEntity.AnyEntity;

public class Player extends AnyEntity {
    public Player(String name, int healthPoints, int currentHealthPoints, int damageHand, boolean isAlive, int level, int experience,
                  int strength, int perception, int endurance, int charisma, int intelligence, int agility, int luck,
                  int chanceDodge, int chanceOfHitting, int chanceOfCriticalAttack,
                  int skillMeleeAttack, int skillDodge, int currentSkillPoints) {
        super(name, healthPoints, currentHealthPoints, damageHand, isAlive, level, experience,
                strength, perception, endurance, charisma, intelligence, agility, luck,
                chanceDodge, chanceOfHitting, chanceOfCriticalAttack,
                skillMeleeAttack, skillDodge, currentSkillPoints);
    }
}
