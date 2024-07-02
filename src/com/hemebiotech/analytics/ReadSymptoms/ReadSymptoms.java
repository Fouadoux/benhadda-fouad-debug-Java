package com.hemebiotech.analytics.ReadSymptoms;

import com.hemebiotech.analytics.Exception.EmptyFileException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Define methode to read the file with the symptoms
 *
 */
public class ReadSymptoms implements IReadSymptoms {

	private final String filepath;

	/**
	 * Class constructor
	 * @param filepath Path of the file containing the symptoms
	 */
	public ReadSymptoms(String filepath) {
		this.filepath = filepath;
	}

	/**
	 *Using a BufferedReader to read the symptoms file and a loop to write each symptom to a List
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	public List<String> readSymptoms() {
		List<String> symptomList = new ArrayList<>();

		if (filepath != null && !filepath.isEmpty()) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				int count =0;
				while (line != null) {
					symptomList.add(line);
					line = reader.readLine();
					count ++;
				}
				reader.close();

				// Exception
				// The count is used in the while loop. If the document is empty, it stays at 0 and throws the exception
				if(count==0){
					throw new EmptyFileException("File Empty");
				}
			} catch (FileNotFoundException e){
				System.out.println(e.getMessage());

			} catch (IOException e) {
				e.printStackTrace();

			}catch (EmptyFileException e){
				System.out.println(e.getMessage());
			}
        }
		else {
			System.out.println("Read File : Filepath is empty");
		}
		return symptomList;
	}
}
