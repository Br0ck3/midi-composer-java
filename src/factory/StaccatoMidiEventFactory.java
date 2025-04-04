package src.factory;

import javax.sound.midi.*;

public class StaccatoMidiEventFactory implements MidiEventFactory {
    private static final int STACCATO_EXTENSION = 120;

    @Override
    public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
        return new MidiEvent(message, tick);
    }

    @Override
    public MidiEvent createNoteOff(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
        return new MidiEvent(message, Math.max(tick - STACCATO_EXTENSION, 0));
    }

}