import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    public static void saveDataToFile(String fileName, ArrayList<Player> userData) {
        try {
            try (FileWriter myWriter = new FileWriter(fileName)) {
                for (Player p: userData) {
                    //Add carriage return & line feed to the String
                    myWriter.write(p + "\r\n");
                }
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static ArrayList<Player> readDataFromFile(String fileName) {
        ArrayList<Player> fileData = new ArrayList<Player>();
        try {
            File dataFile = new File(fileName);
            Scanner myReader = new Scanner(dataFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //Remove the carriage return & line feed
                String[] playerData = data.replaceAll("[\r\n]", "").split(",");
                fileData.add(new Player(playerData[0], Integer.parseInt(playerData[1]),playerData[2]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return fileData;
    }
}