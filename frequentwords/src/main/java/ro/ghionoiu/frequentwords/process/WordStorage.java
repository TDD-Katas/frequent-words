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
public class WordStorage {
    private WordSortedSet sortedSet;

    public WordStorage() {
        this(new WordSortedSet());
    }
    
    protected WordStorage(WordSortedSet sortedSet) {
        this.sortedSet = sortedSet;
    }
    
    public void store(String word) {
        
    }
    
    public void displayFrequentWords(int numberOfWords, OutputChannel outputChannel) {
        
    }
}
