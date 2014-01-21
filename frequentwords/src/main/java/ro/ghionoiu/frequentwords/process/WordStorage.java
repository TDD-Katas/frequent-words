/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords.process;

import ro.ghionoiu.frequentwords.process.pair.FrequencyPairSortedSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import ro.ghionoiu.frequentwords.context.output.OutputChannel;
import ro.ghionoiu.frequentwords.process.pair.FrequencyPair;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class WordStorage {
    private FrequencyPairSortedSet frequencyPairSet;
    private Map<String, FrequencyPair> existingWords;

    public WordStorage() {
        this(new FrequencyPairSortedSet());
    }
    
    protected WordStorage(FrequencyPairSortedSet sortedSet) {
        this.frequencyPairSet = sortedSet;
        this.existingWords = new HashMap<String, FrequencyPair>();
        for (FrequencyPair frequencyPair : sortedSet) {
            this.existingWords.put(frequencyPair.getWord(), frequencyPair);
        }
    }
    
    public void store(String word) {
        FrequencyPair currentPair;
        if (existingWords.containsKey(word)) {
            FrequencyPair existingPair = existingWords.get(word);
            frequencyPairSet.remove(existingPair);
            currentPair = new FrequencyPair(existingPair.getFrequency() + 1, word);
        } else {
            currentPair = new FrequencyPair(1, word);
        }
        
        //Add the new pair
        frequencyPairSet.add(currentPair);
        existingWords.put(word, currentPair);
    }
    
    public void displayFrequentWords(int numberOfWords, OutputChannel outputChannel) {
        int counter = 0;
        Iterator<FrequencyPair> it = frequencyPairSet.iterator();
        while (it.hasNext()) {
            if (counter < numberOfWords) {
                FrequencyPair frequencyPair = it.next();
                frequencyPair.displayToOutput(outputChannel);
                counter++;
            } else {
                break;
            }
        }
    }
}
