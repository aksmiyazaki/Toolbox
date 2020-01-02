package main

import "fmt"

func main() {
	// 1
	iarr := [5]int{5, 4, 3, 2, 1}
	fmt.Printf("Array Type: %T\n", iarr)

	for i, v := range iarr {
		fmt.Println(i, "\t", v)
	}

	// 2
	isl := []int{42, 43, 44, 45, 46, 47, 48, 49, 50, 51}

	fmt.Printf("Slice Type %T\n", isl)

	for i, v := range isl {
		fmt.Println(i, "\t", v)
	}

	//3
	fmt.Println(isl[:5])
	fmt.Println(isl[5:])
	fmt.Println(isl[2:7])
	fmt.Println(isl[1:6])

	//4
	x := []int{42, 43, 44, 45, 46, 47, 48, 49, 50, 51}
	x = append(x, 52)
	fmt.Println(x)

	x = append(x, 53, 54, 55)
	fmt.Println(x)

	y := []int{56, 57, 58, 59, 60}
	x = append(x, y...)
	fmt.Println(x)

	// 5 [42, 43, 44, 48, 49, 50, 51]
	x = []int{42, 43, 44, 45, 46, 47, 48, 49, 50, 51}
	y = append(x[:3], x[6:]...)
	fmt.Println(y)

	// 6
	arrst := make([]string, 50, 50)
	arrst = []string{` Alabama`, ` Alaska`, ` Arizona`, ` Arkansas`, ` California`, ` Colorado`, ` Connecticut`, ` Delaware`, ` Florida`, ` Georgia`, ` Hawaii`, ` Idaho`, ` Illinois`, ` Indiana`, ` Iowa`, ` Kansas`, ` Kentucky`, ` Louisiana`, ` Maine`, ` Maryland`, ` Massachusetts`, ` Michigan`, ` Minnesota`, ` Mississippi`, ` Missouri`, ` Montana`, ` Nebraska`, ` Nevada`, ` New Hampshire`, ` New Jersey`, ` New Mexico`, ` New York`, ` North Carolina`, ` North Dakota`, ` Ohio`, ` Oklahoma`, ` Oregon`, ` Pennsylvania`, ` Rhode Island`, ` South Carolina`, ` South Dakota`, ` Tennessee`, ` Texas`, ` Utah`, ` Vermont`, ` Virginia`, ` Washington`, ` West Virginia`, ` Wisconsin`, ` Wyoming`}
	fmt.Println(len(arrst))
	fmt.Println(cap(arrst))

	for i := 0; i < len(arrst); i++ {
		fmt.Println(i, "\t", arrst[i])
	}

	// 7
	arrst2 := [][]string{
		[]string{"James", "Bond", "Shaken, not stirred"},
		[]string{"Miss", "Moneypenny", "Helloooooo, James."},
	}

	fmt.Println(arrst2)
	for i, v := range arrst2 {
		fmt.Println("Slice", i)
		for i2, v2 := range v {
			fmt.Println("Element\t", i2, "\t", v2)
		}
	}

	// 8
	/*
		`bond_james`, `Shaken, not stirred`, `Martinis`, `Women`
		`moneypenny_miss`, `James Bond`, `Literature`, `Computer Science`
		`no_dr`, `Being evil`, `Ice cream`, `Sunsets`
	*/
	mp := map[string][]string{
		"bond_james":      []string{`Shaken, not stirred`, `Martinis`, `Women`},
		"moneypenny_miss": []string{`James Bond`, `Literature`, `Computer Science`},
		"no_dr":           []string{`Being evil`, `Ice cream`, `Sunsets`},
	}

	for k, v := range mp {
		fmt.Println("Key: ", k)
		for it, v2 := range v {
			fmt.Println("IT:", it, "VALUE:", v2)
		}
	}

	// 9
	mp["Alexandre"] = []string{"Potato", "Tomato", "Suricato"}
	for k, v := range mp {
		fmt.Println("Key:", k, "Value: ", v)
	}

	// 10
	if v, ok := mp["no_dr"]; ok {
		fmt.Println("Found key with value: ", v)
		delete(mp, "no_dr")
	}

	for k, v := range mp {
		fmt.Println("Key:", k, "Value: ", v)
	}

}
