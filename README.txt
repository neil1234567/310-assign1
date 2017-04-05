
this program is written in java

the aim of the program:

                 function : findshortpath:
                               1. Find the shortest path of two points in one 18*18 grid;
                               2. Calculate the length of the shortest path;
                               3. Calculate the total number of nodes placed on the fringe in the shortest path;

                 function : findshortpath_landmarks:
                               1. Find the shortest from the start point to the nearest landmark;
                               2. Find the shortest from the end point to the nearest landmark;
                               3. Calculate the length of the shortest path with landmarks;
                               4. Calculate the total number of nodes placed on the fringe in the shortest path with landmarks;

How to use the program:
                  assume we want to find the shortest path from (x1,y1) to (x2,y2) without landmarks:
                               we type code: findShortPath(matrix, x1,y1,x2,y2);

                  assume we want to find the shortest path from (x1,y1) to (x2,y2) with landmarks:
                               we type code: findShortPath_landmarks(matrix,x1,y1,x2,y2);

                  notice: x1,y1,x2,y2 should be int and in the range [0,17];
                          the output of the path is from end point to start point from top to bottom of the screen;
