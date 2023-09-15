// Ejercicio 1 F# Funcional
let desplazar (direccion: string) (n: int) (lista: int list) =
    let longitud = List.length lista
    match direccion with
    | "izq" ->
        let saltoActual = min n longitud
        let listaDesplazada = List.skip saltoActual lista
        let relleno = List.init (longitud - List.length listaDesplazada) (fun _ -> 0)
        listaDesplazada @ relleno
    | "der" ->
        let tomaActual = max 0 (longitud - n)
        let relleno = List.init (longitud - tomaActual) (fun _ -> 0)
        let listaDesplazada = List.take tomaActual lista
        relleno @ listaDesplazada
    | _ -> failwith "Dirección Inválida"

// Pruebas
printfn "%A" <| desplazar "izq" 3 [1; 2; 3; 4; 5]
printfn "%A" <| desplazar "der" 2 [1; 2; 3; 4; 5]
printfn "%A" <| desplazar "izq" 6 [1; 2; 3; 4; 5]
