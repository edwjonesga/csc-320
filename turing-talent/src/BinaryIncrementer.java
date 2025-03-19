public class BinaryIncrementer {
    private TuringMachine tm;

    public BinaryIncrementer(String input) {
        tm = new TuringMachine(input, "q0", "q_accept", "q_reject");
    }

    public String compute() {
        tm.run();
        return tm.getTapeOutput();
    }
}
