# Maze Generation and Pathfinding Visualizions
## About this Project
This project leverages the A* algorithm with a heuristic optimized for maze pathfinding. It also re-creates Prim's algorithm for the purpose of maze generation. Java Swing is then employed to provide users with a visually appealing representation of the processes. For this purpose, the algorithms have also been given time delays.

## Getting Started
- To use the pathfinding algorithm, ensure the file containing the info for the maze is located in the ```/MazeSolving``` directory, a starting node (indicated using "1"), and a destination node (indicated using "2") exist. Then run ```Main.java```, where you will be asked to enter the name of the maze file (include the file extension). Lastly, if the fie is found, the maze pathfinding will begin. Note that if a path to the destination node does not exist, and the user will be notified and the algorithm will end.
- To use the generation algorithm, run ```Main.java``` in the ```/MazeGeneration``` directory. Once generated, the generated maze file will be outputted into ```GeneratedMaze.txt``` file in the ```/MazeGeneration``` directory.

## Demos
Pathfinding #1   
![ezgif-5-69a6f251](https://github.com/CatFreefall/Maze-Generation-and-Solving/assets/102479933/75be6ee1-a188-4b70-a2fe-10a93279568a)

Pathfinding #2   
![ezgif-5-ab17742ef7](https://github.com/CatFreefall/Maze-Generation-and-Solving/assets/102479933/d9a1473c-827e-4eaf-bdf9-c3ef70087582)

Pathfinding #3   
![ezgif-5-160ab334be](https://github.com/CatFreefall/Maze-Generation-and-Solving/assets/102479933/906a28e0-9035-4fa1-bd7d-db3389a33462)

Generation #1   
![prims-1](https://github.com/CatFreefall/Maze-Generation-and-Solving/assets/102479933/6efd86de-6038-4755-be37-171a06e28e62)

Generation #2   
![prims-2](https://github.com/CatFreefall/Maze-Generation-and-Solving/assets/102479933/44528056-284b-4b3a-b94d-0a534c32c6ab)



## Additional Documentation
- In maze files, numbers are used to denote each type of node: "0" for a wall node, "1" for the starting node, "2" for the destination/end node, "3" for a marked node (A node that has been put into the fringe, but has not yet been explored), "4" for an explored node, and "5" for an open node.
- To change the delay at which each node is explored for maze pathfinding, open ```AStarAlgorithm.java``` in ```/MazeSolving/AstarAlgorithm``` and change the instance variable ```timeDelay``` to your desired value. This is measured in milliseconds.
- To change tile colours, open ```TileColours.java``` in ```/MazeSolving/Tile``` and change the colours of each of the nodes to ones of your choice.
- Diagonal distance is used as A*'s heuristic in the pathfinding algorithm.
- To adjust the dimensions of the maze generated using Prim's, change the parameters of the ```PrimsAlgorithm``` class called in the main function.
