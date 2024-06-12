package game1;

import game1.CreateEntity.AnyEntity;
import game1.CreateEntity.Enemy.Enemy;
import game1.CreateEntity.Player.Player;
import game1.Level.PlayerLevel;

import java.util.List;

public class Messages {


    public void error() throws InterruptedException {
        System.out.println("Вы ввели что-то не то!");
        Thread.sleep(3000);
    }

    // =========================== Логи старта игры =======================================================//
    public void firstTextThisGame() {
        System.out.println("""
                Добро пожаловать! Вам доступны следующие команды:
                Чтобы создать нового персонажа введите команду - New
                Чтобы посмотреть всех сохраненных персонажей введите команду - Load"""
        );
    }

    public void selectionCommandInLoadPlayer() {
        System.out.println("""
                Что вы желаете сделать далее?
                Вам доступны следующие команды:
                                
                Загрузить персонажа - LoadP
                Удалить персонажа - DelP""");
    }

    public void loadPlayer() {
        System.out.println("Введите имя персонажа которого желаете загрузить!");
    }
// =========================== Конец логов старта игры =================================================//

    //================= Логи создания персонажа ============================================================//
    public void insertNamePlayer() {
        System.out.println("Введите имя персонажа");
    }

    public void noPlayerThisName() {
        System.out.println("Персонаж с таким именем не существует!");
    }

    public void loadPlayerThisName() {
        System.out.println("Данный персонаж уже существует! Загрузить его?\n" +
                "Для загрузки доступна команда - Load");
    }

    public void messageResetInputSpecial() {
        System.out.println("Введение параметров сброшено, начните заново!");
    }

    public void messageMaxCountStrength() {
        System.out.println("Параметр Силы,не может быть выше 10 единиц!");
    }

    public void messageMaxCountPerception() {
        System.out.println("Параметр Восприятия,не может быть выше 10 единиц!");
    }

    public void messageMaxCountEndurance() {
        System.out.println("Параметр Выносливости,не может быть выше 10 единиц!");
    }

    public void messageMaxCountCharisma() {
        System.out.println("Параметр Харизмы,не может быть выше 10 единиц!");
    }

    public void messageMaxCountIntelligence() {
        System.out.println("Параметр Интеллекта,не может быть выше 10 единиц!");
    }

    public void messageMaxCountAgility() {
        System.out.println("Параметр Ловкости,не может быть выше 10 единиц!");
    }

    public void messageMaxCountLuck() {
        System.out.println("Параметр Удачи,не может быть выше 10 единиц!");
    }
//================= Конец логов создания персонажа =====================================================//

    // ========================   логи старта битв ========================================================//
    public void questionStartBattle() {
        System.out.println("""
                Дорога приключений ведет Вас! Что будет дальше?
                Доступны команды:
                Поискать противника - Go
                Отдохнуть от трудов ратных - Rest
                Посмотреть характеристики / навыки персонажа - DataP / SklP
                Вернуться в стартовое меню - Back
                """);
    }

    public void enemyForYou(Enemy enemy) {
        System.out.printf("""
                        Ваш противник - %s, %d уровня!
                        Здоровье (%d), базовый урон руками - %d.
                        Шанс нанесения критического урона(х2) - %d %%
                        Шанс попадания атакой - %d %%
                        Шанс увернуться от атаки - %d %%
                        """, enemy.getName(), enemy.getLevel(), enemy.getHealthPoints(), enemy.getDamageHand()
                , enemy.getChanceOfCriticalAttack(), enemy.getChanceOfHitting(), enemy.getChanceDodge());
    }

    public void startBattle() {
        System.out.println("Битва начинается!");
    }
//======================== конец логов старта битв =================================================//

    //================= Логи битвы в Battle ================================================================//
    public void logOfBattle(String name, int damage) {
        System.out.printf(new Randomaizer().textOfMessagesAttack().getValue() + "\n", name, damage);
    }

    public void logOfExperience(int exp) {
        System.out.println("Получено " + exp + " едениц(ы) опыта!");
    }

    public void enemyDefeat(String name) {
        System.out.println(name + " повержен!");
    }

    public void playerDefeat(Player player) {
        System.out.println("Персонаж " + player.getName() + ", отправлен в нокаут!");
    }

    public void battleEnd() {
        System.out.println("Битва окончена!))\n");
    }

    public void countBattleProgress(int progress) {
        System.out.println("\n" + "Ход №" + progress + "!");
    }

    public void questionOfNewBattleNoRest() {
        System.out.println("Кажется Вы не потратили ни капли здоровья и готовы к новой битве!");
    }

