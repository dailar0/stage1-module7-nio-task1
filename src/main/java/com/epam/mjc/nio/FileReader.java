package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {

            String nameString = reader.readLine();
            String ageString = reader.readLine();
            String emailString = reader.readLine();
            String phoneString = reader.readLine();

            String name = nameString.split(":")[1].strip();
            int age = Integer.parseInt(ageString.split(":")[1].strip());
            String email = emailString.split(":")[1].strip();
            long phone = Long.parseLong(phoneString.split(":")[1].strip());

            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            return new Profile();
        }

    }
}
