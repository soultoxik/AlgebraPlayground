package com.company;

import com.company.instance.set.SimpleSetCategory;
import com.company.instance.set.SimpleList;
import com.company.meta.Morphism;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    SimpleSetCategory category = new SimpleSetCategory();
        category.morphisms().add("lesser20", new Morphism<SimpleList, SimpleList>() {
            @Override
            public SimpleList arrow(SimpleList dom) {
                return new SimpleList() {{
                    dom.stream().filter(integer -> integer < 20).forEach(this::add);
                }};
            }
        });


        category.morphisms().add("greater20",new Morphism<SimpleList, SimpleList>() {
            @Override
            public SimpleList arrow(SimpleList dom) {
                return new SimpleList() {{
                    dom.stream().filter(i -> i > 10).forEach(this::add);
                }};
            }
        });

        category.objects().add("test", new SimpleList() {{
            add(1);
            add(11);
            add(4);
            add(16);
            add(14);
            add(25);
            add(37);
        }});

        category
                .compose(
                        category.morphisms().extract("lesser20"),
                        category.morphisms().extract("greater20"))
                .arrow(
                        category.objects().extract("test")
                )
                .forEach(System.out::println);
    }
}
