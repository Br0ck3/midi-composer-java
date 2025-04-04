package src.factory;

public class LegatoMidiEventFactoryAbstract implements LegatoMidiEventFactoryAbstract{
    @Override
    public MidiEventFactory createfactory() {
        return new LegatoMidiEventFactory()
    }
    
}
