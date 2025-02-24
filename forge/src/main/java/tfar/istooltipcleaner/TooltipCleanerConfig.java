package tfar.istooltipcleaner;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class TooltipCleanerConfig {
    public static final TooltipCleanerConfig CONFIG;
    public static final ForgeConfigSpec CLIENT_SPEC;

    static {
        final Pair<TooltipCleanerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(TooltipCleanerConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CONFIG = specPair.getLeft();
    }

    public final ForgeConfigSpec.ConfigValue<List<? extends String>> list;

    public TooltipCleanerConfig(ForgeConfigSpec.Builder builder)  {
        builder.push("general");
        list = builder.defineList("list",defaults(),String.class::isInstance);
        builder.pop();
    }

    static List<? extends String> defaults() {
        List<String> strings = new ArrayList<>();

        Collections.addAll(strings,    "tooltip.irons_spellbooks.imbued_tooltip",
                "tooltip.irons_spellbooks.can_be_imbued",
                "tooltip.irons_spellbooks.can_be_imbued_frame",
                "tooltip.irons_spellbooks.can_be_imbued_number",
                "tooltip.irons_spellbooks.imbue_slots",
                "tooltip.irons_spellbooks.casting_implement_tooltip",
                "tooltip.irons_spellbooks.spell_title",
                "tooltip.irons_spellbooks.mana_cost",
                "tooltip.irons_spellbooks.mana_cost_per_second",
                "tooltip.irons_spellbooks.cooldown_length_seconds",
                "tooltip.irons_spellbooks.cast_type",
                "tooltip.irons_spellbooks.selected_spell",
                "tooltip.irons_spellbooks.rarity",
                "tooltip.irons_spellbooks.spellbook_rarity",
                "tooltip.irons_spellbooks.spellbook_unique",
                "tooltip.irons_spellbooks.spellbook_spell_count",
                "tooltip.irons_spellbooks.press_to_cast",
                "tooltip.irons_spellbooks.press_to_cast_active",
                "tooltip.irons_spellbooks.cast_continuous",
                "tooltip.irons_spellbooks.cast_long",
                "tooltip.irons_spellbooks.cast_charge");

        return strings;
    }


}
