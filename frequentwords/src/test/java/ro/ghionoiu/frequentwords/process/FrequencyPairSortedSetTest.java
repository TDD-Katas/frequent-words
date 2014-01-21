/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords.process;

import ro.ghionoiu.frequentwords.process.pair.FrequencyPairSortedSet;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class FrequencyPairSortedSetTest {
    
    @Test
    public void uses_natural_ordering() {
        FrequencyPairSortedSet instance = new FrequencyPairSortedSet();
        
        assertThat(instance.comparator(), nullValue());
    }
}