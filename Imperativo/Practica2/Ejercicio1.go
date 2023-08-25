package main

import (
	"fmt"
	"sort"
)

type producto struct {
	nombre   string
	cantidad int
	precio   int
}

type listaProductos []producto

var lProductos listaProductos

const existenciaMinima int = 10 //la existencia mínima es el número mínimo debajo de el cual se deben tomar eventuales desiciones

func (l *listaProductos) agregarProducto(nombre string, cantidad int, precio int) {
	_, indice := l.buscarProducto(nombre)
	if indice != -1 {
		// Si el producto ya existe, incrementa la cantidad y ajusta el precio si es diferente
		(*l)[indice].cantidad += cantidad
		if precio != (*l)[indice].precio {
			(*l)[indice].precio = precio
		}
	} else {
		*l = append(*l, producto{nombre: nombre, cantidad: cantidad, precio: precio})
	}
}

// Hacer una función adicional que reciba una cantidad potencialmente infinita de productos previamente creados y los agregue a la lista

func (l *listaProductos) buscarProducto(nombre string) (producto, int) {
	for i, p := range *l {
		if p.nombre == nombre {
			return p, i
		}
	}
	return producto{}, -1 // Retorna un producto vacío y -1 si no se encuentra
}

//modifique la función para que esta vez solo retorne el producto como tal y que retorne otro valor adicional "err" conteniendo un 0 si no hay error y números mayores si existe algún
//tipo de error como por ejemplo que el producto no exista. Una vez implementada la nueva función, cambie los usos de la anterior función en funciones posteriores, realizando los cambios
//que el uso de la nueva función ameriten

func (l *listaProductos) venderProducto(nombre string, cantidad int) {
	prod, indice := l.buscarProducto(nombre)
	if indice != -1 && prod.cantidad >= cantidad {
		prod.cantidad -= cantidad
		if prod.cantidad == 0 {
			// Si la cantidad se reduce a cero, elimina el producto de la lista
			*l = append((*l)[:indice], (*l)[indice+1:]...)
			fmt.Printf("El producto '%s' se ha agotado y se eliminó de la lista.\n", nombre)
		}
	} else {
		fmt.Printf("No hay suficiente existencia de '%s' para vender.\n", nombre)
	}
}

//haga una función para a partir del nombre del producto, se pueda modificar el precio del mismo Pero utilizando la función buscarProducto MODIFICADA PREVIAMENTE

func llenarDatos() {
	lProductos.agregarProducto("arroz", 15, 2500)
	lProductos.agregarProducto("frijoles", 4, 2000)
	lProductos.agregarProducto("leche", 8, 1200)
	lProductos.agregarProducto("café", 12, 4500)

}

func (l *listaProductos) listarProductosMinimos() listaProductos {
	var productosMinimos listaProductos
	for _, p := range *l {
		if p.cantidad <= existenciaMinima {
			productosMinimos = append(productosMinimos, p)
		}
	}
	return productosMinimos
}

func (l *listaProductos) aumentarInventarioDeMinimos(listaMinimos []producto) {
	//A partir de la lista de productos con mínimas existencias de inventario:
	//ampliar el inventario con la compra de más unidades de cada producto de esta lista hasta que cumplan con el mínimo establecido.
	for _, p := range listaMinimos {
		dif := existenciaMinima - p.cantidad
		if dif > 0 {
			fmt.Printf("Comprando %d unidades adicionales de '%s'.\n", dif, p.nombre)
			l.agregarProducto(p.nombre, dif, p.precio)
		}
	}
}

func (l *listaProductos) ordenarPorNombre() {
	sort.Slice(*l, func(i, j int) bool {
		return (*l)[i].nombre < (*l)[j].nombre
	})
}

func main() {
	llenarDatos()
	fmt.Println("Lista de Productos:")
	fmt.Println(lProductos)

	// Venta de productos
	lProductos.venderProducto("arroz", 5)
	lProductos.venderProducto("frijoles", 6)
	lProductos.venderProducto("leche", 3)
	lProductos.venderProducto("café", 15)

	// Listar productos con existencia mínima
	productosMinimos := lProductos.listarProductosMinimos()
	fmt.Println("\nProductos con existencia mínima:")
	fmt.Println(productosMinimos)

	// Aumentar inventario de productos mínimos
	lProductos.aumentarInventarioDeMinimos(productosMinimos)

	fmt.Println("\nLista de Productos actualizada:")
	fmt.Println(lProductos)

	// Ordenar la lista de productos por nombre alfabéticamente
	lProductos.ordenarPorNombre()

	fmt.Println("\nLista de Productos ordenada por nombre alfabeticamente:")
	fmt.Println(lProductos)
}
