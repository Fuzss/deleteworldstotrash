package fuzs.deleteworldstotrash.services;

public interface CommonAbstractions {
    CommonAbstractions INSTANCE = ServiceProviderLoader.load(CommonAbstractions.class);

    boolean isForgeLike();
}
