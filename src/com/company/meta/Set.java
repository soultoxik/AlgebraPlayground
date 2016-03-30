package com.company.meta;

/**
 * Created by maxim on 30.03.2016.
 */
public interface Set<T> {
    <P extends T> void add(String label, P value);
    T extract(String label);
}
