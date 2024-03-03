package befaster.solutions.CHK;

//Example ===> 2E get one B free
public class SpecialDeal {
    private Character freeItem;
    private String freeItemAlias;
    private String eligibilityQuota;
    private int lowerBoundOffer;
    private int upperBoundOffer;

    public SpecialDeal(Character freeItem, String freeItemAlias, String eligibilityQuota,
                       int lowerBoundOffer, int upperBoundOffer) {
        this.freeItem = freeItem;
        this.freeItemAlias = freeItemAlias;
        this.eligibilityQuota = eligibilityQuota;
        this.lowerBoundOffer = lowerBoundOffer;
        this.upperBoundOffer = upperBoundOffer;
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

    public static final class Builder {
        private Character freeItem;
        private String freeItemAlias;
        private String eligibilityQuota;
        private int lowerBoundOffer;
        private int upperBoundOffer;

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

        public Builder upperBoundOffer(int upperBoundOffer) {
            this.upperBoundOffer = upperBoundOffer;
            return this;
        }

        public SpecialDeal build() {
            return new SpecialDeal(freeItem, freeItemAlias, eligibilityQuota, lowerBoundOffer, upperBoundOffer);
        }
    }
}
