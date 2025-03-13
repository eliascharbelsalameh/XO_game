# Tic-Tac-Toe Game (Java)
**Java Version & Dependencies:**  
- **Java Version:** JDK 8 or higher (JDK 11 or later is recommended)  
- **Dependencies:** No external libraries required; the project uses only standard Java libraries.

This is a **Java-based Tic-Tac-Toe game** that supports both **human and AI players**.

---

The AI plays using a **Minimax algorithm** for optimal strategy, ensuring challenging gameplay. Alternative strategies were considered, but the Minimax approach delivers the best performance.

---

## 📌 Features
- **Single-player and Two-player modes**
- **AI Opponent** using Minimax (optimal strategy)
- **Command-line interface** with an easy-to-read game board
- **ANSI color-coded output** for enhanced visualization

---

## 🛠️ Setup & Installation

### Command-line Setup
1. **Clone the Repository**  
   ```sh
   git clone https://github.com/eliascharbelsalameh/XO_game.git
   cd XO_game
   ```

2. **Compile the Java Files**  
   Run the following command in the project root:
   ```sh
   javac -d out *.java
   ```
   This will compile all `.java` files and place the resulting `.class` files in the `out/` directory.

3. **Create the Manifest File**  
   Ensure a file named `MANIFEST.MF` exists in the project root with the following content:
   ```
   Main-Class: Main
   ```
   *(Be sure to include an empty line at the end of the file.)*

4. **Package into a JAR File**  
   Create the executable JAR file:
   ```sh
   jar cfm game.jar MANIFEST.MF -C out .
   ```

5. **Run the Game**  
   Execute the JAR file with:
   ```sh
   java -jar game.jar
   ```

### IDE Setup

#### Eclipse
1. **Import the Project:**
   - Open Eclipse.
   - Navigate to **File > Import… > General > Existing Projects into Workspace**.
   - Select the repository's root directory; Eclipse will detect the project automatically.
2. **Configure Build Path:**
   - Right-click the project in the **Package Explorer**, select **Properties > Java Build Path**.
   - Ensure that your project is set to use JDK 8 (or higher).
3. **Run the Application:**
   - Open `Main.java` from the `src` folder.
   - Right-click on `Main.java` and select **Run As > Java Application**.

#### Visual Studio Code
1. **Install Java Extension Pack:**
   - Make sure the Java Extension Pack is installed from the VSCode Marketplace.
2. **Open the Project:**
   - Open VSCode and select **File > Open Folder…** to open the repository's root directory.
3. **Build and Run:**
   - VSCode should automatically detect the Java project.
   - Open `Main.java`, then click the **Run** button above the `main` method or use the command palette.

#### IntelliJ IDEA
1. **Open the Project:**
   - Launch IntelliJ IDEA and select **Open**.
   - Navigate to the repository's root directory and open it.
2. **Configure the SDK:**
   - IntelliJ will prompt you to set up the Project SDK; ensure it’s set to JDK 8 or higher.
3. **Run the Application:**
   - Locate `Main.java` in the project structure.
   - Right-click `Main.java` and choose **Run 'Main'**.

---

## 🎮 How to Play
- **Player Setup:** The game prompts for player names.
- **Mode Selection:** Choose between Human (0) or AI (1) players. (At least one player must be human.)
- **Gameplay:** The game displays a Tic-Tac-Toe board with rows labeled A, B, C and columns 1, 2, 3.
- **Move Input:** Enter moves using the format: `A1, B2, C3`, etc.
- **Game End:** Play continues until there is a winner or the game ends in a tie.

---

## 🧠 AI Strategy
- The AI uses the **Minimax Algorithm** to determine its moves, ensuring optimal play.

---

## 📂 Project Structure
```
├── src/
│   ├── Main.java         # Entry point of the game
│   ├── Game.java         # Game logic and flow
│   ├── AI.java           # AI player logic (Minimax algorithm)
│   ├── Human.java        # Human player logic
│   ├── Grid.java         # Game board representation
│   ├── Square.java       # Abstract square class
│   ├── CellX.java        # Represents 'X' moves
│   ├── CellO.java        # Represents 'O' moves
│   ├── Empty.java        # Represents an empty square
│   ├── Coordinate.java   # Predefined coordinate mappings
│   ├── Type.java         # Color-coded X and O representation
│   ├── Player.java       # Base class for Human and AI
│   ├── MANIFEST.MF       # Manifest file for JAR execution
├── out/                  # Compiled .class files
├── game.jar              # Packaged executable JAR file
├── README.md             # Project documentation
├── UML_diagram.pdf       # UML diagram and project adjustments
```

---

## ❓ Troubleshooting & Additional Info
- **JAR Execution Issues:**
  - Verify the formatting of `MANIFEST.MF` (ensure an empty line at the end).
  - Check that `Main.class` exists inside the JAR by running:
    ```sh
    jar tf game.jar
    ```
- **Input Handling Issues (Human Player):**
  - If you encounter issues like repetitive "No input provided!" messages, consider using a shared `Scanner` instance for `System.in` (e.g., by using the one declared in the `Game` class) rather than creating a new one in `Human.play()`.
- **IDE Issues:**
  - Ensure your IDE is configured to use the correct Java version.
  - If the project isn’t recognized automatically as a Java project, try creating a new Java project and importing the source files manually.

---

## 📑 Adjustments & UML Diagram
- Detailed updates and justifications for modifications are documented in the **UML_diagram.pdf**.
- View the updated UML diagram and project adjustments [here](https://github.com/eliascharbelsalameh/XO_game/blob/master/UML_diagram.pdf).

---

## 🏆 Credits
Developed by: Elias-Charbel Salameh on March 9, 2025  
for the **Object-Oriented Design (GIN314)** course.

---

Enjoy the game! 🎮✨

