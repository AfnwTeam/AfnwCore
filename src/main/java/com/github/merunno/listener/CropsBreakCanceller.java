package com.github.merunno.listener;

import org.bukkit.ChatColor;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class CropsBreakCanceller implements Listener {

    @EventHandler
    public void onbreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block target = event.getBlock();
        if (Tag.CROPS.isTagged(target.getLocation().add(0,1,0).getBlock().getType())){
            player.sendMessage(ChatColor.RED + "[AfnwCore] 一度植えた成長しきっていない農作物の下にあるブロックは破壊できません。");
            event.setCancelled(true);
            return;
        }
        if(!(Tag.CROPS.isTagged(target.getType()))) return;
        if (target.getBlockData() instanceof Ageable){
            Ageable crop = (Ageable)target.getBlockData();
            if (crop.getMaximumAge() == crop.getAge()) return;
        }
        player.sendMessage(ChatColor.RED + "[AfnwCore] 一度植えた成長しきっていない農作物は破壊できません。");
        event.setCancelled(true);
    }

}
