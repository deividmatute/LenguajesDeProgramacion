package main

import "fmt"

func main() {

	cantElementos := 0
	for {
		fmt.Print("Ingrese la cantidad de elementos : ")
		fmt.Scanln(&cantElementos)
		if cantElementos%2 != 0 && cantElementos > 0 {
			break
		}
		println("Valor no valido (debe ser un numero impar positivo). Intente nuevamente")
	}
	crearFigura(cantElementos)
}

func crearFigura(cant int) {

	indiceMitad := cant / 2
	indiceMinimo := indiceMitad
	indiceMaximo := indiceMitad
	ampliar := true

	i := 0
	for i < cant {
		j := 0
		for j < cant {
			if j >= indiceMinimo && j <= indiceMaximo {
				fmt.Print(" * ")
			} else {
				fmt.Print("   ")
			}
			j++
		}
		if indiceMinimo == 0 {
			ampliar = false
		}
		if ampliar {
			indiceMinimo--
			indiceMaximo++
		} else {
			indiceMinimo++
			indiceMaximo--
		}
		fmt.Println("")
		i++
	}
}
