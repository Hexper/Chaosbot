package org.chaos.bot.wrappers;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/4/13
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class NPC extends Entity {

    public NPC(final Object entity, final ClassLoader loader) {
        super(entity, loader);
    }

    private EntityDef getDefinition() {
        try {
            final Field entityDef = loader.loadClass("NPC").getDeclaredField("desc");
            final Object definition = entityDef.get(entity);
            return new EntityDef(definition, loader);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getId() {
        return getDefinition().getId();
    }
}
