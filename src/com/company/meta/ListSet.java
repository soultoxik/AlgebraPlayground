package com.company.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxim on 30.03.2016.
 */
public class ListSet<T> extends ArrayList<T> implements Set{

    @Override
    public T iterate() {
        return iterator().hasNext()? iterator().next() : null;
    }
}
