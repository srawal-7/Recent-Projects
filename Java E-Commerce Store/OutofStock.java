public class OutofStock extends Exception {
    //-----------------------------------------------------------------
    // Set up the exception object with a particular message.
    //-----------------------------------------------------------------
    OutofStock(String message)
    {
        super(message);
    }
}
