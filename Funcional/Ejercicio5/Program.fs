module RutaCorta

// Definición del grafo del laberinto con paredes
let laberintoConParedes = [
    ("Inicio", ["2"]);
    ("2", ["3"; "8"]);
    ("8", ["2"; "9"]);
    ("3", ["2"; "9"; "4"]);
    ("9", ["8"; "3"]);
    ("4", ["3"; "10"]);
    ("10", ["4"; "16"]);
    ("16", ["10"; "22"]);
    ("22", ["16"; "21"]);
    ("21", ["22"; "15"]);
    ("15", ["21"; "14"]);
    ("14", ["15"; "20"; "13"]);
    ("13", ["14"; "7"; "1"]);
    ("7", ["13"; "1"]);
    ("1", ["7"]);
    ("20", ["14"; "26"]);
    ("26", ["20"; "27"]);
    ("27", ["26"; "28"]);
    ("28", ["27"; "34"; "29"]);
    ("29", ["28"; "23"]);
    ("23", ["29"; "17"]);
    ("17", ["23"; "11"]);
    ("11", ["17"; "5"]);
    ("5", ["11"; "6"]);
    ("6", ["5"]);
    ("34", ["28"; "33"; "35"]);
    ("33", ["34"; "32"]);
    ("32", ["33"; "31"; "Fin"]);
    ("31", ["32"; "25"]);
    ("25", ["31"; "19"]);
    ("19", ["25"]);
    ("Fin", ["32"]);
    ("35", ["34"; "36"]);
    ("36", ["35"; "30"]);
    ("30", ["36"; "24"]);
    ("24", ["30"; "18"]);
    ("18", ["24"; "12"]);
    ("12", ["18"])
]

// Definición del grafo del laberinto sin algunas paredes
let laberintoSinParedes = [
    ("Inicio", ["2"]);
    ("2", ["3"; "8"]);
    ("8", ["2"; "9"]);
    ("3", ["2"; "9"; "4"]);
    ("9", ["8"; "3"]);
    ("4", ["3"; "10"]);
    ("10", ["4"; "16"]);
    ("16", ["10"; "22"]);
    ("22", ["16"; "21"; "28"]);
    ("21", ["22"; "15"]);
    ("15", ["21"; "14"]);
    ("14", ["15"; "20"; "13"]);
    ("13", ["14"; "7"; "1"]);
    ("7", ["13"; "1"]);
    ("1", ["7"]);
    ("20", ["14"; "26"]);
    ("26", ["20"; "27"]);
    ("27", ["26"; "28"; "33"]);
    ("28", ["27"; "34"; "29"; "22"]);
    ("29", ["28"; "23"]);
    ("23", ["29"; "17"]);
    ("17", ["23"; "11"]);
    ("11", ["17"; "5"]);
    ("5", ["11"; "6"]);
    ("6", ["5"]);
    ("34", ["28"; "33"; "35"]);
    ("33", ["34"; "32"]);
    ("32", ["33"; "31"; "Fin"]);
    ("31", ["32"; "25"]);
    ("25", ["31"; "19"]);
    ("19", ["25"]);
    ("Fin", ["32"]);
    ("35", ["34"; "36"]);
    ("36", ["35"; "30"]);
    ("30", ["36"; "24"]);
    ("24", ["30"; "18"]);
    ("18", ["24"; "12"]);
    ("12", ["18"])
]

// Función para verificar si un elemento está en una lista
let miembro elem lista =
    List.exists (fun x -> x = elem) lista

// Función para obtener los vecinos de un nodo en el grafo
let rec vecinos nodo grafo =
    match grafo with
    | [] -> []
    | (head, neighbors) :: rest ->
        if head = nodo then neighbors
        else vecinos nodo rest

// Función para extender una ruta en el grafo
let extender ruta grafo = 
    List.filter
        (fun x -> x <> [])
        (List.map  (fun x -> if (miembro x ruta) then [] else x::ruta) (vecinos (List.head ruta) grafo)) 

// Función principal de búsqueda en profundidad
let rec prof2 ini fin grafo =
    let rec prof_aux fin ruta grafo =
        if List.isEmpty ruta then []
        elif (List.head (List.head ruta)) = fin then
            List.rev (List.head ruta) :: prof_aux fin ((extender (List.head ruta) grafo) @ (List.tail ruta)) grafo       
        else
            prof_aux fin ((List.tail ruta) @ (extender (List.head ruta) grafo)) grafo
    prof_aux fin [[ini]] grafo

// Función para encontrar la ruta más corta utilizando BFS
let shortestPath ini fin grafo =
    let rec bfs queue visited =
        match queue with
        | [] -> None 
        | (currentNode, path) :: rest ->
            if currentNode = fin then
                Some (List.rev (currentNode :: path)) 
            else
                let neighbors = vecinos currentNode grafo
                let newPaths =
                    neighbors
                    |> List.filter (fun neighbor -> not (miembro neighbor visited))
                    |> List.map (fun neighbor -> (neighbor, currentNode :: path))
                bfs (rest @ newPaths) (currentNode :: visited)
    
    let initialQueue = [(ini, [])] 
    match bfs initialQueue [] with
    | Some resultPath -> resultPath
    | None -> []

[<EntryPoint>]
let main _ =
    // Ruta en el laberinto con paredes
    printfn "Ruta en el laberinto con paredes:"
    let rutaConParedes = prof2 "Inicio" "Fin" laberintoConParedes
    List.iter (fun ruta -> printfn "Ruta: %A" ruta) rutaConParedes

    // Ruta en el laberinto sin algunas paredes
    printfn "\nRuta en el laberinto sin algunas paredes:"
    let rutaSinParedes = prof2 "Inicio" "Fin" laberintoSinParedes
    List.iter (fun ruta -> printfn "Ruta: %A" ruta) rutaSinParedes

    // Ruta más corta en el laberinto con paredes
    printfn "\nRuta más corta en el laberinto con paredes:"
    let shortestConParedes = shortestPath "Inicio" "Fin" laberintoConParedes
    match shortestConParedes with
    | [] -> printfn "No se encontró una ruta desde Inicio hasta Fin en el laberinto con paredes."
    | _ -> printfn "Ruta más corta encontrada: %A" shortestConParedes

    // Ruta más corta en el laberinto sin algunas paredes
    printfn "\nRuta más corta en el laberinto sin algunas paredes:"
    let shortestSinParedes = shortestPath "Inicio" "Fin" laberintoSinParedes
    match shortestSinParedes with
    | [] -> printfn "No se encontró una ruta desde Inicio hasta Fin en el laberinto sin algunas paredes."
    | _ -> printfn "Ruta más corta encontrada: %A" shortestSinParedes

    0 // Código de salida

