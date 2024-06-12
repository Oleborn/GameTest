package game1.CreateEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class ParseFileAnyEntity {
    public void parseFile(){
    }

    public void unParseFile(AnyEntity anyEntity, String pathForFiles, String name) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(pathForFiles + "\\" + name + ".txt"));
        HashMap<String, String> EntityMap = new HashMap<>();
        String[] parts = new String[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            parts[i]=lines.get(i);
            String[] download = parts[i].split(":");
            EntityMap.put(download[0], download[1]);
        }
        anyEntity.setName(EntityMap.get("Name"));
        anyEntity.setHealthPoints(Integer.parseInt(EntityMap.get("HealthPoints")));
        anyEntity.setCurrentHealthPoints(Integer.parseInt(EntityMap.get("CurrentHealthPoints")));
        anyEntity.setDamageHand(Integer.parseInt(EntityMap.get("DamageHand")));
        anyEntity.setChanceOfCriticalAttack(Integer.parseInt(EntityMap.get("ChanceOfCrit")));
        anyEntity.setExperience(Integer.parseInt(EntityMap.get("Experience")));
        anyEntity.setCurrentSkillPoints(Integer.parseInt(EntityMap.get("CurrentSkillPoints")));
        anyEntity.setLevel(Integer.parseInt(EntityMap.get("Level")));
        anyEntity.setStrength(Integer.parseInt(EntityMap.get("Strength")));
        anyEntity.setPerception(Integer.parseInt(EntityMap.get("Perception")));
        anyEntity.setEndurance(Integer.parseInt(EntityMap.get("Endurance")));
        anyEntity.setCharisma(Integer.parseInt(EntityMap.get("Charisma")));
        anyEntity.setIntelligence(Integer.parseInt(EntityMap.get("Intelligence")));
        anyEntity.setAgility(Integer.parseInt(EntityMap.get("Agility")));
        anyEntity.setLuck(Integer.parseInt(EntityMap.get("Luck")));
        anyEntity.setSkillMeleeAttack(Integer.parseInt(EntityMap.get("SkillMeleeAttack")));
        anyEntity.setChanceOfHitting(Integer.parseInt(EntityMap.get("ChanceOfHitting")));
        anyEntity.setSkillDodge(Integer.parseInt(EntityMap.get("SkillDodge")));
        anyEntity.setChanceDodge(Integer.parseInt(EntityMap.get("ChanceDodge")));


    }
}
