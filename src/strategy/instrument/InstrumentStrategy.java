package src.strategy.instrument;

/**
 * Interface for instrument selection strategies.
 */
public interface InstrumentStrategy {
    /**
     * Gets the MIDI program number for the instrument.
     *
     * @return The MIDI program number
     */
    int getInstrumentProgram();
} 