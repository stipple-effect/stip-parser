package com.jordanbunke.stip_parser;

import com.jordanbunke.delta_time.io.FileIO;
import com.jordanbunke.delta_time.io.ResourceLoader;

import java.nio.file.Path;

public final class Standards {
    private static final String
            NATIVE_CODE = "native_standard",
            PALETTE_CODE = "palette_standard";
    private static final Path PROGRAM_FILE = Path.of("program");

    public static String NATIVE = "1.0", PALETTE = "1.0";

    static {
        readProgramFile();
    }

    private static void readProgramFile() {
        final String content = FileIO.readResource(
                ResourceLoader.loadResource(PROGRAM_FILE), "Program file");

        final SerialBlock[] blocks = ParserSerializer
                .deserializeBlocksAtDepthLevel(content);

        for (SerialBlock block : blocks) {
            switch (block.tag()) {
                case NATIVE_CODE -> NATIVE = block.value();
                case PALETTE_CODE -> PALETTE = block.value();
            }
        }
    }
}
