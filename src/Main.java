import javax.swing.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Player> playerData = FileIO.readDataFromFile("playerData"); //playerData stores player objects

    public static void main(String[] args){
        JFrame frame = new welcomeForm(playerData);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
