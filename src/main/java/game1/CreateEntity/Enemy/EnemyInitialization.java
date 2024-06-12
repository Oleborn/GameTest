package game1.CreateEntity.Enemy;

import java.io.IOException;

public class EnemyInitialization {
    public Enemy enemy;
    public Enemy createEnemy(){
        {
            try {
                enemy = (Enemy) new EnemyFactory().createEntity();
            } catch (IOException e) {
                throw new RuntimeException("Что-то не то - "+e);
            }
        }
        return enemy;
    }

}
