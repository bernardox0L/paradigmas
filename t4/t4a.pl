%  Uma banda formada por alunos e alunas da escola está gravando um CD com exatamente sete músicas
% distintas – S, T, V, W, X, Y e Z. Cada música ocupa exatamente uma das sete faixas contidas no
% CD. Algumas das músicas são sucessos antigos de rock; outras são composições da própria banda. As
% seguintes restrições devem ser obedecidas:
%  • S ocupa a quarta faixa do CD.
%  • Tanto W como Y precedem S no CD (ou seja, W e Y estão numa faixa que é tocada antes de S
%  no CD).
%  • T precede W no CD (ou seja, T está numa faixa que é tocada antes de W).
%  • Um sucesso de rock ocupa a sexta faixa do CD.
%  • Cada sucesso de rock é imediatamente precedido no CD por uma composição da banda (ou seja,
%  no CD cada sucesso de rock toca imediatamente após uma composição da banda).
%  • Z é um sucesso de rock

% PREDICADOS
rockSucesso(_).
autoral(_).

% REGRAS

% Definindo uma faixa na 4 posição do CD.
regra0(Track, Faixas):- 
    nth1(4, Faixas, Track).

% Definindo que uma faixa venha antes da posição 4.
regra1(Track, Faixas):- 
    nth1(PosTrack, Faixas, Track), 
    PosTrack<4.

% Definindo que uma faixa precede outra.
regra2(Track, Track1, Faixas):-
    nth1(PosTrack, Faixas, Track),
    nth1(PosTrack1, Faixas, Track1),
    PosTrack < PosTrack1.

% Definindo que uma posição do CD é um sucesso de rock.
regra3(Pos, Faixas):-
    nth1(Pos,Faixas,Musica),
	  rockSucesso(Musica).

% Definindo que um sucesso de rock sempre tem uma música autoral antes.
regra4(Faixas):-
    rockSucesso(Track),
    autoral(Track1),
    nextto(Track1, Track, Faixas).

% Definindo uma faixa como sucesso de rock.
regra5(Track) :-
	rockSucesso(Track).

cdIndependente(CD):-
    % CD tem 7 faixas, logo a lista tem que ter 7 posições.
    CD = [_,_,_,_,_,_,_],
    
    % Adicionando músicas na lista
    member(s,CD),
    member(t,CD),
    member(v,CD),
    member(w,CD),
    member(x,CD),
    member(y,CD),
    member(z,CD),
    
    % Aplicando as regras segundo o enunciado.
    regra0(s,CD),
    regra1(w,CD),
    regra1(y,CD),
    regra2(t,w,CD),
    regra3(6,CD),
    regra4(CD),
    regra5(z).
    
    
   % ESSE CÓDIGO DESENVOLVE A SEGUINTE QUESTÃO:
   %  QuestÃo 11. Qual das seguintes alternativas poderia
   % ser a ordem das músicas no CD, da primeira
   % para a sétima faixa?
   %   (A) T, W, V, S, Y, X, Z
   %   (B) V, Y, T, S, W, Z, X
   %   (C) X, Y, W, S, T, Z, S
   %   (D) Y, T, W, S, X, Z, V
   %   (E) Z, T, X, W, V, Y, S
   % 
   % ALTERNATIVA CORRETA: D
