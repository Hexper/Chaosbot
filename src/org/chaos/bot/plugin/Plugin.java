package org.chaos.bot.plugin;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/2/13
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Plugin implements Runnable {

    private boolean running;

    @Override
    public void run() {
        boolean start = start();
        if(start) {
            running = true;
            while(running) {
                sleep(loop());
            }
        }

    }

    public void sleep(final int millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean start() {
        return true;
    }

    public abstract int loop();
}
