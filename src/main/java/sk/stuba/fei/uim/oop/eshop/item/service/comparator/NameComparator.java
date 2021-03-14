package sk.stuba.fei.uim.oop.eshop.item.service.comparator;

import sk.stuba.fei.uim.oop.eshop.item.domain.WithName;

import java.util.Comparator;

public class NameComparator implements Comparator<WithName> {

    private static NameComparator instance;

    private NameComparator() {
    }

    public static NameComparator getInstance() {
        if (instance == null) {
            instance = new NameComparator();
        }
        return instance;
    }

    @Override
    public int compare(WithName first, WithName second) {
        return first.getName().compareTo(second.getName());
    }
}
