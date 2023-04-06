package net.harusamsi.studymod;

import net.harusamsi.studymod.enchantment.FrostEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterEnchantments {
    public static Enchantment FROST = new FrostEnchantment();

    public static void register() {
        Registry.register(Registries.ENCHANTMENT, new Identifier("studymod", "frost"), FROST);
    }
}
