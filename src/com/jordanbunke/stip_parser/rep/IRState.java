package com.jordanbunke.stip_parser.rep;

import java.util.stream.IntStream;

// TODO
public record IRState(
        int width, int height, int frameCount,
        double[] frameDurations, IRLayer[] layers
) {
    public static Builder of(
            final int width, final int height,
            final int frameCount, final IRLayer... layers
    ) {
        return new Builder(width, height, frameCount, layers);
    }

    public static class Builder {
        private final int width, height, frameCount;
        private final IRLayer[] layers;

        private double[] frameDurations;

        Builder(final int width, final int height,
                final int frameCount, final IRLayer[] layers) {
            this.width = width;
            this.height = height;
            this.frameCount = frameCount;
            this.layers = layers;

            frameDurations = IntStream.range(0, frameCount)
                    .mapToDouble(i -> 1.0).toArray();
        }

        public Builder setFrameDurations(final double... frameDurations) {
            this.frameDurations = frameDurations;
            return this;
        }

        public IRState build() {
            return new IRState(width, height,
                    frameCount, frameDurations, layers);
        }
    }
}
