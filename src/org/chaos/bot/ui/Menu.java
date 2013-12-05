package org.chaos.bot.ui;

import org.chaos.bot.game.GameProvider;
import org.chaos.bot.plugin.methods.Interfaces;
import org.chaos.bot.plugin.methods.NPCs;
import org.chaos.bot.wrappers.Client;
import org.chaos.bot.wrappers.Interface;
import org.chaos.bot.wrappers.NPC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/2/13
 * Time: 9:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class Menu extends JMenuBar {

    private final ArrayList<String> selected = new ArrayList<>();

    private Client cl;
    private GameProvider provider;

    public Menu() {
        this.add(getFileMenu());
        this.add(getViewMenu());
    }

    public void pass(final GameProvider provider) {
        this.cl = provider.getClient();
        this.provider = provider;
    }

    public JMenu getViewMenu() {
        final JMenu view = new JMenu("View");
        for (final JMenuItem item : generateItems("Player", "Privilege", "Open interface", "NPC")) {
            item.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   /* final String text = item.getText();
                    if (selected.contains(text)) {
                        selected.remove(text);
                    } else {
                        selected.add(text);
                    }   */
                    debug(item.getText());
                }

            });
            view.add(item);
        }
        view.getPopupMenu().setLightWeightPopupEnabled(false);
        return view;
    }

    public JMenu getFileMenu() {
        final JMenu file = new JMenu("File");
        file.add("Start script");
        file.add("Close bot");
        file.getPopupMenu().setLightWeightPopupEnabled(false);
        return file;
    }

    public JMenuItem[] generateItems(final String... titles) {
        final JMenuItem[] items = new JMenuItem[titles.length];
        for (int i = 0; i < titles.length; i++) {
            final JMenuItem item = new JMenuItem(titles[i]);
            items[i] = item;
        }
        return items;
    }

    public void debug(final String debug) {
        switch(debug) {
            case "Player":
                System.out.println(cl.getLocal().getName());
                break;

            case "Privilege" :
                cl.setPrivilege();
                break;

            case "Open interface" :
                final int id = Integer.parseInt(JOptionPane.showInputDialog(cl.getApplet(), "Interface ID"));
                cl.openInterface(id);
                break;

            case "NPC" :
                final NPCs npcs = new NPCs(provider);
                for(final NPC npc : npcs.getNpcs()) {
                    System.out.println("NPC " + npc.getId());
                }
                break;

        }
    }
}
