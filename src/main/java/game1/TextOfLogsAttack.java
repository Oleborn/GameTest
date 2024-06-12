package game1;

public enum TextOfLogsAttack {
    TEXTATTACK1("%s ударил со всей своей силы и нанес %d урона!"),
    TEXTATTACK2("%s с оттяжечкой размахнулся и дал леща на %d урона!"),
    TEXTATTACK3("%s зарычал, оттолкнулся и обрушил сверху оба кулака, нанеся %d урона!"),
    TEXTATTACK4("%s плюнув через плечо, кулаком нанес %d урона!"),
    TEXTATTACK5("%s спокойно подошел и нанес ударом наотмашь %d урона!"),
    TEXTATTACK6("%s выполнив прекрасный кросс левой рукой, нанес %d урона!"),
    TEXTATTACK7("%s закрыв глаза и махая руками как мельница, нанес %d урона!"),
    TEXTATTACK8("%s прописав четкую двоечку, нанес %d урона!"),
    TEXTATTACK9("%s поставил щелбан, нанеся %d урона!"),
    TEXTATTACK10("%s притворился мертвым, но неожиданно пнув нанес %d урона!"),
    TEXTATTACK11("%s с разворота в прыжке нанес %d урона!"),
    TEXTATTACK12("%s используя отвелкающий финт, нанес %d урона!");

    String value;

    TextOfLogsAttack(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
