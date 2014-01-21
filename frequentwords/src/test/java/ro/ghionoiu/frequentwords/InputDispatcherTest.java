/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords;

import ro.ghionoiu.frequentwords.process.FrequentWords;
import org.junit.Test;
import ro.ghionoiu.frequentwords.InputDispatcher;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import ro.ghionoiu.frequentwords.context.input.ArrayBasedInputChannel;
import ro.ghionoiu.frequentwords.context.input.InputChannel;
import ro.ghionoiu.frequentwords.process.FrequentWords;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class InputDispatcherTest {
    
    @Test
    public void reads_two_lines_from_input_channel() {
        InputChannel inputChannel = mock(InputChannel.class);
        
        runWith(inputChannel);
        
        verify(inputChannel, times(2)).readLine();
    }
    
    @Test
    public void forward_request_to_the_frequent_words_obtainer() {
        InputChannel inputChannel = setInputs(
                "N = 3",
                "list = x,y");
        FrequentWords frequentWordsObtainer = mock(FrequentWords.class);
        
        runWith(inputChannel, frequentWordsObtainer);
        
        verify(frequentWordsObtainer).performRequest(3,"x,y");
    }

    //~~~~~~~~ Test helpers
    
    protected ArrayBasedInputChannel setInputs(String ... inputs) {
        ArrayBasedInputChannel inputChannel = new ArrayBasedInputChannel();
        inputChannel.setInputs(inputs);
        return inputChannel;
    }
    
    protected void runWith(InputChannel inputChannel) {
        runWith(inputChannel, mock(FrequentWords.class));
    }

    protected void runWith(InputChannel inputChannel, 
            FrequentWords frequentWordsObtainer) {
        InputDispatcher dispatcher = new InputDispatcher(
                inputChannel, frequentWordsObtainer);
        dispatcher.run();
    }

}