sub_cadenas(_, [], []).

sub_cadenas(X, [H|T], [H|T2]) :-
    atom_chars(X, XChars),
    atom_chars(H, HChars),
    subcadena(XChars, HChars),
    sub_cadenas(X, T, T2).

sub_cadenas(X, [_|T], T2) :-
    sub_cadenas(X, T, T2).

subcadena(Sub, Lista) :-
    append(_, SubRestante, Lista),
    append(Sub, _, SubRestante).
