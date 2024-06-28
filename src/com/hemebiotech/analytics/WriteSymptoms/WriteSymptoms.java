package com.hemebiotech.analytics.WriteSymptoms;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptoms implements IWriteSymptoms {
    /**
     *
     */
    private final String filepath; // Name of the output file.

    /**
     *Class constructor
     * @param filepath  * Path of the file writing the symptoms in alphabetical order along with their occurrences.
     */
    public WriteSymptoms(String filepath) {
        this.filepath=filepath;
    }

    /**
     *We check if the output file has the .out extension
     * A foreach loop to write the symptoms and their occurrences in the output file
     * @param symptoms a map sorted in alphabetical order key=symptom, value=occurrence
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filepath != null) {
            int pointPosition = filepath.lastIndexOf(".");

                try {
                    if (!filepath.substring(pointPosition + 1).equals("out")) {
                        throw new FileExtentionException("");
                    }
                    FileWriter writer = new FileWriter(filepath);
                    for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                        writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
                    }
                    writer.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }catch (FileExtentionException e) {
                    System.out.println(e.getMessage());
                }
        }
    }
}