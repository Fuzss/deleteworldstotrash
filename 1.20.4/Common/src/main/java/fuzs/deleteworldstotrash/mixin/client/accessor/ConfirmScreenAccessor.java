package fuzs.deleteworldstotrash.mixin.client.accessor;

import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import net.minecraft.client.gui.screens.ConfirmScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ConfirmScreen.class)
public interface ConfirmScreenAccessor {

    @Accessor("message")
    Component deleteworldstotrash$getMessage();

    @Accessor("callback")
    BooleanConsumer deleteworldstotrash$getCallback();
}
