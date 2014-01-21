/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords;

import org.junit.Test;
import ro.ghionoiu.frequentwords.context.input.ArrayBasedInputChannel;
import ro.ghionoiu.frequentwords.context.input.InputChannel;
import ro.ghionoiu.frequentwords.context.output.OutputChannel;
import ro.ghionoiu.frequentwords.context.output.StorageOutputChannel;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class InputDispatcherIT {
    
    @Test
    public void forward_request_to_the_frequent_words_obtainer() {
        InputChannel inputChannel = setInputs(
                "N = 3",
                "list = x,y");
        StorageOutputChannel outputChannel = new StorageOutputChannel();
        
        runWith(inputChannel, outputChannel);
        
        String expected = "1 x\n"
                + "1 y\n";
        assertThat(outputChannel.getStoredOutput(), is(expected));
    }

    //~~~~~~~~ Test helpers
    
    protected ArrayBasedInputChannel setInputs(String ... inputs) {
        ArrayBasedInputChannel inputChannel = new ArrayBasedInputChannel();
        inputChannel.setInputs(inputs);
        return inputChannel;
    }
    

    protected void runWith(InputChannel inputChannel, 
            OutputChannel outputChannel) {
        InputDispatcher dispatcher = new InputDispatcher(
                inputChannel, outputChannel);
        dispatcher.run();
    }

}