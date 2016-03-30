package com.company.instance.set;

import com.company.Category;
import com.company.meta.Any;
import com.company.meta.ListSet;
import com.company.meta.Morphism;
import com.company.meta.Set;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxim on 30.03.2016.
 */
public class SetCategory implements Category<List> {
    @Override
    @SuppressWarnings("unchecked")
    public Set<List> objects() {
        return new ListSet();
    }

    @Override
    @SuppressWarnings("unchecked")
    public
    <X extends List, Y extends List>
    Set<Morphism<X, Y>> morphisms() {
        return new ListSet();
    }

    @Override
    public
    <X extends List, Y extends List, Z extends List>
    Morphism<X, Z> compose(Morphism<X, Y> f, Morphism<Y, Z> g) {
        return dom -> g.arrow(f.arrow(dom));
    }

    @Override
    public <X extends List> Morphism<X, X> id(List object) {
        return dom -> dom;
    }
}
