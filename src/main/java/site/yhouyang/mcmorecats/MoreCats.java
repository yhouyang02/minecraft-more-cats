package site.yhouyang.mcmorecats;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreCats implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("modid");

    public static final Item TEST_CAT_BALL = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static final Block TEST_CAT_BLOCK = new Block(
            FabricBlockSettings.of(Material.STONE).strength(1.8F, 1.8F).sounds(BlockSoundGroup.STONE).requiresTool());

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");

        // register test item
        Registry.register(Registry.ITEM, new Identifier("mcmorecats", "test_cat_ball"), TEST_CAT_BALL);

        // register test block and its corresponding item
        Registry.register(Registry.BLOCK, new Identifier("mcmorecats", "test_cat_block"), TEST_CAT_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("mcmorecats", "test_cat_block"),
                new BlockItem(TEST_CAT_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}
