![markus](images/markus.jpeg)

# Markus

**Markdown to PDF Converter**

Markus is a command-line tool that converts Markdown documentation to PDF.

## Features

- Converts Markdown files to PDF format
- Supports customizable input buffer size
- Allows specifying the output file name

## Usage

```
markus [-b=<bufferLimit>] [-o=<output>] <input>
```

**Arguments:**

- `<input>`: The input Markdown file.

**Options:**

- `-b, --buffer-limit=<bufferLimit>`: The maximum size of the input buffer in KB (default: 512 KB).
- `-o, --output=<output>`: The output PDF file.

## Example

```
markus -b=256 -o=output.pdf input.md
```

This command will convert the `input.md` Markdown file to a PDF file named `output.pdf`, with a maximum input buffer size of 256 KB.

## Installation

To use Markus, you'll need to have Java installed on your system. You can download the latest version of Markus from the [GitHub repository](https://github.com/renemuala/markus).

## Contributing

If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request on the [GitHub repository](https://github.com/renemuala/markus). Contributions are always welcome!