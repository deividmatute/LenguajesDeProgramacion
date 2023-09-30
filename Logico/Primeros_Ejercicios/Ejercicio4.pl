partir([],_,[],[]).

%Ahora por si es menor a 6
partir([H1|T1],U,[H1|T2],T3):-
    H1<6,
    partir(T1,U,T2,T3).

%Ahora por si es mayor a 6
partir([H1|T1],U,T2,[H1|T3]):-
    H1>6,
    partir(T1,U,T2,T3).
