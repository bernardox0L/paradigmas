% Olimpíada Brasileira de Informática – OBI2016 – Iniciação Nível 1 – Fase 1
% Uma série de diagramas com triângulos é construída usando palitos de fósforo, como mostrado na
% figura abaixo.

% 1T = 3PAL  2T = 5PAL  3T = 7PAL  4T = 9PAL

nPalitos(T, P) :- 
    T=<0,
    P is 0.

nPalitos(T, P) :-
    P is 3 + 2*(T-1).

% Questão 1. Quantos palitos são necessários para
% construir o diagrama de número 5?
%  (A) 9
%  (B) 11 <- nPalitos(5,P).
%  (C) 13
%  (D) 15
%  (E) 18

% Questão 2. Quantos palitos são necessários para
% construir o diagrama de número 60?
%  (A) 90
%  (B) 111
%  (C) 121 <- nPalitos(60,P).
%  (D) 163
%  (E) 180