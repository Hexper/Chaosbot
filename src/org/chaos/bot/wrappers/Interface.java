package org.chaos.bot.wrappers;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/4/13
 * Time: 6:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Interface extends Wrapper {

    private final Object wrapper;

    public Interface(final Object wrapper, final ClassLoader loader) {
        super(loader);
        this.wrapper = wrapper;
    }

}
