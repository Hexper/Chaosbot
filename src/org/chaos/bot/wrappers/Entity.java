package org.chaos.bot.wrappers;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/2/13
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Entity extends Wrapper {

    protected final Object entity;

    public Entity(final Object entity, final ClassLoader loader) {
        super(loader);
        this.entity = entity;
    }

    public Entity getInteracting() {
        try {
            final Object interacting = loader.loadClass("Entity").getDeclaredField("interactingEntity").get(entity);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
