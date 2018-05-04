% Olimpíada Brasileira de Informática - OBI2011
% Processadores. O processador é o componente mais importante de um computador. Uma medida da velocidade de um
% processador é o número de operações básicas, como somas e multiplicações, que ele consegue realizar por
% segundo (processadores usados em computadores pessoais são capazes de realizar bilhões de operações
% por segundo). José Carlos está fazendo um estudo sobre as velocidades dos seguintes processadores
% existentes no mercado: R, S, T, U, V, X, Y e Z. Através de experimentos, José Carlos determinou as
% seguintes condições:
% • O processador X é mais veloz do que os processadores T e Z.
% • O processador Z é mais veloz do que os processadores T e Y.
% • O processador T é mais veloz do que o processador R.
% • O processador R é mais veloz do que o processador V.
% • O processador Y é mais veloz do que o processador V.
% • O processador U é mais veloz do que o processador R mas é mais lento do que o processador S.

regra1(P1, P2, Lista):-
    nth1(Pos1, Lista, P1),
    nth1(Pos2, Lista, P2),
    Pos2>Pos1.

listaVeloz(MaisRapido):-
    Velocidade = [_,_,_,_,_,_],

    member(x, Velocidade),
    member(z, Velocidade),
    member(t, Velocidade),
    member(r, Velocidade),
    member(y, Velocidade),
    member(u, Velocidade),

    regra1(x, t, Velocidade),
    regra1(x, z, Velocidade),
    regra1(z, t, Velocidade),
    regra1(z, y, Velocidade),
    regra1(t, r, Velocidade),
    regra1(r, v, Velocidade),
    regra1(y, v, Velocidade),
    regra1(u, r, Velocidade),
    regra1(s, u, Velocidade).
% BUG
% Questão 1. Qual dos processadores seguintes
% pode ser o mais veloz?
% (A) V
% (B) R
% (C) U
% (D) S <- listaVeloz([s,_,_,_,_,_).
% (E) Z
