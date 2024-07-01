package com.hemebiotech.analytics.AnalyticsCounter;

import com.hemebiotech.analytics.ReadSymptoms.ReadSymptoms;
import com.hemebiotech.analytics.WriteSymptoms.WriteSymptoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class provides methods to count the occurrences of symptoms and sort them in alphabetical order.
 */
public class AnalyticsCounter {


    ReadSymptoms readSymptoms;
    WriteSymptoms writeSymptoms;

    /**
     * Constructor that instantiates the classes ReadSymptoms and WriteSymptoms.
     * @param fileRead File to read, containing the symptoms
     * @param fileWrite File or write the results
     */
    public AnalyticsCounter(String fileRead, String fileWrite) {
        this.readSymptoms= new ReadSymptoms(fileRead);
        this.writeSymptoms= new WriteSymptoms(fileWrite);
    }

    /**
     * Call the getSymptoms method from the ReadSymptoms class
     *
     * @return A list with all the symptoms, containing multiple occurrences and not sorted.
     */
    public List<String>getSymptoms(){
        return readSymptoms.readSymptoms();
    }

    /**
     *Call the writeSymptoms method from the WriteSymptoms class
     * @param symptoms
     */
    public void writeSymptoms(Map<String,Integer> symptoms){
        writeSymptoms.writeSymptoms(symptoms);
    }

    /**
     *  Method for counting the occurrence of symptoms
     *  Use computeIfAbsent to create a symptom with a value of 0
     *  @see </https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#computeIfAbsent-K-java.util.function.Function->
     *  Use computeIfPresent to increment the value by 1
     *  @see <https://docs.oracle.com/javase/8/docs/api/java/util/Map.html#computeIfPresent-K-java.util.function.BiFunction->
     *
     * @param readSymptoms A list with all the symptoms, containing multiple occurrences and not sorted.
     * @return a map with the symptoms sorted and counted. We need this to use the method writeSymptoms in the class WriteSymptomDataToFile
     */

    public Map<String, Integer> countSymptoms(List<String> readSymptoms) {
        Map<String,Integer> symptomsCount = new HashMap<>();
        for (String listSymptom : readSymptoms)
        {
            symptomsCount.computeIfAbsent(listSymptom, key->0);
            symptomsCount.computeIfPresent(listSymptom, (key,value)->value+1);
        }
        return symptomsCount;
    }


    /**
     * Method for sorting in alphabetical order
     * Use a foreach loop to put the key and value in a TreeMap to automatically sort the symptoms in alphabetical order.
     *
     * @param symptomsCount a Map with the symptom counted
     * @return a map sorted in alphabetical order key=symptom, value=occurrence
     */
    public Map<String, Integer> sortSymptoms(Map<String ,Integer> symptomsCount) {
        Map<String, Integer> symptomsSort = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : symptomsCount.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            symptomsSort.put(key, value);
        }
        return symptomsSort;
    }
}
