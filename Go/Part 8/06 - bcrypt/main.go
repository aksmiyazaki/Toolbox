package main

import "golang.org/x/crypto/bcrypt"

import "fmt"

func main() {
	s := `password123`
	enc, err := bcrypt.GenerateFromPassword([]byte(s), bcrypt.MinCost)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println(string(enc))

	loginPwd := `password12`
	err = bcrypt.CompareHashAndPassword(enc, []byte(loginPwd))
	if err != nil {
		fmt.Println("Incorrect pwd")
	}
}
