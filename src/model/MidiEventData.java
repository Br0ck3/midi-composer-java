package src.model;

/**
 * Represents MIDI event data read from a CSV file.
 */
public class MidiEventData {
    private int tick;
    private int note;
    private int velocity;
    private int channel;
    private boolean isNoteOn;

    /**
     * Creates a new MidiEventData object.
     *
     * @param tick The tick (timing) of the event
     * @param note The MIDI note number
     * @param velocity The velocity (volume) of the note
     * @param channel The MIDI channel
     * @param isNoteOn Whether this is a note-on event
     */
    public MidiEventData(int tick, int note, int velocity, int channel, boolean isNoteOn) {
        this.tick = tick;
        this.note = note;
        this.velocity = velocity;
        this.channel = channel;
        this.isNoteOn = isNoteOn;
    }

    // Getters
    public int getTick() { return tick; }
    public int getNote() { return note; }
    public int getVelocity() { return velocity; }
    public int getChannel() { return channel; }
    public boolean isNoteOn() { return isNoteOn; }

    // Setters
    public void setTick(int tick) { this.tick = tick; }
    public void setNote(int note) { this.note = note; }
    public void setVelocity(int velocity) { this.velocity = velocity; }
    public void setChannel(int channel) { this.channel = channel; }
} 