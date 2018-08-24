package com.santa.state;

import com.santa.components.Flat;

public class SoldFlat extends FlatBuyingPhase {
    public SoldFlat(Flat flat) {
        super(flat);
    }

    @Override
    public void nextBuyingPhase() {
        flat.setFlatBuyingPhase(this);
    }

    @Override
    public void firstBuyingPhase() {
        flat.setFlatBuyingPhase(new FreeFlat(flat));
    }

    @Override
    public String phaseDescription() {
        return "Flat is sold!";
    }
}
