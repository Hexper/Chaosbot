package org.chaos.bot.ui;

import org.chaos.bot.game.GameProvider;
import org.chaos.bot.wrappers.Client;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/1/13
 * Time: 7:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Window extends JFrame implements AppletStub {

    private final HashMap<String, String> parameters = new HashMap<String, String>();

    public Window() {
        super("Chaos bot");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(765, 555);
        this.setResizable(false);
        this.setVisible(true);
        final Menu menuBar = new Menu();
        this.setJMenuBar(menuBar);


        parameters.put("java_arguments", "-Xmx128");
        parameters.put("height", "767");
        parameters.put("width", "557");
        parameters.put("worldid", "1");
        parameters.put("members", "0");
        parameters.put("modewhat", "0");
        parameters.put("modewhere", "0");
        parameters.put("lang", "0");


        try {
            final GameProvider provider = new GameProvider();
            final Applet applet = provider.getApplet(this);
            menuBar.pass(provider);
            applet.setSize(765, 555);
            this.getContentPane().add(applet, BorderLayout.CENTER);
            applet.init();

        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Window();
    }

    @Override
    public URL getDocumentBase() {
        try {
            return new URL("http://notorious317.com/play/webclient/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public URL getCodeBase() {
        try {
            return new URL("http://notorious317.com/play/webclient/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getParameter(String name) {
        return parameters.get(name);
    }

    @Override
    public AppletContext getAppletContext() {
        return null;
    }

    @Override
    public void appletResize(int width, int height) {

    }
}
