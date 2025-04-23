public class SimpleForkJoinTask extends RecursiveTask<Integer> {
    private final int[] array;
    private final int start;
    private final int end;
    private static final int THRESHOLD = 10;

    public SimpleForkJoinTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        // TODO: If range is small, compute sum directly
        // Otherwise, split and fork/join subtasks
        return 0;
    }
}
