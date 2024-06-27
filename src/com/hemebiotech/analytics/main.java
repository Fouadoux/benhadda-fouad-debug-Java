package com.hemebiotech.analytics;

import com.hemebiotech.analytics.ReadSymptomDataFromFile.ReadSymptoms;
import com.hemebiotech.analytics.SymptomCounter.AnalyticsCounter;
import com.hemebiotech.analytics.WriteSymptomDataToFile.WriteSymptoms;

import java.util.List;
import java.util.Map;

public class main {

    public static void main(String args[]) throws Exception{
        

        ReadSymptoms readerSymptoms = new ReadSymptoms("symptoms.txt");
        List<String> readSymptom = readerSymptoms.readSymptoms();


        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        Map<String,Integer> countSymptoms= analyticsCounter.countSymptoms(readSymptom);
        Map<String,Integer> sortSymptoms= analyticsCounter.sortSymptoms(countSymptoms);

        WriteSymptoms writeSymptoms = new WriteSymptoms("result.out");
        writeSymptoms.writeSymptoms(sortSymptoms);

    }
}
