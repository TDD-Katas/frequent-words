/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords.process;

import org.junit.Test;
import ro.ghionoiu.frequentwords.context.output.OutputChannel;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class FrequentWordsTest {
    
    @Test
    public void should_send_single_words_from_list_to_the_storage() {
        OutputChannel outputChannel = mock(OutputChannel.class);
        WordStorage wordStorage = mock(WordStorage.class);
        FrequentWords instance = new FrequentWords(outputChannel, wordStorage);
        
        instance.performRequest(1, "a, b, c");
        
        for (String word : new String[] {"a","b","c"}) {
            verify(wordStorage).store(word);
        }
    }
    
    @Test
    public void forwards_display_command_to_word_storage() {
        OutputChannel outputChannel = mock(OutputChannel.class);
        WordStorage wordStorage = mock(WordStorage.class);
        FrequentWords instance = new FrequentWords(outputChannel, wordStorage);
        
        instance.performRequest(1, "a, b, c");
        
        verify(wordStorage).displayFrequentWords(1, outputChannel);
    }
}