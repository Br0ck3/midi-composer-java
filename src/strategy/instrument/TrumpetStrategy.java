package src.strategy.instrument;

/**
 * Strategy for Trumpet (MIDI Program 56).
 */
public class TrumpetStrategy implements InstrumentStrategy {
    @Override
    public int getInstrumentProgram() {
        return 56; // Trumpet
    }
} 