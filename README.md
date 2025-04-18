# Algorithmic-analysis-of-network-flow
Implemented max flow algorithm (Ford-Fulkerson with BFS) in Java for a network flow analysis coursework. Includes file parser, flow network data structure, and step-by-step output. (Student ID: 20230577)

# Network Flow Analysis – Max Flow Algorithm (Java)

This project implements the **Ford-Fulkerson algorithm** using **BFS (Edmonds-Karp)** to solve the **maximum flow problem** in a directed graph. It was developed as part of the **Algorithms coursework (5SENG003W)** at the **University of Westminster**.

---

## 🧠 Features

- Java-based flow network representation using adjacency lists
- Residual edge handling and flow augmentation
- Input file parser for graph configuration
- Step-by-step console output of flow updates
- Final report showing total maximum flow and per-edge flow

---

## 📂 Input File Format (`input.txt`)

- The first line is the number of nodes.
- Each following line represents an edge: `from to capacity`

---

## 🚀 Run Instructions

1. Place `input.txt` in the root directory of the project.
2. Compile and run:

```bash
javac NetworkFlowApp.java
java NetworkFlowApp
Flow increased by: 4, Total flow: 4
Flow increased by: 4, Total flow: 8
Maximum Flow: 8

Final Flow in Network:
Edge(0 -> 1 | flow: 4 / 6)
Edge(0 -> 2 | flow: 4 / 4)
...

📌 Coursework Details
Module: Algorithms – 5SENG003W

Student Name: Tharushi Nathasha Walisundara

Student ID: 20230577

Language: Java

📜 License
This project is intended for academic purposes only.
