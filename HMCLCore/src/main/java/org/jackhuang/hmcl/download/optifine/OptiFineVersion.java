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
package org.jackhuang.hmcl.download.optifine;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author huangyuhui
 */
public final class OptiFineVersion {

    @SerializedName("url")
    private final String downloadLink;

    @SerializedName("name")
    private final String name;

    @SerializedName("type")
    private final String type;

    @SerializedName("version")
    private final String patch;

    @SerializedName("mcversion")
    private final String gameVersion;

    public OptiFineVersion() {
        this(null, null, null, null, null);
    }

    public OptiFineVersion(String downloadLink, String name, String type, String patch, String gameVersion) {
        this.downloadLink = downloadLink;
        this.name = name;
        this.type = type;
        this.patch = patch;
        this.gameVersion = gameVersion;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPatch() {
        return patch;
    }

    public String getGameVersion() {
        return gameVersion;
    }
}
