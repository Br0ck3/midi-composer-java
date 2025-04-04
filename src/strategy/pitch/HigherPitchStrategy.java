package src.strategy.pitch;

/**
 * Strategy that increases the pitch by 2 semitones.
 */
public class HigherPitchStrategy implements PitchStrategy {
    @Override
    public int modifyPitch(int note) {
        return note + 2;
    }
} 