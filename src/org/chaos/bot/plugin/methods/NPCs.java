package org.chaos.bot.plugin.methods;

import org.chaos.bot.game.GameProvider;
import org.chaos.bot.wrappers.NPC;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/4/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class NPCs {

    private final GameProvider provider;

    public NPCs(final GameProvider provider) {
        this.provider = provider;
    }

    public NPC[] getNpcs() {
        final Object[] npcs = provider.getClient().getNpcs();
        final ArrayList<NPC> ret = new ArrayList<>();
        for(final Object npc : npcs) {
            if(npc != null) {
                ret.add(new NPC(npc, provider.getLoader()));
            }
        }
        return ret.toArray(new NPC[ret.size()]);
    }
}
