package src;

import src.factory.*;
import src.model.MidiEventData;
import src.parser.MidiCsvParser;
import src.strategy.instrument.*;
import src.strategy.pitch.*;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Main class for the My Little Mozart application.
 * Demonstrates the use of Abstract Factory and Strategy patterns
 * to create and modify MIDI events.
 * 
 * This program reads MIDI event data from a CSV file and applies
 * different combinations of factories and strategies to create
 * variations of the original song.
 * 
 * Based on the MIDI note patterns, this appears to be "Twinkle Twinkle Little Star"
 * with a simple melody that follows the pattern: C C G G A A G
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Create parser and read MIDI events
            MidiCsvParser parser = new MidiCsvParser();
            List<MidiEventData> events = parser.parseFile("mystery_song.csv");

            // Play the original song with standard factory and piano
            System.out.println("Playing original song with Standard factory and Piano...");
            playSequence(events, new StandardMidiEventFactory(), 
                         new AcousticGrandPianoStrategy(), 
                         new HigherPitchStrategy());
            
            // Wait a moment before playing the next variation
            Thread.sleep(2000);
            
            // Play with Legato factory and Trumpet
            System.out.println("Playing with Legato factory and Trumpet...");
            playSequence(events, new LegatoMidiEventFactory(), 
                         new TrumpetStrategy(), 
                         new LowerPitchStrategy());
            
            // Wait a moment before playing the next variation
            Thread.sleep(2000);
            
            // Play with Staccato factory and Bass Guitar
            System.out.println("Playing with Staccato factory and Bass Guitar...");
            playSequence(events, new StaccatoMidiEventFactory(), 
                         new ElectricBassGuitarStrategy(), 
                         new HigherPitchStrategy());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Plays a MIDI sequence using the specified factory and strategies.
     * 
     * @param events The MIDI events to play
     * @param factory The factory to use for creating MIDI events
     * @param instrumentStrategy The instrument strategy to use
     * @param pitchStrategy The pitch strategy to use
     * @throws Exception if there's an error playing the sequence
     */
    private static void playSequence(List<MidiEventData> events, 
                                    MidiEventFactory factory,
                                    InstrumentStrategy instrumentStrategy,
                                    PitchStrategy pitchStrategy) throws Exception {
        // Create MIDI sequence
        Sequence sequence = new Sequence(Sequence.PPQ, 480);
        Track track = sequence.createTrack();

        // Set instrument
        ShortMessage programChange = new ShortMessage();
        programChange.setMessage(ShortMessage.PROGRAM_CHANGE, 0, instrumentStrategy.getInstrumentProgram(), 0);
        track.add(new MidiEvent(programChange, 0));

        // Process each MIDI event
        for (MidiEventData event : events) {
            int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
            
            if (event.isNoteOn()) {
                MidiEvent noteOn = factory.createNoteOn(
                    event.getTick(),
                    modifiedNote,
                    event.getVelocity(),
                    event.getChannel()
                );
                track.add(noteOn);
            } else {
                MidiEvent noteOff = factory.createNoteOff(
                    event.getTick(),
                    modifiedNote,
                    event.getChannel()
                );
                track.add(noteOff);
            }
        }

        // Play the sequence
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();
        sequencer.setSequence(sequence);
        sequencer.start();

        // Wait for the sequence to finish
        while (sequencer.isRunning()) {
            Thread.sleep(100);
        }

        // Clean up
        sequencer.close();
    }
} 