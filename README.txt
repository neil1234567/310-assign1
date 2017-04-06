Programming language: java

The aim of the program:
       
                 function1 : findshortpath:
                            1. Showing the shortest path between two points in one 18*18 grid;
                            2. Showing the length of the shortest path;
                            3. Showing the number of nodes placed on the fringe in the shortest path;

                 function2 : findshortpath_landmarks:
                            1. Showing the shortest path from the start point to its nearest landmark;
                            2. Showing the shortest path from the end point to its nearest landmark;
                            3. Showing the length of the shortest path between start point and end point across their nearest landmarks;
                            4. Showing the total number of nodes placed on the fringe in the shortest path;

How to use the program:
                  To find the shortest path from (x1,y1) to (x2,y2) without landmarks: findShortPath(matrix, x1,y1,x2,y2);

                  To find the shortest path from (x1,y1) to (x2,y2) with landmarks:findShortPath_landmarks(matrix,x1,y1,x2,y2);

                  notice: 1.x1,y1,x2,y2 should be int and in the range [0,17];
                          2.the path shown is from end point to start point sequently;
