package com.senac.commons;

import java.util.ArrayList;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

/**
 *
 * @author lossurdo
 */
public class CommonsCollections {
    
    @Test
    public void testCollectionUtils() {
        ArrayList<String> seriadoA = new ArrayList<>();
        seriadoA.add("Helix");
        seriadoA.add("Game of Thrones");
        seriadoA.add("Homeland");

        ArrayList<String> seriadoB = new ArrayList<>();
        seriadoB.add("Homeland");
        seriadoB.add("How to Get Away with Murder");
        seriadoB.add("Game of Thrones");
        
        // diferença
        System.out.println(CollectionUtils.disjunction(seriadoA, seriadoB));
        
        // comum
        System.out.println(CollectionUtils.intersection(seriadoA, seriadoB));
        
        // união
        System.out.println(CollectionUtils.union(seriadoA, seriadoB));        
    }
    
}
