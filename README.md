Sebastian Olsson's Robotspel2
==========

Game where custom-programmed robots compete.

I created the whole thing from scratch in 2010. The title has the suffix "2" because the game was inspired by
another robot game made by an older student named Niclas Andersson. This game was meant to be used to make each
member in my class program his own robot, and then hold a competition where we decide whose robot is the smartest.
Unfortunately, the plans were scrapped by the time the game engine was completed.

## Install
```
javac -cp .;.. *.java  # For Windows
javac -cp .:.. *.java  # For *NIX
```

## Run
```
java -cp .;.. robotspel2.Robotspel2  # For Windows
java -cp .:.. robotspel2.Robotspel2  # For *NIX
```

## Gameplay
Your robot is placed on a randomly generated battlefield together with some other robots. Your robot then needs
to utilize five tools in order to survive in the battlefield and exterminate the other robots:
* **Wheels**: Cause the robot to move one step in a direction of your choosing. Fastest reloading time.
* **Cannon**: Shoots a round shot in the direction of your choosing. If it hits another robot, that robot dies.
Slowest reloading time.
* **Radar**: Transmits four radar particles in the direction of your choosing. If a particle hits a wall, the robot will
be informed about the lifetime of the particle. From that information, the location of the wall can be deduced.
This way, the robot may learn about its environment. Slow reloading time.
* **Sensor**: Transmits a sensor particle in the direction of your choosing. A sensor particle travels a small distance
and then dies. If the particle died above a pit, the robot will be notified about it. Medium reloading time.
* **Tricker**: Transmits eight large tricker particles in the direction of your choosing. If a tricker particle comes in
contact with a radar particle, the latter changes direction. If it comes in contact with a sensor particle, it will
inject it with false information. This way, the robots need to skeptical about their collected data, as there is always
the possibility that their data have been tampered with.
Fast reloading time.

You can program your own AI by extending the class **Spelare**. For an example, see **SampleRobot.java**.
