/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords.process;

import ro.ghionoiu.frequentwords.context.output.OutputChannel;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class FrequentWords {
    OutputChannel outputChannel;
    
    WordStorage wordStorage;

    public FrequentWords(OutputChannel outputChannel) {
        this(outputChannel, new WordStorage());
    }
    
    protected FrequentWords(OutputChannel outputChannel, WordStorage wordStorage) {
        this.outputChannel = outputChannel;
        this.wordStorage = wordStorage;
    }
    
    public void performRequest(int n, String list) {
        String[] words = list.split(",");
        for (String word : words) {
            wordStorage.store(word.trim());
        }
        wordStorage.displayFrequentWords(n, outputChannel);
    }
}
