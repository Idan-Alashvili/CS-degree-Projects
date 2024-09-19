# Mini-Interpreter

## Overview

This project is a Python-based mini-interpreter developed as a final project for the "Principles of Programming Languages" course. The interpreter supports a variety of features including basic and advanced arithmetic operations, logical operations, string manipulation functions, and more.

## Features

- **Basic Arithmetic Operations**: Addition, subtraction, multiplication, division, modulus, exponentiation, and floor division.
- **Comparison Operations**: Greater than, less than, equal to, not equal to, greater than or equal to, and less than or equal to.
- **Logical Operations**: `and`, `or`.
- **Custom Functions**:
  - `add(*args)`: Returns the sum of the arguments.
  - `subtract(*args)`: Returns the result of subtracting the arguments.
  - `multiply(*args)`: Returns the product of the arguments.
  - `divide(x, y)`: Returns the result of dividing `x` by `y` (handles division by zero).
  - `square(x)`: Returns the square root of `x` (only positive numbers allowed).
  - `replace_char(s, old, new)`: Replaces occurrences of `old` with `new` in the string `s`.
  - `is_upper(s)`: Checks if the string `s` is in uppercase.
  - `is_lower(s)`: Checks if the string `s` is in lowercase.
- **Data Structures**: Lists, tuples, dictionaries, and slicing.
- **Control Flow**: If-statements, for-loops, while-loops, break, and continue statements.
- **REPL Mode**: Allows interactive code execution.

## Usage

1. **Running the Interpreter**

   To start the interpreter, run the `interpreter.py` script. It will enter REPL (Read-Eval-Print Loop) mode where you can type and execute code interactively.

   ```sh
   python interpreter.py
2. **Example Code**
   Below are some examples of code you can execute within the interpreter:
  ```python
  # Basic arithmetic and variable assignment
x = 10
y = 5
z = x + y * 2

# Comparison and conditional statements
if z > 20:
    print("z is greater than 20")
else:
    print("z is not greater than 20")

# Lists and list operations
numbers = [1, 2, 3, 4, 5]
squares = []
for num in numbers:
    squares.append(num ** 2)
print("Squares:", squares)

# Dictionary
person = {"name": "Alice", "age": 30}
print("Person:", person)

# String operations
greeting = "Hello, " + person["name"] + "!"
print(greeting)

# Built-in functions
print("Length of squares:", len(squares))
print("Sum of squares:", sum(squares))

# Math operations
radius = 5
area = math.pi * radius ** 2
print("Circle area:", area)

# Slicing
print("First three squares:", squares[:3])

# Boolean operations
is_adult = person["age"] >= 18 and person["name"] != ""
print("Is adult:", is_adult)

# Tuple
coordinates = (10, 20)
print("Coordinates:", coordinates)

# Advanced math
print("Square root of 16:", math.sqrt(16))

# Handling potential None values
empty_list = []
print("First element of empty list:", empty_list[0] if empty_list else None)

# Attribute access on None
none_value = None
print("Attribute of None:", none_value.some_attribute if none_value is not None else None)

# Basic list operations
numbers = [1, 2, 3, 4, 5]

# Remove an item from the list
REMOVE numbers[2]

print(numbers)

original_string = "hello world"
new_string = replace_char(original_string, "l", "x")
print(new_string)  # Output: hexxo worxd

text = "Hello World"
print("Is 'Hello' uppercase?", isUpper("Hello"))
print("Is 'hello' lowercase?", isLower("hello"))
print("Is 'HELLO' uppercase?", isUpper("HELLO"))
print("Is 'WORLD' lowercase?", isLower("WORLD"))
```
## Requirements

To run this interpreter, you need Python 3.x installed. The project uses the following Python standard libraries:

- `math`
- `ast`

## Authors

- **Idan Alashvili**
- **Maor Pinhas**
- **Yoav Vaknin**
- **Matan Mezamer Tov**
