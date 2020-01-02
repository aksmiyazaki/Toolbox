package main

import "fmt"

// 2
type person struct {
	first string
	last  string
}

func changeMe(p *person) {

	p.first = "José"
	p.last = "Pendejo"
	// Could be like this:
	//(*p).first = "José"
	//(*p).last = "Pendejo"
}

func main() {
	// 1
	v := 42
	fmt.Println(&v)

	// 2
	p := person{
		first: "Manoel",
		last:  "Pinote",
	}
	fmt.Println(p)
	changeMe(&p)
	fmt.Println(p)

}
