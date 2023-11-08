package fr.mrcubee.finder.plugin.bungeecord;

import fr.mrcubee.finder.plugin.PluginFinder;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;
import java.util.logging.Logger;

/** This class retrieves which Bungeecord plugin calls the function.
 * @author MrCubee
 * @version 1.0
 * @since 1.0
 */
public class BungeePluginFinder extends PluginFinder {

    private Plugin findPlugin(int searchIndex) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        Class<?> clazz = null;
        int hashSourceCode;

        if (stackTraceElements.length < (searchIndex + 1))
            return null;
        try {
            clazz = Class.forName(stackTraceElements[searchIndex].getClassName());
        } catch (ClassNotFoundException ignored) {}
        if (clazz == null)
            return null;
        hashSourceCode = clazz.getProtectionDomain().getCodeSource().hashCode();
        for (Plugin plugin : BungeeCord.getInstance().getPluginManager().getPlugins())
            if (plugin.getClass().getProtectionDomain().getCodeSource().hashCode() == hashSourceCode)
                return plugin;
        return null;
    }

    @Override
    public Object findPluginCaller() {
        return findPlugin(4);
    }

    @Override
    public Object findPlugin() {
        return findPlugin(3);
    }

    @Override
    public Logger findLogger(Object plugin) {
        if (!(plugin instanceof Plugin))
            return null;
        return ((Plugin) plugin).getLogger();
    }

    @Override
    public File findDataFolder(Object plugin) {
        if (!(plugin instanceof Plugin))
            return null;
        return ((Plugin) plugin).getDataFolder();
    }
}
