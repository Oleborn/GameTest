package game1.CreateEntity;

public abstract class AnyEntity {
    private String name;
    private int healthPoints;
    private  int currentHealthPoints;
    private int damageHand;
    private boolean isAlive;
    private int level;
    private int experience;

    //============Special==========================================//
    int strength;
    int perception;
    int endurance;
    int charisma;
    int intelligence;
    int agility;
    int luck;

//============Skills==========================================//
    int chanceDodge; // шанс уворота
    int chanceOfHitting; //шанс попадания
    int chanceOfCriticalAttack; // шпнс нанести критический урон
    int skillMeleeAttack;
    int skillDodge;
    int currentSkillPoints;

//============Дальнейшее развитие==============================//




    public AnyEntity(String name, int healthPoints, int currentHealthPoints, int damageHand, boolean isAlive, int level, int experience,
                     int strength, int perception, int endurance, int charisma, int intelligence, int agility, int luck,
                     int chanceDodge, int chanceOfHitting, int chanceOfCriticalAttack, int skillMeleeAttack, int skillDodge, int currentSkillPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.currentHealthPoints = currentHealthPoints;
        this.damageHand = damageHand;
        this.isAlive = isAlive;
        this.level = level;
        this.experience = experience;
        this.strength = strength;
        this.perception = perception;
        this.endurance = endurance;
        this.charisma = charisma;
        this.intelligence = intelligence;
        this.agility = agility;
        this.luck = luck;
        this.chanceDodge = chanceDodge;
        this.chanceOfHitting = chanceOfHitting;
        this.chanceOfCriticalAttack = chanceOfCriticalAttack;
        this.currentSkillPoints = currentHealthPoints;
        this.skillMeleeAttack = skillMeleeAttack;
        this.skillDodge = skillDodge;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public int getDamageHand() {
        return damageHand;
    }
    public void setDamageHand(int damageHand) {
        this.damageHand = damageHand;
    }
    public boolean getIsAlive() {
        return isAlive;
    }
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    public boolean checkIsAlive(int healthPoints) {
        if (healthPoints <= 0) {
            currentHealthPoints=0;
            return false;
        } else {
            return true;
        }
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getCurrentHealthPoints() {
        if (currentHealthPoints > healthPoints){
            return currentHealthPoints = healthPoints;
        } else
            return currentHealthPoints;

    }
    public void setCurrentHealthPoints(int currentHealthPoints) {
        if (currentHealthPoints > healthPoints){
            this.currentHealthPoints = healthPoints;
        }
        else this.currentHealthPoints = currentHealthPoints;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    //===============GetSet Special =============================================//
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getPerception() {
        return perception;
    }
    public void setPerception(int perception) {
        this.perception = perception;
    }
    public int getEndurance() {
        return endurance;
    }
    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }
    public int getCharisma() {
        return charisma;
    }
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getAgility() {
        return agility;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }
    public int getLuck() {
        return luck;
    }
    public void setLuck(int luck) {
        this.luck = luck;
    }

    //=============== GetSet Skill =============================================//
    public int getChanceDodge() {
        return chanceDodge;
    }
    public void setChanceDodge(int chanceDodge) {
        this.chanceDodge = chanceDodge;
    }
    public int getChanceOfHitting() {
        return chanceOfHitting;
    }
    public void setChanceOfHitting(int chanceOfHitting) {
        this.chanceOfHitting = chanceOfHitting;
    }
    public int getChanceOfCriticalAttack() {
        return chanceOfCriticalAttack;
    }
    public void setChanceOfCriticalAttack(int chanceOfCriticalAttack) { this.chanceOfCriticalAttack = chanceOfCriticalAttack; }

    public int getSkillMeleeAttack() { return skillMeleeAttack; }
    public void setSkillMeleeAttack(int skillMeleeAttack) { this.skillMeleeAttack = skillMeleeAttack; }
    public int getSkillDodge() { return skillDodge; }
    public void setSkillDodge(int skillDodge) { this.skillDodge = skillDodge; }
    public int getCurrentSkillPoints() { return currentSkillPoints; }
    public void setCurrentSkillPoints(int currentSkillPoints) { this.currentSkillPoints = currentSkillPoints; }
}
