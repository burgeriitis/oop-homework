package com.santa.state;

import com.santa.components.Flat;

public class ReservedFlat extends FlatBuyingPhase {

    public ReservedFlat(Flat flat) {
        super(flat);
    }

    @Override
    public void nextBuyingPhase() {
        flat.setFlatBuyingPhase(new SoldFlat(flat));
    }

    @Override
    public void firstBuyingPhase() {
        flat.setFlatBuyingPhase(new FreeFlat(flat));
    }

    @Override
    public String phaseDescription() {
        return "Flat is reserved for buying.";
    }
}
