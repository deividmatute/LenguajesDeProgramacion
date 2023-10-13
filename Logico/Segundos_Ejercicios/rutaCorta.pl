% Definimos las conexiones con sus respectivos pesos
conectado(i,a,20).
conectado(i,b,10).
conectado(a,b,30).
conectado(a,c,40).
conectado(b,f,60).
conectado(b,c,50).
conectado(c,f,70).

% Definimos la regla para verificar si dos nodos están conectados
conectados(X,Y,Peso):- conectado(X,Y,Peso).
conectados(X,Y,Peso):- conectado(Y,X,Peso).

% Definimos la regla para encontrar la ruta más corta
ruta(Ini,Fin,Ruta,Costo):- ruta2(Ini,Fin,[],Ruta,Costo).

ruta2(Fin,Fin,_,[Fin],0).
ruta2(Ini,Fin,Visitados,[Ini|Resto],CostoTotal):-
    conectados(Ini,Alguien,Peso),
    not(member(Alguien,Visitados)),
    ruta2(Alguien,Fin,[Ini|Visitados],Resto,Costo),
    CostoTotal is Costo + Peso.
