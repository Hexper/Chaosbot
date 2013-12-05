package org.chaos.bot.wrappers;

import java.applet.Applet;
import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/2/13
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class Client extends Wrapper {

    private final Object client;
    private Class<?> loaded;

    public Client(final Object client, final ClassLoader loader) {
        super(loader);
        this.client = client;
        try {
            this.loaded = loader.loadClass("Client");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public Player getLocal() {
        try {
            final Object player = loader.loadClass("Client").getDeclaredField("myPlayer").get(client);
            return new Player(player, loader);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setPrivilege() {
        try {
            final Field privilege = loaded.getDeclaredField("myPrivilege");
            privilege.setAccessible(true);
            privilege.set(client, 2);
        } catch(final Exception e) {
            e.printStackTrace();
        }
    }

    public void openInterface(final int interfaceId) {
        try {
            final Field open = loaded.getDeclaredField("openInterfaceID");
            open.set(null, interfaceId);
        } catch(final Exception e) {
            e.printStackTrace();
        }
    }

    public Applet getApplet() {
        return (Applet) client;
    }

    public Object[] getInterfaceCache() {
        try {
            final Object interfaces = loader.loadClass("RSInterface").getDeclaredField("interfaceCache").get(null);
            return (Object[]) interfaces;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object[] getNpcs() {
        try {
            final Field npcArray = loader.loadClass("Client").getDeclaredField("npcArray");
            npcArray.setAccessible(true);
            final Object array = npcArray.get(client);
            return (Object[]) array;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
