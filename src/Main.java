import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {

    public static StringBuilder log = new StringBuilder();

    public static void createDir (String path) {
        File file = new File(path);
        if (file.mkdir()) {
            log.append("Directory ").append(file.getName()).append(" created ")
                    .append(new Date().getTime()).append("\n");
        } else {
            log.append("Directory ").append(file.getName()).append(" NOT created ")
                    .append(new Date().getTime()).append("\n");
        }
    }

    public static void createFile (String path, String name) {
        File file = new File(path, name);
        try {
            if (file.createNewFile()) {
                log.append("File ").append(file.getName()).append(" created ")
                        .append(new Date().getTime()).append("\n");
            }
        } catch (IOException e) {
                log.append("File ").append(file.getName()).append(" NOT created ")
                        .append(new Date().getTime()).append(e).append("\n");
            }
    }

    public static void writeToFile (String path) {
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(String.valueOf(log));
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        createDir("/Users/macbook/IdeaProjects/Games/src");
        createDir("/Users/macbook/IdeaProjects/Games/res");
        createDir("/Users/macbook/IdeaProjects/Games/savegames");
        createDir("/Users/macbook/IdeaProjects/Games/temp");
        createDir("/Users/macbook/IdeaProjects/Games/src/main");
        createDir("/Users/macbook/IdeaProjects/Games/src/test");
        createFile("/Users/macbook/IdeaProjects/Games/src/main", "Main.java");
        createFile("/Users/macbook/IdeaProjects/Games/src/main", "Utils.java");
        createDir("/Users/macbook/IdeaProjects/Games/res/drawables");
        createDir("/Users/macbook/IdeaProjects/Games/res/vectors");
        createDir("/Users/macbook/IdeaProjects/Games/res/icons");
        createFile("/Users/macbook/IdeaProjects/Games/temp", "temp.txt");
        writeToFile("/Users/macbook/IdeaProjects/Games/temp/temp.txt");
    }
}