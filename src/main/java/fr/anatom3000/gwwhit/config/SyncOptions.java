package fr.anatom3000.gwwhit.config;

import org.intellij.lang.annotations.MagicConstant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates how config options are synced and applied.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SyncOptions {
    int SPECIAL   = 0b10000000;
    /**
     * The option is used on the client.
     */
    int CLIENT    = 0b00000001;
    /**
     * The option is used on the server.
     */
    int SERVER    = 0b00000010;
    /**
     * The option is used on the server and client. Same as {@link SyncOptions#CLIENT} {@code |} {@link SyncOptions#SERVER}
     */
    int BOTH      = CLIENT | SERVER;
    /**
     * The config is synced.
     */
    int SYNCED    = 0b00000100;
    /**
     * The config is checked. Used when a value can't be changed.
     */
    int CHECKED   = 0b00001000;
    /**
     * The option is not used.
     */
    int NONE      = 0b00000001 | SPECIAL;
    /**
     * The option is a group. It doesn't do anything except contain other options.
     */
    int GROUP     = 0b00000010 | SPECIAL;

    @MagicConstant(flagsFromClass = SyncOptions.class) int value();
}
