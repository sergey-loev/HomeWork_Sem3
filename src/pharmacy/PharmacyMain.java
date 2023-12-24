package pharmacy;

import java.util.*;

public class PharmacyMain {
    public static void main(String[] args) {
        Component pineceline = new Component("Pineceline", "10 mg", 100);
        Component salt = new Component("Salt", "20 gr", 10);
        Component sugar = new Component("Sugar", "87 gr", 80);

        Pharmacy pharmacy1 = new Pharmacy();
        pharmacy1.addComponents(salt, pineceline, sugar);
        Pharmacy pharmacy2 = new Pharmacy();
        pharmacy2.addComponents(salt,  pineceline);
        Pharmacy pharmacy3 = new Pharmacy();
        pharmacy3.addComponents(salt, sugar);
        Pharmacy pharmacy4 = new Pharmacy();
        pharmacy4.addComponents(sugar, pineceline);
        Pharmacy pharmacy5 = new Pharmacy();
        pharmacy5.addComponents(pineceline, salt);

        List<Pharmacy> pharmacies= new ArrayList();
        pharmacies.add(pharmacy1);
        pharmacies.add(pharmacy2);
        pharmacies.add(pharmacy3);
        pharmacies.add(pharmacy4);
        pharmacies.add(pharmacy5);

        Set<Pharmacy> result = new HashSet<>(pharmacies);
        System.out.println(result.size());

        Collections.sort(pharmacies);

        System.out.println(pharmacies);


    }
}
