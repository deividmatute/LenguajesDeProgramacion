aplanar([],[]).
aplanar([H|T],L) :-
    is_list(H),
    aplanar(H,H2),
    aplanar(T,T2),
    append(H2,T2,L).
aplanar([H|T],[H|T2]):-
    \+ is_list(H),
    aplanar(T,T2).
