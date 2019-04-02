package kz.ya.algo.yandex;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yerlana
 */
public abstract class Digest {

//    private Map<byte[], byte[]> cache = new HashMap<>();
    private final Map<byte[], byte[]> cache = new HashMap<>();

    /*
    public byte[] digest(byte[] input) {
        byte[] result = cache.get(input);
        if (result == null) {
            synchronized (cache) {
            result = cache.get(input);
                if (result == null) {
                    result = doDigest(input);
                    cache.put(input, result);
                }
                return result;
            }
        }
        return result;
    }
    */
    public byte[] digest(byte[] input) {
        synchronized (cache) {
            byte[] result = cache.get(input);
            if (result == null) {
                result = doDigest(input);
                cache.put(input, result);
            }
            return result;
        }
    }

    public abstract byte[] doDigest(byte[] input);
}
