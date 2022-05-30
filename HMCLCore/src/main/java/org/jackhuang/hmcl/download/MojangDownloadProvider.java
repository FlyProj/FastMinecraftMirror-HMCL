/*
 * Hello Minecraft! Launcher
 * Copyright (C) 2020  huangyuhui <huanghongxun2008@126.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.jackhuang.hmcl.download;

import org.jackhuang.hmcl.download.fabric.FabricAPIVersionList;
import org.jackhuang.hmcl.download.fabric.FabricVersionList;
import org.jackhuang.hmcl.download.forge.ForgeVersionList;
import org.jackhuang.hmcl.download.game.GameVersionList;
import org.jackhuang.hmcl.download.liteloader.LiteLoaderVersionList;
import org.jackhuang.hmcl.download.optifine.OptiFineBMCLVersionList;

/**
 * @see <a href="http://wiki.vg">http://wiki.vg</a>
 * @author huangyuhui
 */
public class MojangDownloadProvider implements DownloadProvider {
    private final GameVersionList game;
    private final FabricVersionList fabric;
    private final FabricAPIVersionList fabricApi;
    private final ForgeVersionList forge;
    private final LiteLoaderVersionList liteLoader;
    private final OptiFineBMCLVersionList optifine;

    public MojangDownloadProvider() {
        String apiRoot = "https://launchermeta.fastmcmirror.org";

        this.game = new GameVersionList(this);
        this.fabric = new FabricVersionList(this);
        this.fabricApi = new FabricAPIVersionList(this);
        this.forge = new ForgeVersionList(this);
        this.liteLoader = new LiteLoaderVersionList(this);
        this.optifine = new OptiFineBMCLVersionList("https://optifine.fastmcmirror.org");
    }

    @Override
    public String getVersionListURL() {
        return "https://launchermeta.fastmcmirror.org/mc/game/version_manifest.json";
    }

    @Override
    public String getAssetBaseURL() {
        return "https://resources.fastmcmirror.org/";
    }

    @Override
    public VersionList<?> getVersionListById(String id) {
        switch (id) {
            case "game":
                return game;
            case "fabric":
                return fabric;
            case "fabric-api":
                return fabricApi;
            case "forge":
                return forge;
            case "liteloader":
                return liteLoader;
            case "optifine":
                return optifine;
            default:
                throw new IllegalArgumentException("Unrecognized version list id: " + id);
        }
    }

    @Override
    public String injectURL(String baseURL) {
        return baseURL
                .replaceFirst("https://launchermeta.mojang.com","https://launchermeta.fastmcmirror.org")
                .replaceFirst("https://resources.download.minecraft.net","https://resources.fastmcmirror.org")
                .replaceFirst("https://libraries.minecraft.net","https://libraries.fastmcmirror.org")
                .replaceFirst("https://maven.minecraftforge.net","https://forge.fastmcmirror.org")
                .replaceFirst("https://files.minecraftforge.net/maven","https://forge.fastmcmirror.org")
                .replaceFirst("https://meta.fabricmc.net","https://fabricmeta.fastmcmirror.org")
                .replaceFirst("https://maven.fabricmc.net","https://fabric.fastmcmirror.org")
                .replace("http://repo.mumfrey.com/","https://liteloader.fastmcmirror.org/")
                .replace("https://repo.mumfrey.com/","https://liteloader.fastmcmirror.org/");
    }

    @Override
    public int getConcurrency() {
        return 6;
    }
}
