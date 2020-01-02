package main

import "fmt"

type person struct {
	first     string
	last      string
	favFlavor []string
}

type vehicle struct {
	doors int
	color string
}

type truck struct {
	vehicle
	fourWheel bool
}

type sedan struct {
	vehicle
	luxury bool
}

func main() {
	p1 := person{
		first:     "José",
		last:      "Batata",
		favFlavor: []string{"Chocolate", "Sweet Potato"},
	}

	p2 := person{
		first:     "Maria",
		last:      "René",
		favFlavor: []string{"Banana", "Mint"},
	}

	persons := []person{p1, p2}
	for i, p := range persons {
		fmt.Println("Person", i, "has name:", p.first, p.last, "and likes", p.favFlavor, "Ice Cream")
	}

	mp := map[string]person{
		p1.last: p1,
		p2.last: p2,
	}

	for k, v := range mp {
		fmt.Println("Key:\t", k, "\t\tValue:\t", v)
	}

	t := truck{
		vehicle: vehicle{
			doors: 2,
			color: "Red",
		},
		fourWheel: true,
	}

	s := sedan{
		vehicle: vehicle{
			doors: 4,
			color: "Grey",
		},
		luxury: true,
	}

	fmt.Println(t)
	fmt.Println(s)

	fmt.Println("Truck, doors:", t.doors, "Color:", t.color, "has four wheels:", t.fourWheel)
	fmt.Println("Sedan, doors:", s.doors, "Color:", s.color, "is Luxury:", s.luxury)

	fruit := struct {
		name   string
		color  string
		flavor int
	}{
		name:   "Strawberry",
		color:  "Red",
		flavor: 10,
	}

	fmt.Println("Look at this", fruit.name, "it is so", fruit.color, "and my grade in flavor for it is", fruit.flavor)

}
