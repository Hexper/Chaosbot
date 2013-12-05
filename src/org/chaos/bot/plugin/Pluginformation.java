package org.chaos.bot.plugin;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: Jasper
 * Date: 12/2/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Pluginformation {

    public abstract String name();
    public abstract String[] authors();
    public abstract double version() default 1.0;
    public abstract String description() default "";
    public abstract String category() default "none";

}
