package algorithms.breadfirst;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Neighbor {

    private String label;
    private boolean isSeller;

    public Neighbor(String label) {
        this.label = label;
    }

    public Neighbor(String label, boolean isSeller) {
        this.label = label;
        this.isSeller = isSeller;
    }
}
