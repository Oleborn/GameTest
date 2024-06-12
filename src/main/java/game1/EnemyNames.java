package game1;

public enum EnemyNames {
    SKELETON ("Скелет"),
    ZOMBIE ("Зомби"),
    VAMPIRE ("Вампир"),
    ORC ("Орк"),
    WITCH("Ведьма"),
    ANGRY_WIZARD("Волшебник");

    private String value;
    EnemyNames(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
