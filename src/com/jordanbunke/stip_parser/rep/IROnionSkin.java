package com.jordanbunke.stip_parser.rep;

public record IROnionSkin(
        SkinType skinTypeBack, SkinType skinTypeForward,
        double hueBack, double hueForward,
        double fadeFactorBack, double fadeFactorForward,
        int lookBack, int lookForward, boolean underBack, boolean underForward
) {
    private static final int DEF_LOOK = 1;
    private static final double RED = 0d;
    private static final double GREEN = 1 / 3d;
    private static final double DEF_FADE = 0.5;

    public enum SkinType {
        SIMPLE, OUTLINE, TINTED
    }

    public static class Builder {
        private SkinType skinTypeBack, skinTypeForward;
        private double hueBack, hueForward, fadeFactorBack, fadeFactorForward;
        private int lookBack, lookForward;
        private boolean underBack, underForward;

        public Builder() {
            skinTypeBack = SkinType.SIMPLE;
            skinTypeForward = SkinType.SIMPLE;

            hueBack = RED;
            hueForward = GREEN;

            fadeFactorBack = DEF_FADE;
            fadeFactorForward = DEF_FADE;

            lookBack = DEF_LOOK;
            lookForward = DEF_LOOK;

            underBack = true;
            underForward = false;
        }

        public IROnionSkin build() {
            return new IROnionSkin(
                    skinTypeBack, skinTypeForward, hueBack, hueForward,
                    fadeFactorBack, fadeFactorForward, lookBack, lookForward,
                    underBack, underForward);
        }

        public Builder setFadeFactorBack(final double fadeFactorBack) {
            this.fadeFactorBack = fadeFactorBack;
            return this;
        }

        public Builder setFadeFactorForward(final double fadeFactorForward) {
            this.fadeFactorForward = fadeFactorForward;
            return this;
        }

        public Builder setHueBack(final double hueBack) {
            this.hueBack = hueBack;
            return this;
        }

        public Builder setHueForward(final double hueForward) {
            this.hueForward = hueForward;
            return this;
        }

        public Builder setLookBack(final int lookBack) {
            this.lookBack = lookBack;
            return this;
        }

        public Builder setLookForward(final int lookForward) {
            this.lookForward = lookForward;
            return this;
        }

        public Builder setSkinTypeBack(final SkinType skinTypeBack) {
            this.skinTypeBack = skinTypeBack;
            return this;
        }

        public Builder setSkinTypeForward(final SkinType skinTypeForward) {
            this.skinTypeForward = skinTypeForward;
            return this;
        }

        public Builder setUnderBack(final boolean underBack) {
            this.underBack = underBack;
            return this;
        }

        public Builder setUnderForward(final boolean underForward) {
            this.underForward = underForward;
            return this;
        }
    }

    public static IROnionSkin trivial() {
        return new Builder().build();
    }

    @Override
    public boolean equals(final Object o) {
        return o instanceof IROnionSkin os &&
                skinTypeBack == os.skinTypeBack &&
                skinTypeForward == os.skinTypeForward &&
                hueBack == os.hueBack &&
                hueForward == os.hueForward &&
                fadeFactorBack == os.fadeFactorBack &&
                fadeFactorForward == os.fadeFactorForward &&
                underBack == os.underBack &&
                underForward == os.underForward &&
                lookBack == os.lookBack &&
                lookForward == os.lookForward;
    }

    @Override
    public int hashCode() {
        return lookBack * lookForward;
    }
}
