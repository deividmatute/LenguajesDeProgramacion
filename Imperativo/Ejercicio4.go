package main

import (
	"fmt"
	"strconv"
	s "strings"
)

type calzado struct {
	modelo string
	precio int
	talla  int
	stock  int
}

type listaCalzados []calzado

var lCalzados listaCalzados

func llenarDatos() {
	lCalzados = append(lCalzados,
		calzado{"Nike Air Max", 50000, 42, 2},
		calzado{"Adidas Superstar", 57000, 40, 15},
		calzado{"Puma RS-X", 130, 45000, 18},
		calzado{"New Balance 990", 48000, 41, 12},
		calzado{"Vans Old Skool", 29000, 39, 25},
		calzado{"Reebok Classic", 41000, 44, 10},
		calzado{"Converse Chuck Taylor", 60000, 38, 30},
		calzado{"Fila Disruptor", 47000, 37, 8},
		calzado{"Under Armour HOVR", 54000, 45, 14},
		calzado{"Skechers D'Lites", 49000, 40, 22},
		// Agrega más calzados aquí
	)
}

func mostrarCalzados() {

	fmt.Println("Calzados Disponibles: \n")
	for i, v := range lCalzados {
		if v.stock > 0 {
			fmt.Printf("Zapato %d:\n", i+1)
			fmt.Println("Modelo:", v.modelo)
			fmt.Println("Precio:", v.precio)
			fmt.Println("Talla:", v.talla)
			fmt.Println("Stock:", v.stock)
			fmt.Println()
		}
	}

}

var precioTotal int

func (l *listaCalzados) venderCalzado() {

	fmt.Println("Lista de Calzados Disponibles:")

	for {
		mostrarCalzados()
		fmt.Print("Elige la opcion que desea aquirir: ")
		var input string
		fmt.Scanln(&input)

		// Convierte la entrada a un valor entero
		opcion, err := strconv.Atoi(input)
		if err != nil {
			fmt.Println("Error:", err)
			return
		}

		if lCalzados[opcion-1].stock > 0 {
			fmt.Println("\n************* Compra realizada exitosamente *************\n")
			lCalzados[opcion-1].stock -= 1
			precioTotal += lCalzados[opcion-1].precio
			seguir := ""
			fmt.Println("¿Desea comprar otro calzado? (s/n)")
			fmt.Scanln(&seguir)
			if s.ToLower(seguir) != "s" {
				break
			}
		} else {
			fmt.Println("No se ha podido comprar nada")
			lCalzados[opcion-1].stock -= 1
		}

	}

}

func main() {

	llenarDatos()
	precioTotal = 0
	lCalzados.venderCalzado()
	if precioTotal > 0 {
		fmt.Println("Tu monto a pagar es de ", precioTotal)
	}

}
