package befaster.solutions.CHK;

//Example ===> 5A for 200
public class SpecialOffer {
    private final Character item;
    private final int lowerBoundOffer;
    private final int upperBoundOffer;

    public SpecialOffer(Character item, int lowerBoundOffer, int upperBoundOffer) {
        this.item = item;
        this.lowerBoundOffer = lowerBoundOffer;
        this.upperBoundOffer = upperBoundOffer;
    }

    public Character getItem() {
        return this.item;
    }

    public int getLowerBoundOffer() {
        return this.lowerBoundOffer;
    }

    public int getUpperBoundOffer() {
        return this.upperBoundOffer;
    }

    public static final class Builder {
        private Character item;
        private int lowerBoundOffer;
        private int upperBoundOffer;

        private Builder() {

        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder item(Character item) {
            this.item = item;
            return this;
        }

        public Builder lowerBoundOffer(int lowerBoundOffer) {
            this.lowerBoundOffer = lowerBoundOffer;
            return this;
        }

        public Builder upperBoundOffer(int upperBoundOffer) {
            this.upperBoundOffer = upperBoundOffer;
            return this;
        }

        public SpecialOffer build() {
            return new SpecialOffer(item, lowerBoundOffer, upperBoundOffer);
        }
    }
}
