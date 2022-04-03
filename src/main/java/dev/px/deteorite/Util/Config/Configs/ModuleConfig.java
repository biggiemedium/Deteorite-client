package dev.px.deteorite.Util.Config.Configs;

import dev.px.deteorite.Deteorite;
import dev.px.deteorite.Function.Module.Module;
import dev.px.deteorite.Util.Config.Config;

import java.io.*;

public class ModuleConfig extends Config {

    public ModuleConfig() {
        super("Module", true);
    }

    private File modFile = new File(this.getSubFile() + File.separator + "Modules.txt");

    @Override
    public void saves() {
        //if(!modFile.exists()) { modFile.mkdirs(); }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.modFile));
            for(Module m : Deteorite.moduleManager.getModules()) {
                if(m != null && m.isToggled()) { // && !m.getName().matches(null)
                    writer.write(m.getName());
                    writer.write("\r\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loads() {
        try {
            FileInputStream fstream = new FileInputStream(modFile.getAbsolutePath());
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = br.readLine()) != null) {
                String s = line;
                Deteorite.moduleManager.getModules().forEach(m -> {
                    try {
                        if (m.getName().equals(s)) {
                            m.setToggled(true);
                        }
                    } catch(Exception e) {}
                });
                br.close();
            }
            //br.close();
        } catch (IOException ignored) {}
    }
}
