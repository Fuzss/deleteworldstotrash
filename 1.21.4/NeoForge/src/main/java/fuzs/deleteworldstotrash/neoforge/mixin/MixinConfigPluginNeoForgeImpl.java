package fuzs.deleteworldstotrash.neoforge.mixin;

import com.google.common.collect.ImmutableSet;
import fuzs.deleteworldstotrash.DeleteWorldsToTrash;
import net.neoforged.fml.loading.FMLEnvironment;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MixinConfigPluginNeoForgeImpl implements IMixinConfigPlugin {
    private static final Collection<String> DEVELOPMENT_MIXINS = ImmutableSet.of("AbstractPackResourcesNeoForgeMixin",
            "client.ClientDataMainNeoForgeMixin",
            "client.ClientMainNeoForgeMixin");

    public static boolean isDevelopmentEnvironment() {
        return !FMLEnvironment.production &&
                Boolean.getBoolean(DeleteWorldsToTrash.MOD_ID + ".isDevelopmentEnvironment");
    }

    @Override
    public void onLoad(String mixinPackage) {
        // NO-OP
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return isDevelopmentEnvironment() ||
                !DEVELOPMENT_MIXINS.contains(mixinClassName.replaceAll(".+\\.mixin\\.", ""));
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
        // NO-OP
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        // NO-OP
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        // NO-OP
    }
}
