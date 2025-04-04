package src.strategy.instrument;

/**
 * Strategy for Electric Bass Guitar (MIDI Program 33).
 */
public class ElectricBassGuitarStrategy implements InstrumentStrategy {
    @Override
    public int getInstrumentProgram() {
        return 33; // Electric Bass (finger)
    }
} 