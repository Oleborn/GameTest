package game1.CreateEntity.Player;

import game1.Battle;
import game1.CommandsForAll;
import game1.CreateEntity.ParseFileAnyEntity;
import game1.GameActions;
import game1.Level.PlayerLevel;
import game1.Messages;
import game1.Special.CalculationSpecial;
import game1.Special.SpecialDistributionPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class PlayerInitialization {
    public Player player = new Player("",0, 0,0, true, 0,
            0, 1, 1,1,1,1,1,1,
            0, 0, 0, 0, 0, 0);
    public final String pathForFilesPlayers = "src/main/java/game1/PlayersFiles";

    //==================================================================================================//

    public void createPlayer() throws IOException, InterruptedException {
        setNamePlayer();
        if (setNamePlayerCheck(player.getName())){
            Files.createFile(Path.of(pathForFilesPlayers + "\\" + player.getName() + ".txt"));
            new CommandsForAll().resetPlayer(player);
            new SpecialDistributionPlayer().distribution(player);
            savePlayer(player);
        }
        else {
            new Messages().loadPlayerThisName();
            switch (new BufferedReader(new InputStreamReader(System.in)).readLine()) {
                case "Load" -> loadPlayer(player.getName());
                default -> {
                    new Messages().error();
                    System.exit(10);
                }
            }
        }
        new Battle().startBattle(player);
    }

    public void setNamePlayer() throws IOException {
        new Messages().insertNamePlayer();
        player.setName(new BufferedReader(new InputStreamReader(System.in)).readLine());
    }
    public boolean setNamePlayerCheck(String name) {
        return !Files.isRegularFile(Path.of(pathForFilesPlayers + "\\" + name + ".txt"));
    }
    public void setHealthPointsPlayer () {
        player.setHealthPoints(new CalculationSpecial().setHP(player));
    }
    public void setCurrentHealthPointsPlayer () {
        player.setCurrentHealthPoints(player.getHealthPoints());
    }
    public void setDamageHandPlayer () { player.setDamageHand(new CalculationSpecial().setDamageHand(player)); }
    public void setChanceOfCriticalAttack(){ player.setChanceOfCriticalAttack(new CalculationSpecial().calculationChanceOfCriticalAttackFromLuck(player)); }
    public void setChanceOfHitting(){
        player.setChanceOfHitting(new CalculationSpecial().calculationChanceOfHittingFromPer(player));
    }
    public void setChanceDodge(){
        player.setChanceDodge(new CalculationSpecial().calculationChanceDodgeFromAg(player));
    }

    public void savePlayer (Player player) throws IOException {
        System.out.println("Сохранение данных персонажа в файл произведено...");
        player.setLevel(new PlayerLevel().checkPlayerLevel(player ,player.getLevel(), player.getExperience()));
        setHealthPointsPlayer();
        setCurrentHealthPointsPlayer();
        setDamageHandPlayer();
        setChanceOfCriticalAttack();
        setChanceDodge();
        setChanceOfHitting();
        Files.writeString(Path.of(pathForFilesPlayers + "\\" + player.getName() + ".txt"),
                "Name:"             + player.getName() + "\n"
                        + "HealthPoints:"       + player.getHealthPoints() + "\n"
                        + "CurrentHealthPoints:"+ player.getCurrentHealthPoints()+ "\n"
                        + "DamageHand:"         + player.getDamageHand() + "\n"
                        + "ChanceOfCrit:"       + player.getChanceOfCriticalAttack() + "\n"
                        + "Experience:"         + player.getExperience()+ "\n"
                        + "CurrentSkillPoints:" + player.getCurrentSkillPoints()+ "\n"
                        + "Level:"              + player.getLevel()+ "\n"
                        + "Strength:"           + player.getStrength()+ "\n"
                        + "Perception:"         + player.getPerception() + "\n"
                        + "Endurance:"          + player.getEndurance() + "\n"
                        + "Charisma:"           + player.getCharisma() + "\n"
                        + "Intelligence:"       + player.getIntelligence() + "\n"
                        + "Agility:"            + player.getAgility() + "\n"
                        + "Luck:"               + player.getLuck() + "\n"
                        + "SkillMeleeAttack:"   + player.getSkillMeleeAttack() + "\n"
                        + "ChanceOfHitting:"    + player.getChanceOfHitting() + "\n"
                        + "SkillDodge:"         + player.getSkillDodge() + "\n"
                        + "ChanceDodge:"        + player.getChanceDodge()
        );
    }

    public void loadPlayer(String name) throws IOException, InterruptedException {
        if (downloadPlayerCheck(name)) {
            new ParseFileAnyEntity().unParseFile(player, pathForFilesPlayers, name);
        }
        else {
            new Messages().noPlayerThisName();
            new GameActions().startGame();
            Thread.sleep(3000);
        }
        new Battle().startBattle(player);
    }

    public boolean downloadPlayerCheck(String name) {
        return Files.isRegularFile(Path.of(pathForFilesPlayers + "\\" + name + ".txt"));
    }
    public void delSavedPlayer(String name) throws IOException, InterruptedException {
        if (new CommandsForAll().isFilesPlayersEmpty(new File(new PlayerInitialization().pathForFilesPlayers))) {
            if (new PlayerInitialization().downloadPlayerCheck(name))
            {
                Files.delete(Path.of(new PlayerInitialization().pathForFilesPlayers + "\\" + name + ".txt"));
                new Messages().responseForDeletePlayer(name);
                new CommandsForAll().resetPlayer(player);
            } else {
                new Messages().noPlayerThisName();
                new GameActions().startGame();
                Thread.sleep(3000);
            }
        }
        else
        {
            new Messages().responseEmptyDirectoryFilesPlayers();
            Thread.sleep(3000);
            new GameActions().startGame();
        }
    }
}
