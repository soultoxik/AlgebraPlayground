package com.company;

import com.company.instance.set.SetCategory;
import com.company.instance.set.SimpleList;
import com.company.meta.Morphism;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Category<List> category = new SetCategory();
        Morphism<SimpleList, SimpleList> lesser20 = new Morphism<SimpleList, SimpleList>() {
            @Override
            public SimpleList arrow(SimpleList dom) {
                return new SimpleList() {{
                    dom.stream().filter(i -> i < 20).forEach(this::add);
                }};
            }
        };

        Morphism<SimpleList, SimpleList> greater10 = new Morphism<SimpleList, SimpleList>() {
            @Override
            public SimpleList arrow(SimpleList dom) {
                return new SimpleList() {{
                    dom.stream().filter(i -> i > 10).forEach(this::add);
                }};
            }
        };

        SimpleList list = new SimpleList() {{
            add(1);
            add(11);
            add(4);
            add(16);
            add(14);
            add(25);
            add(37);
        }};


        category.compose(lesser20, greater10).arrow(list).forEach(System.out::println);

    }
}
