@echo off

javac -d out/production/gra_project -sourcepath src/main/java src/main/java/game/Main.java
java -cp out/production/gra_project game.Main