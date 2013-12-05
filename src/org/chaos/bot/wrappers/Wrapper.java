package org.chaos.bot.wrappers;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/2/13
 * Time: 1:19 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Wrapper {

    final ClassLoader loader;


    public Wrapper(final ClassLoader loader) {
        this.loader = loader;
    }

    public void test(final Wrapper wrapper) {
        wrapper.getClass().getSimpleName();
    }
}
