persona(juan, [1, 0, 1, 1, 0]).
persona(maria, [0, 1, 1, 1, 0]).
persona(pedro, [1, 0, 0, 0, 1]).
persona(laura, [0, 1, 1, 0, 1]).

similitud([], [], 0).
similitud([H1|T1], [H2|T2], N) :-
    similitud(T1, T2, M),
    (H1 = H2, N is M + 1; N is M).

persona_mas_similar(Cromosoma, Persona, PorcentajeSimilaridad) :-
    persona(Persona, CromosomaPersona),
    similitud(Cromosoma, CromosomaPersona, Similaridad),
    length(Cromosoma, LongitudCromosoma),
    PorcentajeSimilaridad is (Similaridad / LongitudCromosoma) * 100,
    forall((persona(OtraPersona, OtroCromosoma), OtraPersona \= Persona),
           (similitud(Cromosoma, OtroCromosoma, OtraSimilaridad),
            OtraSimilaridad =< Similaridad)).
