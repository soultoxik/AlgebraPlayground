package com.company.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by maxim on 30.03.2016.
 */
public class HashSet<T> extends HashMap<String, T> implements Set<T>{

    @Override
    public <P extends T> void add(String label, P value) {
        put(label, value);
    }

    @Override
    public T extract(String label) {
        return get(label);
    }

}
