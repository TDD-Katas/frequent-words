/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import ro.ghionoiu.frequentwords.context.input.ArrayBasedInputChannel;
import ro.ghionoiu.frequentwords.context.input.InputChannel;
import ro.ghionoiu.frequentwords.context.output.OutputChannel;

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
        FrequentWordsObtainer frequentWordsObtainer = mock(FrequentWordsObtainer.class);
        
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
        runWith(inputChannel, mock(FrequentWordsObtainer.class));
    }

    protected void runWith(InputChannel inputChannel, 
            FrequentWordsObtainer frequentWordsObtainer) {
        InputDispatcher dispatcher = new InputDispatcher(
                inputChannel, mock(OutputChannel.class), 
                frequentWordsObtainer);
        dispatcher.run();
    }

}