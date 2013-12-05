package org.chaos.bot.wrappers;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/2/13
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player extends Entity {

    public Player(final Object player, final ClassLoader loader) {
        super(player, loader);
    }

    public String getName() {
        try {
            return loader.loadClass("Player").getDeclaredField("name").get(entity).toString();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return "null";
    }
}
