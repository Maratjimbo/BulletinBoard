package board.util;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserIO {
    public static synchronized ConcurrentHashMap<String, String> getUsers(String filePath) throws IOException {
        ConcurrentHashMap<String, String> users = new ConcurrentHashMap<>();
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            users.put(line, reader.readLine());
        }

        return users;
    }

    public static synchronized void saveUsers(String filePath, ConcurrentHashMap<String, String> users) throws IOException {
        File file = new File(filePath);
        FileWriter writer = new FileWriter(file);
        StringBuilder out = new StringBuilder();

        for (String key : users.keySet()) {
            out.append(key).append('\n')
                    .append(users.get(key)).append('\n');
        }

        writer.write(out.toString());
        writer.flush();
    }
}
