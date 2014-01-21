/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords.process.pair;

import ro.ghionoiu.frequentwords.context.output.OutputChannel;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public final class FrequencyPair implements Comparable<FrequencyPair>{
    private final int frequency;
    private final String word;

    public FrequencyPair(int frequency, String word) {
        this.frequency = frequency;
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getWord() {
        return word;
    }
    
    //~~~~~~~~ Natural ordering
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.frequency;
        hash = 47 * hash + (this.word != null ? this.word.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FrequencyPair other = (FrequencyPair) obj;
        if (this.frequency != other.frequency) {
            return false;
        }
        if ((this.word == null) ? (other.word != null) : !this.word.equals(other.word)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(FrequencyPair o) {
        int result = o.frequency - this.frequency;
        if (result == 0) {
            result = this.word.compareTo(o.word);
        }
        
        return result;
    }
    
    //~~~~~ Output to stream
    
    public void displayToOutput(OutputChannel outputChannel) {
        outputChannel.writeMessage(frequency+" "+word);
    }
}
