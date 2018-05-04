% Olimpíada Brasileira de Informática – OBI2009 – Modalidade Iniciação Nível 2 – Fase 1 
% Uma força-tarefa para combater a dengue precisa visitar
% sete casas em busca de focos do mosquito. As casa
% são denominadas F, G, H, L, M, P e T. Deve ser feito
% um plano de ação determinando a ordem em que as
% casas são visitadas. Para isso considera-se as seguintes
% condições:
%  • A casa F deve ser uma das três primeiras a serem
%  visitadas.
%  • A casa H deve ser visitada imediatamente antes
%  da casa G.
%  • A casa L não pode ser a primeira nem a sétima
%  casa a ser visitada.
%  • A casa M deve ser a primeira ou a sétima a ser
%  visitada.
%  • A casa P deve ser uma das três últimas a serem
%  visitadas.

regra1(Casa, Lista) :-
    nth1(Posicao, Lista, Casa),
    Posicao<=3.

regra2(Casa1, Casa2, Lista) :-
    nextto(Casa1, Casa2, Lista).

regra3(Casa, Lista):-
    nth1(Posicao, Lista, Casa),
    Posicao =\= 1,
    Posicao =\= 7.

regra4(Casa, Lista):-
    nth1(Posicao, Lista, Casa), Posicao =:= 1; 
    nth1(Posicao, Lista, Casa), Posicao =:= 7.

regra5(Casa, Lista):-
    nth1(Posicao, Lista, Casa),
    Posicao > 4.

ordem(Ordenacao):-
    Ordenacao = [_,_,_,_,_,_,_],

    member(f, Ordenacao),
    member(g, Ordenacao),
    member(h, Ordenacao),
    member(l, Ordenacao),
    member(m, Ordenacao),
    member(p, Ordenacao),
    member(t, Ordenacao),

    regra1(f, Ordenacao),
    regra2(h, g, Ordenacao),
    regra3(l, Ordenacao),
    regra4(m, Ordenacao),
    regra5(p, Ordenacao).

% Questao 1. Qual das seguintes opcoes e uma lista
% completa e correta da ordem que as sete casas devem
% ser visitadas?
% (A) F, T, H, L, P, G e M.
% (B) H, G, F, L, T, P e M. <- ordem(X).
% (C) L, T, F, H G, M e P.
% (D) M, F, D, H, L, G e T.
% (E) M, L, H, G, F, P e T.

% Questão 2. Se em um trecho do percurso visitarmos
% as casas T, L e F, exatamente nesta ordem, qual a
% posição que G foi visitada?
% (A) Segunda. 
% (B) Terceira.
% (C) Quarta.
% (D) Quinta.<- ordem([t, l, f, _, g, _, _]) is true.
% (E) Sexta.

% Questão 3. Se a casa H é a primeira a ser visitada,
% qual a quarta casa a ser visitada?
% (A) F.
% (B) G.
% (C) L. <- ordem([h,_,_,l,_,_,_]) is true.
% (D) M.
% (E) P.

% Questão 4. Se a casa P foi visitada em sexto, a casa
% H poderia ser visitada em várias posições exceto:
% (A) Primeira.
% (B) Segunda.
% (C) Terceira.
% (D) Quarta.
% (E) Quinta. <- ordem([_,_,_,_,h,p,_]) is false.
