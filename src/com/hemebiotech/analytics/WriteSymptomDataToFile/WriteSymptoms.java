package com.hemebiotech.analytics.WriteSymptomDataToFile;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptoms implements IWriteSymptoms {
    /**
     *
     */
    private final String filepath; // Name of the output file.

    /**
     *
     * @param filepath  * Path of the file writing the symptoms in alphabetical order along with their occurrences.
     */
    public WriteSymptoms(String filepath) {
        this.filepath=filepath;
    }

    /**
     *
     * @param symptoms a map sorted in alphabetical order key=symptom, value=occurrence
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filepath != null) {
            int pointPosition = filepath.lastIndexOf(".");    //We check if the output file has the .out extension
            if (filepath.substring(pointPosition + 1).equals("out")) {


                try {
                    FileWriter writer = new FileWriter(filepath);
                    for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {  // A foreach loop to write the symptoms and their occurrences in the output file
                        writer.write(entry.getKey() + " : " + entry.getValue() + "\n");
                    }
                    writer.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else {
                System.out.println("pas la bonne extension de fichier");
            }
        }
    }
}
