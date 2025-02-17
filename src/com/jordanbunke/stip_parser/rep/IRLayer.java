package com.jordanbunke.stip_parser.rep;

import com.jordanbunke.delta_time.image.GameImage;

public record IRLayer(
        String name, GameImage[] cels, GameImage linkedContent,
        double opacity, boolean enabled, boolean celsLinked,
        boolean onionSkinOn, IROnionSkin onionSkin
) {
    private static final String DEF_NAME = "Layer";

    public GameImage getCel(final int index) {
        return cels[index];
    }

    public static Builder of(final int w, final int h) {
        return new Builder(w, h);
    }

    public static Builder of(final GameImage linkedContent) {
        return new Builder(linkedContent);
    }

    public static class Builder {
        private String name;
        private GameImage[] cels;
        private GameImage linkedContent;
        private double opacity;
        private boolean enabled, celsLinked, onionSkinOn;
        private IROnionSkin onionSkin;

        Builder(final GameImage linkedContent) {
            this.linkedContent = linkedContent;
            cels = new GameImage[] { linkedContent };

            name = DEF_NAME;
            opacity = 1.0;
            enabled = true;
            celsLinked = true;
            onionSkinOn = false;
            onionSkin = IROnionSkin.trivial();
        }

        Builder(final int w, final int h) {
            this(new GameImage(w, h));
        }

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setCels(final GameImage... cels) {
            this.cels = cels;
            celsLinked = false;

            if (cels.length > 0)
                linkedContent = cels[0];

            return this;
        }

        public Builder setCelsLinked(final boolean celsLinked) {
            this.celsLinked = celsLinked;
            return this;
        }

        public Builder setEnabled(final boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Builder setLinkedContent(
                final GameImage linkedContent
        ) {
            this.linkedContent = linkedContent;
            celsLinked = true;
            return this;
        }

        public Builder setOnionSkin(final IROnionSkin onionSkin) {
            this.onionSkin = onionSkin;
            return this;
        }

        public Builder setOnionSkinOn(final boolean onionSkinOn) {
            this.onionSkinOn = onionSkinOn;
            return this;
        }

        public Builder setOpacity(final double opacity) {
            this.opacity = opacity;
            return this;
        }

        public IRLayer build() {
            return new IRLayer(name, cels, linkedContent, opacity,
                    enabled, celsLinked, onionSkinOn, onionSkin);
        }
    }
}
