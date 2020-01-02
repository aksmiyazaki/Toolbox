package main

import "fmt"

import "math"

// 4
type person struct {
	first string
	last  string
	age   int
}

// 5
type square struct {
	height int
	width  int
}

type circle struct {
	radius float64
}

type shape interface {
	area() int
}

func main() {
	// 3
	defer deferred()

	// 1
	fmt.Println(foo())
	fmt.Println(bar())

	// 2
	xi := []int{1, 2, 3, 4, 5, 6, 7, 8, 9}
	fmt.Println(foo2(xi...))
	fmt.Println(bar2(xi))

	//4
	p1 := person{
		first: "James",
		last:  "Bond",
		age:   22,
	}
	p1.speak()

	// 5
	sq := square{
		height: 10,
		width:  10,
	}
	info(sq)

	ci := circle{
		radius: 4,
	}
	info(ci)

	// 6
	func() {
		fmt.Println("This is an anonymous func!")
	}()

	// 7
	anf := func() {
		fmt.Println("This is an anonymous func going to a variable!")
	}
	anf()

	// 8
	tom := potato()
	fmt.Println("Funny value:", tom)
	tom()

	// 9
	caller(tom)

	// 10
	sc := screamer()
	fmt.Println(sc())
	fmt.Println(sc())
	fmt.Println(sc())
}

// 1
func foo() int {
	return 42
}

func bar() (int, string) {
	return 42, "Potato"
}

// 2
func foo2(x ...int) int {
	total := 0
	for _, v := range x {
		total += v
	}
	return total
}

func bar2(x []int) int {
	return foo2(x...)
}

// 3
func deferred() {
	fmt.Println("I AM A DEFERRED FUNCTION, I WILL RUN IN THE END!!")
}

// 4
func (r person) speak() {
	fmt.Println("Hey, my name is", r.first, r.last, "and I am", r.age, "yo.")
}

// 5
func (r circle) area() int {
	return int(math.Pi * math.Pow(r.radius, 2))
}

func (s square) area() int {
	return s.height * s.width
}

func info(s shape) {
	switch s.(type) {
	case square:
		fmt.Println("Area of a square is", s.area())
	case circle:
		fmt.Println("Area of a circle is", s.area())
	default:
		fmt.Println("No idea.")
	}
}

// 8
func potato() func() {
	return func() {
		fmt.Println("Thought this was a potato, but it is a tomato")
	}
}

// 9
func caller(x func()) {
	fmt.Println("I will call a funky func")
	x()
}

// 10
func screamer() func() string {
	s := ""
	return func() string {
		s = fmt.Sprintf("%v Woaaah", s)
		return s
	}
}
