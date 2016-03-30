package com.company.meta;

/**
 * Created by maxim on 30.03.2016.
 */
public interface Morphism<D, C> {
    C arrow(D dom);
}
