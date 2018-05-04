% Olimpíada Brasileira de Informática – OBI2014
% Revezamento. Oito alunos – Beto, Dulce, Guto, Júlia, Kelly, Neto, Silvia e Vivian decidiram tentar quebrar o recorde
% da tradicional prova de revezamento e resistência de natação que acontece todos os anos na escola.
% Nessa prova, cada um dos oito competidores da equipe deve nadar mil metros, em estilo livre, na
% forma de revezamento: cada nadador cai na piscina para nadar apenas uma vez, um de cada vez. O
% objetivo é que todos nadem no menor tempo possível. Depois de muita discussão, os competidores    
% decidiram que a ordem em que cairão na piscina deve obedecer às seguintes condições:
% • Silvia não nada por último.
% • Vivian nada após Júlia e Neto nadarem.
% • O primeiro a nadar é ou Beto ou Dulce.
% • Guto nada antes de Júlia, com exatamente uma pessoa nadando entre eles.
% • Kelly nada antes de Neto, com exatamente duas pessoas nadando entre eles.

regra1(Pessoa, Lista):-
    nth1(Pos, Lista, Pessoa),
    Pos =\= 8.

regra2(Pessoa1, Pessoa2, Lista):-
    nth1(Pos1, Lista, Pessoa1),  
    nth1(Pos2, Lista, Pessoa2),
    Pos1> Pos2.

regra3(Pessoa1, Pessoa2, [Prim|_]):-
    Prim = Pessoa1;
    Prim = Pessoa2.

regra4(Pessoa1, Pessoa2, Lista):-
    nth1(Pos1, Lista, Pessoa1),  
    nth1(Pos2, Lista, Pessoa2),  
    Pos1 + 2 =:= Pos2.

regra5(Pessoa1, Pessoa2, Lista):-
    nth1(Pos1, Lista, Pessoa1),  
    nth1(Pos2, Lista, Pessoa2),  
    Pos1 + 3 =:= Pos2.

revezamento(Ordem):-
    Ordem = [_,_,_,_,_,_,_,_],

    member(beto, Ordem),
    member(dulce, Ordem),
    member(guto, Ordem),
    member(julia, Ordem),
    member(kelly, Ordem),
    member(neto, Ordem),
    member(silvia, Ordem),
    member(vivian, Ordem),


    regra1(silvia, Ordem),
    regra2(vivian, julia, Ordem),
    regra2(vivian, neto, Ordem),
    regra3(beto, dulce, Ordem),
    regra4(guto, julia, Ordem),
    regra5(kelly, neto, Ordem).
    
% Questão 21. Qual das seguintes alternativas é
% uma possível lista completa e correta dos nadadores
% do primeiro para o último?
% (A) Dulce, Kelly, Silvia, Guto, Neto, Beto, Júlia, Vivian
% (B) Dulce, Silvia, Kelly, Guto, Neto, Júlia, Beto, Vivian
% (C) Beto, Kelly, Silvia, Guto, Neto, Júlia, Vivian, Dulce <- revezamento(X).
% (D) Beto, Guto, Kelly, Júlia, Dulce, Neto, Vivian, Silvia
% (E) Beto, Silvia, Dulce, Kelly, Vivian, Guto, Neto, Júlia

% Questão 23. Qual das seguintes alternativas é
% necessariamente verdadeira?
% (A) O mais cedo que Vivian pode nadar é em
% oitavo lugar.
% (B) O mais cedo que Júlia pode nadar é em
% quinto lugar.
% (C) O mais cedo que Kelly pode nadar é em
% terceiro lugar.
% (D) O mais cedo que Silvia pode nadar é em
% terceiro lugar.
% (E) O mais cedo que Neto pode nadar é em <- pois revezamento([neto,_,_,_,_,_,_,_]), revezamento([_,neto,_,_,_,_,_,_])
% revezamento([_,_,neto,_,_,_,_,_]) e revezamento([_,_,_,neto,_,_,_,_]) são false e revezamento([_,_,_,_,neto,_,_,_]) é true.
% quinto lugar.

% Questão 24. Guto pode nadar em qualquer das
% ordens abaixo, exceto:
% (A) sexto lugar <- pois revezamento([_,_,_,_,_,guto,_,_]) é false.
% (B) quinto lugar
% (C) quarto lugar
% (D) terceiro lugar
% (E) segundo lugar
