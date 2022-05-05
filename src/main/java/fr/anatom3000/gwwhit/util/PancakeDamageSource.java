package fr.anatom3000.gwwhit.util;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.EntityDamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class PancakeDamageSource extends EntityDamageSource {
    public PancakeDamageSource(PlayerEntity source) {
        super("player", source);
    }

    @Override
    public Text getDeathMessage(LivingEntity entity) {
        return new TranslatableText( "death.attack.gwwhit.pancakes", entity.getDisplayName() );
    }
}
