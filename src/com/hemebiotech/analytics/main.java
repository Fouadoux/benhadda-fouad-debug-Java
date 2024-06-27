package com.hemebiotech.analytics;

import com.hemebiotech.analytics.ReadSymptoms.ReadSymptoms;
import com.hemebiotech.analytics.AnalyticsCounter.AnalyticsCounter;
import com.hemebiotech.analytics.WriteSymptoms.WriteSymptoms;

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
