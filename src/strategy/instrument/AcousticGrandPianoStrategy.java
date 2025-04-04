package src.strategy.instrument;

/**
 * Strategy for Acoustic Grand Piano (MIDI Program 0).
 */
public class AcousticGrandPianoStrategy implements InstrumentStrategy {
    @Override
    public int getInstrumentProgram() {
        return 0; // Acoustic Grand Piano
    }
} 