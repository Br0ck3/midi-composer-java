package src.strategy.pitch;

/**
 * Interface for pitch modification strategies.
 */
public interface PitchStrategy {
    /**
     * Modifies the pitch of a MIDI note.
     *
     * @param note The original MIDI note number
     * @return The modified MIDI note number
     */
    int modifyPitch(int note);
} 