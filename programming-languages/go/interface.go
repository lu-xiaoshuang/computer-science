/*
 * Copyright (C) 2018 Xiaoshuang LU
 * All rights reserved.
 */

package main

// import "fmt"

import
(
    "fmt"
)

type service interface {
    handle(s string) (string)
} 

type service_impl_1 struct {
}

func (this service_impl_1) handle(s string) (string) {
    fmt.Println("service_impl_1 %v", s);
    return s
}

type service_impl_2 struct {
}

func (this service_impl_2) handle(s string) (string) {
    fmt.Println("service_impl_2 %v", s);
    return s
}


// go run interface.go
// go build interface.go && ./interface

func main() {
    var service1 service = new(service_impl_1)
    var service2 service = new(service_impl_2)
    service1.handle("haha")
    service2.handle("haha")
}
