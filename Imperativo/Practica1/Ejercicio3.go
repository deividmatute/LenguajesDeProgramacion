package main

import "fmt"

type Secuencia struct {
	Elementos []string
}

func (s *Secuencia) Rotar(direccion int, posiciones int) {
	longitud := len(s.Elementos)
	if longitud == 0 {
		return
	}

	posiciones %= longitud
	if posiciones < 0 {
		posiciones += longitud
	}

	if direccion == 0 { // Rotación a la izquierda
		copy(s.Elementos, append(s.Elementos[posiciones:], s.Elementos[:posiciones]...))
	} else if direccion == 1 { // Rotación a la derecha
		copy(s.Elementos, append(s.Elementos[longitud-posiciones:], s.Elementos[:longitud-posiciones]...))
	}
}

func main() {
	secuenciaOriginal := Secuencia{Elementos: []string{"a", "b", "c", "d", "e", "f", "g", "h"}}
	rotaciones := []struct {
		Cantidad  int
		Direccion int
	}{
		{Cantidad: 3, Direccion: 0}, // Rotación a la izquierda
		{Cantidad: 2, Direccion: 1}, // Rotación a la derecha
	}

	fmt.Println("Secuencia Original:", secuenciaOriginal.Elementos)

	for _, rotacion := range rotaciones {
		copiaSecuencia := Secuencia{Elementos: make([]string, len(secuenciaOriginal.Elementos))}
		copy(copiaSecuencia.Elementos, secuenciaOriginal.Elementos)

		copiaSecuencia.Rotar(rotacion.Direccion, rotacion.Cantidad)

		direccion := "izq"
		if rotacion.Direccion == 1 {
			direccion = "der"
		}

		fmt.Printf("Rotación %s de %d posiciones: %v\n", direccion, rotacion.Cantidad, copiaSecuencia.Elementos)
	}
}
