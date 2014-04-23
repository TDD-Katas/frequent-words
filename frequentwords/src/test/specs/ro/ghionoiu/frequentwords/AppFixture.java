package ro.ghionoiu.frequentwords;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import ro.ghionoiu.frequentwords.context.input.ArrayBasedInputChannel;
import ro.ghionoiu.frequentwords.context.output.StorageOutputChannel;

@RunWith(ConcordionRunner.class)
public class AppFixture {

    public String getFrequentWords(String firstLine, String secondLine) {
        ArrayBasedInputChannel inputChannel = new ArrayBasedInputChannel();
        inputChannel.setInputs(firstLine, secondLine);
        StorageOutputChannel outputChannel = new StorageOutputChannel();
        
        InputDispatcher dispatcher = new InputDispatcher(
                inputChannel, outputChannel);
        dispatcher.run();
        
        return outputChannel.getStoredOutput();
    }
}
