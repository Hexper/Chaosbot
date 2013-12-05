package org.chaos.bot.wrappers;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/4/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityDef extends Wrapper {

    private final Object wrapper;

    public EntityDef(final Object wrapper, final ClassLoader loader) {
        super(loader);
        this.wrapper = wrapper;
    }

    public int getId() {
        try {
            final Field type = loader.loadClass("EntityDef").getDeclaredField("type");
            return (int) type.getLong(wrapper);
        } catch(final Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
