package net.harusamsi.studymod;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        registerBow(RegisterItems.CUSTOM_BOW);
    }

    private static void registerBow(Item bow) {
        FabricModelPredicateProviderRegistry.register(bow, new Identifier("pull"),
            (itemStack, clientWorld, livingEntity, seed) -> {
                if (livingEntity == null) {
                    return 0.0F;
                }
                return livingEntity.getActiveItem() != itemStack ? 0.0F : (itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
            }
        );

        FabricModelPredicateProviderRegistry.register(bow, new Identifier("pulling"),
                (itemStack, clientWorld, livingEntity, seed) -> {
                    if (livingEntity == null) {
                        return 0.0F;
                    }
                    return livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
                }
        );
    }
}
