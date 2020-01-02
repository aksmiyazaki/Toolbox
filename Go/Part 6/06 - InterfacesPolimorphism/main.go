package main

import "fmt"

type person struct {
	first string
	last  string
}

type secretAgent struct {
	person
	ltk bool
}

func bar(h human) {
	fmt.Println("tomato")
	switch h.(type) {
	case person:
		fmt.Println(h.(person).first, "Without a ltk") // h.(person).first -> Assertion to a type.
	case secretAgent:
		fmt.Println(h.(secretAgent).first, "With a ltk")

	}
}

type human interface {
	speak()
}

func (s secretAgent) speak() {
	fmt.Println("I am", s.first, s.last)
}

func (p person) speak() {
	fmt.Println("I am", p.first, p.last, "as a person")
}

func main() {
	p1 := secretAgent{
		person: person{
			first: "James",
			last:  "Bond",
		},
		ltk: true,
	}
	fmt.Println(p1)
	p1.speak()

	p2 := secretAgent{
		person: person{
			first: "Miss",
			last:  "Potato",
		},
		ltk: true,
	}
	fmt.Println(p2)
	p2.speak()

	bar(p1)

	p3 := person{
		first: "Miss",
		last:  "Potato",
	}

	p3.speak()

	bar(p2)
	bar(p3)

}