    public void messageOfCriticalAttack() {
        System.out.println("Сработал шанс на критическую атаку!");
    }

    public void messageOfDodgeEntity(AnyEntity anyEntity) {
        System.out.println(anyEntity.getName() + " увернулся от атаки противника!");
    }

    public void messageOfHittingEntity(AnyEntity anyEntity) {
        System.out.println(anyEntity.getName() + " промахнулся!");
    }

// ========================    конец логов битв =====================================================//
// ========================    Лог отдыха ===========================================================//

    public void messageLowHP(int currentHP, int fullHP) {
        System.out.printf("Здоровью Вашего персонажа подпорчено и составляет %dHP/%dHP!\n", currentHP, fullHP);
    }

    public void requestForRest() {
        System.out.println("""
                Доступны следующие команды:
                Чтобы отправить персонажа на отдых - Rest
                Чтобы продолжить путешествие - Go
                Посмотреть характеристики / навыки персонажа - DataP / SklP
                """);
    }

    public void finishRest() {
        System.out.println("Ваши силы и здоровье восстановлены!\n");
    }

    public void messageRest(String textRest, String name, int currentHP, int fullHP) {
        System.out.printf(textRest + "\n" +
                "Текущее здоровье - %dHP/%dHP.\n", name, currentHP, fullHP);
    }

    public void messageThatHPisNotEnough() {
        System.out.println("Вашему персонажу стоит подлечиться, прежде чем продолжать путешествие!\n");
    }

    public void messageThatHPEnough() {
        System.out.println("Вы чувствуете себя превосходно! Не время отдыхать - пора уничтожать врагов!\n");
    }

// ========================    Конец логов отдыха ===================================================//

    // ========================    Логи комманд =========================================================//
    public void outAllNamesPlayers(List<String> list) {
        System.out.println("В настоящий момент сохранены следующие персонажи:");
        for (String l : list) {
            System.out.println(l);
        }
    }

    public void requestForDeletePlayer() {
        System.out.println("Введите имя персонажа которого желаете удалить!");
    }

    public void responseForDeletePlayer(String name) {
        System.out.println("Персонаж " + name + " удален!\n");
    }

    public void responseEmptyDirectoryFilesPlayers() throws InterruptedException {
        System.out.println("Сохраненные игроки отсутствуют!\n");
        Thread.sleep(3000);
    }

    public void messageForPlayerData(Player player) {
        System.out.println(
                "Имя персонажа:             " + player.getName() + "\n"
                        + "Очки здоровья:            " + player.getCurrentHealthPoints() + "/" + player.getHealthPoints() + "\n"
                        + "Уровень:                  " + player.getLevel() + "\n"
                        + "Очки опыта:               " + player.getExperience() + "/" + PlayerLevel.levels.get(player.getLevel() + 1) + "\n"
                        + "Урон голыми руками:       " + player.getDamageHand() + "\n"
                        + "Шанс нанесения крита (х2) " + player.getChanceOfCriticalAttack() + "%" + "\n"
                        + "========= Основные характеристики персонажа ===========" + "\n"
                        + "Сила:                " + player.getStrength() + "\n"
                        + "Восприятие:          " + player.getPerception() + "\n"
                        + "Выносливость:        " + player.getEndurance() + "\n"
                        + "Харизма:             " + player.getCharisma() + "\n"
                        + "Интеллект:           " + player.getIntelligence() + "\n"
                        + "Ловкость:            " + player.getAgility() + "\n"
                        + "Удача:               " + player.getLuck() + "\n"
        );
    }

    public void messageForPlayersSkills(Player player) {
        System.out.println(
                "Навыки ближнего боя:" + "\n"
                        + "Рукопажный бой - " + player.getSkillMeleeAttack() + "\n"
                        + "(Шанс попадания по врагу - " + player.getChanceOfHitting() + "%)." + "\n"
                        + "==========================================================" + "\n"
                        + "Навыки защиты:" + "\n"
                        + "Уклонение в ближнем бою - " + player.getSkillDodge() + "\n"
                        + "(Шанс увернуться от атаки врага - " + player.getChanceDodge() + "%)." + "\n"
        );
    }

    public void messageMaxNestedSkillPoints() {
        System.out.println("Значение навыка не может быть больше 100!");
    }

    public void messageOutputSkillsPlayer(int currentSkillPointsPlayer) {
        System.out.printf("""
                У вас есть %d нераспределённых очка(ов) навыков.
                Хотите ли распределить очки навыков? 
                Да, введите - Y
                Нет, ввдеите - N
                """, currentSkillPointsPlayer);
    }
// ========================    Конец логов комманд ==================================================//

}
