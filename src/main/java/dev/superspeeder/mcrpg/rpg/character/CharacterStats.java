package dev.superspeeder.mcrpg.rpg.character;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.UnknownNullability;

public class CharacterStats implements INBTSerializable<CompoundTag> {
    public int strength;     // used for most physical attacks & checks
    public int charisma;     // used for various conversational checks & reduces merchant prices.
    public int dexterity;    // used for speed, "finesse" (to steal the term from d&d) attacks, and thievery
    public int intelligence; // used for magic based attacks
    public int constitution; // used for health & various debuff resistances (ex: poison)
    public int luck;         // used for loot quality

    public CharacterStats() {
        strength = 0;
        charisma = 0;
        dexterity = 0;
        intelligence = 0;
        constitution = 0;
        luck = 0;
    }

    public CharacterStats(int strength, int charisma, int dexterity, int intelligence, int constitution, int luck) {
        this.strength = strength;
        this.charisma = charisma;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.constitution = constitution;
        this.luck = luck;
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        tag.putInt("strength", strength);
        tag.putInt("charisma", charisma);
        tag.putInt("dexterity", dexterity);
        tag.putInt("intelligence", intelligence);
        tag.putInt("constitution", constitution);
        tag.putInt("luck", luck);
        return tag;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag compoundTag) {
        deserializeNBT(compoundTag);
    }

    public void deserializeNBT(CompoundTag compoundTag) {
        strength = compoundTag.getInt("strength");
        charisma = compoundTag.getInt("charisma");
        dexterity = compoundTag.getInt("dexterity");
        intelligence = compoundTag.getInt("intelligence");
        constitution = compoundTag.getInt("constitution");
        luck = compoundTag.getInt("luck");
    }

    public static CharacterStats loadFromNBT(CompoundTag compoundTag) {
        CharacterStats stats = new CharacterStats();
        stats.deserializeNBT(compoundTag);
        return stats;
    }

    public CharacterStats withStrength(int strength) {
        this.strength = strength;
        return this;
    }

    public CharacterStats withCharisma(int charisma) {
        this.charisma = charisma;
        return this;
    }

    public CharacterStats withDexterity(int dexterity) {
        this.dexterity = dexterity;
        return this;
    }

    public CharacterStats withIntelligence(int intelligence) {
        this.intelligence = intelligence;
        return this;
    }

    public CharacterStats withConstitution(int constitution) {
        this.constitution = constitution;
        return this;
    }

    public CharacterStats withLuck(int luck) {
        this.luck = luck;
        return this;
    }
}
