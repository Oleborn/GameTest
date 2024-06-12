package game1.Special;

import game1.CreateEntity.AnyEntity;
import game1.Randomaizer;


public class CalculationSpecial {
    public Integer setHP(AnyEntity anyEntity){
        return (anyEntity.getEndurance()*3)+(anyEntity.getStrength())+(anyEntity.getLevel()*2);
    }
    public Integer setDamageHand(AnyEntity anyEntity){
        return (anyEntity.getStrength()*2)+(anyEntity.getLevel()/2);
    }
    public Integer calculationGivExpPointsFromInt(int intelligencePlayer, int givExpPointsEnemy){
        return givExpPointsEnemy+(intelligencePlayer*2);
    }
    public Integer calculationChanceDodgeFromAg(AnyEntity anyEntity){
        return (anyEntity.getAgility()*2)+(anyEntity.getLevel()/5)+((anyEntity.getSkillDodge()*4)/10);
    }
    public Integer calculationChanceOfHittingFromPer(AnyEntity anyEntity){
        return (anyEntity.getPerception()*5)+(anyEntity.getLevel()/2)+((anyEntity.getSkillMeleeAttack()*4)/10);
    }
    public Integer calculationChanceOfCriticalAttackFromLuck(AnyEntity anyEntity){
        return (anyEntity.getLuck()*2)+(anyEntity.getLevel()/10);
    }
    public Integer calculationDamageCriticalAttack(int chance, int damageEntity){
        if (new Randomaizer().oddsCalculation(chance)){
            return damageEntity*2;
        } else {
            return damageEntity;
        }
    }
    public boolean calculationResultAttackForChanceOfHitting(AnyEntity anyEntity){
        return new Randomaizer().oddsCalculation(anyEntity.getChanceOfHitting());
    }
    public boolean calculationResultDodgeForChanceDodge(AnyEntity anyEntity){
        return new Randomaizer().oddsCalculation(anyEntity.getChanceDodge());
    }
    public Integer calculationQuantitySkillPointsFromInt(AnyEntity anyEntity){
        return 5+(anyEntity.getIntelligence()/2);
    }
}
