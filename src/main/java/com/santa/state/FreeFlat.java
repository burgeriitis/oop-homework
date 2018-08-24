package com.santa.state;

import com.santa.components.Flat;

public class FreeFlat extends FlatBuyingPhase {

    public FreeFlat(Flat flat) {
        super(flat);
    }

    @Override
    public void nextBuyingPhase() {
        flat.setFlatBuyingPhase(new ReservedFlat(flat));
    }

    @Override
    public void firstBuyingPhase() {
        flat.setFlatBuyingPhase(this);
    }

    @Override
    public String phaseDescription() {
        return "Flat is free for reserving.";
    }
}
