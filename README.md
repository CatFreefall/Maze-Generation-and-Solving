# Maze Generation and Pathfinding Visualizions
## About this Project
This project leverages the A* algorithm with a heuristic optimized for maze pathfinding. It also re-creates Prim's algorithm for the purpose of maze generation. Java Swing is then employed to provide users with a visually appealing representation of the processes. For this purpose, the algorithms have also been given time delays.

## Getting Started
- To use the pathfinding algorithm, ensure the file containing the info for the maze is located in the ```MazeSolving``` directory, a starting node (indicated using "1"), and a destination node (indicated using "2") exist. Then run ```Main.java```, where you will be asked to enter the name of the maze file (include the file extension). Lastly, if the fie is found, the maze pathfinding will begin. Note that if a path to the destination node does not exist, and the user will be notified and the algorithm will end.
- To use the generation algorithm, run ```Main.java``` in the ```MazeGeneration``` directory and input the name of the file you want your generated maze to have. Once generated, the file will be ouputted into the ```MazeGeneration``` directory.

## Demos

## Additional Documentation
- In maze files, numbers are used to denote each type of node: "0" for a wall node, "1" for the starting node, "2" for the destination/end node, "3" for a marked node (A node that has been put into the fringe, but has not yet been explored), "4" for an explored node, and "5" for an open node.
- To change the delay at which each node is explored for maze pathfinding, open ```AStarAlgorithm.java``` in ```MazeSolving/AstarAlgorithm``` and change the instance variable ```timeDelay``` to your desired value. This is measured in milliseconds.
- To change tile colours, open ```TileColours.java``` in ```MazeSolving/Tile``` and change the colours of each of the nodes to ones of your choice.
- Diagonal distance is used as A*'s heuristic in the pathfinding algorithm.
