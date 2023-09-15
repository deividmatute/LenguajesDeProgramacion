// Ejercicio 2 F# Funcional
let filterSubstring (substring: string) (list: string list) =
    List.filter (fun (s : string)-> s.Contains(substring)) list

// Imprimir resultado
let listaOriginal = ["la casa"; "el perro"; "pintando la cerca"]
printfn "Lista original: %A" listaOriginal
printfn "Lista filtrada:%A" <| filterSubstring "la" listaOriginal



