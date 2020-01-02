package main

import "fmt"

type person struct {
	first string
	last  string
}

func (p *person) speak() {
	fmt.Println("My name is", p.first, p.last)
}

type human interface {
	speak()
}

func saySomething(h human) {
	h.speak()
}

func main() {
	p := person{
		first: "Zé",
		last:  "Timo",
	}

	// Cant do this saySomething(p)
	saySomething(&p)
	p.speak()
}
