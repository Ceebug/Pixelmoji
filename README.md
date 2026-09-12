<h2 align="center">
  <img src="./logo-wide.png" width="60%">
  <br>
  <strong>Proper emoji support for Minecraft</strong>
</h2>

Pixelmoji adds colourful, pixel-art emoji to Minecraft using a custom font and the [Glomphosche](https://modrinth.com/mod/glomphosche) library.

## Features

- Colourful pixel-art emoji
- Small, crisp textures designed for Minecraft's font renderer
- Support for emoji sequences and composed characters
- Lightweight and client-side

## Limitations

- Emojis may count as multiple characters toward Minecraft's character limits.
- Emojis cannot be coloured. Do not apply colour formatting to emojis, as they may render incorrectly or look unusual.

## Requirements

- **Minecraft 1.21.10**
- [**Fabric Loader**](https://fabricmc.net)
- [**Fabric API**](https://modrinth.com/mod/fabric-api/versions?g=1.21.10)
- **Java 21**
- [**Glomphosche 0.2.1**](https://modrinth.com/mod/glomphosche/version/0.2.1+mc1.21.10)

## Installation

1. Install [Fabric](https://fabricmc.net/) for Minecraft 1.21.10.
2. Install [Fabric API](https://modrinth.com/mod/fabric-api/versions?g=1.21.10).
3. Install [Glomphosche](https://modrinth.com/mod/glomphosche/version/0.2.1+mc1.21.10).
4. Place the Pixelmoji `.jar` in your `mods` folder.
5. Launch Minecraft.

> [!NOTE]
> **Pixelmoji is *Client-side***<br>
> This means that Pixelmoji does not need to exist on the server to run, and you can join any server with the mod enabled.

## Development

Pixelmoji is built using Fabric Loom and Gradle.

### Getting started
Clone the repository:
```powershell
git clone https://github.com/ceebug/pixelmoji.git pixelmoji
```

Then open the repository in your preferred Java development environment.

Happy coding!

### Launching the development client
To launch the development client, use the command:
```powershell
.\gradlew.bat runClient
```

## Supported emojis
Pixelmoji does not yet have textures for all emojis that exist.

If you would like to view the supported emojis, you can see them in the file:<br>
[`supported-emojis.md`](./supported-emojis.md)


## Licence:
Pixelmoji is open source. See [`LICENCE`](./LICENCE) for license information.
