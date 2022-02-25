package dev.px.deteorite.Util;

import com.google.common.reflect.ClassPath;
import dev.px.deteorite.Deteorite;
import dev.px.deteorite.Function.Module.Module;
import dev.px.deteorite.Util.Interfaces.Util;
import net.minecraft.launchwrapper.Launch;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Classutil implements Util {

    public static String packagePath = "dev.px.deteorite";

    public static ArrayList<Class<?>> getClasses(String packageName) {
        ArrayList<Class<?>> classes = new ArrayList<>();
        try {
            for(ClassPath.ClassInfo c : ClassPath.from(Launch.classLoader).getAllClasses()) {
                if(c.getName().startsWith(packageName)) {
                    classes.add(c.load());
                }
            }
            return classes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addPackage(String name, boolean clientPath) {
        try {
            String in = clientPath ? packagePath + name : name;
            ArrayList<Class<?>> list = getClasses(in);
            if(list == null) {
                return;
            }

            for(Class<?> c : list) {
                /*
                Double check below
                 */
                if(Modifier.isAbstract(c.getModifiers())) {
                    continue;
                }

                if(Module.class.isAssignableFrom(c)) {
                    for(Constructor<?> cc : c.getConstructors()) {

                    }
                }
            }
        } catch (Exception ignored) {
            Deteorite.log.info("Something went wrong trying to load module manager arraylist! Please Check Classutil for more info");
        }
    }
}
