package game1;

public enum TextOfLogsRecreation {
    TEXTRECRATIONS1("Отдыхая, %s передернул свой болтик."),
    TEXTRECRATIONS2("Отдыхая, %s достал ушные палочки и поковырялся ими в носу о_О."),
    TEXTRECRATIONS3("Отдыхая, %s три раза вызвал дух Чака Норриса и теперь думает что получил невосприимчивость к физическому урону."),
    TEXTRECRATIONS4("Отдыхая, %s построил Зиккурат."),
    TEXTRECRATIONS5("Отдыхая, %s выкурил IQOS и теперь воняет потными носками..."),
    TEXTRECRATIONS6("Отдыхая, %s поругался с пьяным Маньяком."),
    TEXTRECRATIONS7("Отдыхая, %s попробовал посрать на потолке. Получилось."),
    TEXTRECRATIONS8("Отдыхая, %s выпил банку RED BULL."),
    TEXTRECRATIONS9("Отдыхая, %s позвонил своей бывшей, расстроился. Поплакал."),
    TEXTRECRATIONS10("Отдыхая, %s поиграл в города сам с собой... проиграл..."),
    TEXTRECRATIONS11("Отдыхая, %s накодил какую то херню, представил, что он крутой разработчик."),
    TEXTRECRATIONS12("Отдыхая, %s похавал пельмешки=)."),
    TEXTRECRATIONS13("Отдыхая, %s обнаружил в пупке инопланетную жизнь."),
    TEXTRECRATIONS14("Отдыхая, %s пялил в ютубчик."),
    TEXTRECRATIONS15("Отдыхая, %s перебинтовался и принял все таблетки, какие нашел в аптечке."),
    TEXTRECRATIONS16("Отдыхая, %s вправил вывихнутый 21-й палец."),
    TEXTRECRATIONS17("Отдыхая, %s навернул дошика. Отрыгнул огнем."),
    TEXTRECRATIONS18("Отдыхая, %s проиграл в споре воображаемому собеседнику."),
    TEXTRECRATIONS19("Отдыхая, %s зализывал раны. Не себе."),
    TEXTRECRATIONS20("Отдыхая, %s поиграл в компуктер."),
    TEXTRECRATIONS21("Отдыхая, %s достал козявку и прилепил ее на потолок.");

    private String value;

    TextOfLogsRecreation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
