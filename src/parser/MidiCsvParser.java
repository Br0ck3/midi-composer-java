package src.parser;

import src.model.MidiEventData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser for reading MIDI event data from CSV files.
 */
public class MidiCsvParser {
    
    /**
     * Reads MIDI event data from a CSV file.
     *
     * @param filePath Path to the CSV file
     * @return List of MidiEventData objects
     * @throws IOException if there's an error reading the file
     */
    public List<MidiEventData> parseFile(String filePath) throws IOException {
        List<MidiEventData> events = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip header if present
            reader.readLine();
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    try {
                        int tick = Integer.parseInt(parts[0].trim());
                        int note = Integer.parseInt(parts[1].trim());
                        int velocity = Integer.parseInt(parts[2].trim());
                        int channel = Integer.parseInt(parts[3].trim());
                        boolean isNoteOn = parts.length > 4 && parts[4].trim().equalsIgnoreCase("on");
                        
                        events.add(new MidiEventData(tick, note, velocity, channel, isNoteOn));
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing line: " + line);
                        continue;
                    }
                }
            }
        }
        
        return events;
    }
} 