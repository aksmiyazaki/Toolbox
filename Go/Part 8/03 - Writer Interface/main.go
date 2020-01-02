package main

import "io"

import "os"

import "fmt"

func main() {
	fmt.Fprintln(os.Stdout, "Potato")
	io.WriteString(os.Stdout, "Hello, World")
}
