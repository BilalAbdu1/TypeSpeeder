package se.ju23.typespeeder.InfoForUsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class NewsLetter {
    public String content;

    public LocalDateTime publishDateTime;

    public NewsLetter() {
        this.content = getContent();
        this.publishDateTime = getPublishDateTime();
    }
    public static String getFormattedPublishDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
    public String getContent(){
        String text = null;
        Path currentWorkingdir = Paths.get("").toAbsolutePath();
        String path = currentWorkingdir + File.separator + "Newsletter.txt";
        if (!Files.exists(Paths.get(path))) {
            createPatchFile(path); // Create the file if it doesn't exist
        }
        text = readTextFromFile(path);

        return text;
    }
    public static LocalDateTime getPublishDateTime() {
        LocalDateTime a = null;
        Path currentWorkingdir = Paths.get("").toAbsolutePath();
        String patho = currentWorkingdir + File.separator + "Newsletter.txt";
        if (!Files.exists(Paths.get(patho))) {
            createPatchFile(patho); // Create the file if it doesn't exist
        }
        try {
            Path path = Paths.get(patho);
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
            a = LocalDateTime.ofInstant(attrs.lastModifiedTime().toInstant(), ZoneId.systemDefault());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file attributes: " + e.getMessage());

        }
        return a;
    }
    private static void createPatchFile(String filePath) {
        try {
            Files.createFile(Paths.get(filePath));
            System.out.println("Created Patch.txt at: " + filePath);
            // Skriv standardinnehållet till filen
            String defaultContent = getString();
            Files.write(Paths.get(filePath), defaultContent.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file: " + e.getMessage());
        }
    }
    public static String getString(){
        return "Welcome to Typespeeder 1.0.1 BETAVERSION.\n" +
                "Contact our admin to invite some friends.\n" +
                "To improve our game we would appreciate all the feedback you have!\n" +
                "\n" +
                "ENJOY!\n" +
                "CONTACT Admin: Hussein.adem@iths.se";
    }

    public String readTextFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try {
            Path path = Paths.get(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        return content.toString();
    }

    @Override
    public String toString() {
        return "NewsLetter\n" + content +
                "PublishDateTime: " + getFormattedPublishDateTime(publishDateTime) + "\n" ;
    }
}
