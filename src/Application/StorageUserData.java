package Application;

import java.io.*;

public class StorageUserData {
    int load()
    {
        String fileName = "userdata.txt";
        try(BufferedReader file = new BufferedReader(new FileReader(fileName))){
            String line = file.readLine();
            return Integer.parseInt(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(int budget) {
        String fileName = "userdata.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(Integer.toString(budget));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean existUserData()
    {
        String fileName = "userdata.txt";
        File file = new File(fileName);
        return file.exists();
    }
}
