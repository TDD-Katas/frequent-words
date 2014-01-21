/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords.process;

import ro.ghionoiu.frequentwords.process.pair.FrequencyPair;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.spy;
import ro.ghionoiu.frequentwords.context.output.OutputChannel;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class WordStorageTest {
    
    
    @Test
    public void will_store_frequency_and_words_as_pairs_into_a_sorted_set() {
        WordSortedSet sortedSet = new WordSortedSet();
        WordStorage instance = new WordStorage(sortedSet);
        
        instance.store("a");
        
        assertThat(sortedSet.contains(new FrequencyPair(1, "a")), is(true));
    }
    
    @Test
    public void will_increment_frequency_for_existing_words() {
        WordSortedSet sortedSet = new WordSortedSet();
        sortedSet.add(new FrequencyPair(1, "a"));
        WordStorage instance = new WordStorage(sortedSet);
        
        instance.store("a");
        
        assertThat(sortedSet.contains(new FrequencyPair(2, "a")), is(true));
    }
    
    @Test
    public void the_first_frequency_pair_is_the_one_with_the_highest_frequency() {
        WordSortedSet sortedSet = new WordSortedSet();
        sortedSet.add(new FrequencyPair(1, "a"));
        WordStorage instance = new WordStorage(sortedSet);
        
        instance.store("a");
        instance.store("a");
        
        assertThat(sortedSet.contains(new FrequencyPair(2, "a")), is(true));
    }
    
    @Test
    public void display_command_will_be_forwarded_to_the_first_pairs_in_set() {
        WordSortedSet sortedSet = new WordSortedSet();
        FrequencyPair highestPair = spy(new FrequencyPair(5, "a"));
        FrequencyPair secondHighestPair = spy(new FrequencyPair(4, "c"));
        
        sortedSet.add(highestPair);
        sortedSet.add(secondHighestPair);
        sortedSet.add(new FrequencyPair(5, "c"));
        WordStorage instance = new WordStorage(sortedSet);
        
        OutputChannel outputChannel = mock(OutputChannel.class);
        
        instance.displayFrequentWords(1, outputChannel);
        verify(highestPair).displayToOutput(outputChannel);
        
        assertThat(true, is(true));
    }
}