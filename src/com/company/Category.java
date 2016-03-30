package com.company;

import com.company.characteristic.Associative;
import com.company.characteristic.Neutral;
import com.company.meta.Any;
import com.company.meta.Morphism;
import com.company.meta.Set;


/**
 * Created by maxim on 30.03.2016.
 */
public interface Category<T> {
    Set<T> objects();
    <X extends T, Y extends T>
    Set<Morphism<X,Y>> morphisms();

    @Associative
    <X extends T,Y extends T,Z extends T>
    Morphism<X,Z> compose(Morphism<X,Y> f, Morphism<Y, Z> g);

    @Neutral
    <X extends T>
    Morphism<X, X> id(T object);
}
