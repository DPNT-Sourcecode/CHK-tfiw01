package befaster.solutions.CHK;

//Example ===> 2E get one B free
public class SpecialDeal {
    private Character freeItem;
    private String freeItemAlias;
    private String eligibilityQuota;
    private int lowerBoundOffer;
    private int cummulativeLowerBoundOffer;
    private int upperBoundOffer;
    private int cummulativeUpperBoundOffer;
    private int cummulativeValue;

    public SpecialDeal(Character freeItem, String freeItemAlias, String eligibilityQuota,
                       int lowerBoundOffer, int cummulativeLowerBoundOffer, int upperBoundOffer,
                       int cummulativeUpperBoundOffer, int cummulativeValue) {
        this.freeItem = freeItem;
        this.freeItemAlias = freeItemAlias;
        this.eligibilityQuota = eligibilityQuota;
        this.lowerBoundOffer = lowerBoundOffer;
        this.cummulativeLowerBoundOffer = cummulativeLowerBoundOffer;
        this.upperBoundOffer = upperBoundOffer;
        this.cummulativeUpperBoundOffer = cummulativeUpperBoundOffer;
        this.cummulativeValue = cummulativeValue;
    }

    public Character getFreeItem() {
        return freeItem;
    }

    public String getFreeItemAlias() {
        return freeItemAlias;
    }

    public String getEligibilityQuota() {
        return eligibilityQuota;
    }

    public int getLowerBoundOffer() {
        return lowerBoundOffer;
    }

    public int getUpperBoundOffer() {
        return upperBoundOffer;
    }

    public int getCummulativeLowerBoundOffer() {
        return cummulativeLowerBoundOffer;
    }

    public int getCummulativeUpperBoundOffer() {
        return cummulativeUpperBoundOffer;
    }

    public int getCummulativeValue() {
        return cummulativeValue;
    }

    public void incrementCummulativeValue() {
        this.cummulativeValue++;
    }

    public static final class Builder {
        private Character freeItem;
        private String freeItemAlias;
        private String eligibilityQuota;
        private int lowerBoundOffer;
        private int cummulativeLowerBoundOffer;
        private int upperBoundOffer;
        private int cummulativeUpperBoundOffer;
        private int cummulativeValue;

        private Builder() {

        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder freeItem(Character freeItem) {
            this.freeItem = freeItem;
            return this;
        }

        public Builder freeItemAlias(String freeItemAlias) {
            this.freeItemAlias = freeItemAlias;
            return this;
        }

        public Builder eligibilityQuota(String eligibilityQuota) {
            this.eligibilityQuota = eligibilityQuota;
            return this;
        }

        public Builder lowerBoundOffer(int lowerBoundOffer) {
            this.lowerBoundOffer = lowerBoundOffer;
            return this;
        }

        public Builder cummulativeLowerBoundOffer(int cummulativeLowerBoundOffer) {
            this.cummulativeLowerBoundOffer = cummulativeLowerBoundOffer;
            return this;
        }

        public Builder upperBoundOffer(int upperBoundOffer) {
            this.upperBoundOffer = upperBoundOffer;
            return this;
        }

        public Builder cummulativeUpperBoundOffer(int cummulativeUpperBoundOffer) {
            this.cummulativeUpperBoundOffer = cummulativeUpperBoundOffer;
            return this;
        }

        public Builder cummulativeValue(int cummulativeValue) {
            this.cummulativeValue = cummulativeValue;
            return this;
        }

        public SpecialDeal build() {
            return new SpecialDeal(freeItem, freeItemAlias, eligibilityQuota, lowerBoundOffer,
                cummulativeLowerBoundOffer, upperBoundOffer, cummulativeUpperBoundOffer, cummulativeValue);
        }
    }
}


