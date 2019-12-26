package main

import "fmt"

import "runtime"

var x1 int
var y1 float64

func main() {
	x := 42
	y := 42.99999
	fmt.Println(x)
	fmt.Println(y)
	fmt.Printf("%T\n", x)
	fmt.Printf("%T\n", y)

	x1 = 42
	y1 = 42.99999
	fmt.Println(x1)
	fmt.Println(y1)
	fmt.Printf("%T\n", x1)
	fmt.Printf("%T\n", y1)

	runtime_package()
}

func runtime_package() {
	fmt.Println(runtime.GOOS)
	fmt.Println(runtime.GOARCH)
}
