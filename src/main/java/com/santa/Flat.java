package com.santa;

import java.math.BigDecimal;
import java.math.MathContext;

public abstract class Flat {

    int roomCount;
    long area;
    BigDecimal pricePerSquareMeter;

    BigDecimal price() {
        return pricePerSquareMeter.multiply(new BigDecimal(this.area), new MathContext(2));
    }
}
