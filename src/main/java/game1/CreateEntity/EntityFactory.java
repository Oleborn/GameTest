package game1.CreateEntity;

import java.io.IOException;

public interface EntityFactory {
    AnyEntity createEntity() throws IOException;
}
