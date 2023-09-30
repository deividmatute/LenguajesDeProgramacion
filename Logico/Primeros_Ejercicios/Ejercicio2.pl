subconj(_,[]).
subconj(S,[H|T]):- member(H,S),subconj(S,T).

