package com.hemebiotech.analytics.WriteSymptomDataToFile;

import java.util.Map;

/**
 *Takes a TreeMap with the symptoms in alphabetical order and their occurrence count as an argument to write the results into a .out file.
 *
 */
public interface IWriteSymptoms {
    /**
     *
     * @param symptoms a map sorted in alphabetical order key=symptom, value=occurrence
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
