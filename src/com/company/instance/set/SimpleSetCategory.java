package com.company.instance.set;

import com.company.Category;
import com.company.meta.HashSet;
import com.company.meta.Morphism;
import com.company.meta.Set;

import java.util.HashMap;
import java.util.List;

/**
 * Created by maxim on 30.03.2016.
 */
public class SimpleSetCategory implements Category<SimpleList> {
    private Set objects = new HashSet<>();
    private Set morphisms = new HashSet<>();

    @Override
    @SuppressWarnings("unchecked")
    public Set<SimpleList> objects() {
        return objects;
    }

    @Override
    @SuppressWarnings("unchecked")
    public
    <X extends SimpleList, Y extends SimpleList>
    Set<Morphism<X, Y>> morphisms() {
        return morphisms;
    }

    @Override
    public
    <X extends SimpleList, Y extends SimpleList, Z extends SimpleList>
    Morphism<X, Z> compose(Morphism<X, Y> f, Morphism<Y, Z> g) {
        return dom -> g.arrow(f.arrow(dom));
    }

    @Override
    public <X extends SimpleList> Morphism<X, X> id(SimpleList object) {
        return dom -> dom;
    }
}
