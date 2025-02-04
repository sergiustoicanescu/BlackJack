# 🎲 BlackJack Java Game

## Overview
This is a simple and fun desktop blackjack-style betting game built with **Java Swing**. It’s easy to use—just start with a budget, place your bets, and play rounds where you can win, lose, or draw. The goal is to provide a smooth and enjoyable experience with a clean interface.

### Why This Project?
Besides being a great way to practice **software architecture** and **design patterns**, I wanted to create a game that is easy to play and interactive. It was fun building a project where users can quickly jump in, place bets, and enjoy a smooth gameplay experience.

---

## 🎮 Features
✅ **Simple & Intuitive UI** – Easy to navigate interface for quick betting rounds.  
✅ **State Management** – Uses the **State Pattern** to manage different phases of the game.  
✅ **Command Pattern** – Ensures smooth execution of user interactions through encapsulated commands.  
✅ **Separation of Concerns** – Clean Model-View-Controller (**MVC**) architecture for maintainability.

---

## 📽️ Demo
![Game Demo](screenshots/BlackJackDemo.gif)

---

## 🛠️ Tech Stack
- **Language**: Java
- **Framework**: Swing (GUI)

---

## 🚀 Installation & Setup

### 1️⃣ Clone the Repository
```sh
 git clone https://github.com/sergiustoicanescu/BlackJack.git
 cd BlackJack
```

### 2️⃣ Build the Project
Ensure you have **JDK 19** installed and include `vecmath-1.5.2.jar` in the classpath.
```sh
  javac -d out -sourcepath src -cp lib/vecmath-1.5.2.jar src/Main.java
```

### 3️⃣ Run the Application
```sh
 java -cp out:lib/vecmath-1.5.2.jar Main
```

---

---

## 🐞 Known Issues & Future Improvements
### 🔴 Known Issues
- Sometimes UI elements may flicker.
- Game logic should have better unit test coverage.

### 🔜 To-Do
- [ ] Add sound effects and more animations.
- [ ] Add multiplayer functionality.

---

## 🤝 Contributing
1. Fork the repository.
2. Create a new branch (`feature/new-feature`).
3. Commit changes and push.
4. Open a PR!

---

### ✨ Enjoy the Game & Happy Betting! 🎰
