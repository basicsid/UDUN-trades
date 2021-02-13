package com.sid.entities;

import com.sid.items.ItemRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.registries.ForgeRegistries;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SidVillagerTrades {

    public SidVillagerTrades(){
            ItemStack heroItem = new ItemStack(ItemRegistry.award.get());
            ItemStack test = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("iceandfire", "fire_dragon_heart")));
            ItemStack test2 = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("iceandfire", "ice_dragon_heart")));
            ItemStack test3 = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("iceandfire", "lightning_dragon_heart")));
            ItemStack ectoplasm = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("iceandfire","ectoplasm")),8);
            ItemStack cyclops_skull = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("iceandfire","cyclops_skull")));
            ItemStack scales = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("iceandfire","shiny_scales")),16);
            ItemStack hydra_fang = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("iceandfire","hydra_fang")));

            ItemStack fur = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("alexsmobs","bear_fur")),6);
            ItemStack croc = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("alexsmobs","crocodile_scute")),6);
            ItemStack raccoon = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("alexsmobs","raccoon_tail")),5);
            ItemStack mooseribs = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("alexsmobs","moose_ribs")),5);
            ItemStack centipede = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("alexsmobs","centipede_leg")),7);
            ItemStack sharktooth = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("alexsmobs","shark_tooth")),16);

            addTrade(test,heroItem,VillagerProfession.CLERIC,5,30,1,0.0f);
            addTrade(test2,heroItem,VillagerProfession.TOOLSMITH,5,30,1,0.0f);
            addTrade(test3,heroItem,VillagerProfession.LIBRARIAN,5,30,1,0.0f);

            addTrade(ectoplasm,emerald(1),VillagerProfession.CLERIC,2,2,16,0.05f);
            addTrade(hydra_fang,emerald(3),VillagerProfession.FLETCHER,4,20,12,0.0f);
            addTrade(cyclops_skull,emerald(5),VillagerProfession.CLERIC,5,2,3,0.0f);
            addTrade(scales,emerald(1),VillagerProfession.WEAPONSMITH,4,2,16,0.05f);

            addTrade(fur,emerald(1),VillagerProfession.SHEPHERD,1,2,16,0.05f);
            addTrade(croc,emerald(1),VillagerProfession.LEATHERWORKER,4,20,12,0.05f);
            addTrade(raccoon,emerald(1),VillagerProfession.LEATHERWORKER,2,2,12,0.05f);
            addTrade(mooseribs,emerald(1),VillagerProfession.BUTCHER,4,30,16,0.05f);
            addTrade(centipede,emerald(1),VillagerProfession.CLERIC,3,20,12,0.05f);
            addTrade(sharktooth,emerald(1),VillagerProfession.FISHERMAN,3,10,12,0.05f);
            addTrade(sharktooth,emerald(1),VillagerProfession.FLETCHER,4,15,12,0.05f);
    }

    protected void addTrade(ItemStack item, int emeralds, VillagerProfession profession, int level, int xp, int maxTrades, float priceMult){
        List<VillagerTrades.ITrade> tradeList = getTradeList(profession);
        BasicTrade tradoc = new BasicTrade(item, emerald(emeralds), maxTrades,xp,priceMult);
        tradeList.add(tradoc);
        setTradeList(level,tradeList,profession);
    }

    protected void addTrade(ItemStack item, ItemStack reward, VillagerProfession profession, int level, int xp, int maxTrades,float priceMult){
        List<VillagerTrades.ITrade> tradeList = getTradeList(profession);
        BasicTrade tradoc = new BasicTrade(item, reward, maxTrades,xp,priceMult);
        tradeList.add(tradoc);
        setTradeList(level,tradeList,profession);
    }

    /**
     * Just makes a new ItemStack of emeralds
     * @param E The amount of emeralds you want in the trade
     * @return An ItemStack of X emeralds.
     */
    protected ItemStack emerald(int E){

        return new ItemStack(Items.EMERALD, E);
    }

    protected Int2ObjectMap<VillagerTrades.ITrade[]> getTrades(VillagerProfession profession){
        return VillagerTrades.VILLAGER_DEFAULT_TRADES.computeIfAbsent(profession, villagerProfession -> new Int2ObjectArrayMap<>());
    }

    protected List<VillagerTrades.ITrade> getTradeList(VillagerProfession profession){
        VillagerTrades.ITrade[] iTrades = getTrades(profession).computeIfAbsent(1, integer -> new VillagerTrades.ITrade[0]);
        return new ArrayList<>(Arrays.asList(iTrades));
    }

    protected void setTradeList(int level, List<VillagerTrades.ITrade> tradeList, VillagerProfession profession){
        getTrades(profession).put(level, tradeList.toArray(new VillagerTrades.ITrade[0]));
    }
}
