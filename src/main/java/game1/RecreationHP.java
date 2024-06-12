package game1;

import game1.CreateEntity.Player.Player;
import game1.CreateEntity.Player.PlayerInitialization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecreationHP {

    public void questionRecreationHP(Player player) throws IOException, InterruptedException {
        new Messages().requestForRest();
        switch (new BufferedReader(new InputStreamReader(System.in)).readLine()) {
            case "Rest" -> recreationHP(player);
            case "Go" -> {
                if (!(player.getCurrentHealthPoints() <= 0)) {
                    new Battle().startBattle(player);
                } else {
                    new Messages().messageThatHPisNotEnough();
                    questionRecreationHP(player);
                }
            }
            case "DataP" -> new CommandsForAll().outputAllPlayerData(player);
            case "SklP" -> new CommandsForAll().outputSkillsPlayer(player);
            default -> {
                new Messages().error();
                System.exit(11);
            }
        }
    }

    public void recreationHP(Player player) throws InterruptedException, IOException {
        while (player.getCurrentHealthPoints() < player.getHealthPoints()) {
            player.setCurrentHealthPoints(new Calculations().calculationsRestHP(player.getCurrentHealthPoints()));
            new Messages().messageRest(new Randomaizer().textOfMessageRecreationsHP().getValue(), player.getName(),
                    player.getCurrentHealthPoints(), player.getHealthPoints());
        }
        player.setIsAlive(true);
        new PlayerInitialization().savePlayer(player);
        new Messages().finishRest();
        Thread.sleep(3000);
        new Battle().startBattle(player);
    }
}
