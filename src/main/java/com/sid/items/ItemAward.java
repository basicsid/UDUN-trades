package com.sid.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stat;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.ProjectileImpactEvent;


public class ItemAward extends Item {
    public ItemAward(){
        super(new Properties().group(ModGroup.itemGroup));
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!playerIn.isCreative()) {
            itemstack.shrink(1);
        }

        worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.PLAYERS, 0.75F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));


        playerIn.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE,18000,1));
        playerIn.inventory.addItemStackToInventory(new ItemStack(Items.EMERALD,8));
        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }

    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
}
