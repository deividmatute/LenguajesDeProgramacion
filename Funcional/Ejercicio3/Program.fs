// Ejercicio 3 F# Funcional
let elementoEnesimo (n: int) (lista: int list) =
    let listaIndexada = List.mapi (fun i x -> (i, x)) lista
    let resultado = List.tryFind (fun (i, x) -> i = n) listaIndexada
    match resultado with
    | Some (_, valor) -> Some valor
    | None -> None

let imprimirResultado n lista =
    match elementoEnesimo n lista with
    | Some valor -> printfn "n_esimo %d %A\n%d" n lista valor
    | None -> printfn "n_esimo %d %A\nNo existe el elemento n-ésimo" n lista


imprimirResultado 2 [1; 2; 3; 4; 5]
imprimirResultado 3 [1; 2; 3; 4; 5]
imprimirResultado 6 [1; 2; 3; 4; 5]

