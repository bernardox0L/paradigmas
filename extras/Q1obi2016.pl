% Olimp�ada Brasileira de Inform�tica � OBI2016 � Inicia��o N�vel 1 � Fase 1
% Uma s�rie de diagramas com tri�ngulos � constru�da usando palitos de f�sforo, como mostrado na
% figura abaixo.

% 1T = 3PAL  2T = 5PAL  3T = 7PAL  4T = 9PAL

nPalitos(T, P) :- 
    T=<0,
    P is 0.

nPalitos(T, P) :-
    P is 3 + 2*(T-1).

% Quest�o 1. Quantos palitos s�o necess�rios para
% construir o diagrama de n�mero 5?
%  (A) 9
%  (B) 11 <- nPalitos(5,P).
%  (C) 13
%  (D) 15
%  (E) 18

% Quest�o 2. Quantos palitos s�o necess�rios para
% construir o diagrama de n�mero 60?
%  (A) 90
%  (B) 111
%  (C) 121 <- nPalitos(60,P).
%  (D) 163
%  (E) 180