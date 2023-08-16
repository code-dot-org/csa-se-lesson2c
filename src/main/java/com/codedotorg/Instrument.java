package com.codedotorg;

public class Instrument {
    
    /** The name of a instrument */
    private String name;

    /**
     * Constructor for the Instrument class.
     *
     * @param name The name of the instrument.
     */
    public Instrument(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the instrument.
     * @return String The name of the instrument.
     */
    public String getName() {
        return name;
    }

}
