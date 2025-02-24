# STIP Parser

The code for serializing and deserializing [*Stipple Effect*](https://github.com/stipple-effect/stipple-effect) project files and palette files is maintained here, in its own repo, and included in *Stipple Effect* as a dependency. This way, other programs can easily import `stip-parser` and save image data as a *Stipple Effect* project without being dependent on the entire *Stipple Effect* codebase.

## Using *STIP Parser*

### Saving a *Stipple Effect* project to file

```java
import com.jordanbunke.stip_parser.ParserSerializer;
// ...

// 'state' is an IRState, 'filepath' is a Path
ParserSerializer.save(state, filepath);
```

### Loading a `.stip` file

```java
import com.jordanbunke.stip_parser.ParserSerializer;
import com.jordanbunke.stip_parser.rep.IRState;
// ...

// 'content' is a String representing the contents of a .stip file
IRState state = ParserSerializer.load(content);
```

### Intermediate representation classes

*STIP Parser* uses **intermediate representation classes** to represent *Stipple Effect* data types:

* `IRState` - Represents a [project state](https://stipple-effect.github.io/docs/project#state)
* `IRLayer` - Represents a [layer](https://stipple-effect.github.io/docs/layer)
* `IROnionSkin` - Represents an [onion skin](https://stipple-effect.github.io/docs/layer#onion-skin) configuration
* `IRPalette` - Represents a [palette](https://stipple-effect.github.io/docs/palette)

## Dependents

The following programs rely on *STIP Parser*, and must import the library in order to be built from source:

* [*Top Down Sprite Maker*](https://github.com/jbunke/tdsm)

You can download the library as a JAR by going to [Releases](https://github.com/stipple-effect/stip-parser/releases). Unless otherwise specified by the release notes or the README of the program you are attempting to build, the latest release is likely what you are looking for.
