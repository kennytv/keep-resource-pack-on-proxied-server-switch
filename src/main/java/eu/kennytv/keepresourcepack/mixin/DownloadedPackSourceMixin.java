/*
 * This file is part of KeepResourcePackOnProxiedServerSwitch - https://github.com/kennytv/keep-resource-pack-on-proxied-server-switch
 * Copyright (C) 2023 Nassim Jahnke
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eu.kennytv.keepresourcepack.mixin;

import eu.kennytv.keepresourcepack.KeepResourcePack;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import net.minecraft.client.resources.DownloadedPackSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DownloadedPackSource.class)
public abstract class DownloadedPackSourceMixin {

    @Inject(method = "downloadAndSelectResourcePack", at = @At("RETURN"))
    private void clearServerPack(final URL url, final String hash, final boolean bl, final CallbackInfoReturnable<CompletableFuture<?>> cir) {
        KeepResourcePack.lastResourcePackHash = hash; // If it fails, then too bad
        // cir.getReturnValue().thenAccept($ -> KeepResourcePack.lastResourcePackHash = hash);
    }
}
