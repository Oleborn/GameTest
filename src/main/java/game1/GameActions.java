package game1;

import game1.CreateEntity.Player.PlayerInitialization;
import game1.Level.PlayerLevel;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameActions {

    public void startGame() throws IOException, InterruptedException {
        new Messages().firstTextThisGame();
        new PlayerLevel().createAndCalculationLevelsForPlayer();
        switch (new BufferedReader(new InputStreamReader(System.in)).readLine()) {
            case "New" -> new PlayerInitialization().createPlayer();
            case "Load" -> {
                if (new CommandsForAll().isFilesPlayersEmpty(new File(new PlayerInitialization().pathForFilesPlayers))) {
                    new CommandsForAll().getNameAllSavePlayers();
                    new Messages().selectionCommandInLoadPlayer();
                } else {
                    new Messages().responseEmptyDirectoryFilesPlayers();
                    startGame();
                }
                switch (new BufferedReader(new InputStreamReader(System.in)).readLine()) {
                    case "LoadP" -> {
                        new Messages().loadPlayer();
                        new PlayerInitialization().loadPlayer(new BufferedReader(new InputStreamReader(System.in)).readLine());
                    }
                    case "DelP" -> {
                        new Messages().requestForDeletePlayer();
                        new PlayerInitialization().delSavedPlayer(new BufferedReader(new InputStreamReader(System.in)).readLine());
                        Thread.sleep(4000);
                        startGame();
                    }
                    default -> {
                        new Messages().error();
                        startGame();
                    }
                }

            }
            default -> {
                new Messages().error();
                startGame();
            }
        }
    }

    public void finishGame() {

    }

}
