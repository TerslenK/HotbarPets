package io.github.thebusybiscuit.hotbarpets.pets;

import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.hotbarpets.SimpleBasePet;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public class GhastPet extends SimpleBasePet {

    private final HotbarPets plugin;

    public GhastPet(HotbarPets plugin, SlimefunItemStack item, ItemStack food, ItemStack[] recipe) {
        super(plugin.getItemGroup(), item, food, recipe);

        this.plugin = plugin;
    }

    @Override
    public void onUseItem(Player p) {
        Fireball ball = p.launchProjectile(Fireball.class);
        ball.setMetadata("hotbarpets_player", new FixedMetadataValue(plugin, p.getUniqueId()));

        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 500, 1));
    }

}
