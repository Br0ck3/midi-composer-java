package src.factory;

public class StandardMidiEventFactory implements MidiEventFactoryAbstract {
    @Override
    public MidiEventFactory createFactory() {
        return new StandardMidiEventFactory();
    }
}
