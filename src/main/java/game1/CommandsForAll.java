package game1;

import game1.CreateEntity.Player.Player;
import game1.CreateEntity.Player.PlayerInitialization;
import game1.Special.SpecialDistributionPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CommandsForAll {
    Messages message = new Messages();

    public void getNameAllSavePlayers() {
        File fileFolder = new File(new PlayerInitialization().pathForFilesPlayers);
        File[] listNameFiles = fileFolder.listFiles();
        List<String> listNames = new ArrayList<>();
        for (int i = 0; i < (listNameFiles != null ? listNameFiles.length : 0); i++) {
            String[] downloadHealthPoints = listNameFiles[i].getName().split("\\.");
            listNames.add(downloadHealthPoints[0]);
        }
        message.outAllNamesPlayers(listNames);
    }

    public boolean isFilesPlayersEmpty(File directory) throws IOException {
        DirectoryStream<Path> stream = Files.newDirectoryStream(directory.toPath());
        return stream.iterator().hasNext();
    }

    public void outputAllPlayerData(Player player) throws IOException, InterruptedException {
        message.messageForPlayerData(player);
        Thread.sleep(5000);
        new Battle().startBattle(player);
    }

    public void outputSkillsPlayer(Player player) throws IOException, InterruptedException {
        if (player.getCurrentSkillPoints() > 0) {
            new Messages().messageOutputSkillsPlayer(player.getCurrentSkillPoints());
            switch (new BufferedReader(new InputStreamReader(System.in)).readLine()) {
                case "Y" -> {
                    new SpecialDistributionPlayer().skillDistribution(player);
                    Thread.sleep(3000);
                    new Battle().startBattle(player);
                }
                case "N" -> {
                    Thread.sleep(3000);
                    new Battle().startBattle(player);
                }
                default -> {
                    message.error();
                }
            }
        } else {
            message.messageForPlayersSkills(player);
            Thread.sleep(5000);
            new Battle().startBattle(player);
        }
    }

    public void resetPlayer(Player player) {
        player.setStrength(1);
        player.setPerception(1);
        player.setEndurance(1);
        player.setCharisma(1);
        player.setIntelligence(1);
        player.setAgility(1);
        player.setLuck(1);
        player.setExperience(0);
        player.setChanceOfCriticalAttack(0);

        player.setSkillMeleeAttack(0);
        player.setSkillDodge(0);
        player.setCurrentSkillPoints(0);
    }
}
