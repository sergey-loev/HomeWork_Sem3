package pharmacy;

import java.util.*;

public class Pharmacy implements Iterable<Component>,Comparable<Pharmacy> {
    private int index;
    private List<Component> components;

    public Pharmacy() {
        this.index = 0;
        this.components = new ArrayList<>();
    }

    public void addComponents(Component... components) {
        if (components.length == 0) System.out.println("Вы ничего не добавили!");
        else Collections.addAll(this.components, components);
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public Iterator<Component> iterator() {
        return new Iterator<Component>() {
            @Override
            public boolean hasNext() {
                return index < components.size();
            }

            @Override
            public Component next() {
                return components.get(index++);
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        Collections.sort(pharmacy.components);
        Collections.sort(components);
        return index == pharmacy.index && Objects.equals(components, pharmacy.components);
    }

    @Override
    public int hashCode() {
        Collections.sort(components);
        return Objects.hash(index, components);
    }

    @Override
    public int compareTo(Pharmacy o) {
        int thisPower = 0;
        int oPower = 0;
        for(Component thisComponents: this.components) thisPower += thisComponents.getPower();
        for(Component oComponents: o.components) oPower += oComponents.getPower();
        if (thisPower > oPower) return 1;
        if (thisPower < oPower) return -1;
        return 0;
    }

    @Override
    public String toString() {
        int thisPower = 0;
        for(Component thisComponents: this.components) thisPower += thisComponents.getPower();
        return "Pharmacy{" +
                "Power=" + thisPower +
                ", components=" + components +
                '}';
    }
}

