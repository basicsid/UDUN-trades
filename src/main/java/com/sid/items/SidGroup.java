package com.sid.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SidGroup extends ItemGroup {
    public SidGroup(){
        super("sid_group");
    }

    @Override
    public ItemStack createIcon(){
        return new ItemStack(ItemRegistry.award.get());
    }
}
