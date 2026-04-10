import java.util.Objects;

public class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static <K, V> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public <A> Pair<A, V> withKey(A key) {
        return new Pair<>(key, value);
    }

    public <B> Pair<K, B> withValue(B value) {
        return new Pair<>(key, value);
    }

    public Pair<V, K> swap() {
        return new Pair<>(value, key);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pair<?, ?>)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(key, p.key) && Objects.equals(value, p.value);
    }

    public int hashCode() {
        return Objects.hash(key, value);
    }

    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}