sumlist([], 0).
sumlist([H|T], S):-
    sumlist(T, X),
    S is X + H.
