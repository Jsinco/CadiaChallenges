package me.jsinco.cadiachallenges;

import lombok.Getter;
import me.jsinco.cadiachallenges.config.YMLConfig;
import org.bukkit.Material;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class Settings {

    private final CadiaChallenges plugin = CadiaChallenges.getInstance();

    private List<Material> blockBreakWhitelist;
    private List<Material> blockPlaceWhitelist;

    public Settings() {
        this.cache();
    }

    public void cache() {
        final YMLConfig config = this.plugin.getFiles().get("config");

        this.blockBreakWhitelist = this.materialFromList(config.list("block-break-whitelist"));
        this.blockPlaceWhitelist = this.materialFromList(config.list("block-place-whitelist"));
    }

    private List<Material> materialFromList(final List<String> list) {
        return list.stream()
                .map(Material::getMaterial)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

}
