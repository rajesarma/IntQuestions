package ds.lru;

public class LfuCache {
    int value, frequency;

    public LfuCache(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }
}
