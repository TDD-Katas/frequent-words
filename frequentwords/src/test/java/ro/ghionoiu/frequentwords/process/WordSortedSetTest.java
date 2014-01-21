/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords.process;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class WordSortedSetTest {
    
    @Test
    public void uses_natural_ordering() {
        WordSortedSet instance = new WordSortedSet();
        
        assertThat(instance.comparator(), nullValue());
    }
}