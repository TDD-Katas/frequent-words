/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords;

import org.junit.Test;
import ro.ghionoiu.frequentwords.context.output.StorageOutputChannel;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class FrequentWordsObtainerTest {
    
    @Test
    public void testPerformRequest() {
        int n = 0;
        String list = "";
        
        StorageOutputChannel outputChannel = new StorageOutputChannel();
        outputChannel.getStoredOutput();
        
        FrequentWordsObtainer instance = new FrequentWordsObtainer(outputChannel);
        instance.performRequest(n, list);
        
        
        assertThat(outputChannel.getStoredOutput(),is(""));
    }
}