package evictionStrategy;

public class EvictionPolicyFactory {
    public static EvictionPolicy getEvictionPolicy(EvictionPolicyType evictionPolicyType) {
        switch (evictionPolicyType) {
            case FIFO:
                return new FifoEvictionPolicy();
        }
        return null;
    }
}
