package src.strategy.pitch;

/**
 * Strategy that decreases the pitch by 2 semitones.
 */
public class LowerPitchStrategy implements PitchStrategy {
    @Override
    public int modifyPitch(int note) {
        return note - 2;
    }
} 