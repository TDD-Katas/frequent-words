/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.ghionoiu.frequentwords;

import ro.ghionoiu.frequentwords.context.input.InputChannel;
import ro.ghionoiu.frequentwords.context.input.SystemConsoleInput;
import ro.ghionoiu.frequentwords.context.output.OutputChannel;
import ro.ghionoiu.frequentwords.context.output.SystemConsoleOutput;

/**
 *
 * @author Iulian Ghionoiu <iulian.ghionoiu@exenne.ro>
 */
public class Main {
    public static void main(String[] args) {
        InputChannel inputChannel = new SystemConsoleInput();
        OutputChannel outputChannel = new SystemConsoleOutput();
        InputDispatcher inputDispatcher = new InputDispatcher(inputChannel, outputChannel);
        inputDispatcher.run();
    }
}
