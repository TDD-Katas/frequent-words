/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords.process.pair;

import ro.ghionoiu.frequentwords.process.pair.FrequencyPair;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import ro.ghionoiu.frequentwords.context.output.OutputChannel;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class FrequencyPairTest {
    
    @Test
    public void equals_should_respect_contract() {
        EqualsVerifier.forClass(FrequencyPair.class)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }
    
    @Test
    public void first_pair_is_the_one_with_the_highest_frequency() {
        assertBetterThan(pair(4, "a"), pair(3, "a"));
    }
    
    @Test
    public void if_two_pairs_have_same_frequency_the_first_is_the_one_with_lower_alphabetic_order() {
        assertBetterThan(pair(3, "a"), pair(3, "b"));
    }
    
    @Test
    public void pair_is_written_to_output() {
        OutputChannel outputChannel = mock(OutputChannel.class);
        
        pair(3, "a").displayToOutput(outputChannel);
        
        verify(outputChannel).writeMessage("3 a");
    }

    //~~~~~~~~~~ Test helper
    
    private FrequencyPair pair(int frequency, String word) {
        return new FrequencyPair(frequency, word);
    }
    
    private void assertBetterThan(FrequencyPair instance, FrequencyPair otherPair) {
        assertThat(instance.compareTo(otherPair), is(-1));
    }
}