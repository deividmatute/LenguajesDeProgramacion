// For more information see https://aka.ms/fsharp-console-apps
module RutaCorta

open Recipientes
// Grafo de prueba
let grafo = [
    ("i", ["a"; "b"]);
    ("a", ["i"; "c"; "d"]);
    ("b", ["i"; "c"; "d"]);
    ("c", ["a"; "b"; "x"]);
    ("d", ["a"; "b"; "f"]);
    ("f", ["d"]);
    ("x", ["c"])
]


// Función para generar vecinos
let rec vecinos nodo grafo =
    match grafo with
    | [] -> []
    | (head, neighbors) :: rest ->
        if head = nodo then neighbors
        else vecinos nodo rest

// Función para extender una ruta
let extender ruta grafo = 
    List.filter
        (fun x -> x <> [])
        (List.map  (fun x -> if (miembro x ruta) then [] else x::ruta) (vecinos (List.head ruta) grafo)) 

// Función principal de búsqueda en profundidad
let rec prof2 ini fin grafo =
    let rec prof_aux fin ruta grafo =
        if List.isEmpty ruta then []
        elif (List.head (List.head ruta)) = fin then
            List.rev (List.head ruta) //:: prof_aux fin ((extender (List.head ruta) grafo) @ (List.tail ruta)) grafo       
        else
            prof_aux fin ((List.tail ruta) @ (extender (List.head ruta) grafo)  ) grafo
    prof_aux fin [[ini]] grafo
 
// Función para generar vecinos con pesos
let vecinosConPesos nodo grafo =
    match grafo |> List.tryFind (fun (head, _) -> head = nodo) with
    | Some (_, neighbors) -> neighbors
    | None -> []

// Función para extender una ruta con pesos
let extenderConPesos ruta grafo = 
    let nodoActual = List.head ruta
    let vecinosConPesos = vecinosConPesos nodoActual grafo
    List.filter
        (fun (vecino, _) -> not (List.exists (fun (n, _) -> n = vecino) ruta))
        (List.map (fun (vecino, peso) -> (vecino::ruta, peso)) vecinosConPesos)

// Función principal de búsqueda en profundidad con pesos
let rutaCortaDFS ini fin grafo =
    let rec prof_aux fin ruta grafo =
        if List.isEmpty ruta then None
        elif List.head ruta = fin then
            Some (List.rev ruta)
        else
            let extensiones = extenderConPesos ruta grafo
            let rutasExtendidas =
                extensiones
                |> List.map (fun (rutaExt, peso) -> (prof_aux fin rutaExt grafo, peso))
                |> List.filter (fun (res, _) -> res.IsSome)
                |> List.map (fun (res, peso) -> (res.Value, peso))
            if List.isEmpty rutasExtendidas then
                None
            else
                Some (List.minBy (fun (_, peso) -> peso) rutasExtendidas |> fst)

    match prof_aux fin [ini] grafo with
    | Some ruta -> Some (ruta, List.sumBy snd ruta)
    | None -> None
