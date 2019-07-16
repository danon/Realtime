package app;

import debug.DefaultLoginGameClient;
import ui.gfx.resources.Resources;
import util.LookAndFeel;
import util.option.Options;

import static javax.swing.JOptionPane.*;

public class Application {
    public final static String VERSION = "0.02";
    public final static Options RunOptions = new Options();

    public static void main(String[] args) {
        LookAndFeel.setLookAndFeel();

        RunOptions.setOptions(args);
        System.out.println(RunOptions);

        if (RunOptions.isUsed("-Debug")) {
            Resources.load();
            new GameServer();
            new DefaultLoginGameClient();
        } else {
            int option = showOptionDialog(null,
                    "Would you like to run the server?", "Are you server?",
                    YES_NO_OPTION, QUESTION_MESSAGE, null,
                    new Object[]{"Server", "Client"}, "Server");

            switch (option) {
                case YES_OPTION:
                    new GameServer();
                    break;

                case NO_OPTION:
                    Resources.load();
                    new GameClient().start();
                    break;
            }
        }
    }
}
