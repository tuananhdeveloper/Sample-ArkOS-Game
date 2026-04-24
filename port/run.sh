#!/bin/bash
set -e

PORTDIR="$(cd "$(dirname "$0")" && pwd)"
LOGDIR="/roms2/ports_logs"
mkdir -p "$LOGDIR"
LOGFILE="$LOGDIR/$(basename "$PORTDIR")-$(date +%Y%m%d-%H%M%S).log"

exec > >(tee -a "$LOGFILE") 2>&1

echo "=== START $(date) ==="
echo "PORTDIR=$PORTDIR"
uname -a || true
id || true
pwd || true
ls -la || true

export GAME_DIR="$PORTDIR/SampleGame"
export GAME_MAIN_CLASS="com.tuananh.demo.Main"
export GAME_WIDTH=640
export GAME_HEIGHT=480

# JDK
export JAVA_HOME="./roms2/jdk"
echo "JAVA_HOME=$JAVA_HOME"
ls -la "$JAVA_HOME" || true
find "$JAVA_HOME" -name libjvm.so -maxdepth 5 || true

# SDL/env
export SDL_VIDEODRIVER=KMSDRM
export SDL_AUDIODRIVER=alsa
export SDL_VIDEODRIVER=kmsdrm
export SDL_OMAP_LAYER_IDX=0
export SDL_RENDER_DRIVER=opengles2

resume_es() {
  killall -CONT emulationstation 2>/dev/null || true
}

killall -STOP emulationstation 2>/dev/null || true
trap resume_es EXIT

chmod +x "$GAME_DIR/launcher" || true
echo "Running launcher..."
$GAME_DIR/launcher
echo "Launcher exited with $?"
