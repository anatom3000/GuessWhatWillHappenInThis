package fr.anatom3000.gwwhit.client.render.entity;

import fr.anatom3000.gwwhit.entity.projectile.SentientArrow;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class SentientArrowRenderer extends ProjectileEntityRenderer<SentientArrow> {

	public SentientArrowRenderer(Context context) {
		super(context);
	}

	@Override
	public Identifier getTexture(SentientArrow var1) {
		return ArrowEntityRenderer.TEXTURE;
	}

}
