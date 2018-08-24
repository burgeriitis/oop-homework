package com.santa.state;

import com.santa.components.Flat;

public abstract class FlatBuyingPhase {

    final Flat flat;

    FlatBuyingPhase(Flat flat) {
        this.flat = flat;
    }

    public abstract void nextBuyingPhase();

    public abstract void firstBuyingPhase();

    public abstract String phaseDescription();
}
