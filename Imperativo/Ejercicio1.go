package main

import (
	"fmt"
	"log"
	"os"
)

func main() {
	rutaArchivo := "rutaArchivoTexto.txt" //Cambiar la ruta.

	contenido, err := os.ReadFile(rutaArchivo)
	if err != nil {
		log.Fatal(err)
	}
	texto := string(contenido)

	nCaractSinEsp := 0
	nCaractConEsp := 0
	nPalabras := 1
	nLineas := 1

	i := 0
	for i < len(texto) {
		if texto[i] != ' ' && texto[i] != '\n' && texto[i] != '\r' {
			nCaractSinEsp++
			nCaractConEsp++
		} else if texto[i] == ' ' {
			nPalabras++
			nCaractConEsp++
		} else if texto[i] == '\n' {
			nPalabras++
			nLineas++
		}
		i++
	}

	fmt.Println("\n\nResultados del texto\n")
	fmt.Println("Numero de caracteres excluyendo espacios: ", nCaractSinEsp)
	fmt.Println("Numero de caracteres incluyendo espacios: ", nCaractConEsp)
	fmt.Println("Numero de palabras: ", nPalabras)
	fmt.Println("Numero de lineas: ", nLineas)
}
