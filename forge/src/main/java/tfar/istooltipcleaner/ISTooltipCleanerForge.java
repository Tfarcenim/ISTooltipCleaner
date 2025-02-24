package tfar.istooltipcleaner;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import java.util.List;

@Mod(ISTooltipCleaner.MOD_ID)
public class ISTooltipCleanerForge {
    
    public ISTooltipCleanerForge() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT,TooltipCleanerConfig.CLIENT_SPEC);
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
        MinecraftForge.EVENT_BUS.addListener(EventPriority.LOWEST,this::onTooltip);
        // Use Forge to bootstrap the Common mod.
        ISTooltipCleaner.init();
        
    }

    void onTooltip(ItemTooltipEvent event) {
        List<Component> tooltip = event.getToolTip();
        tooltip.removeIf(component -> component.getContents() instanceof TranslatableContents translatableContents
                && TooltipCleanerConfig.CONFIG.list.get().contains(translatableContents.getKey()));
    }
}