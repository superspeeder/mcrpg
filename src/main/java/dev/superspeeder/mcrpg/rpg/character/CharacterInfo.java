package dev.superspeeder.mcrpg.rpg.character;

public record CharacterInfo(
        CharacterStats stats,
        CharacterClass class_,
        CharacterRace race
) {
}
