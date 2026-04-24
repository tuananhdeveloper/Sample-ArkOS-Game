# SampleArkOSGame

A sample libGDX game project targeting [ArkOS](https://github.com/AeolusUX/ArkOS-R3XS) using a custom Java SDL2 backend (`gdx-backend-sdl2-arkos`).  
This setup produces a single fat JAR (`game.jar`) and all resources/launchers needed to run on ArkOS.

---

## 🛠️ Features

- **Fat JAR export:** All dependencies, including custom backend, in one game.jar.
- ArkOS-friendly native launcher and SDL2 `.so` packaging.
- Easy scriptable build/export (`assemblePort.gradle`).

---

## 📦 Project Structure

```
SampleArkOSGame/
├── assets/                # Game assets (textures, sounds, etc)
├── core/                  # Main game code (libGDX ApplicationListener)
├── native/                # C/C++ SDL2 native backend & launcher source
│   └── build/             # Compiled launcher and SDL2 libs (.so)
├── port/                  # Optional: extra scripts/docs for port
├── build.gradle
├── settings.gradle
├── assemblePort.gradle    # Export script (see below)
└── README.md
```

---

## 🚀 Building the ArkOS Release

### 1. **Prerequisites**

- Download jdk.zip from this project, extract it and place it into /roms2 folder (or /roms folder)
- Change GAME_DIR, GAME_MAIN_CLASS, GAME_WIDTH, GAME_HEIGHT and JAVA_HOME inside port/run.sh (if needed).

### 2. **Export the ArkOS package**

From the project root (where `assemblePort.gradle` is):

```sh
./gradlew assemblePort
```

You'll get an export in:

```
build/port/
├── game.jar                  # All game code + backend + deps
├── libgdx_sdl2_arkos.so      # Native SDL2 backend for ArkOS
├── launcher                  # Native launcher binary
├── assets/                   # Your game assets
├── run.sh                    # (Optional) Reference launch script
```
---

## 📦 Using your existing libGdx project with the custom backend

Step 1. Copy `native/`, `port/` and `assemblePort.gradle` from this project to your root folder.

Step 2. In your root `build.gradle`, add:
```sh
apply from: "assemblePort.gradle"
```
Step 3. From the project root, run this:
```gradle
./gradlew assemblePort
```
---

## 🕹️ Running on ArkOS

- Copy `game.jar`, `run.sh`, `launcher`, `natives/`, and `assets/` to your ArkOS SD card’s Ports area, in their own directory.
- If you couldn't run the game, you can place the `run.sh` into the Ports folder root.

<img style="width:50%; height:auto;" alt="IMG_3858" src="https://github.com/user-attachments/assets/5ab71a30-5915-42c0-be1a-9baae21a4aca" />

---

## 🔓 Removing the Signature (Commercial/Attribution-Free Use)

By default, this backend displays a developer signature:

> Made by tuananhdeveloper

**If you wish to use the backend/launcher without this signature, please support the project by purchasing a signature-free version.**

### How to Purchase Signature Removal

1. Visit my Ko-fi page: https://ko-fi.com/s/7ab6cfa55e
2. Buy now.

Thank you for respecting my work.
---

[![ko-fi](https://ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/tuananhdeveloper)
