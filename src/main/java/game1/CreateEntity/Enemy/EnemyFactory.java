package game1.CreateEntity.Enemy;

import game1.*;
import game1.CreateEntity.AnyEntity;
import game1.CreateEntity.Enemy.Enemy;
import game1.CreateEntity.EntityFactory;
import game1.CreateEntity.ParseFileAnyEntity;
import game1.Special.CalculationSpecial;

import java.io.IOException;

public class EnemyFactory implements EntityFactory {
    final String pathForFilesEnemies = "src/main/java/game1/EnemyFiles";
    @Override
    public AnyEntity createEntity() throws IOException {

        Enemy enemy = new Enemy("", 0, 0 , 0, true, 0,
                0,1,1,1,1,1,1,1,
                0, 0,0, 0, 0, 0);

        new ParseFileAnyEntity().unParseFile(enemy, pathForFilesEnemies, new Randomaizer().selectionsOfEnemy());
        return enemy;
    }
}
