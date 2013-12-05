package org.chaos.bot.plugin.methods;

import org.chaos.bot.game.GameProvider;
import org.chaos.bot.wrappers.Interface;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/4/13
 * Time: 7:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class Interfaces {

    private final GameProvider provider;

    public Interfaces(final GameProvider provider) {
        this.provider = provider;
    }

    public Interface[] getCache() {
        final Object[] cache = provider.getClient().getInterfaceCache();
        final ArrayList<Interface> interfaces = new ArrayList<>();
        for (final Object object : cache) {
            if (object == null) {
                continue;
            }
            final Interface inter = new Interface(cache, provider.getLoader());
            interfaces.add(inter);
        }
        return interfaces.toArray(new Interface[interfaces.size()]);
    }

    public Interface getInventory() {
        return new Interface(provider.getClient().getInterfaceCache()[149], provider.getLoader());
    }
}
