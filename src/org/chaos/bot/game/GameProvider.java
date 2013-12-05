package org.chaos.bot.game;

import org.chaos.bot.wrappers.Client;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/1/13
 * Time: 7:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameProvider {

    private ClassLoader loader;
    private Client client;

    public GameProvider() throws MalformedURLException {
        final File file = new File("./Webclient.jar");
        final URLClassLoader loader = new URLClassLoader(new URL[]{file.toURL()});
        this.loader = loader;

    }

    public Applet getApplet(final AppletStub stub) {
        try {
            final Class<?> client = loader.loadClass("Client");
            final Applet applet = (Applet) client.newInstance();
            this.client = new Client(applet, loader);
            applet.setStub(stub);
            return applet;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Client getClient() {
        return client;
    }

    public ClassLoader getLoader() {
        return loader;
    }
}
