package ro.ghionoiu.frequentwords;

import ro.ghionoiu.frequentwords.process.FrequentWords;
import ro.ghionoiu.frequentwords.context.input.InputChannel;
import ro.ghionoiu.frequentwords.context.output.OutputChannel;

/**
 * Hello world!
 *
 */
public class InputDispatcher {
    public static final String TOKEN_SEPARATOR = "=";
    private InputChannel inputChannel;
    private FrequentWords frequentWordsObtainer;

    public InputDispatcher(
            InputChannel inputChannel,
            OutputChannel outputChannel) {
        this(inputChannel, new FrequentWords(outputChannel));
    }
    
    public InputDispatcher(InputChannel inputChannel, FrequentWords frequentWordsObtainer) {
        this.inputChannel = inputChannel;
        this.frequentWordsObtainer = frequentWordsObtainer;
    }
    
    public void run() {
        String numberLine = inputChannel.readLine();
        String listLine = inputChannel.readLine();
        
        if (numberLine != null && listLine != null) {
            int numberOfReqults = extractNumber(numberLine);
            String list = extractList(listLine);
            frequentWordsObtainer.performRequest(numberOfReqults, list);
        }
    }
    
    //~~~~~~~ Input processing ~~~~~~~~

    private int extractNumber(String numberLine) throws NumberFormatException {
        return Integer.parseInt(extractValueFromLine(numberLine));
    }

    private String extractList(String listLine) {
        return extractValueFromLine(listLine);
    }

    private String extractValueFromLine(String line) {
        return getSecondToken(line).trim();
    }

    protected String getSecondToken(String line) {
        return line.split(TOKEN_SEPARATOR)[1];
    }
}
