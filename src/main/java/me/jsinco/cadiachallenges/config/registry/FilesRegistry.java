package me.jsinco.cadiachallenges.config.registry;

import me.jsinco.cadiachallenges.CadiaChallenges;
import me.jsinco.cadiachallenges.config.YMLConfig;
import me.jsinco.cadiachallenges.config.YMLConfigFactory;

import java.io.File;
import java.util.Arrays;

public class FilesRegistry extends Registry<String, YMLConfig> {

    private final CadiaChallenges main;
    private final YMLConfigFactory configFactory;

    public FilesRegistry(final CadiaChallenges main) {
        this.main = main;
        this.configFactory = new YMLConfigFactory(main);
    }

    public FilesRegistry createFile(final String file) {
        this.put(file, this.configFactory.createConfig(this.main.getDataFolder(), file));
        return this;
    }

    public FilesRegistry createFile(final String... files) {
        Arrays.stream(files).forEach(this::createFile);
        return this;
    }

    public FilesRegistry createFile(final File folder, final String... files) {
        String folderName = folder.getAbsolutePath().replaceAll(this.main.getDataFolder().getAbsolutePath() + File.separator, "");
        Arrays.stream(files).forEach(fileName -> this.put(fileName, this.configFactory.createConfig(folder, fileName, folderName)));
        return this;
    }

    public FilesRegistry createOptionalFile(final File folder, final String... files) {
        Arrays.stream(files).forEach(fileName -> this.put(fileName, this.configFactory.createOptionalConfig(folder, fileName)));
        return this;
    }

}
