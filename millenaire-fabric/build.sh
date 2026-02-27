#!/bin/bash
export JAVA_HOME=/opt/jdk/jdk-21.0.10
export PATH=$JAVA_HOME/bin:$PATH

echo "🔨 Начинаю компиляцию Millenaire мода..."
echo "☕ Используем Java: $(java -version 2>&1 | head -1)"
echo ""

cd /app/millenaire-fabric
./gradlew build --no-daemon
