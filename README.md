# Tic-Tac-Toe Game (Java)

This is a **Java-based Tic-Tac-Toe game** that supports both **human and AI players**. The AI will play using a **Minimax algorithm** for optimal strategy.

---

## 📌 Features
- **Single-player and Two-player modes**
- **AI Opponent** using Minimax (optimal strategy)
- **Command-line interface** with easy-to-read game board
- **ANSI color-coded output** for better visualization

---

## 🛠️ Setup & Installation

### 1️⃣ **Compile the Java Files**
Run the following command to compile all `.java` files:

```sh
javac -d out *.java
```
This will store the compiled `.class` files inside the `out/` directory.

### 2️⃣ **Create the Manifest File**
Ensure the `MANIFEST.MF` file exists with the following content:
```
Main-Class: Main
```
_(Make sure there is an empty line at the end of the file)_

### 3️⃣ **Package into a JAR File**
Run this command to create the JAR file:

```sh
jar cfm game.jar MANIFEST.MF -C out .
```

### 4️⃣ **Run the Game**
To start the game, use:

```sh
java -jar game.jar
```

---

## 🎮 How to Play
- The game will ask for **player names**.
- Choose between **Human (0) or AI (1)**. You must have at least 1 **Human** player.
- The game will display the **Tic-Tac-Toe board** with A, B, and C as the rows and 1, 2, and 3 as the columns.
- **Enter your move** using the format: `A1, B2, C3`, etc.
- The game continues until there is a **winner or a tie**.

---

## 🧠 AI Strategy
- The AI uses **Minimax Algorithm** for optimal play.

---

## 📂 Project Structure
```
├── src/
│   ├── Main.java        # Entry point of the game
│   ├── Game.java        # Game logic and flow
│   ├── AI.java          # AI player logic (Minimax & Heuristic)
│   ├── Human.java       # Human player logic
│   ├── Grid.java        # Game board representation
│   ├── Square.java      # Abstract square class
│   ├── CellX.java       # Represents 'X' moves
│   ├── CellO.java       # Represents 'O' moves
│   ├── Empty.java       # Represents an empty square
│   ├── Coordinate.java  # Predefined coordinate mappings
│   ├── Type.java        # Color-coded X and O representation
│   ├── Player.java      # Base class for Human and AI
│   ├── MANIFEST.MF      # Manifest file for JAR execution
├── out/                 # Compiled .class files
├── game.jar             # Packaged JAR file
```

---

## ❓ Troubleshooting
- If `java -jar game.jar` doesn’t work:
  - Check `MANIFEST.MF` formatting (empty line at end required).
  - Verify that `Main.class` is inside the JAR (`jar tf game.jar`).
- If AI is making bad moves, ensure `AI.useMinimax` is set correctly.

---

## 🏆 Credits
Developed by: Elias-Charbel Salameh on March 9, 2025.
for **Object-Oriented Design (GIN314)** course.

---

Enjoy the game! 🎮✨

