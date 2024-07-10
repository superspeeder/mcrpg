package dev.superspeeder.mcrpg.rpg.character;

import java.util.Set;

public enum CharacterClass {
    Warrior(1.0f, Set.of(BasicProficiency.HEAVY_WEAPONS, BasicProficiency.LIGHT_WEAPONS)),
    Ranger(1.2f, Set.of(BasicProficiency.THROWING_WEAPONS, BasicProficiency.RANGED_WEAPONS)),
    Mage(1.0f, Set.of(BasicProficiency.MAGIC)),
    Rogue(1.5f, Set.of(BasicProficiency.LIGHT_WEAPONS, BasicProficiency.THROWING_WEAPONS)),
    Summoner(1.2f, Set.of(BasicProficiency.MAGIC)),
    ;

    CharacterClass(
            float baseSpeedModifier,
            Set<BasicProficiency> basicProficiencies
    ) {

    }
}
