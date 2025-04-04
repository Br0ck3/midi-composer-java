# My Little Mozart

A Java application that demonstrates the use of design patterns to create and modify MIDI music.

## Overview

This project implements a MIDI composition system using the Abstract Factory and Strategy design patterns. It reads MIDI event data from a CSV file, applies different strategies to modify the pitch and instrument, and plays the resulting sequence.

## Design Patterns Used

1. **Abstract Factory Pattern**: Creates MIDI events with different articulation styles
   - StandardMidiEventFactory: Creates standard MIDI events
   - LegatoMidiEventFactory: Creates legato MIDI events (extends note duration by 80 ticks)
   - StaccatoMidiEventFactory: Creates staccato MIDI events (reduces note duration by 120 ticks)

2. **Strategy Pattern for Pitch**: Modifies the pitch of MIDI notes
   - HigherPitchStrategy: Increases pitch by 2 semitones
   - LowerPitchStrategy: Decreases pitch by 2 semitones

3. **Strategy Pattern for Instrument**: Selects different MIDI instruments
   - AcousticGrandPianoStrategy: Uses the Acoustic Grand Piano (Program 0)
   - ElectricBassGuitarStrategy: Uses the Electric Bass Guitar (Program 33)
   - TrumpetStrategy: Uses the Trumpet (Program 56)

## Project Structure

- `src/model`: Contains the MidiEventData class
- `src/parser`: Contains the MidiCsvParser class
- `src/factory`: Contains the MIDI event factories
- `src/strategy/pitch`: Contains the pitch strategies
- `src/strategy/instrument`: Contains the instrument strategies
- `src`: Contains the Main class

## How to Run

1. Place a CSV file named "mystery_song.csv" in the project root directory
2. Run the Main class
3. The program will play three variations of the song using different combinations of factories and strategies

## CSV Format

The CSV file should have the following format:
```
tick,note,velocity,channel,type
```

Where:
- `tick`: The timing of the event
- `note`: The MIDI note number
- `velocity`: The velocity (volume) of the note
- `channel`: The MIDI channel
- `type`: "on" for note-on events, "off" for note-off events

## Mystery Song

Based on the MIDI note patterns, the mystery song appears to be "Twinkle Twinkle Little Star" with a simple melody that follows the pattern: C C G G A A G.
