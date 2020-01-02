package main

import "fmt"

// func (r receiver) identifier (parameters) (return(s)) { code }
func main() {
	foo()
	bar("potato")

	s := "Tomato"
	test(s)
	fmt.Println(s)

	s1 := woo("Hey")
	fmt.Println(s1)

	a, b := mouse("t1", "t2")
	fmt.Println(a)
	fmt.Println(b)
}

func mouse(fn string, ln string) (string, bool) {
	return "Tomato", true
}

func woo(s string) string {
	return fmt.Sprint(s, " woo")
}

func foo() {
	fmt.Println("Foo")
}

// Everything in go is passed by value.
func bar(s string) {
	fmt.Println("Hello", s)
}

func test(s string) {
	s = "Turned into Potato"
}
