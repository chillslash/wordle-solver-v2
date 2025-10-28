# Wordle Solver v2

A small interactive Wordle helper written in Java. It recommends the next guess based on how you score your guesses.

## Features
- Interactive CLI that recommends the next best guess
-- Selects candidate answers using Wordle-style feedback
- Uses a plain word list in `wordle/words.txt`

## Requirements
- Java 8 or newer

## Build
From the repository root, compile the Java source files:

```powershell
javac wordle\*.java
```

## Run
Run the program from the project root (classes are in the `wordle` package):

```powershell
java wordle.bot
```

## Interactive usage
When running the program it will repeatedly:

- Print a recommended word and the number of remaining candidate answers.
- Prompt: `Enter your word (l/e):`
  - Type a 5-letter guess you used (for example `slate`).
  - Type `l` to list all remaining candidate words.
  - Type `e` to exit the program.

- If you enter a 5-letter guess you'll be prompted: `Enter your result:`. Enter a 5-character result string using:
  - `g` = green (correct letter in correct position)
  - `y` = yellow (correct letter, wrong position)
  - `n` = gray / absent

Example result string: `gynnn` (first letter green, second yellow, rest gray)

## Example session
1. Program prints: `Recommended Word: tares [5759 left]`
2. You enter: `slate`
3. Program prompts: `Enter your result:`
4. You enter: `ynnny`
5. Program selects candidates and prints the next recommended word.

## Files
- `wordle/bot.java` — interactive CLI entrypoint
-- `wordle/utility.java` — scoring and selection logic
- `wordle/startup.java` — loads words from `words.txt`
- `wordle/words.txt` — list of words used by the solver

## Notes & next steps
- The solver expects you to follow Wordle result conventions (`g`, `y`, `n`).
- If you'd like, I can:
  - Add a sample session transcript to the README.
  - Add a minimal test harness to exercise the selection logic.
  - Provide a Windows PowerShell script to compile+run in one command.
