Nand2Tetris Projects 1–6

My implementation of Nand2Tetris Projects 1–6, covering the construction of a computer system from basic logic gates through machine language and an assembler.

Progress

Project| Topic| Status
Project 1| Boolean Logic| ✅ Completed
Project 2| Boolean Arithmetic| ✅ Completed
Project 3| Memory| ✅ Completed
Project 4| Machine Language| ✅ Completed
Project 5| Computer Architecture| ✅ Completed
Project 6| Assembler| ✅ Completed

Project 1: Boolean Logic

Implemented the fundamental logic gates required by the Hack computer platform.

Concepts covered:

- NAND
- NOT
- AND
- OR
- XOR
- Multiplexers
- Demultiplexers
- Multi-bit logic
- Multi-way gates

Project 2: Boolean Arithmetic

Built the arithmetic components used by the Hack ALU.

Components include:

- Half Adder
- Full Adder
- Add16
- Inc16
- ALU

The ALU combines arithmetic and logical operations into a single processing unit.

Project 3: Memory

Implemented the sequential logic and memory hierarchy required by the Hack computer.

Components include:

- Bit
- Register
- RAM8
- RAM64
- RAM512
- RAM4K
- RAM16K
- PC

This project introduced the concepts of state, registers, addressing, and sequential logic.

Project 4: Machine Language

Worked directly with the Hack machine language and instruction set.

Covered:

- A-instructions
- C-instructions
- Symbols
- Labels
- Variables
- CPU registers
- Memory addresses
- Assembly programming

Example:

@2
D=A
@3
D=D+A
@0
M=D

Project 5: Computer Architecture

Built the main components of the Hack computer.

Components include:

- CPU
- Memory
- Computer

The CPU combines:

- ALU
- Registers
- Instruction decoding
- Control logic

The completed computer can execute Hack machine-language programs.

Project 6: Assembler

Implemented a Java-based assembler that translates Hack assembly language into 16-bit Hack machine code.

Components

Parser.java
Code.java
SymbolTable.java
Main.java

Parser

Responsible for reading and interpreting Hack assembly instructions.

It identifies:

- A-instructions
- C-instructions
- Labels

Code

Converts assembly mnemonics into their corresponding binary representations.

SymbolTable

Handles:

- Predefined symbols
- Labels
- Variables
- RAM addresses

Main

Coordinates the complete two-pass assembly process and generates ".hack" machine-code files.

Example

Input:

@2
D=A
@3
D=D+A
@0
M=D

Output:

0000000000000010
1110110000010000
0000000000000011
1110000010010000
0000000000000000
1110001100001000

Technologies

- Java
- Hack Assembly
- Nand2Tetris Hardware Description Language (HDL)
- Git

What I Learned

Through Projects 1–6, I gained practical experience with:

- Digital logic
- Computer arithmetic
- Sequential circuits
- Memory architecture
- CPU architecture
- Machine language
- Assembly programming
- Instruction encoding
- Symbol resolution
- Parsing
- Two-pass assembly
- Java file I/O
- Basic compiler/assembler design

Completion

Project 1  ████████████████████ 100% ✅
Project 2  ████████████████████ 100% ✅
Project 3  ████████████████████ 100% ✅
Project 4  ████████████████████ 100% ✅
Project 5  ████████████████████ 100% ✅
Project 6  ████████████████████ 100% ✅

Nand2Tetris Projects 1–6: Completed.

This repository represents my work through the hardware and machine-language portion of Nand2Tetris.
