package main

import "fmt"

import "encoding/json"

type person struct {
	First string `json:"First"`
	Last  string `json:"Last"`
	Age   int    `json:"Age"`
}

func main() {
	s := `[{"First":"James","Last":"Bond","Age":32},{"First":"Miss","Last":"Universe","Age":30}]`
	bs := []byte(s)

	fmt.Println(s)
	fmt.Println(bs)

	people := []person{}
	err := json.Unmarshal(bs, &people)
	if err != nil {
		fmt.Println(err)
	}

	fmt.Println(people)
}
